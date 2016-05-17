/**
 * 
 */
package modele;

import org.newdawn.slick.Animation;

/**
 * @author Yumiao Fu
 *
 */
public class Joueur {
	
	private int direction;
	private boolean moving;
	private float x;
	private float y;
	private Animation[] animation;
	
	public Joueur(int direction, float x, float y) {
		this.direction = direction;
		this.x = x;
		this.y = y;
		this.moving = false;
		this.animation = new Animation[8];
	}

	public Animation[] getAnimation() {
		return animation;
	}

	public void setAnimation(Animation[] animation) {
		this.animation = animation;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
