
package controleur;

import java.util.ArrayList;
import java.util.List;

import modele.Caracteristique;
import modele.Equipe;
import modele.Joueur;
import modele.JoueurBlesseException;
import modele.Sponsor;

/**
 * @author Meriem El Qsimi
 * relecteurs Aurélie Durand
 */
public class GestionEquipe {
	private Equipe equipe;
	private List<Joueur> joueurEnJeu;
	

	public GestionEquipe(Equipe equipe) {
		super();
		this.equipe = equipe;
		this.joueurEnJeu = new ArrayList<Joueur>();
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
		joueur.setFatigue(joueur.getFatigue()-1);
	}
	public void fatigueJoueur(Joueur joueur){
		joueur.setFatigue(joueur.getFatigue()+1);
	}	
	public void entrainerJoueur(Joueur joueur){
		Caracteristique caracteristique = Caracteristique.getRandom();
		switch(caracteristique){
			case force:
				joueur.setForce(joueur.getForce()+1);
			case resistance:
				joueur.setResistance(joueur.getResistance()+1);
			case vitesse:
				joueur.setVitesse(joueur.getVitesse()+1);
			case precision:
				joueur.setPrecision(joueur.getPrecision()+1);
			default:
				System.out.println("Quelle caractéristique dois-je améliorer ?");
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
	
	public List<Joueur> getJoueurEnJeu() {
		return joueurEnJeu;
	}

	public void setJoueurEnJeu(List<Joueur> joueurEnJeu) {
		this.joueurEnJeu = joueurEnJeu;
	}

	public void jouerJoueur(Joueur joueur) throws JoueurBlesseException{
			joueur.setEnJeu(true);
			this.joueurEnJeu.add(joueur);
	}
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
}
