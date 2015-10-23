/****************************************************************************************
Name            : Registration
Revision Log    : 2015-10-14: Babalu patidar : created.
                : 
                : 
Use             : This class is used to validate Registration from.
                :
****************************************************************************************/
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//doGet method validate all entries of registration from on server side.
	//And return result to page.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("email").toString();
		String name=request.getParameter("name").toString();
		String password=request.getParameter("password").toString();
		String confirmPassword=request.getParameter("confirmPassword").toString();
		String age=request.getParameter("age").toString();
		String state=request.getParameter("state").toString();
		String city=request.getParameter("city").toString();
		String address=request.getParameter("address").toString();
		boolean flag=true;
		
		String result = "";
		
		if(name == "") {
			result+="Name not entered<br>";
			flag=false;
		} 
		
		else if(email == "")  {
			result+="Email not entered<br>";
		    flag=false;
		}
		
		else if(password.length() < 8 ) {
			result+="Password Length should be greater than 8 <br>";
		     flag=false;
		}
		
		else if(!password.equalsIgnoreCase(confirmPassword)) {  
			result+="Password doesn't match<br>";
			flag=false;
		}
		
		else if( age == "" || Integer.parseInt(age)<=18 || Integer.parseInt(age)>100) {
			result+="Age should be between 18-100 <br>";
		   flag=false;	
		}
		
		else if(state  == "") { 
			result+="State is not selected<br>";
			flag=false;
		}
		else if( city  == "") { 
			result+="Cities is not selected<br>";
			flag=false;
		}
		else if( address == ""){
			result+="Address is not entered<br>";
			flag=false;
		}
		
		if(flag==true){
				
		       if(Database.insert(name,email,password)){
		    	   pw.println("<br><b>Registered Successfully... <b><br><a href='login.jsp'>Login Now<a>");
		       }
		       else {
		    	   result="Email Id is already registered..";
		    	   response.sendRedirect("registration.jsp?message="+URLEncoder.encode(result, "UTF-8"));
		       }
		}else{
			response.sendRedirect("registration.jsp?message="+URLEncoder.encode(result, "UTF-8"));
	    }
		
	}
	//End of doGet method.
}
//End of class.
