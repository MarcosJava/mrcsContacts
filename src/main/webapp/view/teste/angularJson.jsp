<!DOCTYPE html>
<html  ng-app="createUser">
<head>
<meta charset="utf-8">
<title>Servico Json</title>
<script src="angular.min.js"></script>
<script src="json.js"></script>
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
			<th></th><th>Nome</th><th>Telefone</th><th>Operadora</th>
		</tr>
		<tr ng-class="{selecionadoCss: contato.selecionado}"  ng-repeat="contato in contatos">
			<td><input type="checkbox" ng-model="contato.selecionado" /></td>
			<td>{{contato.name}}</td> 
			<td>{{contato.password}}</td>
			<td>{{contato.email}}</td>
		</tr>
	</table>
	
</body>
</html>