/**
 * 
 */
package controleur;

import modele.Match;
import modele.Joueur;

/**
 * @author Meriem El Qsimi
 *
 */
public class GestionMatch {
	private Match match;
	private GestionEquipe gestionEquipeIA;
	private GestionEquipe gestionEquipeJoueur;
	public GestionMatch(Match match, GestionEquipe eqIA, GestionEquipe eqJ) {
		super();
		this.match = match;
		this.gestionEquipeIA = eqIA;
				//new GestionEquipe(this.match.getEquipeIA());
		this.gestionEquipeIA = eqJ;

	}
	public void fatigueJoueurs(){
		for(Joueur joueur : match.getEquipeIA().getListJoueur()){
			if(joueur.isEnJeu()){
				joueur.setFatigue(joueur.getFatigue()+1);
			}
		}		
		for(Joueur joueur : match.getEquipeJoueur().getListJoueur()){
			if(joueur.isEnJeu()){
				joueur.setFatigue(joueur.getFatigue()+1);
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
	public void tempsMort(){
	}
	public void jouer(){
	}
}
