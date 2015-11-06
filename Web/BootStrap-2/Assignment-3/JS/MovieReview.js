$(document).ready(function() {
		loadData();
		$('#myTable').dataTable({
			"iDisplayLength" : 5,
			"bPaginate" : true,
			"bInfo" : false,
			"bFilter" : true,
			"bLengthChange" :false
		});
	});

function loadData(){
	
var contentArray=[];


var movie1 = {Title:"ABCD", Genere:"Romantic", Director:"Prabhu Deva", Review  : "Good", Rating : "Best ever"};

var movie2 = {Title:"ABCD2", Genere:"Thriller", Director:"Prabhu Deva", Review  : "Good", Rating : "Best ever"};

var movie3 = {Title:"Golmaal", Genere:"Drama", Director:"Rohit Shatty", Review  : "Good", Rating : "Best ever"};

var movie4 = {Title:"Golmaal returns", Genere:"Comedy", Director:"Rohit Shatty", Review  : "Good", Rating : "Best ever"};

var movie5 = {Title:"Sholey", Genere:"Thriller", Director:"Ramesh Sippy", Review  : "Good", Rating : "Best ever"};

var movie6 = {Title:"Pyar ka Panchnama", Genere:"Horror", Director:"Luv Ranjan", Review  : "Good", Rating : "Best ever"};

var movie7 = {Title:"DDLJ", Genere:"Romantic", Director:"Aditya Chopra", Review  : "Good", Rating : "Best ever"};

var movie8 = {Title:"MP3", Genere:"Romantic", Director:"Nupur Asthana ", Review  : "Good", Rating : "Best ever"};

var movie9 = {Title:"Wanted", Genere:"Action", Director:"Prbhu Deva", Review  : "Good", Rating : "Best ever"};

var movie10 = {Title:"Ready", Genere:"Comedy-Action", Director:"Anees Bazmee", Review  : "Good", Rating : "Best ever"};

var movie11 = {Title:"PK", Genere:"Drama", Director:"Rajkumar Hirani", Review  : "Good", Rating : "Best ever"};

var movie12 = {Title:"Dhoom", Genere:"Action", Director:"Vijay Krishna Acharya", Review  : "Good", Rating : "Best ever"};

var movie13 = {Title:"Dhoom-2", Genere:"Action", Director:"Vijay Krishna Acharya", Review  : "Good", Rating : "Best ever"};

var movie14 = {Title:"Dhoom-3", Genere:"Action", Director:"Vijay Krishna Acharya", Review  : "Good", Rating : "Best ever"};

var movie15 = {Title:"Krish", Genere:"Action", Director:"Rakesh Roshan", Review  : "Good", Rating : "Best ever"};

var movie16 = {Title:"Krish-2", Genere:"Action", Director:"Rakesh Roshan", Review  : "Good", Rating : "Best ever"};

var movie17 = {Title:"Krish-3", Genere:"Action", Director:"Rakesh Roshan", Review  : "Good", Rating : "Best ever"};

contentArray.push(movie1);
contentArray.push(movie2);
contentArray.push(movie3);
contentArray.push(movie4);
contentArray.push(movie5);
contentArray.push(movie6);
contentArray.push(movie7);
contentArray.push(movie8);
contentArray.push(movie9);
contentArray.push(movie10);
contentArray.push(movie11);
contentArray.push(movie12);
contentArray.push(movie13);
contentArray.push(movie14);
contentArray.push(movie15);
contentArray.push(movie16);
contentArray.push(movie17);
	
var tbody = document.getElementById('mytableTbody');
for (var i = 0; i < contentArray.length; i++) {
	var tr = "<tr>";
	tr += "<td>" + contentArray[i].Title + "</td>" + "<td>" + contentArray[i].Genere + "</td>" + "<td>" + contentArray[i].Director + "</td>" + "<td>" + contentArray[i].Review + "</td>" + "<td>" + contentArray[i].Rating + "</td>" + "</tr>";
	tbody.innerHTML += tr;
}
}