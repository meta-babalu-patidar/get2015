/****************************************************************************************
Name            : Main
Revision Log    : 2015-10-17: Babalu patidar : created.
                : 
                : 
Use             : This class is used to run method of annotation method.
                :
****************************************************************************************/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
	
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
	
		Class <?>tempClass = Employee.class;
		//Methods store all method of class employee
		Method[] methods = tempClass.getDeclaredMethods();
	
		for (Method method : methods) {
	
			if (method.isAnnotationPresent(Enhancement.class)) {
				Enhancement test = method.getAnnotation(Enhancement.class);
				int info = test.id();
				String name = test.name();
				if (1 == info) {
					System.out.println("Welcome");
					// try to invoke the method with param
					method.invoke(Employee.class.newInstance(), info, name,
							test.engineer(), test.date());
				}
			} else {
				System.out.println("Welcome");
				method.invoke(Employee.class.newInstance());
			}
			//End of if else statement
	
		}
		//End of for-each loop
	
	}
	//End of main method

}
//End of class
