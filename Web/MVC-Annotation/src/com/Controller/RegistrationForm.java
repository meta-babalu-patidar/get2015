/****************************************************************************************
Name            : RegistrationForm
Revision Log    : 2015-10-15: Babalu patidar : created.
                : 
                : 
Use             : This class is used to register a employee.
                :
****************************************************************************************/
package com.Controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Helper.EmployeeCache;
import com.Helper.IsEmployeeID;
import com.Model.Employee;


@SuppressWarnings("serial")
@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher requestDispatcher ;
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			int Id =(Integer.parseInt(request.getParameter("Id")));
			int age =(Integer.parseInt(request.getParameter("age")));
			String registrationDate = new Date().toString();
			if(IsEmployeeID.check(Id)) {
				Employee employee = new Employee(name, email, Id, age, registrationDate);
				EmployeeCache employeeCache = EmployeeCache.getInstance();
				employeeCache.addEmployee(employee);
				request.setAttribute("list", employeeCache.getAllEmployees());
				requestDispatcher = request.getRequestDispatcher("View/EmployeeList.jsp");
				requestDispatcher.forward(request, response);
			} else {
				
				request.setAttribute("msg","Employee Id Already Present");
				requestDispatcher = request.getRequestDispatcher("View/Registration.jsp");
				requestDispatcher.forward(request, response);
			}
		
		}
		catch(Exception e) {
						
			RequestDispatcher requestDispatcher ;
			request.setAttribute("msg","Please Enter Correct Entries");
			requestDispatcher = request.getRequestDispatcher("View/Registration.jsp");
			requestDispatcher.forward(request, response);
		}
		//End of try catch block
	}
	//End of doGet Method
}
//End of servlet.
