/**
 * 
 */
package controleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import modele.Equipe;
import modele.Joueur;
import modele.JoueurBlesseException;
import modele.Match;
import modele.NbrIncorrectPasseurException;
import modele.Role;

/**
 * @author Meriem El Qsimi
 *
 */
public class GestionMatch { 
	// g�rer le match entre deux �quipes
	private Equipe equipeIA;
	private Equipe equipeJoueur;
	// on utilise ses deux classes pour nous aider
	private GestionEquipe gestionEquipeIA;
	private GestionEquipe gestionEquipeJoueur;
	// c'est l'�tat d'un match � sauvegarder
	private Match match;
	
	public GestionMatch(Equipe equipeIA, Equipe equipeJoueur) {
		this.equipeIA = equipeIA;
		this.equipeJoueur = equipeJoueur;
		
		this.gestionEquipeIA = new GestionEquipe(equipeIA);
		this.gestionEquipeJoueur = new GestionEquipe(equipeJoueur);
		this.match = new Match(equipeIA, equipeJoueur);
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
	 * Fonction qui permet de cr�er un accident � un joueur sur le terrain lorsque sa fatigue est au maximum
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
	 */
	public void rotation(Joueur joueurTerrain, Joueur joueurAttente) throws JoueurBlesseException, NbrIncorrectPasseurException {
		// Le joueur en attente ne doit pas �tre bless�
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
	
	private void constituerEquipe() throws IOException, NumberFormatException, JoueurBlesseException {
		System.out.println(this.equipeJoueur);
		System.out.println("Veuillez s�lectionner les 6 joueurs qui vous voulez faire jouer.");
		System.out.println("(Rentrez le num�ro des joueurs un par un. Pensez � s�lectionner un et un seul passeur.)");

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1; i<7; i++) {
        	System.out.print("Joueur "+i+" : ");
        	String numString = bufferRead.readLine();
        	int numero = Integer.parseInt(numString);
        	this.equipeJoueur.getListJoueur().get(numero).setEnJeu(true);
        	//A finir
        }
	}
	
	/**
	 * Fonction qui v�rifie que le joueur a bien choisi un �quipe avec un et un seul passeur.
	 * L'IA ne doit pas faire d'erreur � ce niveau l�.
	 * @return true si l'�quipe de joueurs qui jouent contient un et un seul passeur, faux sinon
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
	
	
	public void tempsMort(){
	}
	
	public void jouer() throws IOException, NumberFormatException, JoueurBlesseException{
		System.out.println(this.equipeJoueur+" VS "+this.equipeIA);
		constituerEquipe();
	}
	
	public Equipe getEquipeIA() {
		return equipeIA;
	}

	public void setEquipeIA(Equipe equipeIA) {
		this.equipeIA = equipeIA;
	}

	public Equipe getEquipeJoueur() {
		return equipeJoueur;
	}

	public void setEquipeJoueur(Equipe equipeJoueur) {
		this.equipeJoueur = equipeJoueur;
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
}
