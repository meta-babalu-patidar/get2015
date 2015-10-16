<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.Model.Employee"%>
<%@page import="com.Helper.EmployeeCache"%>
 
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
				<form action="RegistrationForm" class="register">
				<h1>Registration :- </h1><br>
				<table>
						<tr>
						<td>Name *</td>
						<td><input type="text" name="name" id="name" required placeholder="Enter Name" class="text"></td>
					</tr>
					<tr>
						<td>Email *</td>
						<td><input type="email" name="email" id="email" required placeholder="Enter Email" class="text"></td>
					</tr>
					
					<tr>
						<td>Age *</td>
						<td><input type="number" name="age" id="age" min="18" max="100" required  placeholder="Enter Age Between 18 - 100" class="text"></td>
					</tr>
					<tr>
						<td>Employee Id *</td>
						<td><input type="number" name="Id" id="Id" min="1" required placeholder="Enter employeeId" class="text"></td>
					</tr>
					
					<tr>
						<td colspan="2"><input name="submit" type="submit" value="Submit" id="submitButton" ></td>
					</tr>
					<tr>
						<td colspan="2" style="color:red">${msg}</td>
					</tr>
				</table>
			</form>
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