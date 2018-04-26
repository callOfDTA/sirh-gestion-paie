<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<title>Creer Employe</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item active"><a class="nav-link" href="#">Employés</a>
		</li>
		<li class="nav-item active"><a class="nav-link" href="#">Bulletins</a>
		</li>
	</ul>
	</nav>
	<div class="container">
		<h1>Créer Employe</h1>

		<div class="col-sm-12">
			<form:form method="post" modelAttribute="RemunerationEmploye">
				<div class="form-group row">
					<label for="inputMatricule" class="col-sm-4">Matricule</label>
					<div class="col-sm-8">
						<form:input type="text" class="form-control" id="inputMatricule"
							placeholder="matricule" path="matricule" />
					</div>

					<label for="inputEntreprise" class=" col-sm-4">Entreprise</label>
					<div class="col-sm-8">
						<form:select path="entreprise.id" class="form-control"
							id="formEntreprise">
							<form:options items="${entreprises}" itemValue="id"
								itemLabel="denomination" />
						</form:select>
					</div>

					<label for="inputProfil" class="col-sm-4">Profil</label>
					<div class="col-sm-8">
						<form:select path="profilRemuneration.id" class="form-control"
							id="formProfil">
							<form:options items="${profils}" itemValue="id" itemLabel="code" />
						</form:select>
					</div>
					<label for="inputGrade" class="col-sm-4">Grade</label>
					<div class=" col-sm-8">
						<form:select path="grade.id" class="form-control" id="formGrade">
							<c:forEach items="${ grades }" var="g">
								<option value="${g.id}">${g.code} - <fmt:formatNumber pattern="#,##0" value="${g.tauxBase*g.nbHeuresBase*12}"></fmt:formatNumber> € / an</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="row justify-content-end">
					<input type="submit" class="btn btn-primary">
				</div>
			</form:form>
		</div>

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