<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
	$(function() {
		$("#datepicker").datepicker({ dateFormat: 'yy-mm-dd', changeYear: true }).val();
	});
	$(function() {
		$("#datepicker2").datepicker({ dateFormat: 'yy-mm-dd' }).val();
	});
</script>
<style>
</style>
</head>
<body>
	<h2>add patient</h2>

	<!--  dodawanie gym  -->
	<f:form action="${contextPath }/addpatientconfirmation" method="post"
		modelAttribute="patient">

		<div>
			First name:
			<f:input path="patient.firstName" />
		</div>
		<div>
			Last name:
			<f:input path="patient.lastName" />
		</div>
		<div>
			Date of birth:
			<f:input id="datepicker" path="patient.dateOfBirth" />
		</div>
		<div>
			Phone number:
			<f:input path="patient.phoneNumber" />
		</div>
		<div>
			Date of first visit:
			<f:input id="datepicker2" path="visit.date" />
		</div>
		<div>
			Therapist:
			<f:select path="visit.therapist.id" items="${therapists}"
				itemLabel="firstName" itemValue="id" />
		</div>
		<div>
			Type of visit:
			<f:select path="visit.type" items="${ typeOfVisit}" />
		</div>

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button type="submit">submit</button>
	</f:form>
	<f:form action="${contextPath }/homepage" method="get">


		<button type="submit">back</button>
	</f:form>

</body>
</html>
