<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<title>Création bulletin de salaire</title>
</head>
<body>

	<a href="/paie/mvc/employes/lister">Employés</a>
	<a href="creer">Bulletins</a>

	<div class="container">

		<h1>Ajouter un bulletin</h1>

		<form:form method="post" modelAttribute="bulletinForm">

			<div class="row">
				<div class="col-3">
					<form:label path="periode">Période</form:label>
				</div>
				<div class="col-6">
					<form:select path="periode.id" class="form-control" id="formPeriode">
						<c:forEach items="${periodeList}" var="p">
							<form:option value="${p.id}" label="${p.duree}"></form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-3">
					<form:label path="remunerationEmploye">Matricule</form:label>
				</div>
				<div class="col-6">
					<form:select path="remunerationEmploye.id" class="form-control" id="formRemunerationEmploye">
						<c:forEach items="${remunerationEmployeList}" var="e">
							<form:option value="${e.id}" label="${e.matricule}"></form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-3">
					<form:label  path="primeExceptionnelle">Prime exceptionnelle</form:label>
				</div>
				<div class="col-6">
					<form:input path="primeExceptionnelle" id="formPrimeExceptionnelle" required="required"/>
				</div>
			</div>

			<input type="submit" value="creer">
		</form:form>
	</div>

</body>
</html>