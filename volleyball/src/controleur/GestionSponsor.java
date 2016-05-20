/**
 * 
 */
package controleur;

import java.util.ArrayList;
import java.util.List;

import modele.Classement;
import modele.Equipe;
import modele.Sponsor;

/**
 * @author Meriem EL QSIMI
 *
 */
public class GestionSponsor { 
	private List<Sponsor> listSponsors;
	private Classement classement;
	private GestionEquipe gestionEquipeIA;
	private GestionEquipe gestionEquipeJoueur;
	public GestionSponsor(GestionEquipe eqIA, GestionEquipe eqJ) {
		super();
		this.listSponsors = new ArrayList<Sponsor>();
		this.gestionEquipeIA = eqIA;
		//new GestionEquipe(this.match.getEquipeIA());
		this.gestionEquipeIA = eqJ;		
	}
	
	public void addSponsorEquipe(Equipe equipe, Sponsor sponsor){
		equipe.addSponsor(sponsor);
	}
	public void deleteSponsorEquipe(Equipe equipe, Sponsor sponsor){
		equipe.deleteSponsor(sponsor);
	}	
	
	public boolean peutDonnerSub(Equipe equipe, Sponsor sponsor){
		return classement.getRangEquipe(equipe) >= sponsor.getRangExige();
	}
	public void subEquipes(List<Equipe> eqs,Sponsor sponsor){
		for(Equipe equipe : eqs){
			if(peutDonnerSub(equipe,sponsor)){
				addSponsorEquipe(equipe,sponsor);
			}
		}
	}
	public void subSponsors(){
		for(Sponsor sponsor : this.listSponsors){
			subEquipes(this.classement.getEquipes(),sponsor);
		}
	}
}
