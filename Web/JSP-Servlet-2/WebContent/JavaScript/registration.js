
function createCity() {
	var cityObject = document.getElementById("city");
	var stateObject = document.getElementById("state");
	cityObject.innerHTML = "<Option value=''>Select City</option>"
	switch(stateObject.value) {
		case "Rajsthan" :
			cityObject.innerHTML += "<Option value='Jaipur'>Jaipur</option><Option value='Kota'>Kota</option><Option value='Ajmer'>Ajmer</option><Option value='Bharatpur'>Bharatpur</option>";
			break;
		case "MP" :
			cityObject.innerHTML += "<Option value='Indore'>Indore</option><Option value='Bhopal'>Bhopal</option><Option value='Gwalior'>Gwalior</option><Option value='Susner'>Susner</option>";
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
		