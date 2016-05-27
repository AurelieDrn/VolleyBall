package modele;

/**
 * @author Aurélie Durand
 *
 */
public class Balle {

	Position position;
	
	public Balle(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
