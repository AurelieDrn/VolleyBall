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
		ArrayList listEquipe = new ArrayList<Equipe>();
		Equipe O = new Equipe(0, "O");
		Equipe AI = new Equipe(1,"AI");
		
		
		listEquipe.add(O);
		listEquipe.add(AI);
		ArrayList listMatch = new ArrayList<Match>();
		
		listMatch.add(AI);
		listMatch.add(O);
		AI.setPremierSet(true);
		AI.setSecondSet(true);
		AI.setDernierSet(true);
		
		Championnat Disco = new Championnat("Disco");
		Disco.setListEquipe(listEquipe);
		Disco.setListMatch(listMatch);
		
	}

}
