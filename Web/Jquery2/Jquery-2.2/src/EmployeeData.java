

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EmployeeData
 */
@WebServlet("/EmployeeData")
public class EmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empName = request.getParameter("name");

		String detail = "";
		switch(empName)
		{
		case "Babalu": detail="Name: Babalu Patidar Age:22 Dob:19-09-1992  Address:Jhalawar";break;
		case "Banwari": detail="Name: Banwari kewat Age:22 Dob:19-09-1992  Address:Guna";break;
		case "Girdhari": detail="Name: Girdhari Age:22 Dob:19-09-1994  Address:UP";break;
		case "Dheeraj": detail="Name: Dheeraj Age:23 Dob:03-07-1992  Address:Kishangarh";break;
		}
		

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(detail);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
