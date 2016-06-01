package controleur;

import java.io.IOException;

import exception.JoueurBlesseException;
import exception.SetEnCoursException;
import modele.Equipe;
import modele.EquipeFactory;
import modele.Role;

public class TestControleur {

	public static void main(String[] args) {
		Equipe equipeJoueur = EquipeFactory.getEquipe();
		equipeJoueur.setNomEquipe("La super équipe de Mr Dupont");
		equipeJoueur.getListJoueur().get(0).setRole(Role.passeur);
		equipeJoueur.getListJoueur().get(1).setRole(Role.attaquant);
		equipeJoueur.getListJoueur().get(2).setRole(Role.attaquant);
		equipeJoueur.getListJoueur().get(3).setRole(Role.defenseur);
		equipeJoueur.getListJoueur().get(4).setRole(Role.defenseur);
		equipeJoueur.getListJoueur().get(5).setRole(Role.defenseur);
		Equipe equipeIA = EquipeFactory.getEquipe();
		equipeIA.setNomEquipe("L'équipe IA");
		GestionMatch gm = new GestionMatch(equipeJoueur, equipeIA);
		try {
			gm.jouer();
		} catch (NumberFormatException | JoueurBlesseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SetEnCoursException e) {
			e.printStackTrace();
		}
		
		// Test rotation des joueurs
		/*System.out.println(gm.getPositionsDepartJoueur());
		gm.rotationJoueur();
		System.out.println(gm.getPositionsDepartJoueur());*/
	}

}
