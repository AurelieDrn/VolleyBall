package Modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Equipe extends Observable{
	private int numeroEquipe;
	private String nomEquipe;
	private int budget;
	private List<Joueur> listJoueur;
	private List<Sponsor> listSponsor;
	
	public Equipe(){
		super();
	}
	
	public Equipe(int numero, String nom, int budget){
		this.numeroEquipe = numero;
		this.nomEquipe = nom;
		this.budget = budget;
		this.listJoueur = new ArrayList<>();
		this.listSponsor = new ArrayList<>();
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
		return this.listJoueur;
	}

	public void setListJoueur(List<Joueur> listJoueur) {
		this.listJoueur = listJoueur;
	}
	public List<Sponsor> getListSponsor() {
		return listSponsor;
	}

	public void setListSponsor(List<Sponsor> listSponsor) {
		this.listSponsor = listSponsor;
	}

	public void init(){
		this.setChanged();
		this.notifyObservers();
	}	

}
