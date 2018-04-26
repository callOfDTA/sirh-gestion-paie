<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>creerEmploye</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
</head>
<body>
	<a href="bulletin.jsp">Bulletins</a>

	<div class="container">

		<h1>Ajouter un employé</h1>
		<a href="lister">Revenir à la liste</a>
		<form:form method="post" modelAttribute="employeForm">
			<div class="row">
				<div class="col-4">
					<label>Matricule</label>
				</div>
				<div class="col-6">
				<!-- il faut aussi sécuriser niveau serveur -->
					<form:input path="matricule" id="formMatricule" required="required"/>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<label>Entreprise</label>
				</div>
				<div class="col-6">
					<form:select path="entreprise.id" class="form-control"
						id="formEntreprise">
						<form:options items="${entrepriseList}" itemValue="id"
							itemLabel="denomination" />

					</form:select>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<label>Profil</label>
				</div>
				<div class="col-6">
					<form:select path="profilRemuneration.id" class="form-control"
						id="formProfil">
						<form:options items="${profilList}" itemValue="id"
							itemLabel="code" />
					</form:select>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<label>Grade</label>
				</div>
				<div class="col-6">
					<form:select path="grade.id" class="form-control" id="formGrade">
					<c:forEach items="${gradeList}" var="g">
						<form:option  value="${g.id}" label="${g.libelle}"></form:option>
					</c:forEach>
						
					</form:select>
				</div>
			</div>
			<input type="submit" value="creer">
		</form:form>
	</div>

</body>
</html>