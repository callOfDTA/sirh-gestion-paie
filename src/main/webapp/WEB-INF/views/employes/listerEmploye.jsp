<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<title>Lister employés</title>
</head>
<body>

	<a href="creer">Employés</a>
	<a href="bulletin.jsp">Bulletins</a>

	<div class="container">
		<h1>Liste des employés</h1>
		
		<div><a href="creer">Ajouter un employe</a></div>
		
		<div class="row">
			<div class="col-6">Date/heure création</div>
			<div class="col-3">Matricule</div>
			<div class="col-3">Grade</div>
		</div>
		<div class="row">
			<c:forEach items="${employeList}" var="e">
				<div class="col-6">${e.dateCreation}</div>
				<div class="col-3">${e.matricule}</div>
				<div class="col-3">${e.grade.code}</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>