package controleur.IO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modele.Joueur;
import modele.Position;
import modele.Role;

public class CreateJoueurs {

	private List<Joueur> joueurs;
	private int nbrJoueurs;
	
	public CreateJoueurs() {
		super();
		this.joueurs = new ArrayList<Joueur>();
		this.nbrJoueurs = 96;
		for(int i = 0; i<this.nbrJoueurs; i++){
			int fatigue = 0;
			int force = loadRandom();;
			int salaireHebdo = loadRandomSalary();
			int precision = loadRandom();
			int fpsy = loadRandom();
			int resis = loadRandom();
			int vitesse = loadRandom();
			Role role = Role.randomRole();
			int resistance = loadRandom();
			Position position = null;
			boolean estBlesse = false;
			joueurs.add(new Joueur(position, salaireHebdo, role, fatigue, force, precision, fpsy, vitesse, resistance));
		}
	}
    public static int randomInt(int min, int max) {

        int random = (int) ((max - min + 1) * Math.random() + min);
        return random;

    }
	
	public Role loadRandomRole(){
		return null;	
	}
	
	public static int loadRandomSalary(){
		int min = 100;
		int max = 500;
		return randomInt(min,max);
	}
	public static int loadRandom(){
		int min = 0;
		int max = 100;
		return randomInt(min,max);
	}
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	public int getNbrJoueurs() {
		return nbrJoueurs;
	}
	public void setNbrJoueurs(int nbrJoueurs) {
		this.nbrJoueurs = nbrJoueurs;
	}
	
	
	
}
