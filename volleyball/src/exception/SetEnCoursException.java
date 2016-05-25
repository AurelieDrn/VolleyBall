/**
 * 
 */
package modele;

/**
 * @author Aurelie Durand
 *
 */
public class SetEnCoursException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6079043120133743780L;

	public String getMessage() {
		return "Le set est encore en cours de jeu !";
	}
}
