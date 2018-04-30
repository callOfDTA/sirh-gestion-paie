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
	href='<c:url value="/bootstrap/css/bootstrap.css"/>'>
<title>SIRH - Bulletins de salaire</title>
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
		<h1>Bulletin de salaire</h1>
		<div class="row">
			<div class="col-sm-2">
				<p class="font-weight-bold">Entreprise</p>
				<p>${bulletin.remunerationEmploye.entreprise.denomination }</p>
				<p class="font-weight-bold">SIRET :</p>
				<p>${bulletin.remunerationEmploye.entreprise.siret}</p>
			</div>
			<div class="col-sm-2 offset-sm-8">
				<p class="font-weight-bold">Période</p>
				<p>Du ${bulletin.periode.periodeDebut} au
					${bulletin.periode.periodeFin}</p>
				<p class="font-weight-bold">Matricule :</p>
				<p>${bulletin.remunerationEmploye.matricule}</p>
			</div>
		</div>
		<div>



			<h6>Salaire</h6>
			<table class="table table-striped table-bordered table-hover table-condensed table-responsive-sm">
				<thead>
					<tr>
						<th scope="col">Rubrique</th>
						<th scope="col">Base</th>
						<th scope="col">Taux salarial</th>
						<th scope="col">Montant Salarial</th>
						<th scope="col">Taux patronal</th>
						<th scope="col">Cot. patronal</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Salaire de base</td>
						<td>${bulletin.remunerationEmploye.grade.nbHeuresBase }</td>
						<td>${bulletin.remunerationEmploye.grade.tauxBase }</td>
						<td>${resultat.salaireDeBase}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Prime Exept.</td>
						<td></td>
						<td></td>
						<td>${bulletin.primeExceptionnelle}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Salaire Brut</td>
						<td></td>
						<td></td>
						<td>${resultat.salaireBrut}</td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div>
			<h6>Cotisations</h6>
			<table class="table table-striped table-bordered table-hover table-condensed table-responsive-sm">
				<thead>
					<tr>
						<th scope="col">Rubrique</th>
						<th scope="col">Base</th>
						<th scope="col">Taux salarial</th>
						<th scope="col">Montant Salarial</th>
						<th scope="col">Taux patronal</th>
						<th scope="col">Cot. patronal</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach
						items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsNonImposables }"
						var="cot">
						<tr>
							<td>${cot.code }${cot.libelle }</td>
							<td>${resultat.salaireBrut}</td>
							<td>${cot.tauxSalarial }</td>
							<td><fmt:formatNumber pattern="#,##0.00"
									value="${cot.tauxSalarial * resultat.salaireBrut}"></fmt:formatNumber></td>
							<td>${cot.tauxPatronal }</td>
							<td><fmt:formatNumber pattern="#,##0.00"
									value="${cot.tauxPatronal * resultat.salaireBrut}"></fmt:formatNumber></td>
						</tr>
					</c:forEach>
					<tr>
						<td class="font-weight-bold">Total Retenue</td>
						<td></td>
						<td></td>
						<td class="font-weight-bold">${resultat.totalRetenueSalarial}</td>
						<td></td>
						<td class="font-weight-bold">${resultat.totalCotisationsPatronales}</td>
					</tr>
				</tbody>
			</table>



		</div>
		<div>
			<h6>NET Imposable : ${resultat.netImposable}</h6>
			<table class="table table-striped table-bordered table-hover table-condensed table-responsive-sm">
				<thead>
					<tr>
						<th scope="col">Rubrique</th>
						<th scope="col">Base</th>
						<th scope="col">Taux salarial</th>
						<th scope="col">Montant Salarial</th>
						<th scope="col">Taux patronal</th>
						<th scope="col">Cot. patronal</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach
						items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsImposables }"
						var="cot">
						<tr>
							<td>${cot.code }${cot.libelle }</td>
							<td>${resultat.salaireBrut}</td>
							<td>${cot.tauxSalarial }</td>
							<td><fmt:formatNumber pattern="#,##00.00"
									value="${cot.tauxSalarial * resultat.salaireBrut}"></fmt:formatNumber></td>
							<td>${cot.tauxPatronal }</td>
							<td><fmt:formatNumber pattern="#,##00.00"
									value="${cot.tauxPatronal * resultat.salaireBrut}"></fmt:formatNumber></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<div class="form-group row justify-content-end">
				<h6 class="font-weight-bold">NET A PAYER :
					${resultat.netAPayer}</h6>
			</div>
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