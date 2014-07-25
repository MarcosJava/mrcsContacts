<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">

<div class="row-fluid" >
<font color="red" size="7px"><c:out value="${error }" /></font> 

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading"><font color="pink-dark" size="6">Todas as suas contas</font></div>
<form ng-app="" ng-controller="MyCtrl">
  <!-- Table -->
  <table class="table">
    <tr>
    	<td>Nome</td>
    	<td>Descricao</td>
    	<td>Valor Inicial</td>
    	<td>Data Criada</td>
    	<td>Editar</td>
    	<td>Excluir</td>
    </tr>
    <c:forEach var="items" items="${lstAccount }">
    <tr>
    	<td><c:out value="${items.name}" /></td>
    	<td><c:out value="${items.description}" /></td>
    	<td><fmt:formatNumber currencySymbol="R$" 
    							  maxFractionDigits="2" 
    							  type="currency" 
    							  value="${items.amountStart}" /> </td>
    	<td>
    		<fmt:formatDate value="${items.dateCreate }" pattern="dd/MM/yyyy"/>
    	</td>
    	<td>
    		<a href='<c:url value="/user/accounts/update/${items.id}" />' class="btn btn-primary btn-small"><i class="icon-white icon-pencil"></i> Editar</a>
    	</td>
    	
    	<td>
    	<button class="btn btn-danger btn-small" ng-click="vai(<c:out value="${items.id}" />)" 
    		type="button" data-toggle="modal" data-target="#confirmDelete" data-title="Deletar Conta" 
    		data-message="Você tem certeza que quer deletar essa conta ?">
        		<i class="icon-white icon-trash"></i> Deletar
    </button>
    	</td>
    </tr>
    
    
    	<!-- Modal Dialog -->
<div class="modal fade" id="confirmDelete" role="dialog" aria-labelledby="confirmDeleteLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Deletar Permanentemente</h4>
      </div>
      <div class="modal-body">
        <p>Você tem certeza disso ?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <a href= '<c:url value="/user/account/delete/{{angle}}" />'  type="button" class="btn btn-danger" id="confirm">Deletar</a>
      </div>
    </div>
  </div>
</div>
    
    </c:forEach>
  </table>
  </form>
</div>

<br />
<br />
<br />


<ul class="pager">
  <li><a href="#">Previous</a></li>
  <li><a href="#">Next</a></li>
</ul>
</div>


</sec:authorize>