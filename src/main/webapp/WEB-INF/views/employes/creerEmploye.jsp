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
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
    	<title>Création Employé</title>
  	</head>
  	
  	<body>
    	<h1>Créer Employe</h1>
		<p>Préfixe Matricule : ${prefixMatricule}</p>

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
      		<form:form method="post" modelAttribute="RemunerationEmploye" style="width: 35rem">
	    		<div class="form-group row">
	        		<label for="matricule" class="col-sm-4">Matricule</label>
	        		<div class="col-sm-8">
						<form:input type="text" class="form-control form-control-sm"
							id="matricule" name="matricule" placeholder="Matricule"
							path="matricule" />
					</div>
	       		</div> 
	       		
 				<div class="form-group row">
 					<label for="entreprise">Entreprise</label>		
    				<form:select path="entreprise.id" class="form-control" id="formEntreprise">
						<form:options items="${entreprises}" itemValue="id" itemLabel="denomination"/>	
					</form:select>
 				</div> 			
 				<div class="form-group row">
    				<label for="profil">Profil</label>
    				<form:select path="profilRemuneration.id" class="form-control" id="formProfil">
						<form:options items="${profils}" itemValue="id" itemLabel="code"/>	
					</form:select>
 				</div> 			
      			<div class="form-group row">
    				<label for="grade">Grade</label>
    				<form:select path="grade.id" class="form-control" id="formGrade">
						<c:forEach items="${grades}" var="g">
+							<option value="${g.id}">${g.code} - <fmt:formatNumber pattern="#,##0" value="${g.tauxBase*g.nbHeuresBase*12}"></fmt:formatNumber> € / an</option>
+						</c:forEach>
					</form:select>
 				</div>   
	       		<button type="submit" class="btn btn-primary">Ajouter</button>
    		</form:form>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
		<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.js"></script>
  	</body>

</html>