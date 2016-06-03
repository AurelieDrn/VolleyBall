/**
 * 
 */
package vue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modele.Joueur;
import modele.Position;

/**
 * @author Aurelie
 *
 */
public class InitPositionJoueurs {
	
	// positionne les joueurs de l'équipe sur le demi terrain du bas
	public static ArrayList<Joueur> positionnerJoueursNonIA(List<Joueur> joueurs) {
		Collections.shuffle(joueurs);
		// tous les joueurs regardent vers le Nord
		for(Joueur joueur : joueurs) {
			joueur.setDirection(0);
		}
		// ligne du fond
		joueurs.get(0).setPosition(new Position(7,2));
		joueurs.get(1).setPosition(new Position(4,2));
		joueurs.get(2).setPosition(new Position(1,2));
		// ligne avant
		joueurs.get(3).setPosition(new Position(1,7));
		joueurs.get(4).setPosition(new Position(4,7));
		joueurs.get(5).setPosition(new Position(7,7));
		return (ArrayList<Joueur>) joueurs;
	}
	
	// positionne les joueurs de l'équipe sur le demi terrain du haut
		public static ArrayList<Joueur> positionnerJoueursIA(List<Joueur> joueurs) {
			Collections.shuffle(joueurs);
			// tous les joueurs regardent vers le Nord
			for(Joueur joueur : joueurs) {
				joueur.setDirection(2);
			}
			// ligne du fond
			joueurs.get(0).setPosition(new Position(1,15));
			joueurs.get(1).setPosition(new Position(4,15));
			joueurs.get(2).setPosition(new Position(7,15));
			// ligne avant
			joueurs.get(3).setPosition(new Position(7,10));
			joueurs.get(4).setPosition(new Position(4,10));
			joueurs.get(5).setPosition(new Position(1,10));
			return (ArrayList<Joueur>) joueurs;
		}

}
