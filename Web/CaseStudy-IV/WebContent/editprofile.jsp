<%@page import="java.io.IOException"%>
<%@page import="java.sql.*"%>
<%@page import="com.helper.*" %>
<%@page import="com.model.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>cardekho.com</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css"></link>
	</head>
	<body>
	<div id="wrapper">
		<header>
			<h1>Car Dekho</h1>
			<br>
			<h3>Drive For Excellence</h3>
		</header>
		<nav>
		  <ul class="nav1">
			<li><a href="AdminHomeController">My Home</a></li>
			<li><a href="CreateController">Create</a></li>
			<li><a href="SearchAdminController">Search</a></li>
			<li><a href="LogoutController">Logout</a></li>
		  </ul>
		</nav>
		<section class="sectionAdmin">
				<h1>Update Details </h1>
				<form action="EditProfileController" method="post">
				<table>
				<%
					try{
						ResultSet rs = VehicleJDBCHelper.adminProfile();
						rs.next();
						out.print("<tr><td>Email</td><td><input type='text' class='field' name='email' readonly required value='"+rs.getString("email")+"'></td></tr>");
						out.print("<tr><td>Name</td><td><input type='text' class='field' name='name' required value='"+rs.getString("name")+"'></td></tr>");
						out.print("<tr><td>Contact</td><td><input type='text' class='field' name='contact' required value='"+rs.getString("contact")+"'></td></tr>");
						out.print("<tr><td>Address</td><td><input type='text' class='field' name='address' required value='"+rs.getString("address")+"'></td></tr>");
					} catch(Exception e) {
						System.out.print(e.getMessage());
						e.printStackTrace();
					}
				%>
					<tr>
						<td colspan="2"><input type="submit" class="button" value="Submit"></td>
					</tr>
				</table>
				</form>
		</section>
		<footer>
			<p> @Copyright  2015. All Rights Reserved. Designed By <b>Babalu Patidar</b> </p>
		</footer>
		</div>
	</body>
</html>