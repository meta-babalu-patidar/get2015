/*************************
	 * @author Babalu Patidar
	 * Program to Find longestSequnce 
	 * longest method take an array and return longest sequnce string
	 ***********/

import java.util.Arrays;
 
 //starting of class
public class LongestSequence 
{

	
	int k=0;

	int count = 1;  int max = 1;int start=0;int last=0;
String longest(int a[]) //longest method take an array and return longest sequnce string
{
	
	for (int i = 1; i < a.length; i++) 
	{
	    if (a[i] >= a[i - 1]) 
	    {   
	        last=i;
	        count++;
	    } 
	    else {
	        if (count > max)
	        {
	            max = count;
	        }
	        count = 1;
	        start=i;
	    }
	}

	int[] b=new int[max];
	for(int i=start;i<=last;i++)
	{   b[k]=a[i];
	    k++;
		 
		
	}
	System.out.println(Arrays.toString(b));
	return Arrays.toString(b);
 }//End of method

}//End of class 

 
