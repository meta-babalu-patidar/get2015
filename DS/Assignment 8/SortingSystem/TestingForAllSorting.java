/****************************************************************************************
Name            : TestingForAllSorting
Revision Log    : 2015-09-04: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement TestingForAllSorting method
                :
****************************************************************************************/

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestingForAllSorting {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//Test for bubble sort
	@Test
	public void testForBubbleSort() {
		int input[]={13,56,90,34,78,45,23};
		int expected[]={13,23,34,45,56,78,90};
		new BubbleSort().bubbleSort(input);
		assertArrayEquals(expected, input);
	}
	
	//Test for Quick Sort
	@Test
	public void testForQuickSort() {
		
		int input[]={13,56,90,34,78,45,23,49,34,78,93,134};
		int expected[]={13,23,34,34,45,49,56,78,78,90,93,134};
		new QuickSort().quickSort(input,0,input.length-1);
		assertArrayEquals(expected, input);
	}
	
	//Test for Counting sort
	@Test
	public void testForCountingSort() {
		
		int input[]={13,56,90,34,78,45,23};
		int expected[]={13,23,34,45,56,78,90};
		new CountingSort().countingSort(input,2);
		assertArrayEquals(expected, input);
	}
	
	//Test for Radix sort
	@Test
	public void testForRadixSort() {
		
		int input[]={13,56,90,238,34,78,45,23,178};
		int expected[]={13,23,34,45,56,78,90,178,238};
		new RadixSort().radixSort(input,3);
		assertArrayEquals(expected, input);
	}
	
	//Test for Bubble Sort Using ComarisonSort
	@Test
	public void testForBubbleSortUsingComarisonSort() {
		int input[]={13,56,90,34,78,45,23};
		int expected[]={13,23,34,45,56,78,90};
		SortingSystemMain.comparisonSort(input);
		assertArrayEquals(expected, input);
	}
	
	//Test for Quick Sort Using ComarisonSort
	@Test
	public void testForQuickSortUsingComarisonSort() {
		
		int input[]={13,56,90,34,78,45,23,49,34,78,93,134};
		int expected[]={13,23,34,34,45,49,56,78,78,90,93,134};
		SortingSystemMain.comparisonSort(input);
		assertArrayEquals(expected, input);
	}
	
	//Test for Counting Sort Using LinearSort
	@Test
	public void testForCountingSortUsingLinearSort() {
		
		int input[]={13,56,90,34,78,45,23};
		int expected[]={13,23,34,45,56,78,90};
		SortingSystemMain.linearSort(input);
		assertArrayEquals(expected, input);
	}
	
	//Test for Radix Sort Using LinearSort
	@Test
	public void testForRadixSortUsingLinearSort() {
		
		int input[]={13,56,90,238,34,78,45,23,178};
		int expected[]={13,23,34,45,56,78,90,178,238};
		SortingSystemMain.linearSort(input);
		assertArrayEquals(expected, input);
	}
	

}
