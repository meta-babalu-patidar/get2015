
/**
 * @author Babalu Patidar
 *
 */

package CharAtAndException;

public class StringOperation {
	 
	private String stringInput;
	StringOperation (String stringInput){
		this.stringInput = stringInput;
	}
	
	public char charAt(int index) throws MetaException{
		char strArray[] = new char[stringInput.length()];
		strArray = stringInput.toCharArray();
		char result;
		try{
			result = strArray[index];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new MetaException("Array out of bound .Please enter correct index ");	
		}
		return result;
	}
	
}