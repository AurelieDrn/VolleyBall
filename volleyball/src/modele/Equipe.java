/**
 * 
 */
package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yumiao Fu
 * relecteurs Aurélie Durand
 */
public class Equipe implements Comparable<Equipe>{

	private int numeroEquipe;
	private String nomEquipe;
	private int budget;
	private List<Joueur> listJoueurs;
	private List<Sponsor> listSponsors;
	private int salaireHebdo;
	
	public Equipe(int numero, String nom) { 
		super();
		this.numeroEquipe = numero;
		this.nomEquipe = nom;
		this.budget = budget;
		this.listJoueurs = new ArrayList<>();
		this.listSponsors = new ArrayList<>();
		this.salaireHebdo = 5000; //je sais pas comment on va l'attribuer
		//le salaire hebdo sera-il le même pour toutes les équipes? ou bien on l'attribue lors de la création?
	}
	

		


	
	public boolean equipeComplete(){
		return this.listJoueurs.size() == 12;
	}
	
	public boolean addJoueur(Joueur joueur){
		return this.listJoueurs.add(joueur);
	}
	
	public void deleteJoueur(Joueur joueur){
		this.listJoueurs.remove(joueur);
	}
	
	public boolean addSponsor(Sponsor sponsor){
		return this.listSponsors.add(sponsor);
	}
	
	public void deleteJoueur(Sponsor sponsor){
		this.listJoueurs.remove(sponsor);
	}

	
	
	@Override
	public int compareTo(Equipe eq) {
		int last = this.nomEquipe.compareTo(eq.nomEquipe);	
		return last == 0 ? this.nomEquipe.compareTo(eq.nomEquipe) : last;
	}
	
	public int getNumeroEquipe() {
		return this.numeroEquipe;
	}

	public void setNumeroEquipe(int numeroEquipe) {
		this.numeroEquipe = numeroEquipe;
	}

	public String getNomEquipe() {
		return this.nomEquipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getSalaireHebdo() {
		return salaireHebdo;
	}

	public void setSalaireHebdo(int salaireHebdo) {
		this.salaireHebdo = salaireHebdo;
	}

	public List<Joueur> getListJoueurs() {
		return listJoueurs;
	}

	public List<Joueur> getListJoueur() {
		return this.listJoueurs;
	}

	public void setListJoueurs(List<Joueur> listJoueurs) {
		this.listJoueurs = listJoueurs;
	}
	public List<Sponsor> getListSponsors() {
		return listSponsors;
	}

	public void setListSponsors(List<Sponsor> listSponsors) {
		this.listSponsors = listSponsors;
	}
}
