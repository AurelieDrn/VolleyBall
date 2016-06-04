/**
 * 
 */
package game;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import controleur.GestionEquipe;
import controleur.GestionMatch;
import exception.JoueurBlesseException;
import exception.MatchEnCoursException;
import exception.NbTempsMortsException;
import exception.SetEnCoursException;
import modele.Equipe;
import modele.EquipeFactory;
import modele.Role;


/**
 * @author Aurelie
 *
 */
public class Game extends StateBasedGame{

	public static final String gamename = "Volley Ball! 0.1";
	// numero des états
	public static final int menu = 0;
	public static final int play = 1;
	public static final int equipe = 2;
	
	public Game(String gamename, GestionMatch gm, GestionEquipe ge){
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play, gm));
		this.addState(new GererEquipe(equipe, ge));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		// initialise la liste des états du jeu
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(equipe).init(gc, this);
		// le premier état à montrer
		this.enterState(menu);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException, JoueurBlesseException, SetEnCoursException, CloneNotSupportedException, MatchEnCoursException, NbTempsMortsException, InterruptedException {
		Equipe equipeJoueur = EquipeFactory.getEquipe();

		equipeJoueur.setNomEquipe("Equipe joueur");
		equipeJoueur.getListJoueur().get(0).setRole(Role.passeur);
		equipeJoueur.getListJoueur().get(1).setRole(Role.attaquant);
		equipeJoueur.getListJoueur().get(2).setRole(Role.attaquant);
		equipeJoueur.getListJoueur().get(3).setRole(Role.defenseur);
		equipeJoueur.getListJoueur().get(4).setRole(Role.defenseur);
		equipeJoueur.getListJoueur().get(5).setRole(Role.defenseur);

		
		Equipe equipeIA = EquipeFactory.getEquipe();
		equipeIA.setNomEquipe("Equipe IA");

		equipeIA.getListJoueur().get(0).setRole(Role.passeur);
		equipeIA.getListJoueur().get(1).setRole(Role.attaquant);
		equipeIA.getListJoueur().get(2).setRole(Role.attaquant);
		equipeIA.getListJoueur().get(3).setRole(Role.defenseur);
		equipeIA.getListJoueur().get(4).setRole(Role.defenseur);
		equipeIA.getListJoueur().get(5).setRole(Role.defenseur);


		InitPositionJoueurs.positionnerJoueursIA(equipeIA.getListJoueur());
		InitPositionJoueurs.positionnerJoueursNonIA(equipeJoueur.getListJoueur());
		
		GestionMatch gm = new GestionMatch(equipeJoueur, equipeIA);
		GestionEquipe ge = new GestionEquipe(equipeJoueur);
		AppGameContainer appgc;
		//gm.jouer();
		try{
			appgc = new AppGameContainer(new Game(gamename, gm, ge));
			appgc.setDisplayMode(832, 672, false);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

}
