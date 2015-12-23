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
			System.out.println(str.charAt(4));
		} catch (MetaException exception) {
			System.out.println(exception.getMessage());
		}
	}	
}


