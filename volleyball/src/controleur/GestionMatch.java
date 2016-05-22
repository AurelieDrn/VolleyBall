/**
 * 
 */
package controleur;

import java.util.ArrayList;
import java.util.List;

import modele.Joueur;
import modele.JoueurBlesseException;
import modele.Match;
import modele.Role;

/**
 * @author Meriem El Qsimi
 *
 */
public class GestionMatch { 
	private Match match;
	private GestionEquipe gestionEquipeIA;
	private GestionEquipe gestionEquipeJoueur;
	List<Joueur> joueursEnJeuIA;
	List<Joueur> joueursEnJeuJ;
	public GestionMatch(Match match, GestionEquipe eqIA, GestionEquipe eqJ) {
		super();
		this.match = match;
		this.gestionEquipeIA = eqIA;
				//new GestionEquipe(this.match.getEquipeIA());
		this.gestionEquipeIA = eqJ;
		this.joueursEnJeuIA = new ArrayList<Joueur>();
		this.joueursEnJeuJ = new ArrayList<Joueur>();
	}
	public void fatigueJoueurs(){
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
	public void reposJoueurs(){
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
	public void mettreAJourMatch(Match match){
	}
	public void gestionAccident(){
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
	
	public void joueurJoueur(Joueur joueur, GestionEquipe gEquipe) throws JoueurBlesseException{
		gEquipe.jouerJoueur(joueur);
	}
	
	public boolean checkEquipeJ(){
		int i = 0;
		for(Joueur joueur : this.gestionEquipeJoueur.getJoueurEnJeu()){
			if(joueur.getRole() == Role.passeur){
				i++;
			}
		}
		return (i==1);
	}
	public boolean checkEquipeIa(){		
		int i = 0;
		for(Joueur joueur : this.gestionEquipeIA.getJoueurEnJeu()){
			if(joueur.getRole() == Role.passeur){
				i++;
			}
		}
	return (i==1);
	}
	
	public void tempsMort(){
	}
	public void jouer(){
	}
}
