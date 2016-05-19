package vue;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import controleur.IO.CreateJoueurs;
import modele.Equipe;
import modele.Joueur;

public class Test {

	public static void main(String[] args) throws SlickException {
		/*
		Joueur joueur0 = new Joueur(0, 7, 2);
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
		
		Equipe equipe1 = new Equipe();
		ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
		equipe1.addJoueur(joueur0);
		equipe1.addJoueur(joueur1);
		equipe1.addJoueur(joueur2);
		equipe1.addJoueur(joueur3);
		equipe1.addJoueur(joueur4);
		equipe1.addJoueur(joueur5);
		equipe1.addJoueur(joueur6);
		equipe1.addJoueur(joueur7);
		equipe1.addJoueur(joueur8);
		equipe1.addJoueur(joueur9);
		equipe1.addJoueur(joueur10);
		equipe1.addJoueur(joueur11);
		WindowGame game = new WindowGame(equipe1.getMembres());
		new AppGameContainer(game, 832, 672, false).start();
		//joueurs.get(0).setMoving(true);
		game.setJoueurs(joueurs);
		*/
		CreateJoueurs cr = new CreateJoueurs();
		for(int i = 0; i<cr.getNbrJoueurs(); i++){
			System.out.println(cr.getJoueurs());
		}
		//game.update(game.getContainer(), 0);
	}

}
