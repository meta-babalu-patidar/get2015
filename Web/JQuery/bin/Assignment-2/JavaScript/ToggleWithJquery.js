

$(document).ready(function(){
	    $("#button3").click(function(){
	        if($("#button3").attr("value") == "Hide"){
	        	$("#button3").attr("value","Show");
		        $("#span").hide();
	        	$("#button2").removeAttr("disabled");
	        	$("#button1").attr("disabled","disabled");
	        }
	        else{
		        $("#span").show();
	        	$("#button3").attr("value","Hide");
	        	$("#button1").removeAttr("disabled");
	        	$("#button2").attr("disabled","disabled");
	        }
	    });
	    
	    $("#button1").click(function(){
	        	$("#button3").attr("value","Show");
		        $("#span").hide();
	        	$("#button2").removeAttr("disabled");
	        	$("#button1").attr("disabled","disabled");
	    });
	    
	    $("#button2").click(function(){
	        
		        $("#span").show();
	        	$("#button3").attr("value","Hide");
	        	$("#button1").removeAttr("disabled");
	        	$("#button2").attr("disabled","disabled");
	        
	    });
});
