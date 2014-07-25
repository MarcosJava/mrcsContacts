<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">

<h2> <font color="gray">A maior: </font></h2>


<div class="row">
<div class="span4">

<h3><font color="gray">Receitas </font></h3>
<c:forEach var="revenue" items="${revenue }">
<div class="panel panel-primary">
<ul class="list-group">
  
  <li class="list-group-item">
  	<font color="green"><b>Nome :</b>  </font>
  	<font color="blue"><c:out value="${revenue.name } " /> </font>
  </li>
  
  <li class="list-group-item">
  	<font color="green"><b>Descrição :</b>  </font>
  	<font color="blue"><c:out value="${revenue.description }" /></font>
  </li>
  
  <li class="list-group-item"> 
  	<font color="green"><b>Valor :</b>  </font>
  	<font color="blue">	<fmt:formatNumber currencySymbol="R$" 
  										  maxFractionDigits="2" 
  										  type="currency" 
  										  value="${revenue.value }" /></font>  
  </li>
  
  <li class="list-group-item">
  	<font color="green"><b>Data :</b>  </font>
  	<font color="blue"><fmt:formatDate value="${revenue.dateRelease }" pattern="dd/MM/yyyy"/></font>
  </li>
  
  <li class="list-group-item">
  	<font color="green"><b>Feito na conta :</b>  </font>
  	<font color="blue"> <c:out value="${revenue.account.name}" /> </font>
  </li>
</ul>

</div>
</c:forEach>
<hr />
<p style="color:red;">Obs: caso aparecer mais de 1, deu empate =]</p>

</div>










<div class="span4">

<h3><font color="gray">Despesas </font></h3>
<c:forEach var="deposit" items="${deposit }">
<div class="panel panel-primary">
<ul class="list-group">
  
  <li class="list-group-item">
  	<font color="green"><b>Nome :</b>  </font>
  	<font color="blue"><c:out value="${deposit.name } " /> </font>
  </li>
  
  <li class="list-group-item">
  	<font color="green"><b>Descrição :</b>  </font>
  	<font color="blue"><c:out value="${deposit.description }" /></font>
  </li>
  
  <li class="list-group-item"> 
  	<font color="green"><b>Valor :</b>  </font>
  	<font color="red">	<fmt:formatNumber currencySymbol="R$" 
  										  maxFractionDigits="2" 
  										  type="currency" 
  										  value="${deposit.value }" /></font>  
  </li>
  
  <li class="list-group-item">
  	<font color="green"><b>Data :</b>  </font>
  	<font color="blue"><fmt:formatDate value="${deposit.dateRelease }" pattern="dd/MM/yyyy"/></font>
  </li>
  
  <li class="list-group-item">
  	<font color="green"><b>Feito na conta :</b>  </font>
  	<font color="blue"> <c:out value="${deposit.account.name}" /> </font>
  </li>
</ul>

</div>
</c:forEach>
<hr />
<p style="color:red;">Obs: caso aparecer mais de 1, deu empate =]</p>

</div>



</div>
</sec:authorize>