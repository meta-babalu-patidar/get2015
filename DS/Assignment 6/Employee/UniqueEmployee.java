/****************************************************************************************
Name            : UniqueEmployee
Revision Log    : 2015-09-02: Babalu patidar : created.
                : 
                : 
Use             : This class is used to store unique employee.  
                :
****************************************************************************************/

import java.util.*;

public class UniqueEmployee {
	String employeeID,nameOfEmployee,addressOfEmployee;
	//Constructor of class UniqueEmployee
	public UniqueEmployee(String employeeID,String nameOfStudent,String addressOfStudent) {
		this.employeeID=employeeID;
		this.nameOfEmployee=nameOfStudent;
		this.addressOfEmployee=addressOfStudent;
	}
	
	public String getemployeeID() {
		return employeeID;
	}
	
	public String toString() {
		return "{"+employeeID+","+nameOfEmployee+","+addressOfEmployee+"}";
	}
	
	//Start of main method 
	//@param employeeList :Specify list of employee
	public static void main(String args[]) {
		List<UniqueEmployee> employeeList=new ArrayList<UniqueEmployee>();
		employeeList=addEmployee();
		System.out.println("Employee record is");
		System.out.println(employeeList);
		System.out.println("Employee sorted order By name");
		Set<UniqueEmployee> employeeSet=new HashSet<UniqueEmployee>(employeeList);
		System.out.println(employeeSet);
	}
	//End of main method
	
	//Start of addEmployee Method
		public static List<UniqueEmployee> addEmployee() {
			int numberOfEmployee = 0;
			Scanner scan=new Scanner(System.in);
			List<UniqueEmployee> employeeList=new ArrayList<UniqueEmployee>();
			String employeeID,nameOfEmployee,addressOfEmployee;
			System.out.println("Enter Number of employee at least 5");
			try{
				numberOfEmployee=Integer.parseInt(scan.nextLine());
			}
			catch(Exception e){
				System.out.println("Enter integer number");
				addEmployee();
			}
			if(numberOfEmployee<5){
				System.out.println("Enter value that is greater than or equals to 5");
				addEmployee();
				
			}
			for(int count=0;count<numberOfEmployee;count++){
			
				System.out.println("Enter record of "+(count+1)+" Employee");
				
				System.out.println("Enter Employee ID");
				employeeID=scan.nextLine();
				System.out.println("Enter Employee Name");
				nameOfEmployee=scan.nextLine();
				System.out.println("Enter Employee Address");
				addressOfEmployee=scan.nextLine();
				employeeList.add(new UniqueEmployee(employeeID, nameOfEmployee,addressOfEmployee));
			}
			scan.close();
			return employeeList;
		}
		//End of addEmployee Method
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeID == null) ? 0 : employeeID.hashCode());
		return result;
	}
	//End of hashCode method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UniqueEmployee other = (UniqueEmployee) obj;
		if (employeeID == null) {
			if (other.employeeID != null)
				return false;
		} else if (!employeeID.equals(other.employeeID))
			return false;
		return true;
	}
	//End of equals method
	
}
//End of class
	
