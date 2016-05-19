/**
 * 
 */
package modele;

/**
 * @author Yumiao Fu
 * relecteurs Aurélie Durand
 */
public class Sponsor {
	private int rangExige;
	private int sub;
	
	public Sponsor(int rangExige, int sub) {
		super();
		this.rangExige = rangExige;
		this.sub = sub;
	}
	public int getRangExige() {
		return rangExige;
	}

<<<<<<< HEAD
	public void setRangExige(int rangExige) {
		this.rangExige = rangExige;
	}

	public int getSub() {
		return sub;
	}

	public void setSub(int sub) {
		this.sub = sub;
=======
	private String nomSponsor;
	private int rangExige;
	private int montantSubvention;
	
	public Sponsor(String nom, int rangExige, int montantSubvention){
		this.nomSponsor = nom;
		this.rangExige = rangExige;
		this.montantSubvention = montantSubvention;
	}

	public String getNomSponsor() {
		return this.nomSponsor;
	}

	public void setNomSponsor(String nomSponsor) {
		this.nomSponsor = nomSponsor;
	}

	public int getRangExige() {
		return this.rangExige;
	}

	public void setRangExige(int rangExige) {
		this.rangExige = rangExige;
	}

	public int getMontantSubvention() {
		return this.montantSubvention;
	}

	public void setMontantSubvention(int montantSubvention) {
		this.montantSubvention = montantSubvention;
>>>>>>> branch 'master' of https://gitlab.univ-nantes.fr/MeriemQs/VolleyballJava.git
	}
}
