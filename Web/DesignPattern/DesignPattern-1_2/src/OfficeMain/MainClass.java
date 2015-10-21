/****************************************************************************************
Name            : MainClass
Revision Log    : 2015-10-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to perform operation on office.
                :
****************************************************************************************/

package OfficeMain;

import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

import workstation.Office;
import factory.FactoryMaker;
import Engineermodel.EngineerType;
import Engineermodel.IEngineer;

public class MainClass {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int choice;
		while(true) {
	
			//Calling of printMenu method.
			choice = printMenu();
			switch(choice) {
			case 1:
				//Calling of addEngineer method
				addEngineer();
				break;
			case 2:
				//Calling of displayEngineer method.
				displayEngineer();
				break;
			case 3:
				scanner.close();
				System.exit(0);
				break;
			default :
				System.out.println("Enter correct choice..");
				
			}
			//End of switch satatement
		}
		//End of loop.	
	}
	//End of main method

	//printMenu method print menu list.
	//@return user choice.
	private static int printMenu() {
		
		int choice;
		System.out.print("\n Enter your choice : \n 1. Add Engineer \n 2. Display Engineers \n 3. Exit");
		
		do {
			System.out.println("\n Please Enter positive integer(less than 4)");
			while(!scanner.hasNextInt()) {
				System.out.println("\n Please Enter Integer Only");
				scanner.next();
			}
			choice = scanner.nextInt();
		}while( choice <= 0 || choice >= 4 );
		return choice;	
	}
	//End of printmenu method.
	
	//addEngineer method addEngineer into List of engineer 
	private static void addEngineer() {
		
		int type;
		String name;
		EngineerType role;
		IEngineer engineer;
		Office office = Office.getInstance();
		System.out.println("\n Select Engineer's type : \n 1. Developer\n 2. Mechanical Engineer");
		
		do {
			System.out.println("\n Please Enter positive integer(less than 3)");
			while(!scanner.hasNextInt()) {
				System.out.println("\n Please Enter Integer Only");
				scanner.next();
			}
			type = scanner.nextInt();
		}while( type <= 0 || type >= 3 );
		
		System.out.print("\n Enter Name of Engineer : ");
		name = scanner.next();
		if( type == 1 ){
			role = EngineerType.Developer;
		} else {
			role = EngineerType.MechanicalEngineer;
		}
		engineer = FactoryMaker.getFactory(role);
		engineer.setName(name);
		engineer.setRole(role);
		office.addEngineer(engineer);	
	}
	//End of addEngineer list.
	
	//Start of displayEngineer method
	private static void displayEngineer() {
		IEngineer engineer;
		Office office = Office.getInstance();
		List<IEngineer> listEngineers;
		Iterator<IEngineer> iterator;
		listEngineers = office.displayList();
		if(listEngineers.size() == 0) {
			System.out.println("List is empty..");
		} else {
			System.out.println("\n -:All Engineer are below :-");
			iterator = listEngineers.iterator();
			while(iterator.hasNext()) {
				engineer = iterator.next();
				System.out.println(engineer.toString());
			}
			System.out.println("\n");
		}
		
	}
	//End of displayengineer method.
	
	
}
//End of main class
