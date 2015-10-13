package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegistrationForm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWritterw = response.getWriter();
		boolean flag=true;
		response.setContentType("text/html");
		printWritterw.println("<b>This is servlet page.<b><br><br>");
		if(request.getParameter("firstName") == "")
		{
			printWritterw.println("First Name not entered<br>");
			flag=false;
		} 
		
		if(request.getParameter("lastName")== "") 
		{
			printWritterw.println("Last Name not entered<br>");
		    flag=false;
		}
		
		if(request.getParameter("password").length() < 8 )
		{
			printWritterw.println("Password Length should be greater than 8 <br>");
		     flag=false;
		}
		
		if(!request.getParameter("password").equalsIgnoreCase(request.getParameter("confirmPassword"))) 
		{  
			printWritterw.println("Password doesn't match<br>");
			flag=false;
		}
		
		if( request.getParameter("age")=="")
		{
		   printWritterw.println("Age is not entered<br>");
		   flag=false;	
		}
		
		if(request.getParameter("state") == "")
		{ 
			printWritterw.println("State is not selected<br>");
			flag=false;
		}
		if(request.getParameter("city") == "") 
		{ 
			printWritterw.println("Cities is not selected<br>");
			flag=false;
		}
		if(request.getParameter("address")=="")
		{
			printWritterw.println("Address is not entered<br>");
			flag=false;
		}
	   
		if(flag==true){
				printWritterw.println("Form is validated at server side<br>");
		       RequestDispatcher requestDispatcher=request.getRequestDispatcher("/");  
		        requestDispatcher.forward(request, response);  
		}
	}
}	
