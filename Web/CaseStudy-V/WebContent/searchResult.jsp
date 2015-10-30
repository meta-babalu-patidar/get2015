<%@page import="com.helper.*" %>
<%@page import="com.model.*" %>
<%@page import="java.util.*"%>
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
						
							<%
								boolean flag =true;
								String make = request.getAttribute("make").toString();
								List<String> modelList = (List<String>)request.getAttribute("model");
								Iterator<String> modelIterator = modelList.iterator();
								while(modelIterator.hasNext()) {
									
									if(flag){
										flag =false;
										%>	<tr>
										<th>Make</th>
										<th>Model</th>
										<th>View Details</th>
									</tr><%
									}
									String model = modelIterator.next();
									out.print("<tr><td>"+make+"</td><td>"+model+"</td><td><a href='ViewDetailUserController?make="+make+"&model="+model+"'>View Details</a></td></tr>");
								}
								
								if(flag){
									%><tr><th>No Car Found..</th></tr>
									<%
								}
						%>
					</table>
				
			</form>
		</section>
		<footer>
			<p> @Copyright  2015. All Rights Reserved. Designed By <b>Babalu Patidar</b> </p>
		</footer>
		</div>
	</body>
</html>