<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href='<c:url value="/home" />'> <spring:message code="project.title" /> </a>
          
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href='<c:url value="/home" />'> <spring:message code="home" /> </a></li>
              <li><a href=<c:url value="/contactMe" />><spring:message code="contacts" /></a></li>
            </ul>
            
            <form  class="navbar-form pull-right" method="post" action="j_spring_security_check">
				<input type='text' name='j_username' placeholder='<spring:message code="user.email" />'/> 
				<input type='password' name='j_password' placeholder='<spring:message code="user.password" />'/>
				<input type="checkbox" name="_spring_security_remember_me"/> 
					<font color="white"><spring:message code="rememberme" /></font>
				<button type="submit" class="btn"><spring:message code="signIn" /></button>
			</form>
			
          </div><!--/.nav-collapse collapse -->
        </div><!-- container -->
      </div><!-- navbar-inner -->
    </div><!-- navbar navbar-inverse navbar-fixed-top -->