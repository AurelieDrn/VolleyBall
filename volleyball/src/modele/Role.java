/**
 * 
 */
package modele;

/**
 * @author Yumiao Fu
 * relecteurs Meriem El Qsimi, Aur�lie Durand
 */
public enum Role {
	attaquant, defenseur, passeur;
	
	public static Role getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
