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

	<h1 align="center">Bulletin de salaire</h1>

	<h2>
		<b>Entreprise</b>
	</h2>
	<div class="form-group row ml-0">
		<label class="col-10">${ bulletin.remunerationEmploye.entreprise.denomination}</label>
		<label class="col2">Matricule : ${ bulletin.remunerationEmploye.matricule }</label>
		<div class="form-group col-8 ml-0">
			<label>Siret : ${ bulletin.remunerationEmploye.entreprise.siret}</label>
		</div>
	</div>

	<div class="table-responsive mt-5">
		<h5>
			<strong>Salaire</strong>
		</h5>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Rubrique</th>
					<th scope="col">Base</th>
					<th scope="col">Taux Salarial</th>
					<th scope="col">Montant Salarial</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Salaire de Base</td>
					<td>${bulletin.remunerationEmploye.grade.nbHeuresBase}hr</td>

					<td>${bulletin.remunerationEmploye.grade.tauxBase}%</td>
					<td>${calcul.salaireDeBase}€</td>
				</tr>
				<tr>
					<td>Prime Exept</td>
					<td></td>
					<td></td>
					<td>${bulletin.primeExceptionnelle}€</td>
				</tr>
				<tr>
					<td>Salaire Brut</td>
					<td></td>
					<td></td>
					<td>${calcul.salaireBrut}€</td>
				</tr>
			</tbody>
		</table>
	</div>


	<div class="table-responsive mt-5">
		<h5>
			<strong>Cotisations</strong>
		</h5>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Rubrique</th>
					<th scope="col">Base</th>
					<th scope="col">Taux Salarial</th>
					<th scope="col">Montant Salarial</th>
					<th scope="col">Taux patronal</th>
					<th scope="col">Cot. patronales</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ bulletin.remunerationEmploye.profilRemuneration.cotisationsNonImposables }" var="cot">
					<tr>
						<td>${cot.code} ${cot.libelle}</td>
						<td>${calcul.salaireBrut}€</td>
						<td>${cot.tauxSalarial}</td>
						<td>${calcul.salaireBrut * cot.tauxSalarial} €</td>
						<td>${cot.tauxPatronal}</td>
						<td>${calcul.salaireBrut * cot.tauxPatronal} €</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<div class="table-responsive mt-5">
		<h5>
			<strong>NET Imposable : ${calcul.netImposable}€</strong>
		</h5>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Rubrique</th>
					<th scope="col">Base</th>
					<th scope="col">Taux Salarial</th>
					<th scope="col">Montant Salarial</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ bulletin.remunerationEmploye.profilRemuneration.cotisationsImposables }" var="cot">
					<tr>
						<td>${cot.code} ${cot.libelle}</td>
						<td>${calcul.salaireBrut}€</td>
						<td>${cot.tauxSalarial}</td>
						<td>${calcul.salaireBrut * cot.tauxSalarial} €</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<strong>NET A PAYER : ${calcul.netAPayer}€</strong>
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

