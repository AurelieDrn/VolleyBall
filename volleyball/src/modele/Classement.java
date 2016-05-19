/**
 * 
 */
package modele;

import java.util.Collections;
import java.util.List;

/**
 * @author Yumiao Fu
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
		return 0;
	}
}
