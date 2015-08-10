/*************************
	 * @author Babalu Patidar
	 * Program to check whether array is ascending descending  or un sorted
	 * check method take an array as input and return 1 for ascending 2 for descending 0 for unsorted
	 ***********/
import java.util.Arrays;

//start of SortCheck class
public class SortCheck {
	
	public int check(int n[]) //check method take an array as input and return 1 for ascending 2 for descending 0 for unsorted
	{
		
		
		int len=n.length;
		int i=0,out=0;
		for( i=0;i<len-1;i++)
		{ int j=i+1;
			if(n[i]>n[j])
			break;	
		}
		if(i==len-1)
			out=1;
		else
		{
			for( i=0;i<len-1;i++)
			{ int j=i+1;
				if(n[i]<n[j])
				break;	
			}
			
			if(i==len-1)
				out=2;
			
			
		}
		
		
		
	
		
	return out;

}// End of method
}// End of class

