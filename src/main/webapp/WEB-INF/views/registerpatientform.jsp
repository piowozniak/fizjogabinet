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
			<f:input path="patient.dateOfBirth" />
		</div>
		<div>
			Phone number:
			<f:input path="patient.phoneNumber" />
		</div>
		<div>
			Date of first visit:
			<f:input path="visit.date" />
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
