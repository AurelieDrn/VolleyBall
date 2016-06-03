/**
 * 
 */
package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import controleur.GestionMatch;
import modele.Equipe;
import modele.EquipeFactory;

/**
 * @author Aurelie
 *
 */
public class Game extends StateBasedGame{

	public static final String gamename = "Volley Ball! 0.1";
	// numero des états
	public static final int menu = 0;
	public static final int play = 1;
	protected GestionMatch gm;
	
	public Game(String gamename, GestionMatch gm){
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play, gm));
		this.gm = gm;
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		// initialise la liste des états du jeu
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		// le premier état à montrer
		this.enterState(menu);
	}
	
	public static void main(String[] args) {
		Equipe equipeJoueur = EquipeFactory.getEquipe();
		equipeJoueur.setNomEquipe("La super équipe de Mr Dupont");

		Equipe equipeIA = EquipeFactory.getEquipe();
		equipeJoueur.setNomEquipe("IA");

		InitPositionJoueurs.positionnerJoueursIA(equipeIA.getListJoueur());
		InitPositionJoueurs.positionnerJoueursNonIA(equipeJoueur.getListJoueur());
		
		GestionMatch gm = new GestionMatch(equipeJoueur, equipeIA);
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Game(gamename, gm));
			appgc.setDisplayMode(832, 672, false);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

}
