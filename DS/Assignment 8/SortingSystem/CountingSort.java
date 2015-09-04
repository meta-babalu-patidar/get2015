/****************************************************************************************
Name            : CountingSort
Revision Log    : 2015-09-04: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement CountingSort method
                :
****************************************************************************************/
public class CountingSort {

	//Start of countingSort method
	void countingSort(int array[],int max){
		int tempArray[]=new int[(int) Math.pow(10, max)];
		int count=0;
		for(int i=0;i<array.length;i++){
			tempArray[array[i]]++;
		}
		for(int i=0;i<tempArray.length;i++){
			while(tempArray[i]!=0){
				array[count++]=i;
				tempArray[i]--;
			}
			//End of while loop
		}
		//End of for loop
	}
	//End of countingSort method
}
//End of class
