<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body onload='document.loginForm.username.focus();'>

	<c:if test="${not empty error}"><div>${error}</div></c:if>
	<c:if test="${not empty message}"><div>${message}</div></c:if>

	<form name='login' action="<c:url value='/loginPage' />" method='POST'>
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
			</tr>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</table>
	</form>
</body>
</html>