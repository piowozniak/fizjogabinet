<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body onload='document.loginForm.username.focus();'>
	<t:template>
		<h3>patients page</h3>
		<f:form style="display: inline;"
			action="${contextPath }/searchpatient" method="get">
			<input name="search" />
			<button type="submit">Search</button>
		</f:form>
		</br>

		<c:forEach items="${allPatients}" var="patient">
			<td>${patient.firstName }</td>
			<td>${patient.lastName }</td>
			<f:form style="display: inline;"
				action="${contextPath }/displaypatientscard/${patient.id }"
				method="get">
				<button type="submit">details</button>
			</f:form>
			<f:form style="display: inline;"
				action="${contextPath }/editpatient/${patient.id }" method="get">
				<button type="submit">edit details</button>
			</f:form>
			</br>
		</c:forEach>
	</t:template>
</body>
</html>