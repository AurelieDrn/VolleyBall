/**
 * 
 */
package controleur.IA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modele.Joueur;
import modele.Match;
import modele.Position;

/**
 * @author Aurelie
 *
 */
public class IAGenerale {

	private List<Position> ciblesTerrainHaut;
	private List<Position> ciblesTerrainBas;
	private Position positionArriveeBalle;
	private Match match;
	private int nbTouches;
	private boolean terrain; // true si on vise le terrain du haut
	
	public IAGenerale(Match match) {
		this.match = match;
		this.nbTouches = 2; // initialisé à 2 pour le service
		this.ciblesTerrainHaut = new ArrayList<Position>();
		this.ciblesTerrainBas = new ArrayList<Position>();
		this.terrain = true;
		initCibles();
	}
	
	/**
	 * Initialise les listes de cibles à viser lors de l'envoi d'une balle
	 */
	private void initCibles() {
		this.ciblesTerrainHaut.add(new Position(1,10));
		this.ciblesTerrainHaut.add(new Position(4,10));
		this.ciblesTerrainHaut.add(new Position(7,10));
		this.ciblesTerrainHaut.add(new Position(3,12));
		this.ciblesTerrainHaut.add(new Position(5,12));
		this.ciblesTerrainHaut.add(new Position(1,13));
		this.ciblesTerrainHaut.add(new Position(7,13));
		this.ciblesTerrainHaut.add(new Position(3,14));
		this.ciblesTerrainHaut.add(new Position(5,14));
		this.ciblesTerrainHaut.add(new Position(1,16));
		this.ciblesTerrainHaut.add(new Position(4,16));
		this.ciblesTerrainHaut.add(new Position(7,16));
		
		this.ciblesTerrainBas.add(new Position(1,7));
		this.ciblesTerrainBas.add(new Position(4,7));
		this.ciblesTerrainBas.add(new Position(7,7));
		this.ciblesTerrainBas.add(new Position(3,5));
		this.ciblesTerrainBas.add(new Position(5,5));
		this.ciblesTerrainBas.add(new Position(1,4));
		this.ciblesTerrainBas.add(new Position(7,4));
		this.ciblesTerrainBas.add(new Position(3,3));
		this.ciblesTerrainBas.add(new Position(5,3));
		this.ciblesTerrainBas.add(new Position(1,1));
		this.ciblesTerrainBas.add(new Position(4,1));
		this.ciblesTerrainBas.add(new Position(7,1));
	}
	
	public Match envoi() {
		if(this.nbTouches == 2) {
			this.positionArriveeBalle = this.choixCibleAdverse();
			this.terrain = false;
		}
		return match;
	}
	
	/**
	 * Choisit la cible dans le terrain adverse en fonction de la position des joueurs adverses
	 * @return la position de la cible à viser
	 */
	private Position choixCibleAdverse() {
		List<Joueur> joueursAdverses;
		List<Position> ciblesIntermediaires;
		Map<Position, Double> positionDistance = new HashMap<Position, Double>();
		// on vise le terrain du haut
		if(this.terrain) {
			joueursAdverses = this.match.getEquipeIA().getListJoueur();
			ciblesIntermediaires = this.ciblesTerrainHaut;
		}
		else { // on vise le terrain du bas
			joueursAdverses = this.match.getEquipeJoueur().getListJoueur();
			ciblesIntermediaires = this.ciblesTerrainBas;
		}
		for(Position cible : ciblesIntermediaires) {
			double d = 0;
			double distanceJoueurBalle = 200;
			// Chercher le joueur le plus proche pour chaque cible
			for(Joueur adversaire : joueursAdverses) {
				d = Math.sqrt(Math.pow((adversaire.getPosition().getX()-cible.getX()),2))+Math.sqrt(Math.pow((adversaire.getPosition().getY()-cible.getY()),2));
				if(d < distanceJoueurBalle) {
					distanceJoueurBalle = d;
				}
			}
			// Ajouter chaque cible avec la distance la plus proche
			positionDistance.put(cible, distanceJoueurBalle);
		}
		
		double plusGrandeDistance = 0;
		Position cible = new Position(0,0);
		for (Map.Entry<Position, Double> entry : positionDistance.entrySet()) {
		    Position position = entry.getKey();
		    double distance = entry.getValue();
		    if(distance > plusGrandeDistance){
		    	plusGrandeDistance = distance;
		    	cible = position;
		    }
		}
		return cible;
	}
}
