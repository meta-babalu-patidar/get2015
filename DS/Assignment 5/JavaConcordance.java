/****************************************************************************************
Name            : JavaConcordance
Revision Log    : 2015-09-01: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement JavaConcordance  
                :
****************************************************************************************/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JavaConcordance {
	static Scanner scan=new Scanner(System.in);
	static HashMap<Character, ArrayList<Integer>>hashmap=new HashMap<Character,ArrayList<Integer>>();
	
	//Start of main method
	//@param inpuString : Specify input string for user
	public static void main(String ar[]){
		
		String inputString="";
		System.out.println("Enter String..");
		inputString=scan.nextLine();
		//Calling of findfindConcordance method
		findConcordance(inputString);
		System.out.println(hashmap);
		scan.close();
	}
	//End of main method
	
	//Star of findConcordance method
	//@param count : specify that which element is to be map
	//@param len : specify length of inputString
	public static  void findConcordance(String inputString){
		int count=0;
		int len=inputString.length();
		
		for ( int current=0 ; current<len ; current++ ){	
			Character character=inputString.charAt(current);
			if(character!=' '){
				if(hashmap.containsKey(character)==true){
					ArrayList<Integer> arraylist=hashmap.get(character);
					arraylist.add(count++); 
					hashmap.replace(character,arraylist);
					
				}
				else{
					ArrayList<Integer> arraylist =new ArrayList<Integer>();
					arraylist.add(count++);
					hashmap.put(character,arraylist);
				}
				//End of else
			}
			//End of if
		}
		//End of for loop	
	}
	//End of findConcordance method

}
//End of class
