<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<br />
<br />
<br />

<sec:authorize access="isAuthenticated()">

	<div class="bs-example">


		<fieldset>
			<legend> Fazendo um lançamento na conta</legend>
			${error }

			<form class="form-horizontal" action="createRelease/create"
				method="post">

				<div class="form-group">
					<label for="inputAmount" class="control-label col-xs-2">
						Nome da conta: </label>
					<div class="col-xs-10">
						<input type="text" class="form-control" id="inputAmount"
							placeholder="Nome da conta" name="amount">
					</div>
				</div>
				<br />


				<div class="form-group">
					<label for="inputDescription" class="control-label col-xs-2">
						Selecione uma Conta: </label>
					<div class="col-xs-10">
						
						<div class="btn-group form-control">
							<a class="btn dropdown-toggle btn-select" data-toggle="dropdown"
								href="#"> Selecione uma Conta<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#">Item I</a></li>
								<li><a href="#">Item II</a></li>
								<li><a href="#">Item III</a></li>
								<li class="divider"></li>
								<li><a href="#">Other</a></li>
							</ul>
						</div>
					</div>
				</div>
				
				<script type="text/javascript">
				 $(".dropdown-menu li a").click(function(){
					  var selText = $(this).text();
					  $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
					});

					$("#btnSearch").click(function(){
						alert($('.btn-select').text());
					});
				</script>
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
						Valor: </label> <input type="text" class="form-control"
						placeholder="Valor" id="inputAmount" name="amount"> <span
						class="input-group-addon">.00</span>
				</div>



				<br /> <br /> <br />

				<div class="form-group">
					<div class="col-xs-offset-2 col-xs-10">
						<button type="submit" class="btn btn-primary">Criar</button>
					</div>
				</div>
			</form>
		</fieldset>
	</div>


</sec:authorize>