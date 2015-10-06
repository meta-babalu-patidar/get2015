
function check() {
	if(document.getElementById("firstName").value.trim() == "") {
		alert("First Name Is Empty");
	} 
	
	else if(document.getElementById("lastName").value.trim() == "") {
		alert("Last Name Is Empty");
	}
	
	else if(document.getElementById("password").value.length < 8 ){
		alert("Password Length should be greater than 8");
	}
	
	else if(document.getElementById("password").value != document.getElementById("confirmPassword").value) {
		alert("Password & Confirm Password mismatch!!");
	}
	else if(document.getElementById("age").value < 18 || document.getElementById("age").value>=100) {
		alert("Age Should be in range 18-100");
	}
	else if(document.getElementById("state").selectedIndex == 0 || document.getElementById("city").selectedIndex == 0 ) {
		alert("State or City are not Selected!!");
	}
	else {
		alert(document.getElementById("textBox").value);
	}
	
}
function createCity() {
	var cityObject = document.getElementById("city");
	var stateObject = document.getElementById("state");
	cityObject.innerHTML = "<Option value='Select City'>Select City</option>"
	switch(stateObject.value) {
		case "Rajsthan" :
			cityObject.innerHTML += "<Option value='Jaipur'>Jaipur</option><Option value='Kota'>Kota</option><Option value='Ajmer'>Ajmer</option><Option value='Bharatpur'>Bharatpur</option>";
			break;
		case "MP" :
			cityObject.innerHTML += "<Option value='Indore'>Indore</option><Option value='Bhopal'>Bhopal</option><Option value='Gwalior'>Gwalior</option><Option value='Susner>Susner</option>";
			break;
		case "UP" :
			cityObject.innerHTML += "<Option value='Kanpur'>Kanpur</option><Option value='Aligarh'>Aligarh</option><Option value='Mathura'>Mathura</option><Option value='Agra'>Agra</option>";
			break;
		case "Maharastra":
			cityObject.innerHTML += "<Option value='Pune'>Pune</option><Option value='Mumbai'>Mumbai</option><Option value='Aurangabad'>Aurangabad</option><Option value='Thane'>Thane</option>";
			break;
	}
}

function activateSubmit() {
	if(document.getElementById("acceptCondition").checked == true) {
		document.getElementById("submitButton").disabled = false;
	}
	else {
		document.getElementById("submitButton").disabled = true;
	}
}
		