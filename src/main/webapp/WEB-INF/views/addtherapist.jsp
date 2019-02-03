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
	<f:form action="${contextPath }/addtherapist" method="post"
		modelAttribute="therapist">
		<div>
			First name:
			<f:input path="firstName" />
		</div>
		<div>
			Last name:
			<f:input path="lastName" />
		</div>
		<div>
			E-mail:
			<f:input path="email" />
		</div>
		<div>
			Phone number:
			<f:input path="phoneNumber" />
		</div>
		<div>
			<f:hidden path="id" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button type="submit">submit</button>
	</f:form>
	<f:form action="${contextPath }/controlpanel" method="get">
		<button type="submit">back</button>
	</f:form>

</body>
</html>
