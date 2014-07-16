<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR" id="ng-app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/resources/css/bootstrap.min.css'  />"
	rel="stylesheet" />
<link
	href="<c:url value='/resources/css/bootstrap-responsive.min.css'  />"
	rel="stylesheet" />
<script src="<c:url value='/resources/js/jquery.js' />"></script>
<script src="<c:url value='/resources/js/angular.js' />"></script>
<script src="<c:url value='/resources/js/myAngularDeleteAccount.js' />"></script>
<script src="<c:url value='/resources/js/myScript.js' />"></script>




<title><tiles:getAsString name="titles" /></title>
</head>
<body ng-app="" ng-controller="MyCtrl" >
	<div class="container">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="bodymain" />
		<tiles:insertAttribute name="footer" />
	</div>

	<div class="modal hide" id="pleaseWaitDialog" data-backdrop="static"
		data-keyboard="false">
		<div class="modal-header">
			<h1>Processing...</h1>
		</div>
		<div class="modal-body">
			<div class="progress progress-striped active">
				<div class="bar" style="width: 100%;"></div>
			</div>
		</div>
	</div>





	<!--[if IE]>
            <script src="<c:url value='/resources/js/bootstrap.min.ie.js' />"></script>
        <![endif]-->
	<!--[if !IE]><!-->
	<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
	<!--<![endif]-->


</body>
</html>