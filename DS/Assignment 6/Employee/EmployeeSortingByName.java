/****************************************************************************************
Name            : EmployeeSortingByName
Revision Log    : 2015-09-02: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement employee sorting by name.  
                :
****************************************************************************************/

import java.util.*;

class EmployeeSortingByName implements Comparable<Object>{
	String employeeID,nameOfEmployee,addressOfEmployee;
	//Constructor of class EmployeeSortingByName
	public EmployeeSortingByName(String employeeID,String nameOfStudent,String addressOfStudent) {
		this.employeeID=employeeID;
		this.nameOfEmployee=nameOfStudent;
		this.addressOfEmployee=addressOfStudent;
	}
	public String getNameOfStudent() {
		return nameOfEmployee;
	}
	public String toString() {
		return "{"+employeeID+","+nameOfEmployee+","+addressOfEmployee+"}";
	}
	
	//Override compareTo method
	@Override
	public int compareTo(Object o) {
		return getNameOfStudent().compareTo(((EmployeeSortingByName)o).getNameOfStudent());
	}
	
	
	//Start of addEmployee Method
	public static List<EmployeeSortingByName> addEmployee() {
		int numberOfEmployee = 0;
		Scanner scan=new Scanner(System.in);
		List<EmployeeSortingByName> employeeList=new ArrayList<EmployeeSortingByName>();
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
			employeeList.add(new EmployeeSortingByName(employeeID, nameOfEmployee,addressOfEmployee));
		}
		scan.close();
		return employeeList;
	}
	//End of addEmployee Method
	
	

	//Start of main method 
	//@param employeeList :Specify list of employee
	public static void main(String args[]) {
		List<EmployeeSortingByName> employeeList=new ArrayList<EmployeeSortingByName>();
		employeeList=addEmployee();
		System.out.println("Employee record is");
		System.out.println(employeeList);
		System.out.println("Employee sorted order By name");
		Collections.sort(employeeList);
		System.out.println(employeeList);
		
	}
	//End of main method
	
	
}
