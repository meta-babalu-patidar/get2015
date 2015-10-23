/****************************************************************************************
Name            : Login
Revision Log    : 2015-10-14: Babalu patidar : created.
                : 
                : 
Use             : This class is used to validate login from.
                :
****************************************************************************************/
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//doGet method validate all entries of login from on server side.
	//And return result to page.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("email").toString();
		String password=request.getParameter("password").toString();
		boolean flag=true;
		
		String result = "";
		
		if(email == "")  {
			result+="Email not entered<br>";
		    flag=false;
		}
		
		else if(password.length() < 0 ) {
			result+="Password not entered <br>";
		     flag=false;
		}
		
		if(flag==true){
				int i=0;
				try {
					i = Database.search(email,password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       if(i==1){
		    	   pw.println("<br><b>Login Successfully... <b><br><a href='login.jsp'>Logout..<a>");
		       }
		       else {
		    	   result="Email Id or Password is incorrect..";
		    	   response.sendRedirect("login.jsp?message="+URLEncoder.encode(result, "UTF-8"));
		       }
		}else{
			response.sendRedirect("login.jsp?message="+URLEncoder.encode(result, "UTF-8"));
	    }
			
	}
	//End of doGet method.

}
//End of class.
