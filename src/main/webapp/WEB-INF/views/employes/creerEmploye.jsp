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
	href='<c:url value="/bootstrap/css/bootstrap.css"/>'>
<title>SIRH - Ajouter un employé</title>
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

		<h1>Ajouter un Employe</h1>

		<div class="col-sm-12">
			<form:form method="post" modelAttribute="RemunerationEmploye">
				<div class="form-group row">
					<label for="matricule" class="col-sm-4">Matricule</label>
					<div class="col-sm-8">
						<form:input type="text" class="form-control form-control-sm"
							id="matricule" name="matricule" placeholder="Matricule"
							path="matricule" />
					</div>


					<label for="entreprise" class="col-sm-4">Entreprise</label>
					<div class="col-sm-8">
						<form:select path="entreprise.id" class="form-control" id="formGrade">
							<form:options items="${entreprises}" itemValue="id" itemLabel="denomination" />
						</form:select>
					</div>
					<label for="profil" class="col-sm-4">Profil</label>
					<div class="col-sm-8">
						<form:select path="profilRemuneration.id" class="form-control" id="formGrade">
							<form:options items="${profils}" itemValue="id" itemLabel="code" />
						</form:select>
					</div>
					<label for="grade" class="col-sm-4">Grade</label>
					<div class="col-sm-8">
						<form:select path="grade.id" class="form-control" id="formGrade">
							<form:options items="${grades}" itemValue="id" itemLabel="code" />
						</form:select>
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