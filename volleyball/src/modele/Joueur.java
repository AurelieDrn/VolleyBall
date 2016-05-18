/**
 * 
 */
package modele;

import org.newdawn.slick.Animation;

/**
 * @author Yumiao Fu
 * relecteurs Aur�lie Durand
 */
public class Joueur {
	
	private int numero;
	private String nom;
	private Role role;
	private int force;
	private int resistance;
	private int vitesse;
	private int precision;
	private int forcePsy;
	private boolean estBlesse;
	private int salaire;
	
	private int direction; // de 0 � 4
	private boolean moving; // vrai si le joueur est en mouvement
	private float x;
	private float y;
	private Animation[] animation; // permet d'animer le joueur
	
	public Joueur(int numero, String nom, Role role, int force, int resistance, int vitesse, int precision, int forcePsy, int salaire) {
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
	}
	
	// Constructeur provisoire pour tester rapidement dans l'interface
	public Joueur(int direction, int x, int y) {
		this.direction = direction;
		this.x = x;
		this.y = y;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getForcePsy() {
		return forcePsy;
	}

	public void setForcePsy(int forcePsy) {
		this.forcePsy = forcePsy;
	}

	public boolean isEstBlesse() {
		return estBlesse;
	}

	public void setEstBlesse(boolean estBlesse) {
		this.estBlesse = estBlesse;
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
	
}
