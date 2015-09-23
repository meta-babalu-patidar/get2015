/****************************************************************************************
Name            : MyException
Revision Log    : 2015-09-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to handle all the eaception manually.
                :
****************************************************************************************/
package helper;

public class MyException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public MyException(Exception e) {
		System.out.print(e.getMessage());
	}
	//End of myException constructor
}
//End of class
