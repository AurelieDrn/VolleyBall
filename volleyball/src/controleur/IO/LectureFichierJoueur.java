package controleur.IO;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import modele.Joueur;

/**
 * @author Meriem EL QSIMI
 *
 */

public class LectureFichierJoueur {

	private ArrayList<Joueur> joueurs;
	private String nomFichier;
	public LectureFichierJoueur(String file) {
		super();
		this.joueurs = new ArrayList<Joueur>();
		this.nomFichier = file;
	}	
	public void load(){
		try(
			FileInputStream fis = new FileInputStream(nomFichier);
			ObjectInputStream read = new ObjectInputStream(fis);){
			
			int nbrJ = read.readInt();
			for(int i = 0; i < nbrJ; i++){
				this.joueurs.add((Joueur)read.readObject());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "LectureFichierJoueur [joueurs=" + joueurs + "]";
	}


	
}

