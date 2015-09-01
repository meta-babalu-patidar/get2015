/****************************************************************************************
Name            : QueueUsingCollection
Revision Log    : 2015-09-01: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement queue using java collection linkedList 
                :
****************************************************************************************/

import java.util.LinkedList;
import java.util.Scanner;


public class QueueUsingCollection {

	//Start of main method
	//@param choice : Specify choice of user
	//@param element : specify input element
	public static void main(String args[]) {
		
		int choice;
		int element;
		int output;
		Scanner scan = new Scanner(System.in);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		do{
			//Calling of displayMenu
			displayMenu();
			while(!scan.hasNextInt()) {
				System.out.println("Please Enter Integer ..");
				scan.next();
			}
			choice = scan.nextInt();
			//Start of switch
			switch(choice) {
			
				case 1:
					System.out.println("Enter a number: ");
					while(!scan.hasNextInt()) {
						System.out.println("Please Enter Integer Only");
						scan.next();
					}
					element = scan.nextInt();
					linkedList.addLast(element);
					break;
					
				case 2:
					if(!linkedList.isEmpty()) {
						output = linkedList.poll();
						System.out.println("Removed Element is: "+output);
					}
					else{
						System.out.println("Queue is Empty");
					}
					break;
					
				case 3:
					if(!linkedList.isEmpty()) {
						output = linkedList.peek();
						System.out.println("Front Element is: "+output);
					}
					else{
						System.out.println("Queue is Empty");
					}
					break;
					
				case 4:
					if(!linkedList.isEmpty()) {
					
						System.out.println(linkedList);
					}
					else{
						System.out.println("Queue is Empty");
					}
					break;
					
				case 5:
					linkedList.clear();
					break;
					
				case 6:
					System.exit(0);
					break;
					
					default:
						System.out.println("Enter correct choice");
			}
			//End of switch case
				
		} while(choice!=6);
		//End of do-While
		scan.close();
	}
	//End of main method
	
	
	//Start of displayMenu method
	public static void  displayMenu(){
		System.out.println("Enter your choice: \n"
			+ "1. Add an element to queue\n"
			+ "2. Remove an element from queue\n"
			+ "3. Get front element of queue\n"
			+ "4. Display the queue\n"
			+ "5. clear the queue\n"
			+ "6. Exit");
	}//End of displayMenu method
}
//End of class

