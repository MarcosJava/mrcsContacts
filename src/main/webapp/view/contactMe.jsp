<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br />
<br />
<br />
<br />
<br />

	
		<div class="control-group error">
			<div class="control-label" style="font-size:22px;">
				<c:out value="${errorzim }" />
			</div>
		</div>
		
		<sf:form class="well span8" action="/financeiro/contactMe/sending" modelAttribute="contactMeVO">
			<div class="row">
				<div class="span3">
					<fieldset>
					<!-- Titles -->
					<legend><spring:message code="contact.title" /></legend>
					
					<!-- FirstName -->
					<div class="control-group error">
						<label><spring:message code="contact.firstName" /> 
							<sf:errors path="firstName" cssClass="control-label" />
						</label> 
					</div>
					<input type="text" class="span3" name="firstName">
					
					<!-- LastName -->
					 <div class="control-group error">
						<label><spring:message code="contact.lastName" />
							<sf:errors path="lastName" cssClass="control-label" />
						</label> 
					</div>
					<input type="text" class="span3" name="lastName">
					
					<!-- Email --> 
					 <div class="control-group error">
						<label><spring:message code="contact.email" />
							<sf:errors path="email" cssClass="control-label" />
						</label> 
					 </div>
					 <input type="text" class="span3" name="email">
					 
					<!-- Subject -->
					<div class="control-group error">
					
					 	<p class="control-label" ><c:out value="${error.subject}" /></p>
					</div>
						<label>
						<spring:message code="contact.subject" />
							<select id="subject" name="subject" class="span3">
									<option value="none"><spring:message code="choose.one" /></option>
									<option value="service"><spring:message code="contact.subject.customerService" /></option>
									<option value="suggestions"><spring:message code="contact.subject.suggestions" /></option>
									<option value="product"><spring:message code="contact.subject.productSupport" /></option>
							</select>
						</label>
					
				</div><!-- span3 -->
				
				<div class="span5">
					<div class="control-group error">
						<label><spring:message code="contact.message" />
							<sf:errors path="message" cssClass="control-label" />
						</label>
					</div>
					
					<textarea name="message" id="message" class="input-xlarge span5"
						rows="10"></textarea>
				</div><!-- span5 -->

				<button type="submit" class="btn btn-primary pull-right" onclick="myApp.showPleaseWait();">
					<spring:message code="send" />
				</button>
				</fieldset>
			</div><!-- span5 -->
		</sf:form>
	</div>
	