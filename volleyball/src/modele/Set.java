package Modele;

public class Set {
	private boolean premierSet;
	private boolean secondSet;
	private boolean dernierSet;
	
	public Set(){
		this.premierSet = false;
		this.secondSet = false;
		this.dernierSet = false;
	}
	
	public Set(boolean premier, boolean second, boolean dernier){
		this.premierSet = premier;
		this.secondSet = second;
		this.dernierSet = dernier;
	}

	public boolean isPremierSet() {
		return this.premierSet;
	}

	public void setPremierSet(boolean premierSet) {
		this.premierSet = premierSet;
	}

	public boolean isSecondSet() {
		return this.secondSet;
	}

	public void setSecondSet(boolean secondSet) {
		this.secondSet = secondSet;
	}

	public boolean isDernierSet() {
		return this.dernierSet;
	}

	public void setDernierSet(boolean dernierSet) {
		this.dernierSet = dernierSet;
	}
}
	