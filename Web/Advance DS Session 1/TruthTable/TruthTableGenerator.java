/****************************************************************************************
Name            : TruthTableGenerator
Revision Log    : 2015-10-05: Babalu patidar : created.
                : 
                : 
Use             : This class is used to genrate truth table of given expression
                :
****************************************************************************************/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;


public class TruthTableGenerator {
	
	
	public void truthTableGenerator(String input) {
		
			//Calling of convertInToPostfix method
			String inputPostfix = convertInToPostfix(input);
			//Calling of solvePostfix method
			solvePostfix(inputPostfix);
	}
	//End of main method
	
	//Start of convertIntoPostfix method
	private String convertInToPostfix(String input) {
		Stack<Character> stackObj = new Stack<Character>();
		
		//Calculating length of infix expression 
		int inputLength = input.length();
		String postfixExpression = "";
		Object poppedItem;
		int braces = 0;
		
		//For loop for read entire expression
		for(int i = 0; i < inputLength; i++) {
			Character temp = new Character(input.charAt(i));
			
			//If char is letter add in to postfix
			if(Character.isLetter(temp)){
				postfixExpression+= temp;
			}
			
			//If ( then push into stack
			else if(temp == '('){
				stackObj.push(temp);
				braces++;
			}
			//If ) then pop all element up to (
			else if(temp == ')'){
				
				if(braces == 0){
					System.out.println("Invalid Expression");
					return null;
				}
				
				while(!((char)stackObj.peek() == '(')){
					poppedItem = stackObj.pop();
					postfixExpression += poppedItem;
				}
				stackObj.pop();
				braces--;
			}
			
			else if(temp == '&' || temp == '|' || temp == '~'){
				if(stackObj.size() == 0) {
					stackObj.push(temp);
				}
				else{
					if(input.charAt(i) == '~'){
						if((char)stackObj.peek() == '~'){
							poppedItem = stackObj.pop();
							postfixExpression +=  poppedItem;
						}
					}
					else if(input.charAt(i) == '&'){
						while(stackObj.peek() != '|' && stackObj.peek() != '(') {
							poppedItem = stackObj.pop();
							postfixExpression +=  poppedItem;
							if(stackObj.size() == 0)
								break;
						}
					}
					else if(input.charAt(i) == '|')
					{
						while(stackObj.size() != 0 && stackObj.peek() != '(') {
							poppedItem = stackObj.pop();
							postfixExpression +=  poppedItem;
						}
					}	
					stackObj.push(temp);
				}
			}
		}
		//Pop all remaining element in stack and add in postfix
		while(stackObj.size() != 0)
		{
			poppedItem = stackObj.pop();
			postfixExpression +=  poppedItem;
		}
		return postfixExpression;
	}
	//End of convert into postfix method
	

	//Start of initTable method
	//Method initlize table according to number of uniqe charactor
	private char[][] initTable(int numberOfCharacters) {
	    int numberOfRows = (int)Math.pow(2, numberOfCharacters);
	    char[][] chars = new char[numberOfRows][numberOfCharacters];
	    for(int i=0;i<numberOfRows;i++){
			int rowNumber=i;
			for(int j=numberOfCharacters-1;j>=0;j--){
				int remender=rowNumber%2;
				if(remender==1){
					chars[i][j]='T';
				}
				else{
					chars[i][j]='F';
				}
				rowNumber/=2;	
			}
		}
	    
	    return chars;
	}
	//End of initTable method
	
	//ReturnLetters method is used to return set for input string
	private Set<Character> returnLetters(String input) {
		Set<Character> set =new HashSet<Character>();
		for(int i=0;i<input.length();i++){
			Character ch=(Character)input.charAt(i);
			if(Character.isLetter(ch)){
				set.add(ch);
			}
		}
		return set;	
	}
	//End of returnLetter method
	
	//Start of solvePostfix method
	//Method is used to evaluate result for expression
	private void solvePostfix(String inputPostfix) {
			
		Set<Character> letterSet = returnLetters(inputPostfix);
	    char result = ' ';
	    char[][] chars = initTable(letterSet.size());
	    Iterator<Character> letterSetIterator1 = letterSet.iterator();
    	while(letterSetIterator1.hasNext()) {
    		char c = letterSetIterator1.next();
    		System.out.print(c+"\t");
    	}
    	System.out.print("Output");
    	System.out.println();
	    for(int i = 0; i < chars.length; i++) {
	    	String inputUpdate = inputPostfix;
	    	int j = 0;
	    	Iterator<Character> letterSetIterator = letterSet.iterator();
	    	while(letterSetIterator.hasNext()) {
	    		char c = letterSetIterator.next();
	    		inputUpdate = inputUpdate.replace(c, chars[i][j]);
	    		j++;
	    	}
		    Stack<Character> list = new Stack<Character>();
		    //result of 1st popping
		    char c1;     
		    // result of 2nd popping
		    char c2;  
		    
		    //For loop intrate on each row of table and calculate result.
		    for (j = 0; j < inputUpdate.length(); j++) {
		        char ch = inputUpdate.charAt(j);
	            if (ch == ' ') {
	            } 
	            else {
	            	if (Character.isLetter(ch)) {
	                    list.push(ch);
	                } 
	                else {
	                	if(ch == '~') {
	                		c1 = list.pop();
	                		list.push(performOperation(c1, ch));
	                	}
	                	else {
		                    c1 = list.pop();
		                    c2 = list.pop();
	
		                    switch (ch) {
		                        case '&':
		                            list.push(performOperation(c1,c2,'&'));
		                            break;
		                        case '|':
		                            list.push(performOperation(c1,c2,'|'));
		                            break;
		                        default:
		                            System.out.println("Invalid operator order!");
		                    }
	                	}
	                }
	            }
		    }
		    //End of for loop
		    result =  list.pop();
		    
		    //Print truth table
		    for(int count = 0; count < chars[0].length; count++) {
		    	System.out.print(chars[i][count]+"\t");
		    }
		    System.out.println(result);
		}
	}
	//End of solvePostfix method

	//performOperation method for three parameter
	private Character performOperation(char c1, char c2, char op) {
		if(op == '&') {
			if(c1 == 'F' || c2 == 'F') {
				return 'F';
			}
			else
				return 'T';
		}
		
		else {
			if(c1 == 'T' || c2 == 'T') {
				return 'T';
			}
			else
				return 'F';
		}
	}
	// end of performOperation method.
	
	//performOperation method for two parameter
	private Character performOperation(char c1, char op) {
		if(c1 == 'F')
			return 'T';
		else
			return 'F';
	}
	//End of performOperation method
		
}

//End of class
