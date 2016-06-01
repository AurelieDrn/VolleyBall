package controleur;

import java.io.IOException;

import exception.JoueurBlesseException;
import modele.Equipe;
import modele.EquipeFactory;

public class TestControleur {

	public static void main(String[] args) {
		Equipe equipeJoueur = EquipeFactory.getEquipe();
		equipeJoueur.setNomEquipe("La super �quipe de Mr Dupont");
		Equipe equipeIA = EquipeFactory.getEquipe();
		equipeIA.setNomEquipe("L'�quipe IA");
		GestionMatch gm = new GestionMatch(equipeJoueur, equipeIA);
		try {
			gm.jouer();
		} catch (NumberFormatException | JoueurBlesseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Test rotation des joueurs
		/*System.out.println(gm.getPositionsDepartJoueur());
		gm.rotationJoueur();
		System.out.println(gm.getPositionsDepartJoueur());*/
	}

}
