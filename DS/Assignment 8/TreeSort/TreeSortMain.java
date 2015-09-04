/****************************************************************************************
Name            : TreeSortMain
Revision Log    : 2015-09-04: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement all tree  method 
                :
****************************************************************************************/
import java.util.Arrays;
import java.util.Scanner;


public class TreeSortMain {
	
	//Start of main method
    public static void main(String args[])
    {
    	TreeSort object= new TreeSort();  
    	int inputArray[]=takeInputOFArray();
	    //Calling treeSort method
	    object.treeSort(inputArray);
	    //Displaying sorted array
	    System.out.println("Sorted Roll Numbers Using QueueSort\n"+Arrays.toString(inputArray)); 
	}
    //End of main method
    
    //takeInputOFArray method is used to take input for an arrray
    //@param count is used for index of element
    //@param size represent size of array
    static int[] takeInputOFArray(){
    	int count;
    	int size=0;
    	int[] inputArray = null;
    	Scanner scan= new Scanner(System.in);
		do{
			System.out.println("Enter number of students should be greater than 0");
			while(!scan.hasNextInt()) {
				System.out.println("Please Enter Integer Only");
				scan.next();
			}
			 size=scan.nextInt();
		}while(size<=0);
		//End of do-while loop
		inputArray=new int[size];
    	System.out.println("Enter roll number of all student");
    	
 	 	for(count=0;count<size;count++) {
	    	while(!scan.hasNextInt()) {
				System.out.println("Please Enter Integer Only");
				scan.next();
	    	}
	    	inputArray[count]=scan.nextInt();
	    	for(int j=0;j<count;j++){
	    		if(inputArray[j]==inputArray[count]){
	    			System.out.println("Roll Number is already present..Enter diffrent Roll number");
	    			count--;
	    		}
	    	}
        }
 	 	//End of for loop
	    scan.close();
		return inputArray;
    	
    }
    //End of takeInputOFArray method

}
//End of class
