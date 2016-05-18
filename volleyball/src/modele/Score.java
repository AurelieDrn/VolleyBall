/**
 * 
 */
package modele;

/**
 * @author Yumiao Fu
 *
 */
public class Score {
	private int scoreEquipeIA;
	private int scoreEquipeJoueur;
	private Set setEquipeIA;
	private Set setEquipeJoueur;
	
	public Score(){
		this.scoreEquipeIA = 0;
		this.scoreEquipeJoueur = 0;
	}
	
	public void calculScore(){
		if(this.setEquipeIA.isPremierSet()){
			this.scoreEquipeIA ++;
		}
		else if(this.setEquipeIA.isSecondSet()){
			this.scoreEquipeIA ++;
		}
		else if(this.setEquipeIA.isDernierSet()){
			this.scoreEquipeIA ++;
		}
		else if(this.setEquipeJoueur.isPremierSet()){
			this.scoreEquipeJoueur++;
		}
		else if(this.setEquipeJoueur.isSecondSet()){
			this.scoreEquipeJoueur++;
		}
		else if(this.setEquipeJoueur.isDernierSet()){
			this.scoreEquipeJoueur++;
		}
	}

	public int getScoreEquipeIA() {
		return this.scoreEquipeIA;
	}

	public void setScoreEquipeIA(int scoreEquipeIA) {
		this.scoreEquipeIA = scoreEquipeIA;
	}

	public int getScoreEquipeJoueur() {
		return this.scoreEquipeJoueur;
	}

	public void setScoreEquipeJoueur(int scoreEquipeJoueur) {
		this.scoreEquipeJoueur = scoreEquipeJoueur;
	}
	public void init(){
		this.scoreEquipeIA = 0;
		this.scoreEquipeJoueur = 0;
	}

}
