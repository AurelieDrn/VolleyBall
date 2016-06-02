package exception;

public class MatchEnCoursException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1275008416669075758L;

	public String getMessage() {
		return "Le match n'est pas fini !";
	}
}
