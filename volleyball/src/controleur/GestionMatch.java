/**
 * 
 */
package controleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import controleur.IA.IAGenerale;
import exception.JoueurBlesseException;
import exception.NbChangementsDepassesException;
import exception.NbrIncorrectPasseurException;
import modele.Equipe;
import modele.Joueur;
import modele.Match;
import modele.Position;
import modele.Role;

/**
 * @author Meriem El Qsimi, Aurélie DURAND
 *
 */
public class GestionMatch { 
	// on utilise ses deux classes pour nous aider
	private GestionEquipe gestionEquipeIA;
	private GestionEquipe gestionEquipeJoueur;
	// c'est l'état d'un match à sauvegarder
	private Match match;
	private List<Position> positionsDepartJoueur;
	private List<Position> positionsDepartIA;
	
	public GestionMatch(Equipe equipeJoueur, Equipe equipeIA) {
		this.gestionEquipeIA = new GestionEquipe(equipeIA);
		this.gestionEquipeJoueur = new GestionEquipe(equipeJoueur);
		this.match = new Match(equipeJoueur, equipeIA);
		
		this.positionsDepartJoueur = new LinkedList<Position>();
		this.positionsDepartIA = new LinkedList<Position>();
		this.init();
	}
	
	private void init() {
		this.positionsDepartJoueur.add(new Position(7,2));
		this.positionsDepartJoueur.add(new Position(4,2));
		this.positionsDepartJoueur.add(new Position(1,2));
		this.positionsDepartJoueur.add(new Position(1,7));
		this.positionsDepartJoueur.add(new Position(4,7));
		this.positionsDepartJoueur.add(new Position(7,7));
		
		this.positionsDepartIA.add(new Position(1,15));
		this.positionsDepartIA.add(new Position(4,15));
		this.positionsDepartIA.add(new Position(7,15));
		this.positionsDepartIA.add(new Position(7,10));
		this.positionsDepartIA.add(new Position(4,10));
		this.positionsDepartIA.add(new Position(1,10));
	}
	
	/**
	 * Fonction qui permet d'augmenter la fatigue de tous les joueurs sur le terrain
	 */
	private void fatigueJoueurs(){
		for(Joueur joueur : match.getEquipeIA().getListJoueur()){
			if(joueur.isEnJeu()){
				this.gestionEquipeIA.fatigueJoueur(joueur);
			}
		}		
		for(Joueur joueur : match.getEquipeJoueur().getListJoueur()){
			if(joueur.isEnJeu()){
				this.gestionEquipeJoueur.fatigueJoueur(joueur);
			}
		}
	}
	
	/**
	 * Fonction qui permet de diminuer la fatiguge de tous les joueurs qui attendent
	 */
	private void reposJoueurs(){
		for(Joueur joueur : match.getEquipeIA().getListJoueur()){
			if(!joueur.isEnJeu()){
				this.gestionEquipeIA.reposerJoueur(joueur);
			}
		}		
		for(Joueur joueur : match.getEquipeJoueur().getListJoueur()){
			if(!joueur.isEnJeu()){
				this.gestionEquipeJoueur.reposerJoueur(joueur);
			}
		}
	}
	
	/**
	 * Fonction qui permet de créer un accident à un joueur sur le terrain lorsque sa fatigue est au maximum
	 */
	private void gestionAccident(){
		for(Joueur joueur : this.match.getEquipeIA().getListJoueur()){
			if(joueur.getFatigue() == 10){
				joueur.setEstBlesse(true);
			}
		}
		for(Joueur joueur : this.match.getEquipeJoueur().getListJoueur()){
			if(joueur.getFatigue() == 10){
				joueur.setEstBlesse(true);
			}
		}
	}
	
	/**
	 * Fonction permettant de changer un terrain contre un joueur en attente
	 * @param joueurTerrain
	 * @param joueurAttente
	 * @throws JoueurBlesseException
	 * @throws NbrIncorrectPasseurException 
	 * @throws NbChangementsDepassesException 
	 */
	public void changerJoueurs(Joueur joueurTerrain, Joueur joueurAttente) throws JoueurBlesseException, NbrIncorrectPasseurException, NbChangementsDepassesException {
		// Le joueur peut encore faire des changements
		if(this.match.getNbChangementsEquipeJoueur() < 6) {
			// Le joueur en attente ne doit pas être blessé
			if(joueurAttente.estBlesse()) {
				throw new JoueurBlesseException();
			}
			if(joueurTerrain.getRole() == Role.passeur) {
				if(joueurAttente.getRole() != Role.passeur) {
					throw new NbrIncorrectPasseurException();
				}
			}
			else {
				joueurTerrain.setEnJeu(false);
				joueurAttente.setEnJeu(true);
				// Ne pas oublier de repositionner le joueur
				joueurAttente.setPosition(joueurTerrain.getPosition());
			}
		}
		else {
			throw new NbChangementsDepassesException();
		}
		
	}
	
