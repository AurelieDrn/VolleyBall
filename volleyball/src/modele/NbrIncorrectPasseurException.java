/**
 * 
 */
package modele;

/**
 * @author Aurelie
 *
 */
public class NbrIncorrectPasseurException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8293621255013483561L;

	public String getMessage() {
		return "Il doit y avoir un et un seul passeur sur le terrain.";
	}
	
}
