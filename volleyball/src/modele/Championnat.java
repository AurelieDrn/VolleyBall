/**
 * 
 */
package modele;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Yumiao Fu
 * relecteurs Aurélie Durand
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
	public String getNomChampionnat() {
		return nomChampionnat;
	}
	public void setNomChampionnat(String nomChampionnat) {
		this.nomChampionnat = nomChampionnat;
	}
	public List<Equipe> getListEquipe() {
		return listEquipe;
	}
	public void setListEquipe(List<Equipe> listEquipe) {
		this.listEquipe = listEquipe;
	}
	public List<Sponsor> getListSponsors() {
		return listSponsors;
	}
	public void setListSponsors(List<Sponsor> listSponsors) {
		this.listSponsors = listSponsors;
	}
	public List<Match> getListMatch() {
		return listMatch;
	}
	public void setListMatch(List<Match> listMatch) {
		this.listMatch = listMatch;
	}
	public Classement getClassementEquipe() {
		return classementEquipe;
	}
	public void setClassementEquipe(Classement classementEquipe) {
		this.classementEquipe = classementEquipe;
	}
	
}
