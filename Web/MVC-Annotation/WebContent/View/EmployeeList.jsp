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
						Map<Integer, Employee> employeeMap = (Map<Integer, Employee>)request.getAttribute("list");
						
						out.println("<form >");
						out.println("<table  id=\"table1\">");
						if(employeeMap.size()==0){
							out.println("<tr ><td style='color:red';>");
							out.println("No Entery Found");
							out.println("</td></tr  >");
						}
						else{
							
							out.println("<tr  > <th>Employee Id<th> Name<th>Email<th>View Details<th>Edit Details</tr>");
							
							for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
								Employee employee = entry.getValue();
								out.println("<tr  >");
							 	out.println("<td>" + employee.getId() + "</td>" );
							 	out.println("<td>" + employee.getName() + "</td>" );
							 	out.println("<td>" + employee.getEmail() + "</td>" );
							 	out.println("<td><a href=\"/MVC-Annotation/EmployeeList?id="+employee.getId()+"\">View Detail</a></td>");
							 	out.println("<td><a href=\"/MVC-Annotation/EditEmployee?id="+employee.getId()+"\">Edit Detail</a></td></tr>");
							}
							
							
						}
						out.println("</table>");
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