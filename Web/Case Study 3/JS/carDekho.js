	function loginCheck(){
		var id = document.getElementById("id");
		var password = document.getElementById("password");
		if( id.value == "babalupatidar@gmail.com" && password.value == "1234" )
			return true;
		else
		{
			alert("Incorrect email id or password");
			id.value="";
			password.value="";
			return false;
		}
	}
	
	function create(){
		
		if(document.getElementById("name").value != ""&&
			document.getElementById("engineincc").value != ""&& 
			document.getElementById("fuelcapacity").value != ""&& 
			document.getElementById("make").value != ""&& 
			document.getElementById("milage").value != ""&& 
			document.getElementById("model").value != ""&& 
			document.getElementById("price").value != ""&& 
			(document.getElementById("ac").checked == true||document.getElementById("ac1").checked == true)&&
			(document.getElementById("accessoryKit").checked == true||document.getElementById("accessoryKit1").checked == true)&&
			(document.getElementById("powerSteering").checked == true||document.getElementById("powerSteering1").checked == true)) {
				
			alert("Car Created Successfully..");
		}
		else{
			alert("Please Fill all entries..");
		}
	}