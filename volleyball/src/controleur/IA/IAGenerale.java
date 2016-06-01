/**
 * 
 */
package controleur.IA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import modele.Equipe;
import modele.Joueur;
import modele.Match;
import modele.Position;
import modele.Role;

/**
 * @author Aurelie
 *
 */
public class IAGenerale {
	
	private static final int MIN = 0;
	private static final int MAX = 0;
	private static final double COEFF = 1.5;
	
	private Position positionArriveeBalle;
	private Match match;
	private int nbTouches;
	private boolean terrain; // true si on vise le terrain du haut
	private double vitesseBalleTheorique;
	private double distanceParcourue;
	
	private Joueur passeurIA;
	private Joueur passeurJoueur;
	
	private List<Position> ciblesTerrainHaut;
	private List<Position> ciblesTerrainBas;
	private List<Joueur> attaquantsIA;
	private List<Joueur> attaquantsJoueur;
	private List<Joueur> defenseursIA;
	private List<Joueur> defenseursJoueur;
	
	public IAGenerale(Match match) {
		this.match = match;
		this.nbTouches = 2; // initialis� � 2 pour le service
		this.ciblesTerrainHaut = new ArrayList<Position>();
		this.ciblesTerrainBas = new ArrayList<Position>();
		this.attaquantsIA = new ArrayList<Joueur>();
		this.attaquantsJoueur = new ArrayList<Joueur>();
		this.defenseursIA = new ArrayList<Joueur>();
		this.defenseursJoueur = new ArrayList<Joueur>();
		this.terrain = true;
		this.vitesseBalleTheorique = 0;
		init();
	}
	
	/**
	 * Fonction initialisation des attributs de la classe
	 */
	private void init() {
		// initialisation des positions cibles du terrain du haut
		this.ciblesTerrainHaut.add(new Position(1,10));
		this.ciblesTerrainHaut.add(new Position(4,10));
		this.ciblesTerrainHaut.add(new Position(7,10));
		this.ciblesTerrainHaut.add(new Position(3,12));
		this.ciblesTerrainHaut.add(new Position(5,12));
		this.ciblesTerrainHaut.add(new Position(1,13));
		this.ciblesTerrainHaut.add(new Position(7,13));
		this.ciblesTerrainHaut.add(new Position(3,14));
		this.ciblesTerrainHaut.add(new Position(5,14));
		this.ciblesTerrainHaut.add(new Position(1,16));
		this.ciblesTerrainHaut.add(new Position(4,16));
		this.ciblesTerrainHaut.add(new Position(7,16));
		
		// initialisation des positions cibles du terrain du bas
		this.ciblesTerrainBas.add(new Position(1,7));
		this.ciblesTerrainBas.add(new Position(4,7));
		this.ciblesTerrainBas.add(new Position(7,7));
		this.ciblesTerrainBas.add(new Position(3,5));
		this.ciblesTerrainBas.add(new Position(5,5));
		this.ciblesTerrainBas.add(new Position(1,4));
		this.ciblesTerrainBas.add(new Position(7,4));
		this.ciblesTerrainBas.add(new Position(3,3));
		this.ciblesTerrainBas.add(new Position(5,3));
		this.ciblesTerrainBas.add(new Position(1,1));
		this.ciblesTerrainBas.add(new Position(4,1));
		this.ciblesTerrainBas.add(new Position(7,1));
		
		// trouver le passeur, les attaquants et les d�fenseurs de l'�quipe du joueur
		for (Joueur joueur : this.match.getEquipeJoueur().getListJoueur()){
			if(joueur.getRole() == Role.passeur) {
				this.passeurJoueur = joueur;
			} 
			else if(joueur.getRole() == Role.attaquant) {
				this.attaquantsJoueur.add(joueur);
			}
			else {
				this.defenseursJoueur.add(joueur);
			}
		}
		// trouver le passeur, les attaquants et les d�fenseurs de l'�quipe IAs
		for (Joueur joueur : this.match.getEquipeIA().getListJoueur()){
			if(joueur.getRole() == Role.passeur) {
				this.passeurIA = joueur;
			}
			else if(joueur.getRole() == Role.attaquant) {
				this.attaquantsIA.add(joueur);
			}
			else {
				this.defenseursIA.add(joueur);
			}
		}
	}
	
	/**
	 * Changement de terrain.
	 * true - on vise le terrain du haut
	 * false - on vise le terrain du bas
	 */
	private void changementTerrain() {
		if(this.terrain) {
			this.terrain = false;
		}
		else {
			this.terrain = true;
		}
	}
	
