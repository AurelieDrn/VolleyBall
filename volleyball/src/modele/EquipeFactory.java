/**
 * 
 */
package modele;

import java.util.ArrayList;

/**
 * @author Aurelie, Meriem El Qsimi
 *
 */
public class EquipeFactory {
	
	public static Equipe getEquipe() {
		ArrayList<Joueur> listJoueurs = JoueurFactory.getJoueurs(6);
		Equipe equipe = new Equipe(0, null);
		equipe.setListJoueurs(listJoueurs);
		return equipe;
	}

}
