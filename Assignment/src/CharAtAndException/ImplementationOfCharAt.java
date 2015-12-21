/**
 * 
 * @author Babalu Patidar
 *
 */
package CharAtAndException;

public class ImplementationOfCharAt {

	public static void main(String[] args) {

		StringOperation str = new StringOperation("babalu patidar");
		try {
			System.out.println(str.charAt(3));
		} catch (MetaException e) {
			System.out.println(e.getMessage());
		}
	}	
}

