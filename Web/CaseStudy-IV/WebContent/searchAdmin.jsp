<%@page import="java.io.IOException"%>
<%@page import="java.sql.*"%>
<%@page import="com.helper.*" %>
<%@page import="com.model.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Search Car</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css"></link>
	</head>
	<body>
	<div id="wrapper">
		<header>
			<h1>Car Dekho</h1>
			<br>
			<h3>Drive For Excellence</h3>
		</header>
		<nav class="nav1">
		  <ul>
			<li><a href="AdminHomeController">My Home</a></li>
			<li><a href="CreateController">Create</a></li>
			<li class="active"><a href="#">Search</a></li>
			<li class="logout"><a href="LogoutController">Logout</a></li>
		  </ul>
		</nav>
		<section class="section2">
			<form action="SearchAdminController" method="post">
					<h2>Select Details</h2>
					<table>
						<tr>
							<td class="text">Select Make:</td>
							<td><input type="text" list="make" name="make" required placeholder="Select Make" class="list">
							<datalist id="make">
							<%
								try {
									ResultSet rs = VehicleJDBCHelper.distictMake();
									while(rs.next()) {
										out.print("<option value="+rs.getString("make")+">");
									}
								} catch(Exception e) {
									e.printStackTrace();
								}
							%>
							</datalist></td>
						</tr>
						<tr>
							<td colspan="2" align="center" class="button"><input type="submit" name="type" class="button" value="Search"></td>
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