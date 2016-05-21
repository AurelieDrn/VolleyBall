/**
 * 
 */
package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yumiao Fu
 * relecteurs Aurélie Durand, Meriem El Qsimi
 */
public class Equipe extends Set implements Comparable<Equipe> {
	
	private int numeroEquipe;
	private String nomEquipe;
	private int budget;
	private List<Joueur> listJoueurs;
	private List<Sponsor> listSponsors;
	private final int SALAIRE = 5000;
		
	public Equipe(int numero, String nom) {
		this.numeroEquipe = numero;
		this.nomEquipe = nom;
		this.budget = 0;
		this.listJoueurs = new ArrayList<>();
		this.listSponsors = new ArrayList<>();
	}

	public boolean equipeComplete(){
		return this.listJoueurs.size() == 12;
	}
	
	public boolean addJoueur(Joueur joueur){
		return this.listJoueurs.add(joueur);
	}
	
	public boolean deleteJoueur(Joueur joueur){
		return this.listJoueurs.remove(joueur);
	}
	
	public boolean addSponsor(Sponsor sponsor){
		return this.listSponsors.add(sponsor);
	}
	
	public boolean deleteSponsor(Sponsor sponsor) {
		return this.listSponsors.remove(sponsor);
	}
	
	public void deleteJoueur(Sponsor sponsor){
		this.listJoueurs.remove(sponsor);
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
		return this.budget;
	}
	
	public void setBudget(int budget) {
		this.budget = budget;
	}

	public List<Joueur> getListJoueur() {
		return this.listJoueurs;
	}

	public void setListJoueurs(List<Joueur> listJoueurs) {
		this.listJoueurs = listJoueurs;
	}
	
	public void obtenirSalaire() {
		this.budget = this.budget + SALAIRE;
	}

	@Override
	public int compareTo(Equipe eq) {
		int last = this.nomEquipe.compareTo(eq.nomEquipe);	
		return last == 0 ? this.nomEquipe.compareTo(eq.nomEquipe) : last;
	}

	@Override
	public String toString() {
		return "Equipe [numeroEquipe=" + numeroEquipe + ", nomEquipe=" + nomEquipe + ", budget=" + budget
				+ ", listJoueurs=" + listJoueurs + ", listSponsors=" + listSponsors + "]";
	}
}
