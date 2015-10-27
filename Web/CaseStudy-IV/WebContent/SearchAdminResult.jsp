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
		<nav class="nav1">
		  <ul>
			<li><a href="AdminHomeController">My Home</a></li>
			<li><a href="CreateController">Create</a></li>
			<li><a href="SearchAdminController">Search</a></li>
			<li class="logout"><a href="LogoutController">Logout</a></li>
		  </ul>
		</nav>
		<section class="section4">
			<form action="#">
				
					<h2>Car Details</h2>
					<table>
						
						<%
							String make = request.getParameter("make");
							try {
								boolean flag = true;
								ResultSet rs = VehicleJDBCHelper.searchModel(make);
								String model;
								
								while(rs.next()) {
									flag = false;
									if(rs.isFirst()){
										%>	<tr>
												<th>Make</th>
												<th>Model</th>
												<th>View Details</th>
												<th>Edit Car</th>
											</tr><% 
									}
									model = rs.getString("model");
									out.print("<tr><td>"+make+"</td><td>"+model+"</td><td><a href='ViewDetailController?make="+make+"&model="+model+"'>View Details</a></td><td><a href='EditCarController?make="+make+"&model="+model+"'>Edit</a></td></tr>");
								}

								if(flag){
									%><tr><th>No Car Found..</th></tr>
									<%
								}
							}
							catch(Exception e) {
								e.printStackTrace();
							}
						%>
						
					</table>
				
			</form>
		</section>
		<footer>
			<p> @Copyright  2015. All Rights Reserved. Designed By <b>Babalu Patidar</b></p>
		</footer>
		</div>
	</body>
</html>