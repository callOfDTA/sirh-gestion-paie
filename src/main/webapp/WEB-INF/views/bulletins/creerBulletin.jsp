<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<title>Creer Bulletin</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item active"><a class="nav-link" href="#">Employés</a>
		</li>
		<li class="nav-item active"><a class="nav-link" href="#">Bulletins</a>
		</li>
	</ul>
	</nav>
	<div class="container">
		<h1>Créer Bulletin</h1>

		<div class="col-sm-12">
			<form:form method="post" modelAttribute="BulletinSalaire">
				<div class="form-group row">

					<label for="inputPeriode" class=" col-sm-4">Periode</label>
					<div class="col-sm-8">
						<form:select path="periode.id" class="form-control"
							id="formEntreprise">
							<form:options items="${periodes}" itemValue="id"
								itemLabel="periodeLibelle" />
						</form:select>
					</div>

					<label for="inputEmploye" class="col-sm-4">Matricule</label>
					<div class="col-sm-8">
						<form:select path="remunerationEmploye.id" class="form-control"
							id="formProfil">
							<form:options items="${employes}" itemValue="id"
								itemLabel="matricule" />
						</form:select>
					</div>
					<label for="inputPrime" class="col-sm-4">Prime
						exceptionnelle</label>
					<div class="col-sm-8">
						<form:input type="text" class="form-control" id="inputPrime"
							placeholder="prime exceptionnelle" path="primeExceptionnelle" />
					</div>
				</div>

				<div class="row justify-content-end">
					<input type="submit" class="btn btn-primary">
				</div>
			</form:form>
		</div>

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