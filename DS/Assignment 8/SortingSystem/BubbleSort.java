/****************************************************************************************
Name            : BubbleSort
Revision Log    : 2015-09-04: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement BubbleSort method
                :
****************************************************************************************/
public class BubbleSort {
	
	//Start of bubbleSort method
	void bubbleSort(int array[]){
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					int temp;
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
				//End of if statement 
			}
			//End of second for loop
		}
		//End of first for loop
	}	
	//End of method
}
//End of class