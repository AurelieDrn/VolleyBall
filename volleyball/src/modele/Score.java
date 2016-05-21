/**
 * 
 */
package modele;

/**
 * @author Yumiao Fu
 *
 */
public class Score{

	private int scoreEquipeIA;
	private int scoreEquipeJoueur;
	private Set setEquipeIA;
	private Set setEquipeJoueur;
	
	public Score(){
		this.scoreEquipeIA = 0;
		this.scoreEquipeJoueur = 0;
	}
	
	public void calculScore(){
		if(this.setEquipeIA.getPremierSet() == true){
			this.scoreEquipeIA ++;
		}
		else if(this.setEquipeIA.getSecondSet() == true){
			this.scoreEquipeIA ++;
		}
		else if(this.setEquipeIA.getDernierSet() == true){
			this.scoreEquipeIA ++;
		}
		else if(this.setEquipeJoueur.getPremierSet() == true){
			this.scoreEquipeJoueur++;
		}
		else if(this.setEquipeJoueur.getSecondSet() == true){
			this.scoreEquipeJoueur++;
		}
		else if(this.setEquipeJoueur.getDernierSet() == true){
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
