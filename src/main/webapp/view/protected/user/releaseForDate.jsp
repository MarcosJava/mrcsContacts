<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br />
<br />
<br />


<sec:authorize access="isAuthenticated()">

	<div class="bs-example">
		<fieldset>
			<legend> Consultando por Data</legend>
			<form class="form-horizontal" action='<c:url value="/user/releases/dateForDate/retrieve"/>'
				method="post">

				<div class="input-group">
					<label for="calendario" class="control-label col-xs-2">
						Primeira Data:* &nbsp;&nbsp;</label> 
						<input type="text" id="calendario"	name="dateFirst" />
				</div>
				<br />
				<div class="input-group">
					<label for="calendario2" class="control-label col-xs-2">
						Segunda Data:* &nbsp;&nbsp;</label> 
						<input type="text" id="calendario2"	name="dateSecond" />
				</div>

				<br /> <br /> <br />

				<div class="form-group">
					<div class="col-xs-offset-2 col-xs-10">
						<button type="submit" class="btn btn-primary">Consultar</button>
					</div>
				</div>
			</form>
		</fieldset>
	</div>
	
	
	<br />

<div class="row-fluid" >
<div class="panel panel-default">
  <!-- Default panel contents -->
  	
  	<p><font color="blue-light" size="5"> <c:out value="${success}" /> </font></p>
  	
  	<br />
  	<div class="panel-heading">
  		<font color="pink-dark" size="6">Ultimos 5 Lançamentos</font>
  	</div>
  	
  	
<form >


  <!-- Table -->
  <table class="table">
    <tr>
    	<th><font color="green">Conta</font></th>
    	<th><font color="green">Nome do Lançamento</font></th>
    	<th><font color="green">Descricao</font></th>
    	<th><font color="green">Valor Inicial</font></th>
    	<th><font color="green">Data Criada</font></th>
    	<th><font color="green">Excluir</font></th>
    </tr>
    <c:forEach var="items" items="${releases}">
    <tr>
    	
    	<td><font color="blue"><c:out value="${items.account.name}" /></font></td>
    	
    	<td><font color="blue"><c:out value="${items.name}" /></font></td>
    
    	<td><font color="blue"><c:out value="${items.description}" /></font></td>
    	
    	<c:if test="${items.value >= 0}">
    		<td> <font color="blue">
    			<fmt:formatNumber currencySymbol="R$" 
    							  maxFractionDigits="2" 
    							  type="currency" 
    							  value="${items.value }" /> 
    		</font> </td>
    	</c:if>
    	
    	<c:if test="${items.value < 0}">
    		<td> <font color="red">
    			<fmt:formatNumber currencySymbol="R$" 
    							  maxFractionDigits="2" 
    							  type="currency" 
    							  value="${items.value }" />
    		</font> </td>
    	</c:if>
    	
    	<td><font color="blue">
    		<fmt:formatDate value="${items.dateRelease }" pattern="dd/MM/yyyy"/>
    		
    		</font>
    	</td>
    	
    	<td>
    	<button class="btn btn-danger btn-small" ng-click="vai(<c:out value="${items.id}" />)" 
    		type="button" data-toggle="modal" data-target="#confirmDelete" data-title="Deletar Lançamento" 
    		data-message="Você tem certeza que quer deletar esse Lançamento ?">
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
        <a href= '<c:url value="/user/release/delete/{{angle}}" />'  type="button" class="btn btn-danger" id="confirm">Deletar</a>
      </div>
    </div>
  </div>
</div>
    
    
     </c:forEach>
     <tr> <td> </td> </tr>
     <tr> <td> </td> </tr>
    <tr>
    	<td align="center">TOTAL DOS ULTIMOS 5 LANÇAMENTO 
    	
	    	<c:if test="${total > 0}">
	    		<font color="blue">R$ <c:out value="${total}" /></font>
	    	</c:if>
	    	
	    	<c:if test="${total < 0}">
	    		<font color="red">R$ <c:out value="${total}" /></font> 
	    	</c:if>
    	</td>   	
    </tr>
   
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