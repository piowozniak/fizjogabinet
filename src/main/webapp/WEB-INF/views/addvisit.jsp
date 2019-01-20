<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>fizjogabinet</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
</style>
</head>
<body>
	<h2>add visit</h2>

	<f:form action="${contextPath }/addvisit" method="post"
		modelAttribute="visit">

		<div>
			Date:
			<f:input path="date" />
		</div>
		<div>
			Therapist:
			<f:select path="therapist.id" items="${therapists}"
				itemLabel="firstName" itemValue="id" />
		</div>
		<div>
			Type of visit:
			<f:select path="type" items="${ typeOfVisit}" />
		</div>
		<div>
			<f:hidden path="patient.id" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button type="submit">save</button>
	</f:form>

	<f:form action="${contextPath }/displaypatientscard/${visit.patient.id }" method="get">
		<button type="submit">cancel</button>
	</f:form>

</body>
</html>