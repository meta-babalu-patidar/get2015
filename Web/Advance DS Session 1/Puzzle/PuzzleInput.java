/****************************************************************************************
Name            : PuzzleInput
Revision Log    : 2015-10-05: Babalu patidar : created.
                : 
                : 
Use             : This class is used to contain input method of puzzle..
                :
****************************************************************************************/

import java.util.Scanner;


public class PuzzleInput {
	
	// Method to get Integer value from the given.
	public static int getIntegerValue(String message) {
		
		Scanner scan=new Scanner(System.in);
		do {
			System.out.println(message);
			int number;
			String inputStr = scan.next();
			if(isNumeric(inputStr) && (Integer.parseInt(inputStr)>0)) {
				number=Integer.parseInt(inputStr);
				return number;
			}
			else {
				System.out.println("Enter positive integer value");
			}
		}while(true);
	}
	//End of getIntegerValue method
	
	
	//Method to check whether he given input string has integer values or not.
	private static boolean isNumeric(String input) {
		try {
			Integer.parseInt(input);
		} 
		catch (NumberFormatException e) {
			return false;
		}
		return true;	
	}
	//End of isNumeric method.
	
	// Method to get String input from user.
	public static String getStringInput(String message) {
		System.out.println(message);
		Scanner scan=new Scanner(System.in);
		String inputStr = scan.nextLine();
		return inputStr;
	}
	//End of getStringInpurt method.
	
	// Method to get character input from user.
	public static char getCharacterInput(String message) {
		System.out.println(message);
		Scanner scan=new Scanner(System.in);
		char input = scan.next().charAt(0);
		if((input == 'y' || input == 'Y') || (input == 'n' || input == 'N')) {
			return input;
		}
		else {	
			return getCharacterInput(message);
		}
	}
	//End of getCharactor method.
	
	// Method to get array input.
	public static int[] getArrayInput(String message) {
		System.out.println(message);
		Scanner scan=new Scanner(System.in);
		int array[] = new int[9];
		for(int i = 0; i < (array.length-1) ; i++) {
			array[i] = scan.nextInt();
		}
		return array;
	}
	//End of getInputArry method.
	
}
//End of class
