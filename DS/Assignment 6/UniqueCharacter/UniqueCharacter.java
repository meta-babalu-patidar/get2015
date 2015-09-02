/****************************************************************************************
Name            : UniqueCharacter
Revision Log    : 2015-09-02: Babalu patidar : created.
                : 
                : 
Use             : This class is used to find number of unique Characters in input string.  
                :
****************************************************************************************/

import java.util.HashMap;
import java.util.Scanner;

public class UniqueCharacter {
	 
	static HashMap<String,Integer>hashmapresult=new HashMap<String,Integer>();
	//Start of main method
	//@param inpuString : Specify input string for user
	public static void main(String arg[]){
		Scanner scan=new Scanner(System.in);
		String choice ="";
		int number;
		do{
			String inputString="";
			System.out.println("Enter String..");
			inputString=scan.nextLine();
			//Calling of findNumberOfUniqueCharacters method
			number=findNumberOfUniqueCharacters(inputString);
			System.out.println("Number OF Unique Charaters : "+number);
			System.out.println("Enter 1 to continue.. Otherwise Enter any Key");
			choice=scan.nextLine();
		}while(choice.equals("1"));
		
		System.out.println("Exit..");
		scan.close();
	}
	//End of main method
	

	//Star of findNumberOfUniqueCharacters method
	//@param count : specify that which element is to be map
	//@param len : specify length of inputString
	public static  int findNumberOfUniqueCharacters(String inputString){
		if(hashmapresult.containsKey(inputString)==true){
			return (hashmapresult.get(inputString));
		}
		else{
			int numberOfUniqueCharacters=0;
			HashMap<Character,Integer>hashmap=new HashMap<Character,Integer>();
			int len=inputString.length();
			
			for ( int current=0 ; current<len ; current++ ){	
				Character character=inputString.charAt(current);
				if(character!=' '){
					if(hashmap.containsKey(character)==true){
						Integer count=hashmap.get(character);
						count++; 
						hashmap.replace(character,count);
						
					}
					else{
						numberOfUniqueCharacters++;
						hashmap.put(character,1);
					}
				
					//End of else
				}
				//End of if
			}
			//End of for loop	
			hashmapresult.put(inputString, numberOfUniqueCharacters);
			return numberOfUniqueCharacters;
		}
	}
	//End offindNumberOfUniqueCharacters method

}
//End of class
