import java.io.File;

public class tst {

	public static void main(String[] args) {
		System.setProperty("org.lwjgl.librarypath", new File("natives").getAbsolutePath());
	}

}
