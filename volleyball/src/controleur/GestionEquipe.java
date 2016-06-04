
package controleur;

import java.util.ArrayList;
import java.util.List;

import modele.Caracteristique;
import modele.Equipe;
import modele.Joueur;
import modele.Role;
import modele.Sponsor;

/**
 * @author Meriem El Qsimi
 * relecteurs Aurélie Durand
 */
public class GestionEquipe {
	private Equipe equipe;

	public GestionEquipe(Equipe equipe) {
		super();
		this.equipe = equipe;
	}
	
	public void recruterJoueur(Joueur joueur){
		if(this.equipe.getBudget() > joueur.getSalaire() && !(this.equipe.equipeComplete())) {
			this.equipe.addJoueur(joueur);
		}
	}
	
	public void licencierJoueur(Joueur joueur){
		this.equipe.deleteJoueur(joueur);
	}
	
	public void reposerJoueur(Joueur joueur){
		if(joueur.getFatigue() > 0) {
			joueur.setFatigue(joueur.getFatigue()-1);
		}
	}
	
	public void fatigueJoueur(Joueur joueur){
		if(joueur.getFatigue() < 10) {
			joueur.setFatigue(joueur.getFatigue()+1);
		}
	}
	
	public void entrainerJoueur(Joueur joueur){
		if(joueur.getFatigue()<10) {
			Caracteristique caracteristique = Caracteristique.getRandom();
			switch(caracteristique){
				case force:
					if(joueur.getForce()<10){
						joueur.setForce(joueur.getForce()+1);
					}
				case resistance:
					if(joueur.getResistance()<10){
						joueur.setResistance(joueur.getResistance()+1);
					}
				case vitesse:
					if(joueur.getVitesse()<10){
						joueur.setVitesse(joueur.getVitesse()+1);
					}
				case precision:
					if(joueur.getPrecision()<10){
						joueur.setPrecision(joueur.getPrecision()+1);
					}
				default:
					
			}
			joueur.setFatigue(joueur.getFatigue()+1);
		}
	}
	
	public void payerSalaireJoueurs(){
		for(Joueur joueur : this.equipe.getListJoueur()){
			this.equipe.setBudget(this.equipe.getBudget()-joueur.getSalaire());
		}
	}
	
	public void obtenirSalaireEquipe(){
		this.equipe.obtenirSalaire();
	}
	
	public void obtenirArgentSponsors(Sponsor sponsor){
		this.equipe.setBudget(this.equipe.getBudget() + sponsor.getMontantSubvention());
	}
	
	public List<Joueur> getJoueursEnJeu() {
		List<Joueur> joueursEnJeu = new ArrayList<Joueur>();
		for(Joueur joueur : this.equipe.getListJoueur()) {
			if(joueur.isEnJeu()) {
				joueursEnJeu.add(joueur);
			}
		}
		return joueursEnJeu;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	public void changerRole(Joueur joueur, Role role) {
		for(Joueur j : this.getEquipe().getListJoueur()) {
			if(j.equals(joueur)) {
				j.setRole(role);
			}
		}
	}
}
