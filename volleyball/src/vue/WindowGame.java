/**
 * 
 */
package vue;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

import controleur.GestionMatch;
import modele.Joueur;

/**
 * @author Aurelie
 *
 */
public class WindowGame extends BasicGame {

	private GameContainer container;
	private TiledMap map;
	// coordonnées x et y initialisés au coin inférieur gauche
	private float x = 256, y = 608;
	//private int direction = 0;
	//private boolean moving = true;
	
	//private ArrayList<Animation[]> joueurs;
	private List<Joueur> joueurs;
	private GestionMatch gm;
	
	public WindowGame(GestionMatch gestionM) {
		super("WindowGame");
		//this.joueurs = new ArrayList<Animation[]>();
		this.gm = gestionM;
	}
	
	/* (non-Javadoc)
	 * @see org.newdawn.slick.BasicGame#init(org.newdawn.slick.GameContainer)
	 * Initialise le contenu du jeu, charger les graphismes, la musique etc...
	 */
	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		// affichage du terrain
		this.map = new TiledMap("/src/main/resources/map/terrain.tmx");
		this.createAnimations();
		//Animation[] animations = this.createCharacter();
		//this.joueurs.add(animations);
	}
	
	/*
	 * Ajoute les sprites pour effectuer une animation
	 */
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
	    Animation animation = new Animation();
	    for (int x = startX; x < endX; x++) {
	    	// le deuxième argument de addFrame correspond à la vitesse d'enchaînement des sprites
	        animation.addFrame(spriteSheet.getSprite(x, y), 500);
	    }
	    return animation;
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.Game#render(org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
	 * Affiche le contenu du jeu
	 */
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		this.map.render(0, 0);
		for(int i=0; i < this.gm.getEquipeIA().getListJoueur().size(); i++) {
			Joueur j = this.gm.getEquipeIA().getListJoueur().get(i);
			// dessine les joueurs sur le terrain
			g.drawAnimation(j.getAnimation()[j.getDirection() + (j.isMoving() ? 4 : 0)], x+j.getX()*32, y-j.getY()*32);
		}
		for(int i=0; i < this.gm.getEquipeJoueur().getListJoueur().size(); i++) {
			Joueur j = this.gm.getEquipeJoueur().getListJoueur().get(i);
			// dessine les joueurs sur le terrain
			g.drawAnimation(j.getAnimation()[j.getDirection() + (j.isMoving() ? 4 : 0)], x+j.getX()*32, y-j.getY()*32);
		}
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.BasicGame#update(org.newdawn.slick.GameContainer, int)
	 * Met à jour les éléments de la scene en fonction du delta temps qui est survenu
	 */
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
    	/*Joueur j = this.joueurs.get(0);
		if (j.isMoving()) {
	        switch (j.getDirection()) {
	            case 0: j.setY(j.getY()+.01f * delta); break;
	            case 1: j.setX(j.getX()-.01f * delta); break;
	            case 2: j.setY(j.getY()-.01f * delta); break;
	            case 3: j.setX(j.getX()+.01f * delta); break;
	        }
	    }*/
	    /*if(this.joueurs.get(0).isMoving()) {
			this.joueurs.get(0).setX(this.joueurs.get(0).getX()-0.1f * delta);
		}*/
	}
	
	@Override
    public void keyReleased(int key, char c) {
		// Ferme la fenêtre au clic sur la touche ECHAP
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
        //this.joueurs.get(0).setMoving(false);
    }
	
	@Override
	public void keyPressed(int key, char c) {
	    /*switch (key) {
	        case Input.KEY_UP:    this.joueurs.get(0).setDirection(0); this.joueurs.get(0).setMoving(true); break;
	        case Input.KEY_LEFT:  this.joueurs.get(0).setDirection(1); this.joueurs.get(0).setMoving(true); break;
	        case Input.KEY_DOWN:  this.joueurs.get(0).setDirection(2); this.joueurs.get(0).setMoving(true); break;
	        case Input.KEY_RIGHT: this.joueurs.get(0).setDirection(3); this.joueurs.get(0).setMoving(true); break;
	    }*/
	}
	
	/*
	 * Crée les objets animations pour chaque joueur de la liste joueurs
	 */
	public void createAnimations() throws SlickException {
		for(int i=0; i < this.gm.getEquipeIA().getListJoueur().size(); i++) {
			SpriteSheet spriteSheet = new SpriteSheet("/src/main/resources/sprites/character.png", 32, 32);
			Animation[] animation = new Animation[8];
			animation[0] = loadAnimation(spriteSheet, 0, 1, 0);
		    animation[1] = loadAnimation(spriteSheet, 0, 1, 1);
		    animation[2] = loadAnimation(spriteSheet, 0, 1, 2);
		    animation[3] = loadAnimation(spriteSheet, 0, 1, 3);
		    animation[4] = loadAnimation(spriteSheet, 1, 3, 0);
		    animation[5] = loadAnimation(spriteSheet, 1, 3, 1);
		    animation[6] = loadAnimation(spriteSheet, 1, 3, 2);
		    animation[7] = loadAnimation(spriteSheet, 1, 3, 3);
		    this.gm.getEquipeIA().getListJoueur().get(i).setAnimation(animation);
		}
		for(int i=0; i < this.gm.getEquipeJoueur().getListJoueur().size(); i++) {
			SpriteSheet spriteSheet = new SpriteSheet("/src/main/resources/sprites/character.png", 32, 32);
			Animation[] animation = new Animation[8];
			animation[0] = loadAnimation(spriteSheet, 0, 1, 0);
		    animation[1] = loadAnimation(spriteSheet, 0, 1, 1);
		    animation[2] = loadAnimation(spriteSheet, 0, 1, 2);
		    animation[3] = loadAnimation(spriteSheet, 0, 1, 3);
		    animation[4] = loadAnimation(spriteSheet, 1, 3, 0);
		    animation[5] = loadAnimation(spriteSheet, 1, 3, 1);
		    animation[6] = loadAnimation(spriteSheet, 1, 3, 2);
		    animation[7] = loadAnimation(spriteSheet, 1, 3, 3);
		    this.gm.getEquipeJoueur().getListJoueur().get(i).setAnimation(animation);
		}
	}
	
	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public GameContainer getContainer() {
		return container;
	}
	
	/*
	 * Lance la bouche infinie
	 */
	/*public static void main(String[] args) throws SlickException {
		// Configure l'environnement d'execution de la boucle
		
		new AppGameContainer(new WindowGame(joueurs), 832, 672, false).start();
	}*/
	
}
