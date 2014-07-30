<!DOCTYPE html>
<html  ng-app="createUser">
<head>
<meta charset="utf-8">
<title>Servico Json</title>
<script src="angular.min.js"></script>
<script src="json.js"></script>
<style> .selecionadoCss{background-color: red;}</style>
</head>
<body ng-controller="createUserCtrl">
<form>
	<input type="text" ng-mode="user.id" />
	<input type="text" ng-model="user.name" placeholder="Name" />
	<input type="text" ng-model="user.email" placeholder="E-mail" />
	<input type="checkbox" ng-model="user.enabled" /> Ativo 
	<button ng-click="addUser(user)" ng-disabled="!(user.name && user.email)"> Adicionar </button>
	
</form>
	
	
	
	
	<table ng-show="contatos.length > 0">
		
		<tr>
			<th>Nome</th><th>id</th><th>email</th>
		</tr>
		<tr ng-class="{selecionadoCss: !contato.enable}"  ng-repeat="contato in contatos">

			<td>{{contato.name}}</td> 
			<td>{{contato.id}}</td>
			<td>{{contato.email}}</td>
		</tr>
	</table>
	
</body>
</html>