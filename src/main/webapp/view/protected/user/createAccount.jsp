<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<br />
<br />
<br />

<sec:authorize access="isAuthenticated()">
	
<div class="bs-example">


	<fieldset>
		<legend> Criando Conta</legend>
	${error }

	<form class="form-horizontal" action="createAccount/create" method="post">
		
		<div class="form-group">
			<label for="inputEmail" class="control-label col-xs-2"> Nome
				da conta: </label>
			<div class="col-xs-10">
				<input type="text" class="form-control" id="inputEmail"
					placeholder="Nome da conta" name="name">
			</div>
		</div>		
		<br />


		<div class="form-group">
			<label for="inputDescription" class="control-label col-xs-2">
				Descrição: </label>
			<div class="col-xs-10">
				<input type="text" class="form-control" id="inputDescription"
					placeholder="descrição" name="description">
			</div>
		</div>
		<br />

		
		<div class="input-group">
			<label for="inputAmount" class="control-label col-xs-2">
				Valor: </label>
            <input type="text" class="form-control" placeholder="Valor" id="inputAmount" name="amount">
            <span class="input-group-addon">.00</span>
        </div>
            
        
    
		<br />
		<br />
		<br />

		<div class="form-group">
			<div class="col-xs-offset-2 col-xs-10">
				<button type="submit" class="btn btn-primary">Criar</button>
			</div>
		</div>
	</form>
	</fieldset>
</div>


</sec:authorize>