<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body onload='document.loginForm.username.focus();'>
	<h3>control panel</h3>
	<form style="display: inline;" method="get"
		action="javascript:document.getElementById('logout').submit()">
		<button type="submit">Log out</button>
	</form>
	<f:form style="display: inline;" action="${contextPath }/homepage"
		method="get">
		<button type="submit">homepage</button>
	</f:form>
	<f:form style="display: inline;" action="${contextPath}/addpatient"
		method="get">
		<button type="submit">add patient</button>
	</f:form>
	</br>
	<f:form style="display: inline;" action="${contextPath}/addtherapist"
		method="get">
		<button type="submit">add therapist</button>
	</f:form>
	</br>
	<c:forEach items="${therapists}" var="therapist">
		<td>${therapist.firstName }</td>
		<td>${therapist.lastName }</td>
		<f:form style="display: inline;"
			action="${contextPath }/edit/${therapist.id }"
			method="get">
			<button type="submit">edit</button>
		</f:form>
		<f:form style="display: inline;"
			action="${contextPath }/remove/${therapist.id }"
			method="get">
			<button type="submit">remove</button>
		</f:form>
		</br>
	</c:forEach>
</body>
</html>