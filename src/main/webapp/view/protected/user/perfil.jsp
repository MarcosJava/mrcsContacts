<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<div class="row">
 <div class="span4">
 <h3> <font color="gray">Perfil</font></h3>
<img style="width:128px; height:128px;" src='<c:url value="/user/avatar"/>'/> <br />

<sf:form action="/financeiro/user/avatar/create" enctype="multipart/form-data">
	<strong style="color:#00ABFF;">Mude seu avatar:</strong>
	<input type="file" name="avatar"/>	
	<input type="submit" value="Envie" class="btn btn-primary"/>
</sf:form>
 
 
<p> <strong style="color:#00ABFF;">Seu nome :</strong>${user.name } </p> 
<p> <strong style="color:#00ABFF;">Seu e-mail :</strong>${user.email } </p> 

 <a href="#">alterar senha</a>

 </div>
<div class="span4">
 <h3 style="color:gray">Suas contas :</h3>
 
 	<c:forEach var="account" items="${accounts }">
	<strong style="color:#FF8000;"> -${account.name }</strong><p />
	 	
	 	
	 	
	 	
	 <strong style="color:#40682C;">	
	 	 -- Inicio :   
	 </strong>  
	 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	
	 	
	 	
	 	<c:if test="${account.amountStart > 0}">
	    	<font color="blue">
	    		<fmt:formatNumber value="${account.amountStart}" 
	    						  currencySymbol="R$" 
	    						  type="currency" /> <br />
	    	</font>
	    </c:if>
	    
	 	<c:if test="${account.amountStart < 0}">
	    	<font color="red">
	    		<fmt:formatNumber value="${account.amountStart}" 
	    						  currencySymbol="R$" 
	    						  type="currency" /> <br />
	    	</font>
	    </c:if>
	 	
	 	
	 	
	 		
	 	
	  <strong style="color:#40682C;">	
	  	-- Total de lançamentos: 
	  </strong>
	 		&nbsp;&nbsp;&nbsp; 
	
	 			
	 	<c:if test="${(account.total-account.amountStart) > 0}">
	    	<font color="blue"> 
	    		<fmt:formatNumber value="${account.total-account.amountStart}" 
	 					      currencySymbol="R$" 
	 					      type="currency" /> 
	    	</font>
	    </c:if>
	    
	 	<c:if test="${(account.total-account.amountStart) < 0}">
	    	<font color="red">
	    		<fmt:formatNumber value="${account.total-account.amountStart}" 
	 					      currencySymbol="R$" 
	 					      type="currency" /> 
	    	</font>
	    </c:if>
	 		
	 		
	 		
	 		
	 		
	 <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	   
	 	<font color="green">+___________________</font>
	 	
	 	
	 <br />	 
	 
	 <strong style="color:#40682C;">	
	 	-- Total
	 </strong>
	 
	 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 	&nbsp;&nbsp;&nbsp;&nbsp;
	 
	 
	 <c:if test="${account.total > 0}">
	    	<font color="blue">
	    		<fmt:formatNumber value="${account.total}" 
	    						  currencySymbol="R$" 
	    						  type="currency" />
	    	</font>
	    </c:if>
	    
	 	<c:if test="${account.total < 0}">
	    	<font color="red">
	    		<fmt:formatNumber value="${account.total}" 
	    						  currencySymbol="R$" 
	    						  type="currency" />
	    	</font>
	    </c:if>
<hr />
	</c:forEach>
</div>
<div class="span4">
<h3 style="color:gray;">Observações:</h3>
 <p>
 	<strong style="color:#40682C;">
 		Total de Inicio de Conta: 
 	</strong>
 	
 	 <c:if test="${totalStartAmount > 0}">
 	 	<font color="blue">
	    	<fmt:formatNumber value="${totalStartAmount}" 
 					 		  currencySymbol="R$" 
 					  		  type="currency" />
	    </font>
	 </c:if>
	    
	 <c:if test="${totalStartAmount < 0}">
	    <font color="red">
	    	<fmt:formatNumber value="${totalStartAmount}" 
 					  		  currencySymbol="R$" 
 					          type="currency" />
	   	</font>
	 </c:if>

 </p>

 <p>
 	<strong style="color:#40682C;">
 		Total de todos Lançamentos + todos Inicio de Conta (Valor total de todas as contas):
 	</strong>
 	
 	<c:if test="${totalReleaseAccount > 0}">
 	 	<font color="blue">
	    	<fmt:formatNumber value="${totalReleaseAccount}" 
 					  currencySymbol="R$" 
 					  type="currency" />
	    </font>
	 </c:if>
	    
	 <c:if test="${totalStartAmount < 0}">
	    <font color="red">
	    	<fmt:formatNumber value="${totalReleaseAccount}" 
 					  currencySymbol="R$" 
 					  type="currency" />
	   	</font>
	 </c:if>
 	
 	
 	
 </p>
 
 
 <p>
 	<strong style="color:#40682C;">
 		Valor total de todos os lançamentos:
 	</strong> 
 	
 	<c:if test="${totalReleaseByUser > 0}">
 	 	<font color="blue">
	    	<fmt:formatNumber value="${totalReleaseByUser}" 
 					  currencySymbol="R$" 
 					  type="currency" />
	    </font>
	 </c:if>
	    
	 <c:if test="${totalStartAmount < 0}">
	    <font color="red">
	    	<fmt:formatNumber value="${totalReleaseByUser}" 
 					  currencySymbol="R$" 
 					  type="currency" />
	   	</font>
	 </c:if>
 </p>
 
 </div>
 </div>
 
 
 
 
 