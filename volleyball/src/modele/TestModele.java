package modele;

import java.util.ArrayList;

public class TestModele {

	public static void main(String[] args) {
		ArrayList<Joueur> joueurs = JoueurFactory.getJoueurs(6);
		for(Joueur joueur : joueurs) {
			System.out.println(joueur);
		}
		
		Equipe equipe = EquipeFactory.getEquipe();
		//System.out.println(equipe);
	}

}
