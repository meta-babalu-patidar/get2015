/****************************************************************************************
Name            : SortingSystemMain
Revision Log    : 2015-09-04: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement sorting system 
                :
****************************************************************************************/

import java.util.Arrays;
import java.util.Scanner;


public class SortingSystemMain {
	static Scanner scan= new Scanner(System.in);
	
	//Start of main method
	//@param choice : Specify choice of user
	//@param inputArrat : Store element to be sorted
	public static void main(String arg[]){
		
		//Calling of takeInputOfArray method
		int inputArray[]=takeInputOFArray();
		int choice=0;
	 	do{
	 		//Calling of displayMenu method
	 		displayMenu();
			while(!scan.hasNextInt()) {
				System.out.println("Please Enter Integer Only");
				scan.next();
			}
			choice=scan.nextInt();
			
	 		switch(choice){
	 		case 1:
	 			//Calling of comparisonSort method
	 			comparisonSort(inputArray);
	 			break;
	 		
	 		case 2:
	 			//Calling of linearSort method
	 			linearSort(inputArray);
	 			break;
	 		case 3:
	 			System.exit(0);
	 			
	 		default :
	 			System.out.println("Please Enter Correct Choice");
	 		}
	 		//End of switch case
		
		}while(choice!=3);
	 	//End of do while loop
		
	}
	//End of main method
	
	//Start of comparisan sort method
	static void comparisonSort(int inputArray[]){
		
		if(inputArray.length>10){
			QuickSort quickSort=new QuickSort();
			quickSort.quickSort(inputArray, 0, inputArray.length-1);
			System.out.println("System has used Quick sorting technique and sorted list as below :\n"+Arrays.toString(inputArray));
		}
		else{
			BubbleSort bubbleSort=new BubbleSort();
			bubbleSort.bubbleSort(inputArray);
			System.out.println("System has used Bubble sorting technique and sorted list as below :\n"+Arrays.toString(inputArray));
		}
		
	}
	
	//Start of linearSort method
	static void linearSort(int inputArray[]){
		int maximumDigitInElement=findMaximumDigitInElement(inputArray);
		if(maximumDigitInElement>2){
			RadixSort radixSort=new RadixSort();
			radixSort.radixSort(inputArray, maximumDigitInElement);
			System.out.println("System has used Radix sorting technique and sorted list as below :\n"+Arrays.toString(inputArray));
		}
		else{
			CountingSort countingSort=new CountingSort();
			countingSort.countingSort(inputArray,maximumDigitInElement);
			System.out.println("System has used counting sorting technique and sorted list as below :\n"+Arrays.toString(inputArray));
		}
	}
	
	//Start of findMaximumDigitInElement method
	static int findMaximumDigitInElement(int[] inputArray) {
		int digit=0;
		for(int count=0;count<inputArray.length;count++){
			int position=0;
			int number=inputArray[count];
			while(number>0){
				number=number/10;
				position++;
			}
			if(digit<position){
				digit=position;
			}
		}
		return digit;
	}

	//Start of dispalyMenu method
	static void displayMenu(){
		System.out.println("Enter your choice \n1. For comparison sorting\n2. linear sorting\n3.Exit");
	}
	
	
	//Start if takeInputOfaraayMethod
	static int[] takeInputOFArray(){
    	int count;
    	int size=0;
    	int[] inputArray = null;
		do{
			System.out.println("Enter number of Elements to be sort should be greater than 0");
			while(!scan.hasNextInt()) {
				System.out.println("Please Enter Integer Only");
				scan.next();
			}
			 size=scan.nextInt();
		}while(size<=0);
		//End of do-while loop
		inputArray=new int[size];
    	System.out.println("Enter all Element");
    	
 	 	for(count=0;count<size;count++) {
	    	while(!scan.hasNextInt()) {
				System.out.println("Please Enter Integer Only");
				scan.next();
	    	}
	    	inputArray[count]=scan.nextInt();
        }
 	 	//End of for loop
	
		return inputArray;
    	
    }
	//End of takeInputOfArray method

}
//End of class
