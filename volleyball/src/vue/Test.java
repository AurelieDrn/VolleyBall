package vue;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import modele.Joueur;
import modele.JoueurFactory;

public class Test {

	public static void main(String[] args) throws SlickException {
		/*Joueur joueur0 = new Joueur(0, 7, 2);
		Joueur joueur1 = new Joueur(0, 4, 2);
		Joueur joueur2 = new Joueur(0, 1, 2);
		
		Joueur joueur3 = new Joueur(0, 1, 7);
		Joueur joueur4 = new Joueur(0, 4, 7);
		Joueur joueur5 = new Joueur(0, 7, 7);
		
		Joueur joueur6 = new Joueur(2, 1, 15);
		Joueur joueur7 = new Joueur(2, 4, 15);
		Joueur joueur8 = new Joueur(2, 7, 15);
		
		Joueur joueur9 = new Joueur(2, 7, 10);
		Joueur joueur10 = new Joueur(2, 4, 10);
		Joueur joueur11 = new Joueur(2, 1, 10);
		
		ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(joueur0);
		joueurs.add(joueur1);
		joueurs.add(joueur2);
		joueurs.add(joueur3);
		joueurs.add(joueur4);
		joueurs.add(joueur5);
		joueurs.add(joueur6);
		joueurs.add(joueur7);
		joueurs.add(joueur8);
		joueurs.add(joueur9);
		joueurs.add(joueur10);
		joueurs.add(joueur11);
		*/
		ArrayList<Joueur> joueurs = JoueurFactory.getJoueurs(12);
		WindowGame game = new WindowGame(joueurs);
		AppGameContainer a = new AppGameContainer(game, 832, 672, false);
		//a.start();
		game.getJoueurs().get(0).setMoving(true);
		a.start();
		//game.setJoueurs(joueurs);
		
		//game.update(game.getContainer(), 0);
	}

}
