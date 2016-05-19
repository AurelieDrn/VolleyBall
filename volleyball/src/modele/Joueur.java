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
<<<<<<< HEAD
	private int numero;
	private int direction;
	private boolean moving;
=======
	
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
	
	private int direction; // de 0 à 4
	private boolean moving; // vrai si le joueur est en mouvement
>>>>>>> branch 'master' of https://gitlab.univ-nantes.fr/MeriemQs/VolleyballJava.git
	private float x;
	private float y;
<<<<<<< HEAD
	private Position position;
	private int gain;
	private int salaireHebdo;
	private boolean estBlesse;
	private Animation[] animation;
	private Role role;
	private int fatigue;
	private int force;
	private int precision;
	private int psy;
	private int vitesse;
	private int resistance;
	
=======
	private Animation[] animation; // permet d'animer le joueur
>>>>>>> branch 'master' of https://gitlab.univ-nantes.fr/MeriemQs/VolleyballJava.git
	
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
<<<<<<< HEAD
		this.moving = false;
		this.animation = new Animation[8];
		this.gain = 0;
		this.role = null; // je sais pas comment définir le role,
		this.salaireHebdo = 200;//idem pour le salaire
		this.estBlesse = false;
	}
	
	public Joueur(Position position, int salaireHebdo, Role role, int fatigue, int force, int precision, int psy,
			int vitesse, int resistance) {
		super();
		this.position = position;
		this.salaireHebdo = salaireHebdo;
		this.role = role;
		this.fatigue = fatigue;
		this.force = force;
		this.precision = precision;
		this.psy = psy;
		this.vitesse = vitesse;
		this.resistance = resistance;
	}
	public int getSalaireHebdo() {
		return salaireHebdo;
	}

	public void setSalaireHebdo(int salaireHebdo) {
		this.salaireHebdo = salaireHebdo;
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
=======
>>>>>>> branch 'master' of https://gitlab.univ-nantes.fr/MeriemQs/VolleyballJava.git
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public boolean isEstBlesse() {
		return estBlesse;
	}
	public void setEstBlesse(boolean estBlesse) {
		this.estBlesse = estBlesse;
	}
	public int getFatigue() {
		return fatigue;
	}
	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public int getPsy() {
		return psy;
	}
	public void setPsy(int psy) {
		this.psy = psy;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public int getResistance() {
		return resistance;
	}
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	@Override
	public String toString() {
		return "Joueur [numero=" + numero + ", direction=" + direction + ", moving=" + moving + ", x=" + x + ", y=" + y
				+ ", position=" + position + ", gain=" + gain + ", salaireHebdo=" + salaireHebdo + ", estBlesse="
				+ estBlesse + ", animation=" + Arrays.toString(animation) + ", role=" + role + ", fatigue=" + fatigue
				+ ", force=" + force + ", precision=" + precision + ", psy=" + psy + ", vitesse=" + vitesse
				+ ", resistance=" + resistance + "]\n";
	}

	
}
