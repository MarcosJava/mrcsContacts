var app=angular.module("createUser",[]);

	app.controller("createUserCtrl", function($scope,$http){
		
		$scope.contatos;
		
		$scope.carregarContatos = function(){
			var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}};
			$http.get("/financeiro/view/teste/angularJson").success(function(data,status, config){
				$scope.contatos = data;
			}).error(function(data,status,config){
				console.error(data);
			});
		};
		
		$scope.addUser = function(user){
			var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}};
			$http.post("/financeiro/view/teste/angularJson", user).success(function(data,status, config){
				$scope.carregarContatos();
				delete $scope.user;
			}).error(function(data,status,config){
				console.error(data);
			});
				
		};
		
		$scope.carregarContatos();
	});