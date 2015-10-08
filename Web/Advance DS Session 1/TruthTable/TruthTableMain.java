/****************************************************************************************
Name            : TruthTableMain
Revision Log    : 2015-10-05: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement truth table generator 
                :
****************************************************************************************/

import java.util.Scanner;


public class TruthTableMain {

	public static void main(String[] args) {
		
		//Input string from user
		System.out.println("Enter a String");
		Scanner scan = new java.util.Scanner(System.in);
		String input = scan.next();
		input = input.toLowerCase();
		//Validation of string
		if(TruthTableValidation.isExpression(input)) {
			TruthTableGenerator truthTableObj = new TruthTableGenerator();
			//Calling of truthTableGenerator method.
			truthTableObj.truthTableGenerator(input);
		}
		else {
			System.out.println("Enter Valid Expression");
		}
		scan.close();
	}
	//End of main method
}
//End of class