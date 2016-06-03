/**
 * 
 */
package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 * @author Aurelie
 *
 */
public class Menu extends BasicGameState{

	public Menu(int state){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawString("x : "+Mouse.getX()+" Y : "+Mouse.getY(), 50, 50);
		
		Image jouer = new Image("/res/jouer.png");
		Image equipe = new Image("/res/equipe.png");
		Image quitter = new Image("/res/quitter.png");
		g.drawImage(jouer, 300, 130);
		g.drawImage(equipe, 300, 260);
		g.drawImage(quitter, 300, 390);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		if((xpos>300&&xpos<492) && (ypos>443&&ypos<543)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1);
			}
		} 
		if((xpos>300&&xpos<492) && (ypos>323&&ypos<412)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1);
			}
		} 
		if((xpos>300&&xpos<492) && (ypos>194&&ypos<281)){
			if(input.isMouseButtonDown(0)){
				gc.exit();
			}
		} 
	}
	
	public int getID(){
		return 0;
	}
}
