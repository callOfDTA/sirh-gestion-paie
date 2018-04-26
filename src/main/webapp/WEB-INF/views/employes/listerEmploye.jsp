<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>listerEmploye</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
</head>
<body>
	<a href="bulletin.jsp">Bulletins</a>

	<div class="container">
		<h1>Liste des employés</h1>
		<a href="creer">Ajouter une Employé</a>
		<div class="row">
			<div class="col-6">
				<label>Date/heure création</label>
			</div>
			<div class="col-3">
				<label>Matricule</label>
			</div>
			<div class="col-3">
				<label>Grade</label>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${employeList}" var="e" >
				<div class="col-6">${e.dateCreation}</div>
				<div class="col-3">${e.matricule}</div>
				<div class="col-3">${e.grade.code}</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>