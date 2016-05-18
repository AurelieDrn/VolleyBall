package Modele;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void init(){
		this.x = 0;
		this.y = 0;
	}
}
