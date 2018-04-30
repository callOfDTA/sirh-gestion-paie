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
				<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/mvc/bulletin/bulletin/">Bulletin
						<span class="sr-only">(current)</span>
				</a></li>
			</ul>
		</div>
	</nav>

	<h1 align="center">Lister les bulletins de salaire</h1>

	<div align="right" class="mb-2">
		<a href="<%=request.getContextPath()%>/mvc/bulletin/creer/"
			class="btn btn-primary">Ajouter un nouveau bulletin</a>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Date/heure création</th>
				<th scope="col">Période</th>
				<th scope="col">Matricule</th>
				<th scope="col">Salaire brut</th>
				<th scope="col">Net imposable</th>
				<th scope="col">Net A Payer</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ result }" var="r">
			<tr>
				<th scope="row">${r.key.id}</th>
				<td>${r.key.datecreation}</td>
				<td>${r.key.periode.dateDebut}/${r.key.periode.dateFin}</td>
				<td>${r.key.remunerationEmploye.matricule}</td>
				<td>${r.value.salaireBrut}€</td>
				<td>${r.value.netImposable}€</td>
				<td>${r.value.netAPayer}€</td>
				<td><a class="nav-link" href="<%=request.getContextPath()%>/mvc/bulletin/bulletin?ID=${r.key.id}">Visualiser
						<span class="sr-only">(current)</span>
				</a></td>
			</tr>		
			</c:forEach>
		</tbody>
	</table>
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

