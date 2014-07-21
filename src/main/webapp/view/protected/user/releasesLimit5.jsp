<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br />
<br />
<br />

<div class="row-fluid" >
<div class="panel panel-default">
  <!-- Default panel contents -->
  	
  	<div class="panel-heading">
  		<font color="red" size="6">Ultimos 5 Lançamentos</font>
  	</div>
  	
  	
<form >


  <!-- Table -->
  <table class="table">
    <tr>
    	<td><font color="green">Descricao</font></td>
    	<td><font color="green">Valor Inicial</font></td>
    	<td><font color="green">Data Criada</font></td>
    </tr>
    <c:forEach var="items" items="${lstRelease}">
    <tr>
    	<td><font color="blue">${items.description} </font></td>
    	<td> <font color="blue">R$ ${items.value}</font> </td>
    	<td><font color="blue">
    		<fmt:formatDate value="${items.dateRelease }" pattern="dd/MM/yyyy"/>
    		</font>
    	</td>
    </tr>
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













<script src="<c:url value="/resources/js/pages/contacts.js" />"></script>