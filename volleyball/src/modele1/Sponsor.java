package Modele;

public class Sponsor {
	private String nomSponsor;
	private int rangExige;
	private int montantSubvention;
	
	public Sponsor(){
		super();
	}
	
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
	}
	
}
