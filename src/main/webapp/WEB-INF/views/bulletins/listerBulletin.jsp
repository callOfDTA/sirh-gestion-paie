<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<title>Lister Bulletin</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item active"><a class="nav-link" href='<c:url value="/mvc/employes/lister"/>'>Employés</a>
		</li>
		<li class="nav-item active"><a class="nav-link" href='<c:url value="/mvc/bulletins/lister"/>'>Bulletins</a>
		</li>
	</ul>
	</nav>
	<div class="container">
		<h1>Lister Bulletin</h1>

		<form:form method="post">
			<div class="row justify-content-end">
				<input type="submit" class="btn btn-primary"
					value="Créer un nouveau bulletin">
			</div>
		</form:form>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Date/Heure création</th>
					<th scope="col">Période</th>
					<th scope="col">Matricule</th>
					<th scope="col">Salaire brut</th>
					<th scope="col">Net Imposable</th>
					<th scope="col">Net A Payer</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<c:forEach items="${bulletins}" var="b">
				<tbody>
					<tr>
						<td>${b.key.dateCreationLibelle}</td>
						<td>${b.key.periode.periodeLibelle}</td>
						<td>${b.key.remunerationEmploye.matricule}</td>
						<td>${b.value.salaireBrut}</td>
						<td>${b.value.netImposable}</td>
						<td>${b.value.netAPayer}</td>
						<td>${b.value.netAPayer}</td>
						<td><a href='<c:url value="visualiser?id=${b.key.id}"/>'>Visualiser</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>


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