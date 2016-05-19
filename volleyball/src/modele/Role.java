/**
 * 
 */
package modele;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Yumiao Fu
 *
 */
public enum Role {
	attaquant, defenseur, serveur, receptionneur, passeur;
	  private static final List<Role> VALUES =
			    Collections.unmodifiableList(Arrays.asList(values()));
			  private static final int SIZE = VALUES.size();
			  private static final Random RANDOM = new Random();

			  public static Role randomRole()  {
			    return VALUES.get(RANDOM.nextInt(SIZE));
			  }

}
