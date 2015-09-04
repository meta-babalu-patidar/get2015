/****************************************************************************************
Name            : TreeSortTest
Revision Log    : 2015-09-04: Babalu patidar : created.
                : 
                : 
Use             : This class is used to test treeSort  method 
                :
****************************************************************************************/

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TreeSortTest {

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
	
	//Test for tree sort
	@Test
	public void test() {
		TreeSort treeSort=new TreeSort();
		int expected[]={2,5,8,9,10,11,55,77};
		int input[]={2,5,8,9,10,55,77,11};
		treeSort.treeSort(input);
		assertArrayEquals(expected,input);
	}
	//End of test method
	
	@Test
	public void test2() {
		TreeSort treeSort=new TreeSort();
		int expected[]={232,675,856,1060,1121,9967,545325,678877};
		int input[]={232,675,856,9967,1060,1121,545325,678877};
		treeSort.treeSort(input);
		assertArrayEquals(expected,input);
	}
	//End of test2 method
	 
}
//End of class