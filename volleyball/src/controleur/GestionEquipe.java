/**
 * 
 */
package controleur;

import java.util.List;

import modele.Equipe;
import modele.Joueur;
import modele.Sponsor;

/**
 * @author Aurelie
 *
 */
public class GestionEquipe {
	private Equipe equipe;
	
	public GestionEquipe(Equipe equipe) {
		super();
		this.equipe = equipe;
	}
	
	public void recruterJoueur( Joueur joueur){
		if(!this.equipe.equipeComplete()){
			this.equipe.addJoueur(joueur);
		}
	}
	
	public void licencierJoueur( Joueur joueur){
		this.equipe.deleteJoueur(joueur);
	}
	
	public void reposerJoueur(Joueur joueur){
		
	}
	
	public void payerSalaireJoueurs(){
		for(Joueur joueur : this.equipe.getListJoueur()){
			joueur.setGain(joueur.getGain()+ joueur.getSalaire());
		}
	}
	
	public void obtenirSalaireEquipe(){
		
	}
	
	public void obtenirSponsor(Sponsor sponsor){
		this.equipe.addSponsor(sponsor);
		obtenirArgentSponsors(sponsor);
	} 
	
	public void obtenirArgentSponsors(Sponsor sponsor){
		this.equipe.setBudget(this.equipe.getBudget() + sponsor.getMontantSubvention());
	}
}
