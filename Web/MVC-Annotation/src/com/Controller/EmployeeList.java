/****************************************************************************************
Name            : EmployeeList
Revision Log    : 2015-10-15: Babalu patidar : created.
                : 
                : 
Use             : This class is used to control employeeInfo.jsp page.
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
 * Servlet implementation class EmployeeList
 * this servlet show the details of employees 
 * and having link to edit and view detail of a selected employee
 */
@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeeList() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));

		EmployeeCache employeeCache = EmployeeCache.getInstance();
		Employee employee = employeeCache.getEmployeeForId(id);
		RequestDispatcher req = request.getRequestDispatcher("View/EmployeeInfo.jsp");

		request.setAttribute("employee", employee);

		req.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
//End of class
