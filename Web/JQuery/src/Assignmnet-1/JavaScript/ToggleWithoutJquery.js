

function showORHide1(){
		document.getElementById("span").style.visibility = "hidden";
		document.getElementById("button3").value = "Show";
		document.getElementById("button1").disabled = true;
		document.getElementById("button2").disabled = false;
	
}

function showORHide2(){
	document.getElementById("span").style.visibility = "visible";
	document.getElementById("button3").value = "Hide";
	document.getElementById("button2").disabled = true;
	document.getElementById("button1").disabled = false;

}

function showORHide3(){
	if(document.getElementById("button3").value == "Hide"){
		document.getElementById("span").style.visibility = "hidden";
		document.getElementById("button3").value = "Show";
		document.getElementById("button1").disabled = true;
		document.getElementById("button2").disabled = false;
	}
	else{
		document.getElementById("button3").value = "Hide";
		document.getElementById("span").style.visibility = "visible";
		document.getElementById("button2").disabled = true;
		document.getElementById("button1").disabled = false;
	}
	
}


