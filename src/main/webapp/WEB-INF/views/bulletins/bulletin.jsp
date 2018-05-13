<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href='<c:url value="/bootstrap/css/bootstrap.css"/>'>
	<title>SIRH - Bulletin salaire</title>
</head>

<body>
	<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
    	<div>
			<li class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath()%>/mvc/employes/lister">Employés</a>
			</li>
		</div>	
		<div>
			<li class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath()%>/mvc/bulletins/lister">Bulletins</a>
			</li>
		</div>
	</ul>

	<div class="container">

		<h1>Bulletin de salaire</h1>

		<div align="right" class="mt-5 mr-2">
			<h5 class="card-title">Période</h5>
			<p class="card-text">Du ${bulletin.periode.dateDebut} au ${bulletin.periode.dateFin}</p>
			
		</div>

		<div class="mt-5" style="width: 60rem;">
			<div class="card-body form-group row">
				<div class="col">
					<h5 class="card-title">Entreprise</h5>
					<div>
						<p class="card-text">${bulletin.remunerationEmploye.entreprise.denomination}</p>
						<p class="card-text">Siret : ${bulletin.remunerationEmploye.entreprise.siret}</p>
					</div>			
					<p align="right" class="card-text mr-4"><strong>Matricule ${bulletin.remunerationEmploye.matricule}</strong></p>
				</div>
						
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
		
		<div align="right" class="mr-2 mb-3">
			<p><strong>NET A PAYER : ${calcul.netAPayer}€</strong></p>
		</div>
		
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.js"></script>
</body>
</html>