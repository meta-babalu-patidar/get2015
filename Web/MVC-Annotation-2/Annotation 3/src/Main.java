/****************************************************************************************
Name            : Main
Revision Log    : 2015-10-17: Babalu patidar : created.
                : 
                : 
Use             : This class is used to run annotation method.
                :
****************************************************************************************/
import java.lang.reflect.Method;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		
		Class<?> tempClass=AnnotationRunner.class;
		Method[] methods = tempClass.getMethods();

		for (Method method : methods) {
			
			if (method.isAnnotationPresent(CanRun.class)) {
				method.invoke(AnnotationRunner.class.newInstance());
			}
		}
		//End of for each loop 
	}
	//End of main method
}
//End of Main class
			



