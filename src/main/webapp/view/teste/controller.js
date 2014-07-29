function ListaComprasController($scope) {
    
	$scope.url = 'http:/192.168.10.33:8080/financeiro/user/accounts';
	
	$scope.itens = $http.get(url).
    success(function(data) {
        $scope.greeting = data;
    });
    
    
    
 
    $scope.adicionaItem = function () {
        $scope.itens.push({produto: $scope.item.produto,
                           quantidade: $scope.item.quantidade,
                           comprado: false});
        $scope.item.produto = $scope.item.quantidade = '';
    };
}