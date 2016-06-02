/**
 * 
 */
package modele;

import exception.MatchEnCoursException;

/**
 * @author Yumiao Fu
 * relecteurs Aurelie Durand, Meriem El Qsimi
 */
public class Match {

	private Equipe equipeJoueur;
	private Equipe equipeIA;
	private Equipe equipeGagnante;
	private Etat etat;
	private int nbTempsMortEquipeIA;
	private int nbTempsMortEquipeJoueur;
	private int nbChangementsEquipeIA;
	private int nbChangementsEquipeJoueur;
	private Balle balle;
	private Score score;
	
	public Match(Equipe equipeJoueur, Equipe equipeIA) {
		this.equipeJoueur = equipeJoueur;
		this.equipeIA = equipeIA;
		this.equipeGagnante = null;
		
		this.etat = Etat.EnCours;
		this.nbTempsMortEquipeIA = 0;
		this.nbTempsMortEquipeJoueur = 0;
		this.nbChangementsEquipeIA = 0;
		this.nbChangementsEquipeJoueur = 0;
		this.balle = new Balle(new Position(7,2));
		this.score = new Score(equipeIA, equipeJoueur);
	}

	public Equipe getEquipeJoueur() {
		return this.equipeJoueur;
	}

	public void setEquipeJoueur(Equipe equipeJoueur) {
		this.equipeJoueur = equipeJoueur;
	}

	public Equipe getEquipeIA() {
		return this.equipeIA;
	}

	public void setEquipeIA(Equipe equipeIA) {
		this.equipeIA = equipeIA;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public int getNbTempsMortEquipeIA() {
		return nbTempsMortEquipeIA;
	}

	public void setNbTempsMortEquipeIA(int nbTempsMortEquipeIA) {
		this.nbTempsMortEquipeIA = nbTempsMortEquipeIA;
	}

	public int getNbTempsMortEquipeJoueur() {
		return nbTempsMortEquipeJoueur;
	}

	public void setNbTempsMortEquipeJoueur(int nbTempsMortEquipeJoueur) {
		this.nbTempsMortEquipeJoueur = nbTempsMortEquipeJoueur;
	}

	public int getNbChangementsEquipeIA() {
		return nbChangementsEquipeIA;
	}

	public void setNbChangementsEquipeIA(int nbChangementsEquipeIA) {
		this.nbChangementsEquipeIA = nbChangementsEquipeIA;
	}

	public int getNbChangementsEquipeJoueur() {
		return nbChangementsEquipeJoueur;
	}

	public void setNbChangementsEquipeJoueur(int nbChangementsEquipeJoueur) {
		this.nbChangementsEquipeJoueur = nbChangementsEquipeJoueur;
	}

	public Balle getBalle() {
		return balle;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Equipe getEquipeGagnante() throws MatchEnCoursException {
		if(this.etat == Etat.EnCours) {
			throw new MatchEnCoursException();
		}
		return equipeGagnante;
	}

	public void setEquipeGagnante(Equipe equipeGagnante) throws MatchEnCoursException {
		if(this.etat == Etat.EnCours) {
			throw new MatchEnCoursException();
		}
		this.equipeGagnante = equipeGagnante;
	}
}
