/**
 * 
 */
package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tests.xml.Entity;
import org.newdawn.slick.tiled.TiledMap;

import controleur.GestionMatch;
import controleur.IA.IAGenerale;
import exception.JoueurBlesseException;
import exception.MatchEnCoursException;
import exception.NbTempsMortsException;
import exception.SetEnCoursException;
import modele.Etat;
import modele.Joueur;

/**
 * @author Aurelie
 *
 */
public class Play extends BasicGameState{
	
	private TiledMap map;
	private float x = 256, y = 608;
	private GestionMatch gm;

	public Play(int state, GestionMatch gm){
		this.gm = gm;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		this.map = new TiledMap("/res/map/terrain.tmx");
		this.createAnimations();
	}
	List<Entity> entities = new ArrayList<Entity>();
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		this.map.render(0, 0);
		for(int i=0; i < this.gm.getEquipeIA().getListJoueur().size(); i++) {
			Joueur j = this.gm.getEquipeIA().getListJoueur().get(i);
			g.drawAnimation(j.getAnimation()[j.getDirection() + (j.isMoving() ? 4 : 0)], x+j.getX()*32, y-j.getY()*32);
		}
		for(int i=0; i < this.gm.getEquipeJoueur().getListJoueur().size(); i++) {
			Joueur j = this.gm.getEquipeJoueur().getListJoueur().get(i);
			g.drawAnimation(j.getAnimation()[j.getDirection() + (j.isMoving() ? 4 : 0)], x+j.getX()*32, y-j.getY()*32);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		for(int i=0; i < this.gm.getEquipeJoueur().getListJoueur().size(); i++) {
			Joueur j = this.gm.getEquipeJoueur().getListJoueur().get(i);
			if(j.isMoving()){
				switch(j.getDirection()){
				case 0: this.y -= .1f * delta; break;
	            case 1: this.x -= .1f * delta; break;
	            case 2: this.y += .1f * delta; break;
	            case 3: this.x += .1f * delta; break;
				}
			}
		}
		for(int i=0; i < this.gm.getEquipeIA().getListJoueur().size(); i++) {
			Joueur j = this.gm.getEquipeIA().getListJoueur().get(i);
			if(j.isMoving()){
				switch(j.getDirection()){
				case 0: this.y -= .1f * delta; break;
	            case 1: this.x -= .1f * delta; break;
	            case 2: this.y += .1f * delta; break;
	            case 3: this.x += .1f * delta; break;
				}
			}
		}
	}
	
	
	
	public int getID(){
		return 1;
	}
	
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
	    Animation animation = new Animation();
	    for (int x = startX; x < endX; x++) {
	    	// le deuxième argument de addFrame correspond à la vitesse d'enchaînement des sprites
	        animation.addFrame(spriteSheet.getSprite(x, y), 500);
	    }
	    return animation;
	}

	
	public void createAnimations() throws SlickException {
		for(int i=0; i < this.gm.getEquipeIA().getListJoueur().size(); i++) {
			SpriteSheet spriteSheet = new SpriteSheet("/res/sprites/character.png", 32, 32);
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
			SpriteSheet spriteSheet = new SpriteSheet("/res/sprites/character.png", 32, 32);
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
}
