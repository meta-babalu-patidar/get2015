var module = angular.module("customerManager", [ 'ngRoute' ]);
	module.config(function($routeProvider) {
		$routeProvider.when('/addcustomer', {
			templateUrl : 'addcustomer.html',
	
		});
	});
	
	
	module.controller('customerController', function($scope) {
		$scope.listview1 = false;
		$scope.customers = [{firstName:"Babalu",lastName:"Patidar",email:"babalupatidar@gmail.com",address:"Pratap Nagar",numberOfOrders:4}];
	
		$scope.newCustomer = function() {
			
			if(angular.element($('#firstName')).val() == ""){
				alert("Enter first Name");
			}
			else if(angular.element($('#lastName')).val() == ""){
				alert("Enter Last Name");
			}
			else if(angular.element($('#email')).val() == ""){
				alert("Enter email");
			}
			else if(angular.element($('#address')).val() == ""){
				alert("Enter address");
			}
			else if(angular.element($('#numberOforders')).val() == ""){
				alert("Enter Number Of Orders");
			}
			else {
				$scope.customers.push($scope.customerController);
				$scope.customerController = null;
				angular.element($('#addCustomer')).removeClass("in");
			}
			
		}
		
		
		$scope.deletecustomer = function(index) {
			$scope.customers.splice(index, 1);
		}
		$scope.listView = function(input) {
			if(input == 1){
				$scope.listviewed = true;
			}
			else {
				$scope.listviewed = false;
			}
		}
		
	});
