/**
 * 
 */
package modele;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Yumiao Fu
 * relecteurs Aur¨¦lie Durand
 */
public class Championnat {
	private String nomChampionnat;
	private List<Equipe> listEquipe;
	private List<Sponsor> listSponsors;
	private List<Match> listMatch;
	private Classement classementEquipe;
	
	public Championnat(String nom){
		this.nomChampionnat = nom;
		this.listSponsors = new ArrayList<>();
		this.listEquipe = new ArrayList<>();
		this.listMatch = new ArrayList<>();
		this.classementEquipe = new Classement(listEquipe);
	}
	public void initialiserClassement() {
		
	}
}
