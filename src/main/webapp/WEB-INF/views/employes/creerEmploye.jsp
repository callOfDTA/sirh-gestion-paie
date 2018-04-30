<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajouter un Employé</h1>
	<form action="/paie/mvc/employes">
		<label>Matricule : </label><input type="text" id="matricule"><br>
		<label>Entreprise : </label><select class="form-control" id="selectEntreprise"
			name="entrepriseParam">
			<c:forEach items="${ entreprises }" var="e">
				<option value="${e.id}">${e.denomination}</option>
			</c:forEach>
		</select><br>
		<label>Profil :</label><select class="form-control" id="selectProfil"
			name="profilParam">
			<c:forEach items="${ profils }" var="p">
				<option value="${p.id}">${p.code}</option>
			</c:forEach>
		</select><br>
		<label>Grade : </label><select class="form-control" id="selectGrade"
			name="gradeParam">
			<c:forEach items="${ grades }" var="g">
				<option value="${g.id}">${g.code}</option>
			</c:forEach>
		</select><br>

	<input type="submit" value="Ajouter">
	</form>
</body>
</html>