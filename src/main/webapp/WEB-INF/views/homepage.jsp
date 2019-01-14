<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>FizjoGabinet</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
</style>
</head>
<body>

	<h2>hello ${pageContext.request.remoteUser}</h2>

	<c:url value="/logout" var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form style="display: inline;" method="get"
			action="javascript:document.getElementById('logout').submit()">
			<button type="submit">Log out</button>
		</form>
		<f:form style="display: inline;" action="${contextPath }/patientspage"
			method="get">
			<button type="submit">patients page</button>
		</f:form>
		<f:form style="display: inline;" action="${contextPath }/addpatient"
			method="get">
			<button type="submit">add patient</button>
		</f:form>
		<f:form style="display: inline;" action="${contextPath }/addtherapist"
			method="get">
			<button type="submit">add therapist</button>
		</f:form>

		<!--  <a class="button"
			href="javascript:document.getElementById('logout').submit()">Logout</a>-->
	</c:if>

	</br>


</body>
</html>
