/**
 * 
 */
package exception;

/**
 * @author Aurelie
 *
 */
public class JoueurBlesseException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4358747003722142897L;

	public String getMessage() {
		return "Le joueur est bless�, il ne peut pas jouer ! Vous devez d'abord le soigner.";
	}

}
