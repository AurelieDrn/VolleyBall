/**
 * 
 */
package modele;

import org.newdawn.slick.Animation;

import exception.JoueurBlesseException;

/**
 * @author Yumiao Fu
 * relecteurs Aurélie Durand
 */
public class Joueur implements Cloneable {
	
	
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
	private boolean enJeu;

	private int direction; // de 0 à 4
	private boolean moving; // vrai si le joueur est en mouvement
	private Position position;
	private int fatigue;
	
	private Animation[] animation; // permet d'animer le joueur
	
	public Joueur(int numero, String nom, Role role, int force, int resistance, int vitesse, int precision, int forcePsy, int salaire) {
		this.numero = numero;
		this.nom = nom;
		this.salaire = salaire;
		this.role = role;
		this.forcePsy = forcePsy;
		
		// caractéristiques améliorables
		this.force = force;
		this.resistance = resistance;
		this.vitesse = vitesse;
		this.precision = precision;

		// états
		this.estBlesse = false;
		this.direction = 0;
		this.moving = false;
		this.position = new Position(0, 0);
		this.fatigue = 0;
		this.enJeu = false;
	}
	
	public boolean isEnJeu() {
		return enJeu;
	}

	public void setEnJeu(boolean enJeu) throws JoueurBlesseException {
		if(enJeu == true && this.estBlesse()) {
			throw new JoueurBlesseException();
		}
		this.enJeu = enJeu;
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

	public boolean estBlesse() {
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

	public Position getPosition() {
		return this.position;
	}
	
	public void setPosition(Position pos) {
		this.position = pos;
	}
	
	public float getX() {
		return this.position.getX();
	}
	
	public float getY() {
		return this.position.getY();
	}
	
	public void setX(float x) {
		this.position.setX(x);
	}
	
	public void setY(float y) {
		this.position.setY(y);
	}
	
	public int getFatigue() {
		return this.fatigue;
	}
	
	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	@Override
	public String toString() {
		String s = "¤--------------------¤\n";
		String s2 = "| N° : "+this.numero;
		int l2 = s.length()-s2.length()-3;
		for (int i=0; i<= l2; i++) {
			s2 += " ";
		}
		s2 += "|\n";
		
		String s3 = "| Nom : "+this.nom;
		int l3 = s.length()-s3.length()-3;
		for (int i=0; i<= l3; i++) {
			s3 += " ";
		}
		s3 += "|\n";
		
		String s33 = "| Etat : ";
		if(!this.estBlesse()) {
			s33 += "non blessé";
		}
		else {
			s33 += "est blessé";
		}
		int l33 = s.length()-s33.length()-3;
		for (int i=0; i<= l33; i++) {
			s33 += " ";
		}
		s33 += "|\n";
		
		String s4 = "| Rôle : "+this.role;
		int l4 = s.length()-s4.length()-3;
		for (int i=0; i<= l4; i++) {
			s4 += " ";
		}
		s4 += "|\n";
		
		String s5 = "| Force : "+this.force;
		int l5 = s.length()-s5.length()-3;
		for (int i=0; i<= l5; i++) {
			s5 += " ";
		}
		s5 += "|\n";
		
		String s6 = "| Résistance : "+this.resistance;
		int l6 = s.length()-s6.length()-3;
		for (int i=0; i<= l6; i++) {
			s6 += " ";
		}
		s6 += "|\n";
		
		String s7 = "| Vitesse : "+this.vitesse;
		int l7 = s.length()-s7.length()-3;
		for (int i=0; i<= l7; i++) {
			s7 += " ";
		}
		s7 += "|\n";
		
		String s8 = "| Précision : "+this.precision;
		int l8 = s.length()-s8.length()-3;
		for (int i=0; i<= l8; i++) {
			s8 += " ";
		}
		s8 += "|\n";
		
		String s9 = "| Force psy. : "+this.forcePsy;
		int l9 = s.length()-s9.length()-3;
		for (int i=0; i<= l9; i++) {
			s9 += " ";
		}
		s9 += "|\n";
		return s+s2+s3+s33+s4+s5+s6+s7+s8+s9;
	}

	@Override
	public boolean equals(Object obj) {
		Joueur myobj = (Joueur) obj; 
		return this.numero==myobj.getNumero();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
