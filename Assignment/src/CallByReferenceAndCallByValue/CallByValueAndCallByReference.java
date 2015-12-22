/**
 * @author Babalu Patidar
 */

package CallByReferenceAndCallByValue;


import java.util.ArrayList;
import java.util.List;


public class CallByValueAndCallByReference {

	 public static void main(String[] args) {
		 CallByValueAndCallByReference callByValueAndCallByReference = new CallByValueAndCallByReference();
		 int firstValue = 34;
		 System.out.println(firstValue);
		 callByValueAndCallByReference.square(firstValue); // call by value call
		 System.out.println(firstValue);
		 		 
		 List<Integer> listIntegers = new ArrayList<Integer>();
		 listIntegers.add(34);
		 System.out.println(listIntegers.toString());
		 
		 callByValueAndCallByReference.addInList(listIntegers); // call by reference call
		 System.out.println(listIntegers.toString());
		 
		 
	}

	 /**
	  * Method of call by value
	  * @param value
	  */
	private void square(int value) {
		value = value++;
	}
	
	/**
	 * Method for call by reference
	 * @param listIntegers
	 */
	private void addInList(List<Integer> listIntegers) {
		listIntegers.add(20);
	}
	
}