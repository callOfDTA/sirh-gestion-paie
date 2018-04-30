<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Création employé</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">

</head>
<body>
	<a href="<c:url value="/mvc/connexion?logout" />">Logout</a>
	<a href="lister">Employés</a>
	<a href="/paie/mvc/bulletins/lister">Bulletins</a>


	<div class="container">

		<h1>Ajouter un employé</h1>

		<form:form method="post" modelAttribute="employeForm">
		
			<div class="row">
				<div class="col-3">
					<form:label  path="matricule">Matricule</form:label>
				</div>
				<div class="col-6">
					<form:input path="matricule" id="formMatricule" required="required"/>
				</div>
			</div>
		
			
			<div class="row">
				<div class="col-3">
					<form:label path="entreprise">Entreprise</form:label>
				</div>
				<div class="col-6">
					<form:select path="entreprise.id" class="form-control" id="formEntreprise">
						<form:options items="${entrepriseList}" itemValue="id" itemLabel="denomination" />
					</form:select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-3">
					<form:label path="profilRemuneration">Profil</form:label>
				</div>
				<div class="col-6">
					<form:select path="profilRemuneration.id" class="form-control" id="formProfil">
						<form:options items="${profilList}" itemValue="id" itemLabel="code" />
					</form:select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-3">
					<form:label path="grade">Grade</form:label>
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