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
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import controleur.GestionMatch;
import controleur.IA.IAGenerale;
import exception.JoueurBlesseException;
import exception.MatchEnCoursException;
import exception.NbTempsMortsException;
import exception.SetEnCoursException;
import modele.Etat;
import exception.SetEnCoursException;
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
		g.drawString(this.gm.getEquipeJoueur().getNomEquipe(), 50, 100);
		g.drawString(this.gm.getEquipeIA().getNomEquipe(), 700, 100);
		
		g.drawString("Temps morts : "+this.gm.getMatch().getNbTempsMortEquipeJoueur()+"/2", 50, 200);
		g.drawString("Temps morts : "+this.gm.getMatch().getNbTempsMortEquipeIA()+"/2", 600, 200);
	
		Image tempsmort = new Image("/res/tempsmort.png");
		g.drawImage(tempsmort, 50, 220);
		
		g.drawString("Changements : "+this.gm.getMatch().getNbChangementsEquipeJoueur()+"/6", 50, 300);
		g.drawString("Changements : "+this.gm.getMatch().getNbChangementsEquipeIA()+"/6", 600, 300);
		
		Image changer = new Image("/res/changer.png");
		g.drawImage(changer, 50, 320);
		
		g.drawString("Score : "+this.gm.getMatch().getScore().getSet().getScoreEquipeJoueur(), 280, 10);
		g.drawString("Score : "+this.gm.getMatch().getScore().getSet().getScoreEquipeIA(), 440, 10);
		
		Image balle = new Image("res/balle.png");
		g.drawImage(balle, this.x+this.gm.getMatch().getBalle().getPosition().getX()*32, this.y-this.gm.getMatch().getBalle().getPosition().getY()*32);
	
		for(Joueur j : this.gm.getMatch().getEquipeJoueur().getListJoueur()) {
			g.drawString(j.getNumero()+"", (x+j.getX()*32)+12, (y-j.getY()*32)+30);
		}
		
		for(Joueur j : this.gm.getMatch().getEquipeIA().getListJoueur()) {
			g.drawString(j.getNumero()+"", (x+j.getX()*32)+12, (y-j.getY()*32)-20);
		}
		
		int xJoueur = 280;
		int xIA = 440;
		for(int i=0; i<=2; i++){
			if(this.gm.getMatch().getScore().getListSets().size() <= i) {
				g.drawOval(xJoueur, 30, 10, 10);
				xJoueur = xJoueur+20;
				
				g.drawOval(xIA, 30, 10, 10);
				xIA = xIA+20;
			}
			else {
				try {
					if(this.gm.getMatch().getScore().getListSets().get(i).getGagnant().equals(this.gm.getEquipeJoueur())) {
						g.fillOval(xJoueur, 30, 10, 10);
						xJoueur = xJoueur+20;
						
						g.drawOval(xIA, 30, 10, 10);
						xIA = xIA+20;
					} 
					else {
						g.drawOval(xJoueur, 30, 10, 10);
						xJoueur = xJoueur+20;
						
						g.fillOval(xIA, 30, 10, 10);
						xIA = xIA+20;
					}
				} catch (SetEnCoursException e) {
					e.printStackTrace();
				}
			}
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
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		if((xpos>51&&xpos<434) && (ypos>417&&ypos<437)){
			if(input.isMouseButtonDown(0)){
				//this.gm.prendreTempsMortJoueur(ia);
				System.out.println("Vous avez pris un temps mort !");
			}
		} 
		if((xpos>50&&xpos<232) && (ypos>317&&ypos<349)){
			if(input.isMouseButtonDown(0)){
				System.out.println("Clic sur bouton changer de joueur");
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
