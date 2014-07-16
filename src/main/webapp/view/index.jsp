<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

     	<!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
        
        <h1><spring:message code='project.name'/></h1>
        <p>
        	<spring:message code='message.financeiro' />
        </p>
        <p>
        	<a href="createUser" class="btn btn-primary btn-large"><spring:message code='register'  /> &raquo;</a>
        </p>
      </div><!-- hero-unit -->

      <!-- Example row of columns -->
      <div class="row">
        <div class="span4">
          <h2><spring:message code='about.financeiro' /></h2>
          <p>
          		<spring:message code="message.about.financeiro" />
          		
          </p>
        </div>
        <div class="span4">
          <h2><spring:message code="integration" /></h2>
          <p>
          		<spring:message code="message.integration" />
         </p>
          		
          <p><a class="btn" href="#"> <spring:message code="view.details"/> &raquo;</a></p>
       </div>
      </div>