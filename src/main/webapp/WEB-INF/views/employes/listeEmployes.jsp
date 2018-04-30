<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Liste des Employ�s</h1>

<table>
<tr>
<th>Date/heure cr�ation</th><th>Matricule</th><th>Grade</th>
</tr>
<c:forEach items="${employes}" var="e">
	<tr>
		<td>${e.dateCreation}</td>
		<td>${e.matricule}</td>
		<td>${e.grade.code}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>