	/**
	 * Fonction qui permet � un joueur de renvoyer la balle.
	 * @return un objet Match
	 */
	public Match envoi() {
		// On vise le terrain adverse
		if(this.nbTouches == 2) {
			// Choisir la case qu'on va viser
			this.positionArriveeBalle = this.choixCibleAdverse();
		}
		else if(this.nbTouches == 1) { // Passe � un attaquant de l'�quipe
			List<Position> positionsCoequipiers = new ArrayList<Position>();
			List<Joueur> coequipiers;
			if(this.terrain) {
				coequipiers = this.defenseursJoueur;
			}
			else {
				coequipiers = this.defenseursIA;
			}
			// Constituer la liste des positions de ses co�quipiers
			for(Joueur joueur : coequipiers) {
				positionsCoequipiers.add(joueur.getPosition());
			}
			// Choisir un co�quipier au hasard
			this.positionArriveeBalle = positionsCoequipiers.get((int) (Math.random() * positionsCoequipiers.size()-1));
		}
		else { // Passe au passeur de l'�quipe
			if(terrain){
				this.positionArriveeBalle = this.passeurJoueur.getPosition();
			}
			else {
				this.positionArriveeBalle = this.passeurIA.getPosition();
			}
		}
		// Une fois que la position finale de la balle est d�termin�e, on va alt�rer notre tire selon la pr�cision du tireur
		// n est compris entre 0 et 10
		Random r = new Random();
		int n = r.nextInt(MAX - MIN + 1) + MAX;
		Equipe equipeQuiJoue;
		Joueur tireur = null;
		if(terrain) {
			equipeQuiJoue = this.match.getEquipeJoueur();
		}
		else {
			equipeQuiJoue = this.match.getEquipeIA();
		}
		// Trouver le joueur qui tire
		for(Joueur joueur : equipeQuiJoue.getListJoueur()){
			if(joueur.getPosition().equals(this.match.getBalle().getPosition())) {
				tireur = joueur;
			}
		}
		// La position finale de la balle ne sera pas correct
		if(tireur.getPrecision() < n) {
			// Si la pr�cision du joueur est plus petite que le nombre al�atoirement g�n�r� malgr� qu'on l'ait augment�, on d�vier le tire de 2 cases
			int decalage = 0;	//Le nombre de cases � d�caler
			if(COEFF*tireur.getPrecision() < n) {
				decalage = 2;
			}
			else {
				decalage= 1;
			}
			// Prendre une direction au hasard pour d�vier la balle � l'arriv�e
			Direction d = Direction.getRandom();
			if(d == Direction.Haut) {
				this.positionArriveeBalle.setY(this.positionArriveeBalle.getY()+decalage);
			}
			else if(d == Direction.Bas) {
				this.positionArriveeBalle.setY(this.positionArriveeBalle.getY()-decalage);
			}
			else if(d == Direction.Gauche) {
				this.positionArriveeBalle.setX(this.positionArriveeBalle.getX()-decalage);
			}
			else {
				this.positionArriveeBalle.setX(this.positionArriveeBalle.getX()+decalage);
			}
		}
		this.distanceParcourue = Math.sqrt((Math.pow(this.positionArriveeBalle.getX()-tireur.getPosition().getX(), 2))+Math.pow(this.positionArriveeBalle.getY()-tireur.getPosition().getY(), 2));
		// Envoi vers un membre de l'�quipe, la vitesse de la balle est r�duite
		if(this.nbTouches < 2) {
			this.vitesseBalleTheorique = tireur.getForce()/2;
			this.nbTouches++;
		}
		else { // Attaque vers l'�quipe adverse, la balle est plus rapide
			// Si la balle est tir�e en dehors du terrain
			if(this.positionArriveeBalle.getX()<0 || this.positionArriveeBalle.getX()>8 || this.positionArriveeBalle.getY()<0 || this.positionArriveeBalle.getY()>17) {
				if(terrain) {
					this.match.getScore().getSet().incScoreJoueur();
				}
				else {
					this.match.getScore().getSet().incScoreIA();
				}
			}
			else {
				this.vitesseBalleTheorique = tireur.getForce()*3;
			}
		}
		
		if(this.nbTouches == 2) {
			this.changementTerrain();
		}
		this.match.getBalle().setPosition(this.positionArriveeBalle);
		return match;
	}
	
