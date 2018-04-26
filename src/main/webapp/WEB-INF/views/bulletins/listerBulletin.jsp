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
	<title>SIRH - Liste des bulletins</title>
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

		<h1>Bulletins</h1>
		
		<div align="right" class="mr-2 mb-3">
			<a href="<%=request.getContextPath()%>/mvc/bulletins/creer" class="btn btn-primary" role="button">Créer un nouveau bulletin</a>
		</div>
		
		<div class="table-responsive mt-5">
  			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Date/Heure de création</th>
						<th scope="col">Période</th>
						<th scope="col">Matricule</th>
						<th scope="col">Salaire brut</th>
						<th scope="col">Net Imposable</th>
						<th scope="col">Net A Payer</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bulletins}" var="b">
					<tr>
						<th scope="row">${b.id}</th>
						<td>${b.heureCreation}</td>
						<td>${b.periode.dateDebut} - ${b.periode.dateFin}</td>
						<td>${b.remunerationEmploye.matricule}</td>
						<td>
							<fmt:formatNumber  pattern="#,##0" value="${b.remunerationEmploye.grade.nbHeuresBase * b.remunerationEmploye.grade.tauxBase + b.primeExceptionnelle}"></fmt:formatNumber>
						</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>				
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.js"></script>
</body>
</html>