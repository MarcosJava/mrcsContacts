var app=angular.module("listaTelefonica",[]);

		app.controller("listaTelefonicaCtrl", function($scope){
			
				$scope.titulo="Lista Telefonica";
				
				$scope.contatos = [
				                   {nome:"Marcos",telefone:"9999-9999"},
				                   {nome:"Marcelo", telefone:"8888-8888"},
				                   {nome:"Renan", telefone:"7777-7777"}
				                   ];
				$scope.adicionarContato = function(contato){
					$scope.contatos.put(angular.copy(contato));
					delete $scope.contatos;
				};
			
		});