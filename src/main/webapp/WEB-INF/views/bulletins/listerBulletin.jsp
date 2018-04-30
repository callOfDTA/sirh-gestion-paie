<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>listerBulletin</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
</head>
<body>
	<a href="creerBulletin.jsp">Bulletins</a>

	<div class="container">
		<h1>Liste des bulletins</h1>
		<a href="creer">Ajouter un bulletin</a>
		<div class="row">
			<div class="col-3">
				<label>Date/Heure Création</label>
			</div>
			<div class="col-3">
				<label>Période</label>
			</div>
			<div class="col-1">
				<label>Matricule</label>
			</div>
			<div class="col-1">
				<label>Salaire Brut</label>
			</div>
			<div class="col-1">
				<label>Net Imposable</label>
			</div>
			<div class="col-1">
				<label>Net A Payer</label>
			</div>
			<div class="col-1">
				<label>Actions</label>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${bulletinList}" var="b">
				<div class="col-3">${b.key.dateCreation}</div>
				<div class="col-3">${b.key.periode.duree}</div>
				<div class="col-1">${b.key.remunerationEmploye.matricule}</div>
				<div class="col-1">${b.value.salaireBrut}</div>
				<div class="col-1">${b.value.netImposable}</div>
				<div class="col-1">${b.value.netAPayer}</div>
				<div class="col-1">
					<a href="visualiser?id=${b.key.id}">Visualiser</a>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>