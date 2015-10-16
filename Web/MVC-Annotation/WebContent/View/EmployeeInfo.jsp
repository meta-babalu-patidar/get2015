<%@page import="com.Model.Employee"%>
<%@page import="com.Helper.EmployeeCache"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<title>MetaCube</title>
		<link rel = "stylesheet" type = "text/css" href = "CSS/StyleSheet.css"></link>
	</head>
	<body>
		<div id = "wrapper">
			<div id = "header">
				<h2>Metacube</h2>
				<h3>Programmed for excellence</h3>
			</div>
			<div id = "navigation">
				<ul>
					<li><a href="IndexController">Home</a></li>
					<li><a href = "RegistrationController">Registration</a></li>
					<li><a href = "EmployeeListController">Employee List</a></li>
				</ul>
			</div>
			
			<div id = "container">
			<%			
				Employee employee =(Employee)request.getAttribute("employee");
				out.println("<form>");
				out.println("<table id=\"table1\">");

				out.println("<tr  > <th>Employee Id<th> Name<th>Email<th>Age<th>Date Of Registration</tr>");
			 	out.println("<tr >");
			 	out.println("<td >" + employee.getId() + "</td>" );
		 		out.println("<td>" + employee.getName() + "</td>" );
		 		out.println("<td>" + employee.getEmail() +"</td>" );
			 	out.println("<td>"+employee.getAge()+"</td>");
		 		out.println("<td>"+employee.getDateOfRegistration()+"</td></tr></table>");
		 		out.println("</form>");
			 %>
		 
		 </div>
				
			
			<div id = "footer">
				<ul>
					<li><a href = "#">Contact us</a><span>  |</span></li>
					<li><a href = "#">Feedback</a><span>  |</span></li>
					<li><a href = "#">Help</a></li>
				</ul>
				<p> (@) Copyright  2015. All Rights Reserved </p>
			</div>
		</div>
	</body>