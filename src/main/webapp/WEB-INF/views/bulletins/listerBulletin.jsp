<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href='<c:url value="/bootstrap/css/bootstrap.css"/>'>
<title>SIRH - Liste des bulletins de salaires</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
		class="navbar-brand" href="#">LOGO</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href='<c:url value="/mvc/employes/lister"/>'>Employés </a></li>
			<li class="nav-item"><a class="nav-link" href='<c:url value="/mvc/bulletins/lister"/>'>Bulletins</a>
			</li>
		</ul>
	</div>
	</nav>





	<div class="container">

		<h1>Ajouter un Employe</h1>



		<div class="row justify-content-end">
			<form:form method="post">
				<input type="submit" class="btn btn-primary"
					value="Créer un nouveau  bulletin" />
			</form:form>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Date/Heure création</th>
					<th scope="col">Période</th>
					<th scope="col">Matricule</th>
					<th scope="col">Salaire brut</th>
					<th scope="col">Net imposable</th>
					<th scope="col">Net à payer</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bulletins }" var="map">
					<tr>
						<td>${map.key.dateCreationLibelle}</td>
						<td>${map.key.periode.periodeLibelle}</td>
						<td>${map.key.remunerationEmploye.matricule}</td>
						<td>${map.value.salaireBrut}</td>
						<td>${map.value.netImposable}</td>
						<td>${map.value.netAPayer}</td>
						<td>
						<a href='<c:url value="visualiser?id=${map.key.id }"/>' >Visualiser</a>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>




	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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