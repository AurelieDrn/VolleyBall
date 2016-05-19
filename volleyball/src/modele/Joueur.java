/**
 * 
 */
package modele;

import java.util.Arrays;

import org.newdawn.slick.Animation;

/**
 * @author Yumiao Fu
 * relecteurs Aurélie Durand
 */
public class Joueur {
	private int numero;
	private String nom;
	private int forcePsy;
	private int salaire;
	private Role role;
	private int fatigue;
	private int force;
	private int precision;
	private int vitesse;
	private int resistance;
	private Position position;
	private int gain;
	private int direction; // de 0 à 4
	private boolean moving; // vrai si le joueur est en mouvement
	private float x;
	private float y;
	private boolean estBlesse;
	

	private Animation[] animation; // permet d'animer le joueur
	
	public Joueur(int numero, String nom, Role role, int force, int resistance, int vitesse, int precision, int forcePsy, int salaire, int gain) {
		this.numero = numero;
		this.nom = nom;
		this.role = role;
		this.force = force;
		this.resistance = resistance;
		this.vitesse = vitesse;
		this.precision = precision;
		this.forcePsy = forcePsy;
		this.salaire = salaire;	
		this.estBlesse = false;
		this.direction = 0;
		this.moving = false;
		this.x = 0;
		this.y = 0;
		this.gain = gain;
	}


	public Joueur(int numero, String nom, int forcePsy, int salaire, Role role, int fatigue, int force, int precision,
			int vitesse, int resistance, Position position, int gain, int direction, boolean moving, 
			boolean estBlesse) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.forcePsy = forcePsy;
		this.salaire = salaire;
		this.role = role;
		this.fatigue = fatigue;
		this.force = force;
		this.precision = precision;
		this.vitesse = vitesse;
		this.resistance = resistance;
		this.position = position;
		this.gain = gain;
		this.direction = direction;
		this.moving = moving;
		this.estBlesse = estBlesse;
	}


	// Constructeur provisoire pour tester rapidement dans l'interface
	public Joueur(int direction, int x, int y) {
		this.direction = direction;
		this.x = x;
		this.y = y;
		this.moving = false;
		this.animation = new Animation[8];
		this.gain = 0;
		this.role = null; 
		this.estBlesse = false;
	}
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public int getGain() {
		return gain;
	}

	public void setGain(int gain) {
		this.gain = gain;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}



	public int getForcePsy() {
		return forcePsy;
	}

	public void setForcePsy(int forcePsy) {
		this.forcePsy = forcePsy;
	}


	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
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

	public Animation[] getAnimation() {
		return animation;
	}

	public void setAnimation(Animation[] animation) {
		this.animation = animation;
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
	
	public boolean isEstBlesse() {
		return estBlesse;
	}
	
	public int getFatigue() {
		return fatigue;
	}
	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}


	@Override
	public String toString() {
		return "Joueur [numero=" + numero + ", nom=" + nom + ", forcePsy=" + forcePsy + ", salaire=" + salaire
				+ ", role=" + role + ", fatigue=" + fatigue + ", force=" + force + ", precision=" + precision
				+ ", vitesse=" + vitesse + ", resistance=" + resistance + ", position=" + position + ", gain=" + gain
				+ ", direction=" + direction + ", moving=" + moving + ", x=" + x + ", y=" + y + ", estBlesse="
				+ estBlesse + ", animation=" + Arrays.toString(animation) + "]\n";
	}
	
}
