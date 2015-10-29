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
			<li class="active"><a href="#">My Home</a></li>
			<li><a href="CreateController">Create</a></li>
			<li><a href="SearchAdminController">Search</a></li>
			<li><a href="LogoutController">Logout</a></li>
		  </ul>
		</nav>
		<section class="sectionAdmin">
				<h1>Admin Profile</h1>
				<table>
				<%
					try{
						ResultSet rs = VehicleJDBCHelper.adminProfile();
						rs.next();
						out.print("<tr><td>Email</td><td>"+rs.getString("email")+"</td></tr>");
						out.print("<tr><td>Name</td><td>"+rs.getString("name")+"</td></tr>");
						out.print("<tr><td>Contact</td><td>"+rs.getString("contact")+"</td></tr>");
						out.print("<tr><td>Address</td><td>"+rs.getString("address")+"</td></tr>");
					} catch(Exception e) {
						System.out.print(e.getMessage());
						e.printStackTrace();
					}
				%>
					<tr>
						<td colspan="2"><a href="EditProfileController">Edit Profile</a></td>
					</tr>
				</table>
		</section>
		<footer>
			<p> @Copyright  2015. All Rights Reserved. Designed By <b>Babalu Patidar</b> </p>
		</footer>
		</div>
	</body>
</html>