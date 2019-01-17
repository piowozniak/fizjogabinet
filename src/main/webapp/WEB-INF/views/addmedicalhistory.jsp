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
	<h2>add medical history</h2>

	<f:form action="${contextPath }/addmedicalhistory" method="post"
		modelAttribute="medicalHistory">
	
		<div>
			Date:
			<f:input path="medicalHistory.date" />
		</div>
		<div>
			Medication:
			<f:input path="medicalHistory.medication" />
		</div>
		<div>
			Flag:
			<f:input path="medicalHistory.flag" />
		</div>
		<div>
			treatment:
			<f:input  path="medicalHistory.treatment" />
		</div>
		
		

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button type="submit">save</button>
	</f:form>
	<c:if test="${medicalHistory.displayMedicalHistory }" >
		<h2>test hypothesis</h2>
	</c:if>
	
	<f:form action="${contextPath }/homepage" method="get">
		<button type="submit">back</button>
	</f:form>

</body>
</html>
