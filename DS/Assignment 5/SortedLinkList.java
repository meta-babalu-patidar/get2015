/****************************************************************************************
Name            : SortedLinkList
Revision Log    : 2015-09-01: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement add Element in Sorted Linked List 
                :
****************************************************************************************/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class SortedLinkList {

	//Start of main method
	//@param choice : Specify choice of user
	//@param linkedList : Specify linkedList that is used as queue
	public static void main(String arg[]){
		
		int choice=0;
		LinkedList<Integer> linkedlist=new LinkedList<Integer>();
		Scanner scan=new Scanner(System.in);
		do{
			displayMenu();
			try{
				choice=Integer.parseInt(scan.next());
			}
			catch(Exception e){
				System.out.println("Enter integer :");
			}
			
			//Start of switch
			switch(choice){
			case 1:
				System.out.println("Enter element");
				try{
					int element=Integer.parseInt(scan.next());
					addElement(linkedlist, element);
				}
				catch (Exception e) {
					System.out.println("Enter integer :");
				}
				break;
				
			case 2:
				System.out.println("Linkedlist : "+linkedlist);
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Enter correct choice :");
			}
			//End of switch
		
		}while(choice!=3);
		//End of do-while loop
			
		scan.close();
		
		
	}
	//End of main
	
	//Start of displayMenu method
	private static void displayMenu() {
		System.out.println("Enter your choice \n1. Add Element in sorted LinkedList\n2. Display LinkedList\n3. Exit");
		
	}
	//ENd of displayMenu method
	
	//Start of addElement method
	public static void addElement(LinkedList<Integer> linkedList,int data) {
		
		if(linkedList.isEmpty()==true){
			linkedList.add(data);
		}
		else{
		Iterator<Integer> ite=linkedList.iterator();
		int count=0;
		for(;count<linkedList.size();count++){
			if(data<ite.next()){
				break;
			}
		}
		linkedList.add(count, data);
		}
	}
	//End of addElement method
}
//End of class


