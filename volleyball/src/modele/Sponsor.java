/**
 * 
 */
package modele;

/**
 * @author Yumiao Fu
 *
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

	public void setRangExige(int rangExige) {
		this.rangExige = rangExige;
	}

	public int getSub() {
		return sub;
	}

	public void setSub(int sub) {
		this.sub = sub;
	}
}
