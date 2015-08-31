/****************************************************************************************
Name            : PrinterUsingPriorityQueue
Revision Log    : 2015-08-31: Babalu patidar : created.
                : 
                : 
Use             : This class is used to printer that print documents based on priority 
                :
****************************************************************************************/

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrinterUsingPriorityQueue {
	
	//@param PriorityQueue: specify priority queue which holds document in descending order according to document priority
	//@param Size : specify size of the priotirity queue
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		PriorityQueue<Integer> priorityQueueObj = new PriorityQueue<Integer>( 10, Collections.reverseOrder() );
		int documentPriority;
		int size;
		int choice;
		String info[]={"Under Graduates ","Graduates","Professor","Chair Person "};
		try{
			
			do{
				
				System.out.println("Enter your choice:\n1. Add document in to queue\n"
						+ "2. Show the current document to be serviced \n"
						+ "3. Service the currnet document\n"
						+ "4. Exit");
				
				while( !scan.hasNextInt() ) {					
						System.out.println("Please Enter Integer Number");
						scan.next();
				}
				choice = scan.nextInt();
				
				//Start of switch case
				switch(choice){
				
				//Case 1 for add documents in queue
				case 1:	
					do {
						System.out.println("Enter Priorities between 1-4 as : \n"
								+ "4. Chair Person (Highest Priority)\n"
								+ "3. Professor\n"
								+ "2. Graduates\n"
								+ "1. Under Graduates");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Number");
							scan.next();
						}
						documentPriority = scan.nextInt();
					}while(documentPriority <= 0 || documentPriority >= 5);
					
					
					priorityQueueObj.add(documentPriority);
					break;
					
				//case 2 print the first element in queue 
				case 2:
					size = priorityQueueObj.size();
					if( size == 0 ) {  
						System.out.println("Queue is empty");
						break;
					}
					
					System.out.println("Current document to be printed for: "+info[priorityQueueObj.peek()-1]);
					break;
				
				//case 3 for serve the first element in queue	
				case 3:
					size = priorityQueueObj.size();	
					if( size == 0 ) {		
						System.out.println("Queue is empty");
						break;
					}
					System.out.println("Current Serviced document is: "+info[priorityQueueObj.poll()-1]); // else serviced the top priority document and print it
					break;
					
				//case 4 for exit	
				case 4:
					System.out.println("System Exited");
					System.exit(0);
					break;
				default:
					System.out.println("Enter Correct Choice");
				}
				//End of switch
			} while(true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			scan.close();
		}
		//End of try catch
	}
	//End of main method

	
}
//End of class PrinterUsingPriorityQueue
