package exception;

public class NbTempsMortsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3576145668636622777L;

	public String getMessage(){
		return "Nombre alloué de temps morts par set atteint";
	}

}
