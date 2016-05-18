package Modele;

public class Match {
	private Equipe gagnant;
	private Equipe perdant;
	private Etat etat;
	private int nbTempsMortEquipeIA;
	private int nbTempsMortEquipeJoueur;
	private int nbChangementsEquipeIA;
	private int nbChangementEquipeJoueur;
	private boolean doitFaireService;
	private Position positionBalle;
	private Score score;
	
	public Match(Equipe gagnant, Equipe perdant){
		this.gagnant = gagnant;
		this.perdant = perdant;
		this.etat = this.etat.fini;
		this.nbChangementEquipeJoueur = 0;
		this.nbChangementsEquipeIA = 0;
		this.nbTempsMortEquipeIA = 0;
		this.nbTempsMortEquipeJoueur = 0;
		this.doitFaireService = false;
		this.positionBalle.init();
		this.score.init();	
	}

	public Equipe getGagnant() {
		return this.gagnant;
	}

	public void setGagnant(Equipe gagnant) {
		this.gagnant = gagnant;
	}

	public Equipe getPerdant() {
		return this.perdant;
	}

	public void setPerdant(Equipe perdant) {
		this.perdant = perdant;
	}

	public Etat getEtat() {
		return this.etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public int getNbTempsMortEquipeIA() {
		return this.nbTempsMortEquipeIA;
	}

	public void setNbTempsMortEquipeIA(int nbTempsMortEquipeIA) {
		this.nbTempsMortEquipeIA = nbTempsMortEquipeIA;
	}

	public int getNbTempsMortEquipeJoueur() {
		return this.nbTempsMortEquipeJoueur;
	}

	public void setNbTempsMortEquipeJoueur(int nbTempsMortEquipeJoueur) {
		this.nbTempsMortEquipeJoueur = nbTempsMortEquipeJoueur;
	}

	public int getNbChangementsEquipeIA() {
		return this.nbChangementsEquipeIA;
	}

	public void setNbChangementsEquipeIA(int nbChangementsEquipeIA) {
		this.nbChangementsEquipeIA = nbChangementsEquipeIA;
	}

	public int getNbChangementEquipeJoueur() {
		return this.nbChangementEquipeJoueur;
	}

	public void setNbChangementEquipeJoueur(int nbChangementEquipeJoueur) {
		this.nbChangementEquipeJoueur = nbChangementEquipeJoueur;
	}

	public boolean isDoitFaireService() {
		return this.doitFaireService;
	}

	public void setDoitFaireService(boolean doitFaireService) {
		this.doitFaireService = doitFaireService;
	}

	public Position getPositionBalle() {
		return this.positionBalle;
	}

	public void setPositionBalle(Position positionBalle) {
		this.positionBalle = positionBalle;
	}

	public Score getScore() {
		return this.score;
	}
}

