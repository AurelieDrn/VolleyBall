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
public class Equipe implements Comparable<Equipe> {
	
	private int numeroEquipe;
	private String nomEquipe;
	private int budget;
	private List<Joueur> listJoueurs;
	private List<Sponsor> listSponsors;
	private final int SALAIRE = 5000;
	
	
	public Equipe(int numeroEquipe, String nomEquipe, List<Joueur> listJoueurs) {
		super();
		this.numeroEquipe = numeroEquipe;
		this.nomEquipe = nomEquipe;
		this.listJoueurs = listJoueurs;
		this.listSponsors = new ArrayList<>();
	}

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
		String s = "¤------------------------------------------------------¤\n";
		String s2 = "| N° équipe : "+this.numeroEquipe;
		int l2 = s.length()-s2.length()-3;
		for (int i=0; i<= l2; i++) {
			s2 += " ";
		}
		s2 += "|\n";
		
		String s3 = "| Nom équipe : "+this.nomEquipe;
		int l3 = s.length()-s3.length()-3;
		for (int i=0; i<= l3; i++) {
			s3 += " ";
		}
		s3 += "|\n";
		
		String s4 = "| Budget : "+this.budget;
		int l4 = s.length()-s4.length()-3;
		for (int i=0; i<= l4; i++) {
			s4 += " ";
		}
		s4 += "|\n";
		String s5 = "¤------------------------------------------------------¤\n";
		String s6 = s+s2+s3+s4+s5;
		for(int i=0; i < this.listJoueurs.size(); i++) {
			s6 += this.listJoueurs.get(i).toString();
			if(i == this.listJoueurs.size()-1) {
				s6 += "¤--------------------¤\n";
			}
		}
		return s6;
	}
}
