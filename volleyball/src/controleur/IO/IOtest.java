package controleur.IO;

public class IOtest {

	
	public static void main(String[] args) {
		CreateJoueurs cjj = new CreateJoueurs();
		cjj.save();
		LectureFichierJoueur lj = new LectureFichierJoueur("joueurs.csv");
		lj.load();
		System.out.println(lj.toString());
	}

}
