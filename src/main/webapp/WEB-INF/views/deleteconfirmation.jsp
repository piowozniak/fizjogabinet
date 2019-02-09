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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	
</script>
<style>
</style>
</head>
<body>
	<h2>are you sure you want to delete</h2>
	<c:if test="${visit != null }">
		<f:form action="${contextPath }/deletevisit/${visit.id }"
			method="post" modelAttribute="visit">
			<div>
				<f:hidden path="id" />
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit">delete</button>
		</f:form>

		<f:form
			action="${contextPath }/displaypatientscard/${visit.patient.id }"
			method="get">
			<button type="submit">cancel</button>
		</f:form>
	</c:if>
	<c:if test="${medicalHistory != null }">
		<f:form
			action="${contextPath }/deletemedicalhistory/${medicalHistory.id }"
			method="post" modelAttribute="medicalHistory">

			<f:hidden path="id" />

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit">delete</button>
		</f:form>

		<f:form
			action="${contextPath }/displaypatientscard/${visit.patient.id }"
			method="get">
			<button type="submit">cancel</button>
		</f:form>
	</c:if>
	<c:if test="${patient != null }">
		<f:form action="${contextPath }/deletepatient/${patient.id }"
			method="post" modelAttribute="patient">

			<f:hidden path="id" />

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit">delete</button>
		</f:form>

		<f:form action="${contextPath }/displaypatientscard/${patient.id }"
			method="get">
			<button type="submit">cancel</button>
		</f:form>
	</c:if>
	<c:if test="${hypothesis != null }">
		<f:form action="${contextPath }/deletehypothesis/${hypothesis.id }"
			method="post" modelAttribute="hypothesis">

			<f:hidden path="id" />

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit">delete</button>
		</f:form>

		<f:form action="${contextPath }/displaypatientscard/${patient.id }"
			method="get">
			<button type="submit">cancel</button>
		</f:form>
	</c:if>
	<c:if test="${therapist != null }">
		<f:form action="${contextPath }/deletetherapist/${therapist.id }"
			method="post" modelAttribute="therapist">

			<f:hidden path="id" />

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit">delete</button>
		</f:form>

		<f:form action="${contextPath }/displaypatientscard/${patient.id }"
			method="get">
			<button type="submit">cancel</button>
		</f:form>
	</c:if>
	<c:if test="${file != null }">
		<f:form action="${contextPath }/removeFile/${file.id }"
			method="post" modelAttribute="file">

			<f:hidden path="id" />

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit">delete</button>
		</f:form>

		<f:form
			action="${contextPath }/displaypatientscard/${file.patient.id }"
			method="get">
			<button type="submit">cancel</button>
		</f:form>
	</c:if>
</body>
</html>
