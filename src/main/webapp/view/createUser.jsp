<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<br />
<br />
<br />
<br />
	
	<div class="control-group info">
	<div class="control-label" style="font-size:22px;"><c:out value="${success}" /></div>
	</div>
	
		<fieldset>
			<legend> <spring:message code="create.user"/>	</legend>
			
				<sf:form modelAttribute="user" action="registreUser">
				
					<div class="control-group error">
						<div class="control-label " style="font-size:22px;">
							<c:out value="${errors}" />
						</div> 
					</div>
					
					<div class="control-group error">
						<label for="name">
								<spring:message code="user.name" /><sf:errors path="name" cssClass="control-label"/>
						</label>
					</div>
					<input type="text" name="name" />
					
					
					<div class="control-group error">
						<label for="email">
								<spring:message code="user.email" /><sf:errors path="email" cssClass="control-label" />
						</label>
					</div>
					<input type="text" name="email" />
					
					
					<div class="control-group error">
						<label for="password">
							<spring:message code="user.password" /><sf:errors path="password" cssClass="control-label" />
						</label>
					</div>
					<input type="password" name="password" />
					
					<label for="confirmPass">
						<spring:message code="user.confirmPassword" />
					</label>
					<input type="password" name="confirmPass"/>
					
					<br />
					<input type="submit" value='<spring:message code="join" />' class="btn btn-primary btn-large"/>
			
				</sf:form>
		</fieldset>
