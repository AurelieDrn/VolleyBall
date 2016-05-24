package controleur.IO;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class LectureFichierJoueur {




	public static void main(String[] args) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; 
		try {
			String str = "";
			String str1 = "";
			fis = new FileInputStream("/home/fuyumiao/workspace/volleyball/src/modele/test");
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			while ((str = br.readLine()) != null) {
				str1 += str + "\n";
			}
			System.out.println(str1);
			} catch (FileNotFoundException e) {
				System.out.println("ne peux pas chercher le fichier.");
				} catch (IOException e) {
					System.out.println("n'est pas succed.");
					} finally {
						try {
							br.close();
							isr.close();
							fis.close();
							} catch (IOException e) {
								e.printStackTrace();
					}
				}
	 		}
}

