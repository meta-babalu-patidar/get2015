
	
	function createCar(){
		var t1 = document.getElementById("t1").value;
		var t2 = document.getElementById("t2").value;
		var t3 = document.getElementById("t3").value;
		var t4 = document.getElementById("t4").value;
		var t5 = document.getElementById("t5").value;
		var t6 = document.getElementById("t6").value;
		var t7 = document.getElementById("t7").value;
		var t8 = document.getElementById("t8").value;
		var t9 = document.getElementById("t9").value;
		var t10 = document.getElementById("t10").value;
		if( t1.trim() == "" || t2.trim() == "" || t3.trim() == "" || t4.trim() == "" || t5.trim() == "" || t6.trim() == "" || t7.trim() == "" || t8.trim() == "" || t9.trim() == "" || t10.trim() == ""){
			alert("Please fill completely");
			return false;
		}else{
			alert("car created Successfully!!!");
			return true;
		}
	}