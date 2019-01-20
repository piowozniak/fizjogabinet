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
	<h2>add hypothesis</h2>

	<f:form action="${contextPath }/addhypothesis" method="post"
		modelAttribute="hypothesis">

		<div>
			Description:
			<f:input path="description" />
		</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit">save</button>
			<f:input type="hidden" path="medicalHistory.id"
			 />
	</f:form>

	<f:form action="${contextPath }/homepage" method="get">
		<button type="submit">back</button>
	</f:form>

</body>
</html>