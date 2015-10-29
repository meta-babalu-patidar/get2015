<%@page import="java.io.IOException"%>
<%@page import="java.sql.*"%>
<%@page import="com.helper.*" %>
<%@page import="com.model.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Create New Car</title>
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
		  <ul>
			<li><a href="HomeController">Home</a></li>
			<li><a href="LoginController">Login</a></li>
			<li><a href="SearchController">Search</a></li>
		  </ul>
		</nav>
		<section class="section4">
			<form action="#">
				
					<h2>Car Details</h2>
					<table>
						<tr>
							<th>Make</th>
							<th>Model</th>
							<th>View Details</th>
						</tr>
						<tr>
							<%
							String make = request.getParameter("make");
							try {
								ResultSet rs = VehicleJDBCHelper.searchModel(make);
								String model;
								while(rs.next()) {
									model = rs.getString("model");
									out.print("<tr><td>"+make+"</td><td>"+model+"</td><td><a href='ViewDetailUserController?make="+make+"&model="+model+"'>View Details</a></td></tr>");
								}
							} catch(Exception e) {
								e.printStackTrace();
							}
						%>
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