	/**
	 * Fonction qui permet de r�ceptionner la balle lors d'un match
	 * @return un objet Match
	 */
	public Match reception() {
		double distance = 0;
		double distanceJoueurBalle = 18;
		Joueur joueur = null;
		// C'est l'attaquant qui re�oit la balle du passeur
		if(this.nbTouches == 2) {
			// Choisir un attaquant au hasard
			if(terrain) {
				joueur = this.attaquantsJoueur.get((int) (Math.random() * this.attaquantsJoueur.size()-1));
			}
			else {
				joueur = this.attaquantsIA.get((int) (Math.random() * this.attaquantsIA.size()-1));
			}
			distanceJoueurBalle = Math.sqrt(Math.pow(joueur.getPosition().getX()-this.positionArriveeBalle.getX(), 2)+Math.pow(joueur.getPosition().getY()-this.positionArriveeBalle.getY(), 2));
		}
		else if(this.nbTouches == 1) { // C'est au passeur de recevoir la balle du d�fenseur
			if(terrain) {
				joueur = this.passeurJoueur;
			}
			else {
				joueur = this.passeurIA;
			}
			distanceJoueurBalle = Math.sqrt(Math.pow(joueur.getPosition().getX()-this.positionArriveeBalle.getX(), 2)+Math.pow(joueur.getPosition().getY()-this.positionArriveeBalle.getY(), 2));
		}
		else { // C'est au d�fenseur de r�ceptionner la balle
			// Choisir le d�fenseur le plus proche
			List<Joueur> defenseurs;
			if(terrain) {
				defenseurs = this.defenseursJoueur;
			}
			else {
				defenseurs = this.defenseursIA;
			}
			for(Joueur defenseur : defenseurs) {
				distance = Math.sqrt(Math.pow(defenseur.getPosition().getX()-this.positionArriveeBalle.getX(), 2)+Math.pow(defenseur.getPosition().getY()-this.positionArriveeBalle.getY(), 2));
				if(distance < distanceJoueurBalle) {
					distanceJoueurBalle = distance;
					joueur = defenseur;
				}
			}
		}
		// Calcul th�orique du temps de trajet du joueur vers la balle
		double tjoueur = distanceJoueurBalle/joueur.getVitesse();
		
		// Calcul th�orique du temps de trajet de la balle
		double tballe = this.distanceParcourue/this.vitesseBalleTheorique;
		
		// D�placer le joueur
		List<Joueur> joueursQuiJouent;
		if(terrain) {
			joueursQuiJouent = this.match.getEquipeJoueur().getListJoueur();
		}
		else {
			joueursQuiJouent = this.match.getEquipeIA().getListJoueur();
		}
		// Trouver le bon joueur dans Match et le faire bouger
		for(Joueur j : joueursQuiJouent) {
			if(j.equals(joueur)) {
				j.setPosition(this.positionArriveeBalle);
			}
		}
		// Si le joueur ne peut pas rattraper la balle
		if(tjoueur < tballe) {
			if(terrain) {
				this.match.getScore().getSet().incScoreJoueur();
			}
			else {
				this.match.getScore().getSet().incScoreIA();
			}
		}
		return match;
	}
	
	/**
	 * Choisit la cible dans le terrain adverse en fonction de la position des joueurs adverses
	 * @return la position de la cible � viser
	 */
	private Position choixCibleAdverse() {
		List<Joueur> joueursAdverses;
		List<Position> ciblesIntermediaires;
		Map<Position, Double> positionDistance = new HashMap<Position, Double>();
		// on vise le terrain du haut
		if(this.terrain) {
			joueursAdverses = this.match.getEquipeIA().getListJoueur();
			ciblesIntermediaires = this.ciblesTerrainHaut;
		}
		else { // on vise le terrain du bas
			joueursAdverses = this.match.getEquipeJoueur().getListJoueur();
			ciblesIntermediaires = this.ciblesTerrainBas;
		}
		for(Position cible : ciblesIntermediaires) {
			double d = 0;
			double distanceJoueurBalle = 200;
			// Chercher le joueur le plus proche pour chaque cible
			for(Joueur adversaire : joueursAdverses) {
				d = Math.sqrt(Math.pow((adversaire.getPosition().getX()-cible.getX()),2))+Math.sqrt(Math.pow((adversaire.getPosition().getY()-cible.getY()),2));
				if(d < distanceJoueurBalle) {
					distanceJoueurBalle = d;
				}
			}
			// Ajouter chaque cible avec la distance la plus proche
			positionDistance.put(cible, distanceJoueurBalle);
		}
		
		double plusGrandeDistance = 0;
		Position cible = new Position(0,0);
		for (Map.Entry<Position, Double> entry : positionDistance.entrySet()) {
		    Position position = entry.getKey();
		    double distance = entry.getValue();
		    if(distance > plusGrandeDistance){
		    	plusGrandeDistance = distance;
		    	cible = position;
		    }
		}
		return cible;
	}
}
