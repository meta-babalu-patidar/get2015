/*****************************
 * @author Babalu Patidar
 * Program to testcase for convert binary number to octal number 
 *convertBinaryToOctal method return octal number of binary n
 */
 import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BinaryToOctalTest {

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

	@Test //it test binary to octal method
	public void test() {
		
		BinaryToOctal b=new BinaryToOctal();
		int return_v=b.convertBinaryToOctal(11110);
		assertEquals("not match",36,return_v);
	}
		
		
	}


