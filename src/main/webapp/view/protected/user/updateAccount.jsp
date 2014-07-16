<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<sf:form modelAttribute="account" method="post" >

	<sf:input path="description" class="four"/>
	<sf:input path="name" class="four"/>
	
</sf:form>

<sec:authorize access="isAuthenticated()">
	
<div class="bs-example">


	<fieldset>
		<legend> Criando Conta</legend>
	${error }

	<sf:form class="form-horizontal" action="createAccount/create" >
		
		<div class="form-group">
			<label for="inputName" class="control-label col-xs-2"> 
			Nome da conta: </label>
			<div class="col-xs-10">
				<sf:input path="name" class="form-control" id="inputName" />
			</div>
		</div>		
		<br />


		<div class="form-group">
			<label for="inputDescription" class="control-label col-xs-2">
				Descrição: </label>
			<div class="col-xs-10">
				<sf:input path="description" class="form-control" id="inputDescription" />
			</div>
		</div>
		<br />

		
		<div class="input-group">
			<label for="inputAmount" class="control-label col-xs-2">
				Valor: </label>
            <sf:input path="description" class="form-control" id="inputAmount" />
            <span class="input-group-addon">.00</span>
        </div>
            
        
    
		<br />
		<br />
		<br />
			<sf:hidden path="id" />
		<div class="form-group">
			<div class="col-xs-offset-2 col-xs-10">
				<button type="submit" class="btn btn-primary">Editar</button>
			</div>
		</div>
	</sf:form>
	</fieldset>
</div>


</sec:authorize>