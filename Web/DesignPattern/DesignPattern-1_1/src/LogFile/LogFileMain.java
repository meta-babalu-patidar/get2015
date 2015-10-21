
/****************************************************************************************
Name            : LogFileMain
Revision Log    : 2015-10-20: Babalu patidar : created.
                : 
                : 
Use             : This class is used to store exception in log file.
                :
****************************************************************************************/
package LogFile;

public class LogFileMain {
	public static void main(String[] args) {
		
		
		try {
			@SuppressWarnings("unused")
			int c = 100 / 0;
		} 
		catch (Exception e ){
			LogFile loggerClass = LogFile.getInstance();
			loggerClass.catchException(e.fillInStackTrace().toString());
			System.out.println("Divide by Zero exception");
			
		}
		try {
			int arr[]= new int[5];
			arr[6]=10;
			
		} catch (Exception e) {
			LogFile loggerClass = LogFile.getInstance();
			loggerClass.catchException(e.fillInStackTrace().toString());
			System.out.println("Array out bound exception");
		}		
		
	}
	//End of main
}
//End of class
