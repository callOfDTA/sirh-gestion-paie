<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Creer un Bulletin</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
</head>
<body>
	<a href="listerEmploye.jsp">Employés</a>

	<div class="container">

		<h1>Ajouter un bulletin</h1>
		<a href="lister">Revenir à la liste</a>
		<form:form method="post" modelAttribute="bulletinForm">
			<div class="row">
				<div class="col-4">
					<label>Periode</label>
				</div>
				<div class="col-6">
					<form:select path="periode.id" class="form-control"
						id="formPeriode">
						<c:forEach items="${periodeList}" var="p">
							<form:option value="${p.id}" label="${p.duree}"></form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<label>Matricule</label>
				</div>
				<div class="col-6">
					<form:select path="remunerationEmploye.id" class="form-control"
						id="formRemunerationEmploye">
						<c:forEach items="${remunerationEmployeList}" var="re">
							<form:option value="${re.id}" label="${re.matricule}"></form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<label>Prime Exceptionnelle</label>
				</div>
				<div class="col-6">
					<!-- il faut aussi sécuriser niveau serveur -->
					<form:input path="primeExceptionnelle" id="formPrimeExceptionnelle" required="required" />
				</div>
			</div>
			<input type="submit" value="creer">
		</form:form>
	</div>

</body>
</html>