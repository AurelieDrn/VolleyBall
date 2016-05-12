/**
 * 
 */
package vue;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * @author Aurelie
 *
 */
public class WindowGame extends BasicGame {

	private GameContainer container;
	private TiledMap map;

	public WindowGame() {
		super("WindowGame");
	}
	
	/* (non-Javadoc)
	 * @see org.newdawn.slick.BasicGame#init(org.newdawn.slick.GameContainer)
	 * Initialise le contenu du jeu, charger les graphismes, la musique etc...
	 */
	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		//this.map = new TiledMap("/src/main/resources/map/terrain.tmx");
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.Game#render(org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
	 * Affiche le contenu du jeu
	 */
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		this.map.render(0, 0);
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.BasicGame#update(org.newdawn.slick.GameContainer, int)
	 * Met à jour les éléments de la scene en fonction du delta temps qui est survenu
	 */
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
	}
	
	/*
	 * Lance la bouche infinie
	 */
	public static void main(String[] args) throws SlickException {
		// Configure l'environnement d'execution de la boucle
		new AppGameContainer(new WindowGame(), 832, 672, false).start();
	}
	
	@Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
    }

}
