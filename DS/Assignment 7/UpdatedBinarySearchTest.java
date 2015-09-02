/****************************************************************************************
Name            : UpdatedBinarySearchTest
Revision Log    : 2015-09-02: Babalu patidar : created.
                : 
                : 
Use             : This class is used to test UpdateBinarySearch method.  
                :
****************************************************************************************/

import static org.junit.Assert.*;

import org.junit.Test;


public class UpdatedBinarySearchTest {

	//Test for normal case
	@Test
	public void test() {
		int inputArray[]={2,5,8,9,10,55,77};
		int searchElement=5;
		assertEquals(1,UpdatedBinarySearch.updateBinarySearch(inputArray, 0, inputArray.length-1, searchElement));
	}
	
	//Test for left most elecment
	@Test
	public void test1() {
		int inputArray[]={2,5,8,8,8,55,77};
		int searchElement=8;
		assertEquals(2,UpdatedBinarySearch.updateBinarySearch(inputArray, 0, inputArray.length-1, searchElement));
	}
	
	//Test for element not found
	@Test
	public void test2() {
		int inputArray[]={2,5,8,9,10,55,77};
		int searchElement=88;
		assertEquals(-1,UpdatedBinarySearch.updateBinarySearch(inputArray, 0, inputArray.length-1, searchElement));
	}
	
	@Test
	//Test for first element
	public void test3() {
		int inputArray[]={2,2,8,9,10,55,77};
		int searchElement=2;
		assertEquals(0,UpdatedBinarySearch.updateBinarySearch(inputArray, 0, inputArray.length-1, searchElement));
	}


}
