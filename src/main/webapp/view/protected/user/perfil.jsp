<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2> <font color="gray">Perfil</font></h2>

<img style="width:128px; height:128px;" src='<c:url value="/user/avatar"/>'/> <br />

<sf:form action="/financeiro/user/avatar/create" enctype="multipart/form-data">
	<label for="avatar">Mude seu avatar:</label>
	<input type="file" name="avatar"/>
	
	<input type="submit" value="Envie" class="bnt"/>
</sf:form>
 
 
<p> Seu nome : ${user.name } </p> 
 
 Suas contas :<br/>
 	<c:forEach var="account" items="${accounts }">
	 -${account.name }<br />
	 	-- inicio : <fmt:formatNumber value="${account.amountStart}" currencySymbol="R$" type="currency" /> <br />
	 	-- total : <fmt:formatNumber value="${account.total}" currencySymbol="R$" type="currency" /> <br />
	</c:forEach>
<br />
 <p> Total de todas as contas inicio: <fmt:formatNumber value="${totalStartAmount}" currencySymbol="R$" type="currency" /></p>
 <p>Total de todas as contas no total: R$ 5.100,30</p>
 
 <a href="#">alterar senha</a>
 