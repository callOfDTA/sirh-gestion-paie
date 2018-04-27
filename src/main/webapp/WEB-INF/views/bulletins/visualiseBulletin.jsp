<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html">
<title>Bulletin de salaire</title>
</head>
<body>

	<a href="/paie/mvc/employes/lister">Employés</a>
	<a href="lister">Bulletins</a>

	<div class="container">
		<h1>Liste des bulletins</h1>

		<div class="row">
			<div class="col-3">Période :</div>
			<div class="col-3">${bulletin.periode.duree}</div>
		</div>
		<div class="row">
			<div class="col-3">Entreprise :</div>
			<div class="col-3">${bulletin.remunerationEmploye.entreprise.denomination}</div>
			<div class="col-3">SIRET :
				${bulletin.remunerationEmploye.entreprise.siret}</div>
		</div>
		<div class="row">
			<div class="col-3">Matricule :
				${bulletin.remunerationEmploye.matricule}</div>
		</div>

		<div class="row">
			<h3>Salaire :</h3>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Rubriques</th>
					<th scope="col">Base</th>
					<th scope="col">Taux Salarial</th>
					<th scope="col">Montant Salarial</th>
					<th scope="col">Taux patronal</th>
					<th scope="col">Cot.patronales</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td scope="col">Salaire de base</td>
					<td scope="col">${bulletin.remunerationEmploye.grade.nbHeuresBase}</td>
					<td scope="col">${bulletin.remunerationEmploye.grade.tauxBase}</td>
					<td scope="col">${calc.salaireDeBase}</td>
					<td scope="col">${calc.totalCotisationsPatronales}</td>
					<td scope="col">${calc.totalRetenueSalarial * calc.salaireBrut}</td>
				</tr>
				<tr>
					<td scope="col">Prime Except.</td>
					<td scope="col"></td>
					<td scope="col"></td>
					<td scope="col">${bulletin.primeExceptionnelle}</td>
					<td scope="col"></td>
					<td scope="col"></td>
				</tr>
				<tr>
					<td scope="col">Salaire Brut</td>
					<td scope="col"></td>
					<td scope="col"></td>
					<td scope="col">${calc.salaireBrut}</td>
					<td scope="col"></td>
					<td scope="col"></td>
				</tr>
			</tbody>
		</table>


		<div class="row">
			<h3>Cotisations :</h3>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Rubriques</th>
					<th scope="col">Base</th>
					<th scope="col">Taux Salarial</th>
					<th scope="col">Montant Salarial</th>
					<th scope="col">Taux patronal</th>
					<th scope="col">Cot.patronales</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsNonImposables}" var="b">
				<tr>
					<td scope="col">${b.code} ${b.libelle}</td>
					<td scope="col">${calc.salaireBrut}</td>
					<td scope="col">${b.tauxSalarial}</td>
					<td scope="col">${calc.salaireBrut * b.tauxSalarial}</td>
					<td scope="col">${b.tauxPatronal}</td>
					<td scope="col">${calc.salaireBrut * b.tauxPatronal}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<div class="row">
			<h3>NET Imposable : ${calc.netImposable}</h3>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Rubriques</th>
					<th scope="col">Base</th>
					<th scope="col">Taux Salarial</th>
					<th scope="col">Montant Salarial</th>
					<th scope="col">Taux patronal</th>
					<th scope="col">Cot.patronales</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsImposables}" var="b">
				<tr>
					<td scope="col">${b.code} ${b.libelle}</td>
					<td scope="col">${calc.salaireBrut}</td>
					<td scope="col">${b.tauxSalarial}</td>
					<td scope="col">${calc.salaireBrut * b.tauxSalarial}</td>
					<td scope="col">${b.tauxPatronal}</td>
					<td scope="col">${calc.salaireBrut * b.tauxPatronal}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<div class="row">
			<div class="col-6">Net A Payer : ${calc.netAPayer} </div>
		</div>

	</div>

</body>
</html>