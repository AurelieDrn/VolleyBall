/**
 * 
 */
package modele;

/**
 * @author Aurelie Durand
 *
 */
public class TieBreak extends Set {

	public TieBreak(int numero, Equipe equipeIA, Equipe equipeJoueur) {
		super(numero, equipeIA, equipeJoueur);
	}

	public boolean estFini() {
		if(this.scoreEquipeIA >= 15 && this.scoreEquipeIA-this.scoreEquipeJoueur >= 2) {
			this.gagnant = this.equipeIA;
			return true;
		}
		else if(this.scoreEquipeJoueur >= 15 && this.scoreEquipeJoueur-this.scoreEquipeIA >= 2) {
			this.gagnant = this.equipeJoueur;
			return true;
		}
		else {
			return false;
		}
	}
}
