<!DOCTYPE>

<HTML>
<head>
	<title>Registration</title>
	<script type="text/javascript" src="JavaScript/registration.js">
	</script>
	<link rel = "stylesheet" type = "text/css" href = "CSS/registration.css"></link>
</head>
<body>
	<form action="Login" class="login">
	<h1>Login :- </h1><br>
		<table>
			
			<tr>
				<td>Email (As User Name) *</td>
				<td><input type="email" name="email" id="email" placeholder="Enter Email"></td>
			</tr>
			<tr>
				<td>Password *</td>
				<td><input type="password" name="password" id="password" placeholder="Enter password"></td>
			</tr>
			<tr>
				<td></td>
				<td  ><br><input type="submit" value="Login" id="login"></td>
			</tr>   
			<tr>
				<td colspan="2" align="center">New User <a href="registration.jsp">Click Here</a></td></tr>
			</table>
			<p align="center" class="error">${param.message}</p>
	</form>
</body>

</html>