	/**
	 * Permet au joueur de choisir les joueurs qui vont jouer.
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws JoueurBlesseException
	 */
	private void constituerEquipe() throws IOException, NumberFormatException, JoueurBlesseException {
		System.out.println(this.match.getEquipeJoueur());
		System.out.println("Veuillez sélectionner les 6 joueurs qui vous voulez faire jouer.");
		System.out.println("(Rentrez le numéro des joueurs un par un. Pensez à sélectionner un et un seul passeur.)");

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1; i<7; i++) {
        	System.out.print("Joueur "+i+" : ");
        	String numString = bufferRead.readLine();
        	int numero = Integer.parseInt(numString);
        	// Il faudra rentrer l'id unique
        	for(Joueur joueur : this.match.getEquipeJoueur().getListJoueur()) {
        		if(joueur.getNumero() == numero) {
        			joueur.setEnJeu(true);
        			break;
        		}
        	}
        }
	}
	
	/**
	 * Fonction qui vérifie que le joueur a bien choisi un équipe avec un et un seul passeur.
	 * L'IA ne doit pas faire d'erreur à ce niveau là.
	 * @return true si l'équipe de joueurs qui jouent contient un et un seul passeur, faux sinon
	 */
	private boolean nombrePasseurCorrect(){
		int i = 0;
		for(Joueur joueur : this.gestionEquipeJoueur.getJoueursEnJeu()){
			if(joueur.getRole() == Role.passeur){
				i++;
			}
		}
		return (i==1);
	}
	
	/**
	 * Fonction qui vérifie que le joueur a bien sélectionné 6 joueurs pour jouer
	 * @return true si l'équipe contient 6 joueurs en jeu, faux sinon
	 */
	private boolean nombreJoueursCorrect() {
		int compteur = 0;
		for(Joueur joueur : this.gestionEquipeJoueur.getJoueursEnJeu()) {
			compteur++;
		}
		return (compteur==6);
	}
	
	private void resetEquipe() throws JoueurBlesseException {
		for(Joueur joueur : this.getEquipeJoueur().getListJoueur()) {
			joueur.setEnJeu(false);
		}
	}
	
	private boolean matchFini() {
		return this.match.getScore().getNbSetIA() == 3 || this.match.getScore().getNbSetJoueur() == 3;
	}
	
	public void tempsMort(){
	}
	
	/**
	 * Permet de repositionner les joueurs sur le terrain à la position de départ
	 */
	private void initPositions() {
		for(int i=0; i < this.positionsDepartJoueur.size(); i++) {
			this.match.getEquipeJoueur().getListJoueur().get(i).setPosition(this.positionsDepartJoueur.get(i));
			this.match.getEquipeIA().getListJoueur().get(i).setPosition(this.positionsDepartIA.get(i));
		}
	}
	
	/**
	 * Effectue une rotation dans l'équipe IA. Cette fonction place les joueurs, pas besoin d'appeler initPositions après.
	 */
	private void rotationIA() {
		for(int i=0; i <= this.positionsDepartIA.size(); i++) {
			this.positionsDepartIA.add(((LinkedList<Position>) this.positionsDepartIA).removeFirst());
		}
		this.initPositions();
	}
	
	/**
	 * Effectue une rotation dans l'équipe du joueur. Cette fonction place les joueurs, pas besoin d'appeler initPositions après.
	 */
	private void rotationJoueur() {
		for(int i=0; i <= this.positionsDepartJoueur.size(); i++) {
			this.positionsDepartJoueur.add(((LinkedList<Position>) this.positionsDepartJoueur).removeFirst());
		}
		this.initPositions();
	}
	
	/**
	 * Permet de faire jouer un match
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws JoueurBlesseException
	 */
	public void jouer() throws IOException, NumberFormatException, JoueurBlesseException{
		System.out.println(this.match.getEquipeJoueur().getNomEquipe()+" VS "+this.match.getEquipeIA().getNomEquipe());
		this.constituerEquipe();
		while(this.nombrePasseurCorrect() == false) {
			System.out.println("Il faut un et un seul passeur dans votre équipe.\n");
			this.resetEquipe();
			this.constituerEquipe();
		}
		while(this.nombreJoueursCorrect() == false) {
			System.out.println("Vous devez sélectionner 6 joueurs dans votre équipe.\n");
			this.resetEquipe();
			this.constituerEquipe();
		}
		IAGenerale ia = new IAGenerale(this.match);
		this.initPositions();
		while(this.matchFini() == false) {
			ia.envoi();
			ia.reception();
		}
	}
	
	// getters et setters
	public Equipe getEquipeIA() {
		return this.match.getEquipeIA();
	}

	public void setEquipeIA(Equipe equipeIA) {
		this.match.setEquipeIA(equipeIA);
	}

	public Equipe getEquipeJoueur() {
		return this.match.getEquipeJoueur();
	}

	public void setEquipeJoueur(Equipe equipeJoueur) {
		this.match.setEquipeJoueur(equipeJoueur);
	}

	public GestionEquipe getGestionEquipeIA() {
		return gestionEquipeIA;
	}

	public void setGestionEquipeIA(GestionEquipe gestionEquipeIA) {
		this.gestionEquipeIA = gestionEquipeIA;
	}

	public GestionEquipe getGestionEquipeJoueur() {
		return gestionEquipeJoueur;
	}

	public void setGestionEquipeJoueur(GestionEquipe gestionEquipeJoueur) {
		this.gestionEquipeJoueur = gestionEquipeJoueur;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public List<Position> getPositionsDepartJoueur() {
		return positionsDepartJoueur;
	}

	public void setPositionsDepartJoueur(List<Position> positionsDepartJoueur) {
		this.positionsDepartJoueur = positionsDepartJoueur;
	}

	public List<Position> getPositionsDepartIA() {
		return positionsDepartIA;
	}

	public void setPositionsDepartIA(List<Position> positionsDepartIA) {
		this.positionsDepartIA = positionsDepartIA;
	}
}
