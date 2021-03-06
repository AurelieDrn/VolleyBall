package controleur;

import java.io.IOException;

import exception.JoueurBlesseException;
import exception.MatchEnCoursException;
import exception.NbTempsMortsException;
import exception.SetEnCoursException;
import modele.Equipe;
import modele.EquipeFactory;
import modele.Role;

public class TestControleur {

	public static void main(String[] args) {
		Equipe equipeJoueur = EquipeFactory.getEquipe();
		equipeJoueur.setNomEquipe("La super �quipe de Mr Dupont");
		equipeJoueur.getListJoueur().get(0).setRole(Role.passeur);
		equipeJoueur.getListJoueur().get(1).setRole(Role.attaquant);
		equipeJoueur.getListJoueur().get(2).setRole(Role.attaquant);
		equipeJoueur.getListJoueur().get(3).setRole(Role.defenseur);
		equipeJoueur.getListJoueur().get(4).setRole(Role.defenseur);
		equipeJoueur.getListJoueur().get(5).setRole(Role.defenseur);
		Equipe equipeIA = EquipeFactory.getEquipe();
		equipeIA.setNomEquipe("L'�quipe IA");
		equipeIA.getListJoueur().get(0).setRole(Role.passeur);
		equipeIA.getListJoueur().get(1).setRole(Role.attaquant);
		equipeIA.getListJoueur().get(2).setRole(Role.attaquant);
		equipeIA.getListJoueur().get(3).setRole(Role.defenseur);
		equipeIA.getListJoueur().get(4).setRole(Role.defenseur);
		equipeIA.getListJoueur().get(5).setRole(Role.defenseur);
		GestionMatch gm = new GestionMatch(equipeJoueur, equipeIA);
		try {
			gm.jouer();
		} catch (NumberFormatException | JoueurBlesseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SetEnCoursException e) {
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} catch (MatchEnCoursException e) {
			e.printStackTrace();
		} catch (NbTempsMortsException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Test rotation des joueurs
		/*System.out.println(gm.getPositionsDepartJoueur());
		gm.rotationJoueur();
		System.out.println(gm.getPositionsDepartJoueur());*/
	}

}
