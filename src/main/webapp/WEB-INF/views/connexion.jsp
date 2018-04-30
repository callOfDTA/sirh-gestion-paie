<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie - App</title>

<link rel="stylesheet"
	href='<c:url value="/bootstrap-
3.3.7/css/bootstrap.min.css"></c:url>'>

</head>
<body class="container">
	<h1>Connexion</h1>
	<!-- Spring Security s'attend aux paramètres "username" et "password" -->
	<form method="post">
		<input name="username"> <input name="password"> <input
			type="submit" value="Se connecter">
		<sec:csrfInput />
	</form>
	<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->
	<c:if test="${param.error !=null}">
Erreur d'authentification
</c:if>
</body>
</html>