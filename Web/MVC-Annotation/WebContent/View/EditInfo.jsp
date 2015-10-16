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
			
			<div id = "container1">
				<%			
					Employee employee =(Employee)request.getAttribute("employee");
					out.println("<form action = 'EmployeeEditController'>");
					out.println("<table id='table1'>");
					out.println("<tr > <th>Employee Id<th> Name<th>Email<th>Age<th>Date Of Registration<th>Submit</tr>");
				 	
				 	out.println("<tr >");

				 	out.println("<td><input type='text'  name = 'id' required value='" + employee.getId() + "' readonly></td>" );
				 	out.println("<td ><input type='text' name = 'name' required value='" + employee.getName() + "'></td>" );
				 	out.println("<td ><input type='email' name = 'email' required value='" + employee.getEmail() + "'></td>" );
				 	out.println("<td ><input type='number' name = 'age' required value='" + employee.getAge() + "'></td>");
				 	out.println("<td ><input type='text' name = 'dateOfRegistration' required value='" + employee.getDateOfRegistration() + "' readonly></td>");
				 	out.println("<td ><input type = 'submit' value= 'Submit' ></td></tr></table>");
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