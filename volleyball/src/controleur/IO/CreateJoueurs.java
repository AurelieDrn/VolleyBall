package controleur.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modele.Joueur;
import modele.JoueurFactory;
import modele.Role;

public class CreateJoueurs {
	private JoueurFactory jFactory ;
	private ArrayList<Joueur> joueurs;
	
	
	public CreateJoueurs() {
		super();
		this.setjFactory(new JoueurFactory());
		this.joueurs = JoueurFactory.getJoueurs(96);
	}


	public void save(){
			
			try(ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("joueurs.csv"));){
				
				write.writeInt(this.joueurs.size()); 
				for(Joueur joueurs : this.joueurs){
					write.writeObject(joueurs);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	public void clear(){
		this.joueurs.clear();
	}
	
	
	public JoueurFactory getjFactory() {
		return jFactory;
	}


	public void setjFactory(JoueurFactory jFactory) {
		this.jFactory = jFactory;
	}
		
}
