/**
 * 
 */
package modele;

import java.util.ArrayList;
import java.util.List;

import exception.SetEnCoursException;

/**
 * @author Yumiao Fu
 *
 */
public class Score{

	private List<Set> listSets;
	private Equipe equipeIA;
	private Equipe equipeJoueur;
	private int nbSetIA; // nombre de set remportés par l'IA
	private int nbSetJoueur; // nombre de set remportés par le joueur
	
	public Score(Equipe equipeIA, Equipe equipeJoueur){
		this.equipeIA = equipeIA;
		this.equipeJoueur = equipeJoueur;
		this.nbSetIA = 0;
		this.nbSetJoueur = 0;
		this.listSets = new ArrayList<Set>();
	}
	
	public void incNbSetIA() {
		this.nbSetIA++;
	}
	
	public void incNbSetJoueur() {
		this.nbSetJoueur++;
	}

	public int getNbSetIA() {
		return nbSetIA;
	}

	public int getNbSetJoueur() {
		return nbSetJoueur;
	}
	
	public boolean egalite() {
		return this.nbSetIA == 2 && this.nbSetJoueur == 2;
	}
	
	public Set nouveauSet() throws SetEnCoursException {
		if(!this.listSets.isEmpty()) {
			Equipe e = this.listSets.get(this.listSets.size()-1).getGagnant();
			if(e == this.equipeIA) {
				this.incNbSetIA();
			}
			else {
				this.incNbSetJoueur();
			}
		}
		Set set;
		if(this.egalite()) {
			set = new TieBreak(this.listSets.size(), this.equipeIA, this.equipeJoueur);
		}
		else {
			set = new Set(this.listSets.size(), this.equipeIA, this.equipeJoueur);
		}
		this.listSets.add(set);
		return set;
	}

	@Override
	public String toString() {
		return this.listSets.toString();
	}
	
	public Set getSet() {
		return this.listSets.get(this.listSets.size()-1);
	}
}
