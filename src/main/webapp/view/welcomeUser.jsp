 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
 <div class="row">
    <div class="span12">
      <div class="hero-unit center">
          <h1><spring:message code="welcome" /><small><font face="Tahoma">  <c:out value="${success}" />  </font></small></h1>
          <br />
          <p><spring:message code="welcome.one" /></p>
          <p><b><spring:message code="welcome.two" /></b></p>
          <a href="home" class="btn btn-large btn-info">
          		<i class="icon-home icon-white"></i> <spring:message code="welcome.botton" /> 
          </a>
        </div>
        <br /> 
    </div>
  </div>