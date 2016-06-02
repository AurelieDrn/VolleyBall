/**
 * 
 */
package modele;

import exception.SetEnCoursException;

/**
 * @author Aurélie Durand
 * 
 */
public class Set {

	protected int numero;
	protected int scoreEquipeIA;
	protected int scoreEquipeJoueur;
	protected Equipe equipeIA;
	protected Equipe equipeJoueur;
	protected Equipe gagnant;
	protected String nomGagant;
	
	public Set(int numero, Equipe equipeIA, Equipe equipeJoueur) {
		this.numero = numero;
		this.scoreEquipeIA = 0;
		this.scoreEquipeJoueur = 0;
		this.equipeIA = equipeIA;
		this.equipeJoueur = equipeJoueur;
		this.gagnant = null;
	}

	public void incScoreIA() throws CloneNotSupportedException {
		this.scoreEquipeIA++;
		this.estFini();
	}
	
	public void incScoreJoueur() throws CloneNotSupportedException {
		this.scoreEquipeJoueur++;
		this.estFini();
	}

	public boolean estFini() {
		if(this.scoreEquipeIA >= 25 && this.scoreEquipeIA-this.scoreEquipeJoueur >= 2) {
			this.gagnant = this.equipeIA;
			return true;
		}
		else if(this.scoreEquipeJoueur >= 25 && this.scoreEquipeJoueur-this.scoreEquipeIA >= 2) {
			this.gagnant = this.equipeJoueur;
			return true;
		}
		else {
			return false;
		}
	}
	
	public Equipe getGagnant() throws SetEnCoursException {
		if(this.estFini()) {
			return this.gagnant;
		}
		throw new SetEnCoursException();
	}

	@Override
	public String toString() {
		String s = "                                                    \n";
		String s2 = "¤-------------------------------------------------¤\n";
		String s3 = "| Set numero : "+this.numero;
		int l3 = s2.length()-s3.length()-3;
		for (int i=0; i<= l3; i++) {
			s3 += " ";
		}
		s3 += "|\n";
		String s4 = "| Score de "+this.equipeJoueur.getNomEquipe()+" : "+this.scoreEquipeJoueur;
		int l4 = s3.length()-s4.length()-3;
		for (int i=0; i<= l4; i++) {
			s4 += " ";
		}
		s4 += "|\n";
		String s5 = "| Score de "+this.equipeIA.getNomEquipe()+" : "+this.scoreEquipeIA;
		int l5 = s4.length()-s5.length()-3;
		for (int i=0; i<= l5; i++) {
			s5 += " ";
		}
		s5 += "|\n";
		String s6 = "| Gagant du set : "+this.gagnant.getNomEquipe();
		int l6 = s5.length()-s6.length()-3;
		for (int i=0; i<= l6; i++) {
			s6 += " ";
		}
		s6 += "|\n";
		return s+s2+s3+s4+s5+s6;
	}
}
