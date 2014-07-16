<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
		
<div class="masthead">
	<h3 class="muted">FINACEIRO</h3>
</div>
<div class="container">
		<ul class="nav nav-pills">
			<li class="active"><a href='<c:url value="/" />'>Home</a></li>
			<li><a href="#">Perfil</a></li>
			
			<li class="dropdown"><a href="#" data-toggle="dropdown"
				class="dropdown-toggle">Conta <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href='<c:url value="/user/createAccount" />'>Cadastrar</a></li>
					<li><a href='<c:url value="/user/accounts" />'>Listar</a></li>
				</ul>
			</li>
			
			<li class="dropdown"><a href="#" data-toggle="dropdown"
				class="dropdown-toggle">Lançamentos <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li> <a href='<c:url value="/user/createRelease" />'> Criar Lançamento </a> </li>
					<li class="divider"></li>
					<li><a href="#">Ultimos 5 lançamentos</a></li>
					<li><a href="#">Maior lançamento</a></li>
					<li><a href="#">Menor lançamento</a></li>
					<li><a href="#">Consultar por data</a></li>
				</ul>
			</li>
			<li class="dropdown pull-right"> <a href='<c:url value="/logout" />'>Sair</a> </li>
			<sec:authorize ifAllGranted="ROLE_ADMIN">
			<li class="dropdown pull-right">
			<a href="#" data-toggle="dropdown" class="dropdown-toggle">Admin <b	class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Action</a></li>
					<li><a href="#">Another action</a></li>
					<li class="divider"></li>
					<li><a href="#">Settings</a></li>
				</ul>
			</li>	
			</sec:authorize>
		</ul>	
</div>
</sec:authorize>