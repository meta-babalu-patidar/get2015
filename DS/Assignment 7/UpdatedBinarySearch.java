/****************************************************************************************
Name            : UpdatedBinarySearch
Revision Log    : 2015-09-02: Babalu patidar : created.
                : 
                : 
Use             : This class is used to find leftmost index of element in binary search.  
                :
****************************************************************************************/


import java.util.Scanner;


public class UpdatedBinarySearch {
	

	//updateBinarySearch method take an inputArray,first,last,element that find
	//@param: Integer inputArray:Specify input array
	//@param: Integer first:Specify address of first element
	//@param: Integer last:Specify address of last element
	//@param: Integer element:Specify element that is to find in array
	//@param: Integer middle:Specify length of array
	static int updateBinarySearch(int inputArray[],int first,int last,int searchElement)
	{
		int middle=(first+last)/2;;
		if(first<=last)
		{
			//Condition for middle Element is equal to the search element
			if(inputArray[middle]==searchElement)
			{	
				//While loop test that element is left most 
				while(middle>0){
					//Condition that search element is left most
					if(inputArray[middle]!=inputArray[middle-1]){
						break;
					}
					middle--;
				}
				return middle;
			}
			//Condition for left search
			else if(inputArray[middle]>searchElement)
			{
				//recursive calling of left half
				return(updateBinarySearch(inputArray,first,middle-1,searchElement));
			}
			else
			{
				//recusive calling of right half
				return(updateBinarySearch(inputArray,middle+1,last,searchElement));
			}
			
		}
		else{
			//When element not found
			return -1;	
		}
		
	}
	//End of updateBinarySearch method
	
	
	//start of main
	//@param: Integer inputArray:Specify second value as input
	//@param: Integer output:Specify output return by linearsearch method
	//@param: Integer searchElement:Specify searchElement that is to find in array
	public static void main(String arg[])
	{
		int numberOfElement;
		int searchElement;
		int output;
		int element;
		try{
			Scanner scan=new Scanner(System.in);
			System.out.println("how many element in array..");
			numberOfElement=Integer.parseInt(scan.nextLine());
			System.out.println("Enter all  element in assending order..");
			int inputArray[]=new int[numberOfElement];
			for(int i=0;i<numberOfElement;i++){
				
				element=Integer.parseInt(scan.nextLine());
				if(isSort(inputArray, i, element)==true){
					inputArray[i]=element;
				}
				else{
					System.out.println("Enter sorted element..");
					i--;
				}
				
			}
		
			System.out.println("Enter element that you want to search");
			searchElement=Integer.parseInt(scan.nextLine());
			//Calling of updateBinarySearch method
			output=updateBinarySearch(inputArray,0,inputArray.length-1,searchElement);
			if(output==-1){
				System.out.println("Element not found");
			}
			else{
				System.out.print("Index of element is ="+output);
			}	
			scan.close();
		}
		catch(Exception e){
			System.out.println("Enter integer value only");
			main(arg);
		}
	}
	//End of main
	
	public static boolean isSort(int inputArray[],int i,int element){
		if(i==0){
			return true;
		}
		else if(inputArray[i-1]<=element){
			return true;
		}
		return false;
		
	}
	//End of isSort method

}
//End of class
