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
		<li class="nav-item active"><a class="nav-link" href='<c:url value="/mvc/employes/lister"/>'>Employés</a>
		</li>
		<li class="nav-item active"><a class="nav-link" href='<c:url value="/mvc/bulletins/lister"/>'>Bulletins</a>
		</li>
	</ul>
	</nav>
	<div class="container">
		<h1>Bulletin de Salaire</h1>
		<div class="row">
			<div class="col-sm-2">
				<p>Entreprise</p>
				<p>${bulletin.remunerationEmploye.entreprise.denomination}</p>
				<p>SIRET :${bulletin.remunerationEmploye.entreprise.siret}</p>
			</div>
			<div class="col-sm-2 offset-sm-8">
				<p>Période</p>
				<p>Du ${bulletin.periode.dateDebut} au
					${bulletin.periode.dateFin}</p>
				<p>Matricule : ${bulletin.remunerationEmploye.matricule}</p>
			</div>
		</div>

		<div class="row">
			Salaire
			<table class="table table-striped table-bordered table-hover table-condensed table-responsive-sm">
				<thead>
					<tr>
						<th scope="col">Rubriques</th>
						<th scope="col">Base</th>
						<th scope="col">Taux Salarial</th>
						<th scope="col">Montant Salarial</th>
						<th scope="col">Taux patronal</th>
						<th scope="col">Cot. patronales</th>
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
		<div class="row">
			Cotisation
			<table class="table table-striped table-bordered table-hover table-condensed table-responsive-sm">
				<thead>
					<tr>
						<th scope="col">Rubriques</th>
						<th scope="col">Base</th>
						<th scope="col">Taux Salarial</th>
						<th scope="col">Montant Salarial</th>
						<th scope="col">Taux patronal</th>
						<th scope="col">Cot. patronales</th>

					</tr>
				</thead>

				<tbody>
					<c:forEach items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsNonImposables }" var="c">
						<tr>
							<td>${c.code }${cot.libelle }</td>
							<td>${resultat.salaireBrut}</td>
							<td>${c.tauxSalarial }</td>
							<td><fmt:formatNumber pattern="#,##00.00"
									value="${c.tauxSalarial * resultat.salaireBrut}"></fmt:formatNumber></td>
							<td>${cot.tauxPatronal }</td>
							<td><fmt:formatNumber pattern="#,##00.00"
									value="${c.tauxPatronal * resultat.salaireBrut}"></fmt:formatNumber></td>
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
		<div class="row">
			NET Imposable : ${resultat.netImposable }
			<table class="table table-striped table-bordered table-hover table-condensed table-responsive-sm">
				<thead>
					<tr>
						<th scope="col">Rubriques</th>
						<th scope="col">Base</th>
						<th scope="col">Taux Salarial</th>
						<th scope="col">Montant Salarial</th>
						<th scope="col">Taux patronal</th>
						<th scope="col">Cot. patronales</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsImposables }" var="c">
						<tr>
							<td>${c.code }${cot.libelle }</td>
							<td>${resultat.salaireBrut}</td>
							<td>${c.tauxSalarial }</td>
							<td><fmt:formatNumber pattern="#,##00.00"
									value="${c.tauxSalarial * resultat.salaireBrut}"></fmt:formatNumber></td>
							<td>${cot.tauxPatronal }</td>
							<td><fmt:formatNumber pattern="#,##00.00"
									value="${c.tauxPatronal * resultat.salaireBrut}"></fmt:formatNumber></td>
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
		<div class="row justify-content-end">Net a payer : ${resultat.netAPayer }</div>
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