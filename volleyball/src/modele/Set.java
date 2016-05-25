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
	
	public Set(int numero, Equipe equipeIA, Equipe equipeJoueur) {
		this.numero = numero;
		this.scoreEquipeIA = 0;
		this.scoreEquipeJoueur = 0;
		this.equipeIA = equipeIA;
		this.equipeJoueur = equipeJoueur;
		this.gagnant = null;
	}

	public void incScoreIA() {
		this.scoreEquipeIA++;
		this.estFini();
	}
	
	public void incScoreJoueur() {
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
		String s = "Set numero "+this.numero+"\n";
		s += this.equipeIA.getNomEquipe()+" VS "+this.equipeJoueur.getNomEquipe()+"\n";
		s += "Score de l'équipe "+this.equipeIA.getNomEquipe()+" : "+this.scoreEquipeIA+"\n";
		s += "Score de l'équipe "+this.equipeJoueur.getNomEquipe()+" : "+this.scoreEquipeJoueur+"\n";
		s += "Gagant du set : "+this.gagnant+"\n";
		return s;
	}
}
