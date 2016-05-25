/**
 * 
 */
package controleur.IA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modele.Joueur;
import modele.Match;
import modele.Position;
import modele.Role;

/**
 * @author Aurelie
 *
 */
public class IAGenerale {

	private List<Position> ciblesTerrainHaut;
	private List<Position> ciblesTerrainBas;
	private Position positionArriveeBalle;
	private Match match;
	private int nbTouches;
	private boolean terrain; // true si on vise le terrain du haut
	private Joueur passeurIA;
	private Joueur passeurJoueur;
	private List<Joueur> attaquantsIA;
	private List<Joueur> attaquantsJoueur;
	private List<Joueur> defenseursIA;
	private List<Joueur> defenseursJoueur;
	
	public IAGenerale(Match match) {
		this.match = match;
		this.nbTouches = 2; // initialisé à 2 pour le service
		this.ciblesTerrainHaut = new ArrayList<Position>();
		this.ciblesTerrainBas = new ArrayList<Position>();
		this.attaquantsIA = new ArrayList<Joueur>();
		this.attaquantsJoueur = new ArrayList<Joueur>();
		this.defenseursIA = new ArrayList<Joueur>();
		this.defenseursJoueur = new ArrayList<Joueur>();
		this.terrain = true;
		init();
	}
	
	private void init() {
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
	
	public Match envoi() {
		// On vise le terrain adverse
		if(this.nbTouches == 2) {
			this.positionArriveeBalle = this.choixCibleAdverse();
			this.changementTerrain();
		}
		else if(this.nbTouches == 1) { // Passe à un attaquant de l'équipe
			List<Position> positionsCoequipiers = new ArrayList<Position>();
			List<Joueur> coequipiers;
			if(this.terrain) {
				coequipiers = this.defenseursJoueur;
			}
			else {
				coequipiers = this.defenseursIA;
			}
			for(Joueur joueur : coequipiers) {
				positionsCoequipiers.add(joueur.getPosition());
			}
			// Choisir un coéquipier au hasard
			this.positionArriveeBalle = positionsCoequipiers.get((int) (Math.random() * positionsCoequipiers.size()-1));
		}
		else { // Passe au passeur de l'équipe
			if(terrain){
				this.positionArriveeBalle = this.passeurJoueur.getPosition();
			}
			else {
				this.positionArriveeBalle = this.passeurIA.getPosition();
			}
		}
		// A finir
		return match;
	}
	
	/**
	 * Choisit la cible dans le terrain adverse en fonction de la position des joueurs adverses
	 * @return la position de la cible à viser
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
