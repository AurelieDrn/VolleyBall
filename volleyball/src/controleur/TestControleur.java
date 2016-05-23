package controleur;

import java.io.IOException;

import modele.Equipe;
import modele.EquipeFactory;
import modele.JoueurBlesseException;

public class TestControleur {

	public static void main(String[] args) {
		Equipe equipeJoueur = EquipeFactory.getEquipe();
		equipeJoueur.setNomEquipe("La super équipe de Mr Dupont");
		Equipe equipeIA = EquipeFactory.getEquipe();
		equipeIA.setNomEquipe("L'équipe IA");
		GestionMatch gm = new GestionMatch(equipeIA, equipeJoueur);
		try {
			try {
				gm.jouer();
			} catch (NumberFormatException | JoueurBlesseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
