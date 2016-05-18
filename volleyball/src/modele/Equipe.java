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
public class Equipe {
	private int numeroEquipe;
	private String nomEquipe;
	private int budget;
	private List<Joueur> listJoueurs;
	private List<Sponsor> listSponsors;
		
	public Equipe(int numero, String nom, int budget){
		this.numeroEquipe = numero;
		this.nomEquipe = nom;
		this.budget = budget;
		this.listJoueurs = new ArrayList<>();
		this.listSponsors = new ArrayList<>();
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
	public List<Sponsor> getListSponsors() {
		return listSponsors;
	}

	public void setListSponsors(List<Sponsor> listSponsors) {
		this.listSponsors = listSponsors;
	}
}
