/**
 * 
 */
package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aurelie, Meriem El Qsimi
 *
 */
public class JoueurFactory {
	
	public static ArrayList<Joueur> getJoueurs(int nombreJoueurs) {
		List<Joueur> listJoueurs = new ArrayList<Joueur>();
		for(int i=0; i < nombreJoueurs; i++){
			int numero = i;
			String nom = null;
			Role role = Role.getRandom();
			int force = randomInt(0, 10);
			int resistance = randomInt(0, 10);
			int vitesse = randomInt(0, 10);
			int precision = randomInt(0, 10);
			int forcePsychologique = randomInt(0, 10);
			int salaire = randomInt(100, 500);
			listJoueurs.add(new Joueur(numero, nom, role, force, resistance, vitesse, precision, forcePsychologique, salaire));
		}
		return (ArrayList<Joueur>) listJoueurs;
	}
		
	public static int randomInt(int min, int max) {
        int random = (int) ((max - min + 1) * Math.random() + min);
        return random;
    }

}
