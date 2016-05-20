/**
 * 
 */
package modele;

import java.util.Collections;
import java.util.List;

/**
 * @author Meriem EL QSIMI
 *
 */
public class Classement {
	

	private List<Equipe> equipes;
	public Classement(List<Equipe> equipes) {

			super();	
			this.equipes = equipes;
		}
	 	public void initialiser() {
			Collections.sort(equipes);
	 	}
	 	public void miseAJour() {
	 	}
	 	public int getRangEquipe(Equipe equipe) {
	 		Equipe[] eqs = (Equipe[]) this.equipes.toArray();
	 		int rang = 0;
	 		for(int i = 0; i<this.equipes.size();i++){
	 			if(eqs[i].equals(equipe)){
	 				rang = i+1;
	 			}
	 		}
	 		return rang;
	 	}
		public List<Equipe> getEquipes() {
			return equipes;
		}
		public void setEquipes(List<Equipe> equipes) {
			this.equipes = equipes;
		}
}
