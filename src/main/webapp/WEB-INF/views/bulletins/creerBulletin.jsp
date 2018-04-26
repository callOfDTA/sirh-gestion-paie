<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href='<c:url value="/bootstrap/css/bootstrap.css"/>'>
<title>SIRH - Ajouter un bulletin</title>
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
			<li class="nav-item"><a class="nav-link" href="#">Employés </a></li>
			<li class="nav-item"><a class="nav-link" href="#">Bulletins</a>
			</li>
		</ul>
	</div>
	</nav>


	<div class="container">

		<h1>Créer Bulletin de Salaire</h1>

		<div class="col-sm-12">
			<form:form method="post" modelAttribute="bulletin">
				<div class="form-group row">


					<label for="entreprise" class="col-sm-4">Période</label>
					<div class="col-sm-8">
						<form:select path="periode.id" class="form-control" id="formGrade">
							<form:options items="${periodes}" itemValue="id" itemLabel="periodeLibelle" />
						</form:select>
					</div>
					<label for="profil" class="col-sm-4">Matricule</label>
					<div class="col-sm-8">
						<form:select path="remunerationEmploye.id" class="form-control"
							id="formGrade">
							<form:options items="${employes}" itemValue="id" itemLabel="matricule" />
						</form:select>
					</div>

					<label for="primeExceptionnelle" class="col-sm-4">Prime
						exceptionnelle</label>
					<div class="col-sm-8">
						<form:input type="text" class="form-control form-control-sm"
							id="primeExceptionnelle" name="primeExceptionnelle"
							placeholder="Prime exceptionnelle" path="primeExceptionnelle" />
					</div>
				</div>
				<div class="form-group row justify-content-end">
					<button type="submit" class="btn btn-primary col-sm-2">Ajouter</button>
				</div>
			</form:form>
		</div>
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