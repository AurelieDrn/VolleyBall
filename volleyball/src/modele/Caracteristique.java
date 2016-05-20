/**
 * 
 */
package modele;

/**
 * @author Aurélie Durand
 *
 */
public enum Caracteristique {
	
	force, resistance, vitesse, precision;

	public static Caracteristique getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
