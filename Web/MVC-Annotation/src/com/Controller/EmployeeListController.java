/****************************************************************************************
Name            : EmployeeListController
Revision Log    : 2015-10-15: Babalu patidar : created.
                : 
                : 
Use             : This class is used to control employeelist.jsp page.
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

/**
 * Servlet implementation class ListController
 * this controller redirect to Employee list
 */
@WebServlet("/EmployeeListController")
public class EmployeeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		request.setAttribute("list", employeeCache.getAllEmployees());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/EmployeeList.jsp");
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
