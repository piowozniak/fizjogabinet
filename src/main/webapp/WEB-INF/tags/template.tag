<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>
<style>
body {

	padding-top: 4.5rem;
}
</style>
<body>
	<c:url value="/logout" var="logoutUrl" />
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-primary">
		<a class="navbar-brand" href="#">PhysioClinic</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="${contextPath }/fizjogabinet/homepage">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextPath }/fizjogabinet/patientspage">Patients page</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextPath }/fizjogabinet/addpatient" >Add patient</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextPath }/fizjogabinet/controlpanel">Control panel</a></li>
				</li>
			</ul>
			<!--<form class="form-inline mt-2 mt-md-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>-->
		</div>
		<form id="logout" action="${logoutUrl}" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<form style="display: inline;" method="get"
			action="javascript:document.getElementById('logout').submit()">
			<button class="btn btn-info my-2 my-sm-0" type="submit">Log out</button>
		</form>
<!--  		<f:form style="display: inline;"
			action="${contextPath }/fizjogabinet/homepage" method="get">
			<button type="submit">home</button>
		</f:form>
		<f:form style="display: inline;"
			action="${contextPath }/fizjogabinet/patientspage" method="get">
			<button type="submit">patients page</button>
		</f:form>
		<f:form style="display: inline;"
			action="${contextPath }/fizjogabinet/addpatient" method="get">
			<button type="submit">add patient</button>
		</f:form>
		<f:form style="display: inline;"
			action="${contextPath }/fizjogabinet/controlpanel" method="get">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">control panel</button>
		</f:form>-->
	</nav>


	<!--  <a class="button"
			href="javascript:document.getElementById('logout').submit()">Logout</a>-->

	</br>
	<jsp:doBody />
</body>
</html>

