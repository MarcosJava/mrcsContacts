<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR" id="ng-app">
<head>

<link href="<c:url value='/resources/css/bootstrap.min.css'  />" rel="stylesheet"/>
        <link href="<c:url value='/resources/css/bootstrap-responsive.min.css'  />" rel="stylesheet"/>
        <link href="<c:url value='/resources/css/project_style.css'  />" rel="stylesheet"/>
        <script src="<c:url value='/resources/js/jquery-1.9.1.min.js' />"></script>
        <script src="<c:url value='/resources/js/angular.min.js' />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR 404</title>
</head>
<body>
	<div class="container">
  <div class="row">
    <div class="span12">
      <div class="hero-unit center">
          <h1>Essa pagina não existe - <small><font face="Tahoma" color="red"> Error 404</font></small></h1>
          <br />
          <p>A página solicitada não pode ser encontrado, entre em contato com o webmaster/suporte ou tente novamente. Use o botão <b>Voltar</b> de seu navegadore</p>
          <p><b>Ou você pode simplesmente pressionar este botão abaixo:</b></p>
          <a href=' <c:url value="/home" />'
           class="btn btn-large btn-info"><i class="icon-home icon-white"></i> Preciona-me </a>
        </div>
        <br /> 
    </div>
  </div>
</div>
	<script type="text/javascript">
		</script>
		
		 <!--[if IE]>
            <script src="<c:url value='/resources/js/bootstrap.min.ie.js' />"></script>
        <![endif]-->
        <!--[if !IE]><!-->
            <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
        <!--<![endif]-->
</body>
</html>