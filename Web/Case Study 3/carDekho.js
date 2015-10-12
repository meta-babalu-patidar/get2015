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
		alert("Car Created Successfully..");
	}