<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html">
<title>Lister des bulletins</title>
</head>
<body>

	<a href="/paie/mvc/employes/creer">Employés</a>
	<a href="creer">Bulletins</a>

	<div class="container">
		<h1>Liste des bulletins</h1>
		
		<div><a href="creer">Ajouter un nouveau bulletin</a></div>
		
		<div class="row">
			<div class="col-3">Date/heure création</div>
			<div class="col-3">Période</div>
			<div class="col-1">Matricule</div>
			<div class="col-1">Salaire Brut</div>
			<div class="col-1">Net Imposable</div>
			<div class="col-1">Net A Payer</div>
			<div class="col-1">Actions</div>
		</div>
		<div class="row">
			<c:forEach items="${bulletinList}" var="b">
				<div class="col-3">${b.key.dateCreation}</div>
				<div class="col-3">${b.key.periode.duree}</div>
				<div class="col-1">${b.key.remunerationEmploye.matricule}</div>
				<div class="col-1">${b.value.salaireBrut}</div>
				<div class="col-1">${b.value.netImposable}</div>
				<div class="col-1">${b.value.netAPayer}</div>
				<div class="col-1"><a href="affBulletin">Visualiser</a></div>
			</c:forEach>
		</div>
	</div>

</body>
</html>