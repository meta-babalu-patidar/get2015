/****************************************************************************************
Name            : Employee
Revision Log    : 2015-10-17: Babalu patidar : created.
                : 
                : 
Use             : This class is used to make annotaion on method.
                :
****************************************************************************************/
public class Employee {
	
	@Enhancement(id = 1, name = "Babalu")
	public static void employeeDetail(int id, String name, String engineer, String date){
		System.out.println("Hii"+id+"->"+name+"->"+engineer+"->"+date);
	}
	@Enhancement(id = 1, name = "Babalu", engineer="software", date="10/17/2015")
	public static void employeeDetails(int id, String name, String engineer, String date){
		System.out.println("Hii"+id+"->"+name+"->"+engineer+"->"+date);
	}
	public static void employeeDetail(){
		System.out.println("Annotation Not found");
	}

}
//End of class
