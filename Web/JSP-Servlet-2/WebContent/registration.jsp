<!DOCTYPE>

<HTML>
<head>
	<title>Registration</title>
	<script type="text/javascript" src="JavaScript/registration.js">
	</script>
	<link rel = "stylesheet" type = "text/css" href = "CSS/registration.css"></link>
</head>
<body>
	<form action="Registration" class="register">
	<h1>Registration :- </h1><br>
		<table>
			<tr>
				<td>Name *</td>
				<td><input type="text" name="name" id="name" placeholder="Enter Name" class="text"></td>
			</tr>
			<tr>
				<td>Email (As User Name) *</td>
				<td><input type="email" name="email" id="email" placeholder="Enter Email" class="text"></td>
			</tr>
			<tr>
				<td>Password *</td>
				<td><input type="password" name="password" id="password" placeholder="Enter password" class="text"></td>
			</tr>
			<tr>
				<td>Confirm Password *</td>
				<td><input type="password" name="confirmPassword" id="confirmPassword" placeholder="Enter Confirm password" class="text"></td>
			</tr>
			<tr>
				<td>Age *</td>
				<td><input type="number" name="age" id="age" min="18" max="100"  placeholder="Enter Age Between 18 - 100" class="text"></td>
			</tr>
			<tr>
				<td>State *</td>
				<td>
					<Select id="state"  onchange="createCity()" name="state" class="text">
						<option value="">Select State</option>
						<option value="Rajsthan">Rajsthan</option>
						<option value="MP">Madhay Pradesh</option>
						<option value="Maharastra">Maharastra</option>
						<option value="UP">Uttar Pradesh</option>
					</Select>
				</td>
			</tr>
			<tr>
				<td>Select City *</td>
				<td>
					<select id="city" name="city" class="text">
						<option value="">Select City</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Your Address *</td>
				<td><textarea name="address" id="addressLine1" rows="3" placeholder="Enter complete address" class="text"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="checkbox" id="acceptCondition" onChange="activateSubmit()"><label for="acceptCondition"> I Accept all <a href="#">Terms and Conditions</a></label></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" id="submitButton" onClick="check()" disabled></td>
			</tr>
			</table>
			<p align="center" class="error">${param.message}</p>
	</form>
</body>

</html>




