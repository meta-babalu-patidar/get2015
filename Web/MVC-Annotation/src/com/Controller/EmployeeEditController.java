/****************************************************************************************
Name            : EmployeeEditController
Revision Log    : 2015-10-15: Babalu patidar : created.
                : 
                : 
Use             : This class is used to edit employee information.
                :
****************************************************************************************/

package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Helper.EmployeeCache;
import com.Model.Employee;

/**
 * Servlet implementation class InformationEditController
 * this servlet edit information of a selected employee and save 
 */
@WebServlet("/EmployeeEditController")
public class EmployeeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher ;
		String name = request.getParameter("name");
		System.out.println(name);
		String email = request.getParameter("email");
		System.out.println(email);
		int id =(Integer.parseInt(request.getParameter("id")));
		System.out.println(id);
		int age =(Integer.parseInt(request.getParameter("age")));
		System.out.println(age);
		String registrationDate = request.getParameter("dateOfRegistration");
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		Employee employee = new Employee(name, email, id, age, registrationDate);
		employeeCache.updateEmployee(employee);
		request.setAttribute("list", employeeCache.getAllEmployees());
		requestDispatcher = request.getRequestDispatcher("View/EmployeeList.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
//End of class
