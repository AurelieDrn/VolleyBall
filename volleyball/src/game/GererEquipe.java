/**
 * 
 */
package game;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import controleur.GestionEquipe;

/**
 * @author Aurelie
 *
 */
public class GererEquipe extends BasicGameState{

	private GestionEquipe ge;
	private List<Boolean> entrainements;
	private List<Boolean> repos;
	
	public GererEquipe(int state, GestionEquipe ge){
		this.ge = ge;
		this.entrainements = new ArrayList<Boolean>();
		this.repos = new ArrayList<Boolean>();
		this.initialisation();
	}
	
	private void initialisation(){
		for(int i=0; i<12; i++){
			this.entrainements.add(new Boolean(true));
			this.repos.add(new Boolean(true));
		}
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawString("x : "+Mouse.getX()+" Y : "+Mouse.getY(), 200, 10);
		g.setColor(Color.darkGray);
		
		Image retour = new Image("/res/retour.png");
		g.drawImage(retour, 90, 10);
		
		Image cadre_joueur = new Image("/res/cadre_joueur.png");
		int x = 0;
		int xTexte = 38;
		String etat = "";
		g.setColor(Color.black);
		for(int i=0; i<this.ge.getEquipe().getListJoueur().size(); i++) {
			if(i<=5){
				g.drawImage(cadre_joueur, x, 50);
				x = x+139;
				g.drawString(this.ge.getEquipe().getListJoueur().get(i).getNom()+"", xTexte, 87);
				g.drawString(this.ge.getEquipe().getListJoueur().get(i).getRole()+"", xTexte, 98);
				g.drawString(this.ge.getEquipe().getListJoueur().get(i).getSalaire()+"", xTexte+12, 109);
				g.drawString(this.ge.getEquipe().getListJoueur().get(i).getForcePsy()+"", xTexte+29, 120);
				g.drawString(this.ge.getEquipe().getListJoueur().get(i).getForce()+"", xTexte+8, 155);
				g.drawString(this.ge.getEquipe().getListJoueur().get(i).getResistance()+"", xTexte+35, 166);
				g.drawString(this.ge.getEquipe().getListJoueur().get(i).getVitesse()+"", xTexte+19, 177);
				g.drawString(this.ge.getEquipe().getListJoueur().get(i).getPrecision()+"", xTexte+25, 188);
				if(this.ge.getEquipe().getListJoueur().get(i).estBlesse()){
					g.setColor(Color.red);
				}
				else {
					g.setColor(Color.green);
				}
				g.fillOval(xTexte, 227, 10, 10);
				g.setColor(Color.black);
				g.drawString(this.ge.getEquipe().getListJoueur().get(i).getFatigue()+"", xTexte+15, 233);
				xTexte = xTexte+139;
			}
			else {
				x = 0;
				g.drawImage(cadre_joueur, x, 350);
				x = x+139;
			}
		}
		g.setColor(Color.white);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		if((xpos>6&&xpos<129) && (ypos>388&&ypos<414)){
			if(input.isMouseButtonDown(0)){
				if(this.ge.getEquipe().getListJoueur().size()>=1){
					if(this.ge.getEquipe().getListJoueur().get(0).getFatigue()<10){
						if(this.entrainements.get(0)){
							this.ge.entrainerJoueur(this.ge.getEquipe().getListJoueur().get(0));
							this.entrainements.set(0, new Boolean(false));
						}
					}
				}
			}
		} 
		if((xpos>6&&xpos<129) && (ypos>360&&ypos<384)){
			if(input.isMouseButtonDown(0)){
				if(this.ge.getEquipe().getListJoueur().size()>=1){
					if(this.ge.getEquipe().getListJoueur().get(0).getFatigue()>0){
						if(this.repos.get(0)){
							this.ge.reposerJoueur(this.ge.getEquipe().getListJoueur().get(0));
							this.repos.set(0, new Boolean(false));
						}
					}
					
				}
			}
		} 
		/*if((xpos>6&&xpos<129) && (ypos>350&&ypos<374)){
			if(input.isMouseButtonDown(0)){
				if(this.ge.getEquipe().getListJoueur().size()>=1){
					this.ge.licencierJoueur(this.ge.getEquipe().getListJoueur().get(0));
				}
			}
		}*/
		if((xpos>90&&xpos<194) && (ypos>625&&ypos<662)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(0);
			}
		}
	}
	
	public int getID(){
		return 2;
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if((x>6&&x<129) && (y>350&&y<374)){
			if(this.ge.getEquipe().getListJoueur().size()>=1){
				this.ge.licencierJoueur(this.ge.getEquipe().getListJoueur().get(0));
			}
		}
	}
	
}
