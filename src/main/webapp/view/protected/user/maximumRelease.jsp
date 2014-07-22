<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2> <font color="gray">O maior lançamento : </font></h2>

<c:forEach var="release" items="${releases }">
<div class="panel panel-primary">
<ul class="list-group">
  
  <li class="list-group-item">
  	<font color="green"><b>Nome :</b>  </font>
  	<font color="blue"><c:out value="${release.name } " /> </font>
  </li>
  
  <li class="list-group-item">
  	<font color="green"><b>Descrição :</b>  </font>
  	<font color="blue"><c:out value="${release.description }" /></font>
  </li>
  
  <li class="list-group-item"> 
  	<font color="green"><b>Valor :</b>  </font>
  	<font color="blue">	<fmt:formatNumber currencySymbol="R$" 
  										  maxFractionDigits="2" 
  										  type="currency" 
  										  value="${release.value }" /></font>  
  </li>
  
  <li class="list-group-item">
  	<font color="green"><b>Data :</b>  </font>
  	<font color="blue"><fmt:formatDate value="${release.dateRelease }" pattern="dd/MM/yyyy"/></font>
  </li>
  
  <li class="list-group-item">
  	<font color="green"><b>Feito na conta :</b>  </font>
  	<font color="blue"> <c:out value="${release.account.name}" /> </font>
  </li>
</ul>

</div>
</c:forEach>
<p style="color:red;">Obs: caso aparecer mais de 1, deu empate =]</p>