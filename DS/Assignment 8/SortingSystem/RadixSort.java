/****************************************************************************************
Name            : RadixSort
Revision Log    : 2015-09-04: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement RadixSort method
                :
****************************************************************************************/

import java.util.*;
public class RadixSort {
	
	int position=1;
	
	//Start of radix sort method
	void radixSort(int array[],int maximumNumberOfDigit){
		HashMap<Integer, ArrayList<Integer>>hashmap=new HashMap<Integer,ArrayList<Integer>>();
		int count=0;
		//For loop is used to insert elements in hashMap with repect to position from right
		for(int i=0;i<array.length;i++){
			
			int temp=array[i];
			int digit=returnDigitAtPosition(temp, position);
			
				if(!hashmap.containsKey(digit)){
					ArrayList<Integer> arraylist =new ArrayList<Integer>();
					hashmap.put(digit,arraylist);
				}
				hashmap.get(digit).add(array[i]);
		}	
		//End of for loop
		//For loop is used to retraive element from hashMap and put into array
		for(int key=0;key<10;key++){
			if(hashmap.containsKey(key)){
				Iterator<Integer> iterator=hashmap.get(key).iterator();
				while(iterator.hasNext()){
					array[count++]=(int) iterator.next();
				}	
			}
		}
		//End of for loop
		position++;
		
		if(maximumNumberOfDigit>0){
			//recursiveCalling 
			radixSort(array, maximumNumberOfDigit-1);
		}
		
	}
	//End of RadixSort element
	
	//Strat of returnDigitAtPosition method
	int  returnDigitAtPosition(int number,int positionFromRight){
		
		int digit=0;
		while(positionFromRight>0){
			digit=number%10;
			number=number/10;
			positionFromRight--;
		}
		return digit;
		
	}
	
	//End of returnDigitAtPosition method

}
//End of class
