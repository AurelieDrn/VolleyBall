package exception;

public class NbChangementsDepassesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3782386504155107593L;
	
	public String getMessage() {
		return "Vous ne pouvez plus changer de joueurs (6 fois max. par set.";
	}
}
