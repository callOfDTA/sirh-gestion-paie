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
				<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/mvc/bulletin/lister/">Bulletin
						<span class="sr-only">(current)</span>
				</a></li>
			</ul>
		</div>
	</nav>

	<h1 align="center">Ajouter un employé</h1>

	<form method="post">
		<div class="form-group ">
			<label class="col-3" for="Matricule : ">Matricule</label> <input
				class="col-3" type="text" id="Matricule"
				aria-describedby="Matricule" name="Matricule"
				placeholder="Entrer Matricule">
		</div>
		<div class="form-group row ml-0">
			<label class="col-3" for="entreprise : ">entreprise</label> <select
				class="form-control col-3" id="selectEntreprise"
				name="entrepriseParam">
				<c:forEach items="${ entreprise }" var="e">
					<option value="${e.id}">${e.siret}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group row ml-0">
			<label class="col-3" for="profil : ">profil</label> <select
				class="form-control col-3" id="selectProfil" name="profilParam">
				<c:forEach items="${ profil }" var="p">
					<option value="${p.id}">${p.code}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group row ml-0">
			<label class="col-3" for="grades : ">grades</label> <select
				class="form-control col-3" id="selectGrade" name="gradeParam">
				<c:forEach items="${ grade }" var="g">
					<option value="${g.id}">${g.code}-
						<fmt:formatNumber pattern="#,##0"
							value="${g.tauxBase*g.nbHeuresBase*12}"></fmt:formatNumber> € /
						an
					</option>
				</c:forEach>
			</select>
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

