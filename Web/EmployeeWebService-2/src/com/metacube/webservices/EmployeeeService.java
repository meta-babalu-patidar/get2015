
/****************************************************************************************
Name            : EmployeeeService
Revision Log    : 2015-11-02: Babalu patidar : created.
                : 
                : 
Use             : This class is used to perform all operation for employee.
                :
****************************************************************************************/

package com.metacube.webservices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.metacube.EmployeeSystemException;
import com.metacube.dbHelper.EmployeeDBHelper;
import com.metacube.model.Employee;
 
@Path("/Employeeservice")
public class EmployeeeService {
	
	
	@GET
	@Produces("application/xml")
	public String getAllEmployee() {
 
		String result = "<Employeeservice>" + "<Employeeoutput>"+"@Produces(\"application/xml\") Output: \n\nAll Employees \n\n";
		List<Employee> list = new ArrayList<Employee>();
		EmployeeDBHelper employeeDBHelper = new EmployeeDBHelper();
		try {
			list = employeeDBHelper.returnAllEmployee();
		} catch (EmployeeSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list != null){
			result = "<Employeeservice>" + "<Employeeoutput>"+"@Produces(\"application/xml\") Output: \n\nAll Employees \n\n";
			Iterator<Employee> iterator = list.iterator();
			while(iterator.hasNext()){
				Employee employee = new Employee();
				employee = iterator.next();
				result+="<employee>" + "<name>" +employee.getName()+"</name>" + "<id>" + employee.getId() + "</id>" + "<age>" + employee.getAge() + "</age>" + "</employee>";
			}
			result += "</Employeeoutput>" + "</Employeeservice>";
		}
		else{
			result = "<Employeeservice>" + "<Employeeoutput>"+"@Produces(\"application/xml\") Output: \n\n Employees not found \n\n";
			result += "</Employeeoutput>" + "</Employeeservice>";
		}
		return result;
	}
	//End of getAllEmployee method
	
 
	@Path("{c1}/{c2}/{c3}")
	@GET
	@Produces("application/xml")
	public String createEmployee(@PathParam("c1") String name, @PathParam("c2") String id, @PathParam("c3") int age){
		Employee employee = new Employee();
		employee.setName(name);
		employee.setId(id);
		employee.setAge(age);
		
		EmployeeDBHelper employeeDBHelper = new EmployeeDBHelper();
		boolean isInsert = false;
		try {
			isInsert = employeeDBHelper.addEmployee(employee);
		} catch (EmployeeSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isInsert){
			String result = "@Produces(\"application/xml\") Output: \nCreate Employee Output \n\n Employee Created successfully";
			return "<employeeservice>" + "<name>" + employee.getName() + "</name>" + "<employeeoutput>" + result + "</employeeoutput>" + "</employeeservice>";
		}
		else{
			String result = "@Produces(\"application/xml\") Output: \nCreate Employee Output \n\n Employee can't inserted";
			return "<employeeservice>" + "<name>" + employee.getName() + "</name>" + "<employeeoutput>" + result + "</employeeoutput>" + "</employeeservice>";
		}	
	}
	//End of createEmployee method
	
	@Path("{id}")
	@GET
	@Produces("application/xml")
	public String getEmployeebyId(@PathParam("id") String id) {
		EmployeeDBHelper employeeDBHelper = new EmployeeDBHelper();
		Employee employee = null;
		try {
			employee = employeeDBHelper.returnEmployee(id);
		} catch (EmployeeSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(employee != null) {
			String result = "@Produces(\"application/xml\") Output: \ngetEmployeebyId Output \n\n Employee Found";
			return "<employeeservice>" + "<employeeoutput>" + result +  "<name>" + employee.getName() + "</name>" + "<id>" + employee.getId() + "</id>" + "<age>" + employee.getAge() + "</age>" + "</employeeoutput>" + "</employeeservice>";
		} else {
			String result = "@Produces(\"application/xml\") Output: \ngetEmployeebyId Output \n\n Employee not found";
			return "<employeeservice>" + "<name> Not Available </name>" + "<employeeoutput>" + result + "</employeeoutput>" + "</employeeservice>";
		}
	}
	//End of getEmployeebyId
	
	@Path("{name}")
	@POST
	@Produces("application/xml")
	public String getAllEmployeeByName(@PathParam("name") String name) {
		 
		 
		String result = "";
		List<Employee> list = new ArrayList<Employee>();
		EmployeeDBHelper employeeDBHelper = new EmployeeDBHelper();
		try {
			list = employeeDBHelper.returnAllEmployee(name);
		} catch (EmployeeSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list != null){
			result = "<Employeeservice>" + "<Employeeoutput>"+"@Produces(\"application/xml\") Output: \n\nAll Employees \n\n";
			Iterator<Employee> iterator = list.iterator();
			while(iterator.hasNext()){
				Employee employee = new Employee();
				employee = iterator.next();
				result+="<employee>" + "<name>" +employee.getName()+"</name>" + "<id>" + employee.getId() + "</id>" + "<age>" + employee.getAge() + "</age>" + "</employee>";
			}
			result += "</Employeeoutput>" + "</Employeeservice>";
		}
		else{
			result = "<Employeeservice>" + "<Employeeoutput>"+"@Produces(\"application/xml\") Output: \n\n Employees not found \n\n";
			result += "</Employeeoutput>" + "</Employeeservice>";
		}
		return result;
	}
	//End of employeebyname method
	
	@Path("{id}")
	@DELETE
	@Produces("application/xml")
	public String deleteEmployeebyId(@PathParam("id") String id) {
		EmployeeDBHelper employeeDBHelper = new EmployeeDBHelper();
		boolean isDelete = false;
		try {
			isDelete = employeeDBHelper.deleteEmployee(id);
		} catch (EmployeeSystemException e) {
			e.printStackTrace();
		}
		if(isDelete){
			String result = "@Produces(\"application/xml\") Output: \nCreate Employee Output \n\n Employee Deleted successfully";
			return "<employeeservice>" + "<id>" + id + "</id>" + "<employeeoutput>" + result + "</employeeoutput>" + "</employeeservice>";
		}
		else{
			String result = "@Produces(\"application/xml\") Output: \nCreate Employee Output \n\n Employee can't delete";
			return "<employeeservice>" + "<id>" + id + "</id>" + "<employeeoutput>" + result + "</employeeoutput>" + "</employeeservice>";
		}
	}
	//End deleteEmployeebyId method..

}
//End of class..
