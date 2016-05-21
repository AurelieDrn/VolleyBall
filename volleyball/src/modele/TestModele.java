package modele;

import java.util.ArrayList;

public class TestModele {

	public static void main(String[] args) {
		ArrayList<Joueur> joueurs = JoueurFactory.getJoueurs(6);
		for(Joueur joueur : joueurs) {
			//System.out.println(joueur);
		}
		
		Equipe equipeJoueur = EquipeFactory.getEquipe();
		equipeJoueur.setNomEquipe("La super équipe de Mr Dupont");
		System.out.println(equipeJoueur);
		Equipe equipeIA = EquipeFactory.getEquipe();
		equipeIA.setNomEquipe("L'équipe IA");
		System.out.println(equipeIA);
		Score score = new Score(equipeIA, equipeJoueur);
		Set s;
		try {
			s = score.nouveauSet();
			for (int i=0; i <= 25; i++) {
				s.incScoreJoueur();
			}
			Set s2 = score.nouveauSet();
		} catch (SetEnCoursException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(score);
		System.out.println(score.getNbSetJoueur());
		
		
		
		
		
		
		ArrayList listEquipe = new ArrayList<Equipe>();
		Equipe O = new Equipe(0, "O");
		Equipe AI = new Equipe(1,"AI");
		
		
		listEquipe.add(O);
		listEquipe.add(AI);
		ArrayList listMatch = new ArrayList<Match>();
		
		listMatch.add(AI);
		listMatch.add(O);
		//AI.setPremierSet(true);
		//AI.setSecondSet(true);
		//AI.setDernierSet(true);
		
		Championnat Disco = new Championnat("Disco");
		Disco.setListEquipe(listEquipe);
		Disco.setListMatch(listMatch);
		
		
	}

}
