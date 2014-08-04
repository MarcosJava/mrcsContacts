<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">

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

 <a href="/financeiro/user/update" data-target="#confirmUpdate" >alterar senha</a>

 </div>

 </div>
 </sec:authorize> 