<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAIE</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">LOG</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="<%=request.getContextPath()%>/mvc/employes/lister/">Employe
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="<%=request.getContextPath()%>/mvc/bulletin/lister/">Bulletin
						<span class="sr-only">(current)</span>
				</a></li>
			</ul>
		</div>
	</nav>

	<h1 align="center">Ajouter un Bulletin de salaire</h1>

	<form method="post">

		<div class="form-group row ml-0">
			<label class="col-3" for="Période : ">Période</label> <select
				class="form-control col-5" id="selectperiode"
				name="periodeParam">
				<c:forEach items="${ periode }" var="p">
					<option value="${p.id}">${p.dateDebut}/${p.dateFin}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group row ml-0">
			<label class="col-3" for="Matricule : ">Matricule</label> <select
				class="form-control col-5" id="selectmatricule"
				name="matriculeParam">
				<c:forEach items="${ employes }" var="e">
					<option value="${e.id}">${e.matricule}</option>
				</c:forEach>
			</select>
			</div>
			<div class="form-group ">
			<label class="col-3" for="Primeexeptionnel : ">Prime exeptionnel</label> <input
				class="col-5" type="text" id="Primeexeptionnel"
				aria-describedby="Primeexeptionnel" name="Primeexeptionnel"
				placeholder="Entrer Prime exeptionnel (ex: 1000)">
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</div>
	</form>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

