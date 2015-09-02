/****************************************************************************************
Name            : NaturalEmployeeSorting
Revision Log    : 2015-09-02: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement natural sorting of Clooection.  
                :
****************************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NaturalEmployeeSorting implements Comparable<Object>{
	String employeeID,employeeName,employeeAddress;
	//Constructor of class NaturalEmployeeSorting
	public NaturalEmployeeSorting(String employeeID,String nameOfStudent,String addressOfEmployee) {
		
		this.employeeName=nameOfStudent;
		this.employeeID=employeeID;
		this.employeeAddress=addressOfEmployee;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public String toString() {
		return "{"+employeeID+","+employeeName+","+employeeAddress+"}";
	}
	
	//Override compareTo method
	@Override
	public int compareTo(Object o) {
		return getEmployeeID().compareTo(((NaturalEmployeeSorting)o).getEmployeeID());
	}
	
	//Start of main method 
	//@param employeeList :Specify list of employee
	public static void main(String args[]) {
		List<NaturalEmployeeSorting> employeeListByAddress=new ArrayList<NaturalEmployeeSorting>();
		
		employeeListByAddress=addEmployee();
		
		System.out.println("Employee record is");
		System.out.println(employeeListByAddress);
		System.out.println("Employee in natural sorted order");
		Collections.sort(employeeListByAddress);
		System.out.println(employeeListByAddress);
		
	}
	//End of main method
	
	//Start of addEmployee Method
	public static List<NaturalEmployeeSorting> addEmployee() {
		int numberOfEmployee = 0;
		Scanner scan=new Scanner(System.in);
		List<NaturalEmployeeSorting> employeeList=new ArrayList<NaturalEmployeeSorting>();
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
			employeeList.add(new NaturalEmployeeSorting(employeeID, nameOfEmployee,addressOfEmployee));
		}
		scan.close();
		return employeeList;
	}
	//End of addEmployee Method

}
//End of class
