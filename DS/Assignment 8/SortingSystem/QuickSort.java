/****************************************************************************************
Name            : QuickSort
Revision Log    : 2015-09-04: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement QuickSort method
                :
****************************************************************************************/

public class QuickSort {

	//Start of qucikSort method
	void quickSort(int array[],int first,int last){
		
		if(first<last){
			int pivot=first;
			int sortingIndex=first+1;
			int temp;
			for(int i=sortingIndex;i<=last;i++){
				if(array[i]<array[pivot]){
					temp=array[i];
					array[i]=array[sortingIndex];
					array[sortingIndex]=temp;
					sortingIndex++;
				}
			}
			//End of for loop
			temp=array[pivot];
			array[pivot]=array[sortingIndex-1];
			array[sortingIndex-1]=temp;
			//Calling for left part 
			quickSort(array, first, sortingIndex-2);
			//Calling for right part
			quickSort(array,sortingIndex,last);
			
		}
		//End of if statement
	}
	//End of method
}
//End of class