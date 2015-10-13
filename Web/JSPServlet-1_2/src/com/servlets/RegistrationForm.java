package com.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class RegistrationForm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag=true;
		String result = "";
		response.setContentType("text/html");
		
		if(request.getParameter("firstName") == "")
		{
			result+="First Name not entered<br>";
			flag=false;
		} 
		
		if(request.getParameter("lastName")== "") 
		{
			result+="Last Name not entered<br>";
		    flag=false;
		}
		
		if(request.getParameter("password").length() < 8 )
		{
			result+="Password Length should be greater than 8 <br>";
		     flag=false;
		}
		
		if(!request.getParameter("password").equalsIgnoreCase(request.getParameter("confirmPassword"))) 
		{  
			result+="Password doesn't match<br>";
			flag=false;
		}
		
		if( request.getParameter("age")=="")
		{
			result+="Age is not entered<br>";
		   flag=false;	
		}
		
		if(request.getParameter("state") == "")
		{ 
			result+="State is not selected<br>";
			flag=false;
		}
		if(request.getParameter("city") == "") 
		{ 
			result+="Cities is not selected<br>";
			flag=false;
		}
		if(request.getParameter("address")=="")
		{
			result+="Address is not entered<br>";
			flag=false;
		}
	   
		if(flag==true){
			result+="Form is validated at server side<br>"; 
		}
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("ValidationCheck");
		rd.forward(request, response);
	}
}	
