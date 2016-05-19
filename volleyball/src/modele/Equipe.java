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
<<<<<<< HEAD
public class Equipe implements Comparable<Equipe>{
	private String nom;
	private List<Joueur> membres;
	private int budget;
	private List<Sponsor> sponsors;
	private int salaireHebdo;
	
	public Equipe() { 
		super();
		this.membres = new ArrayList<Joueur>();
		this.sponsors = new ArrayList<Sponsor>();
		this.budget = 0;
		this.salaireHebdo = 5000; //je sais pas comment on va l'attribuer
		//le salaire hebdo sera-il le même pour toutes les équipes? ou bien on l'attribue lors de la création?
	}
	
	public List<Joueur> getMembres() {
		return membres;
=======
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
>>>>>>> branch 'master' of https://gitlab.univ-nantes.fr/MeriemQs/VolleyballJava.git
	}

<<<<<<< HEAD
	public void setMembres(List<Joueur> membres) {
		this.membres = membres;
	}


	
	public boolean equipeComplete(){
		return this.membres.size() == 12;
	}
	
	public boolean addJoueur(Joueur joueur){
		return this.membres.add(joueur);
	}
	
	public void deleteJoueur(Joueur joueur){
		this.membres.remove(joueur);
	}
	
	public boolean addSponsor(Sponsor sponsor){
		return this.sponsors.add(sponsor);
	}
	
	public void deleteJoueur(Sponsor sponsor){
		this.sponsors.remove(sponsor);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public List<Sponsor> getSponsors() {
		return sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	@Override
	public int compareTo(Equipe eq) {
		int last = this.nom.compareTo(eq.nom);	
		return last == 0 ? this.nom.compareTo(eq.nom) : last;
	}
	
=======
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
>>>>>>> branch 'master' of https://gitlab.univ-nantes.fr/MeriemQs/VolleyballJava.git
}
