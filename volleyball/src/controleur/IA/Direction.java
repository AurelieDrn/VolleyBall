package controleur.IA;

public enum Direction {
	Haut, Bas, Gauche, Droite;
	
	public static Direction getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
