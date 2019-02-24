<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
		<h3>control panel</h3>

		<f:form style="display: inline;" action="${contextPath}/addtherapist"
			method="get">
			<button type="submit">add therapist</button>
		</f:form>
		</br>
		<c:forEach items="${therapists}" var="therapist">
			<td>${therapist.firstName }</td>
			<td>${therapist.lastName }</td>
			<td>${therapist.status }</td>
			<f:form style="display: inline;"
				action="${contextPath }/edittherapist/${therapist.id }" method="get">
				<button type="submit">edit</button>
			</f:form>
			<f:form style="display: inline;"
				action="${contextPath }/deletetherapist/${therapist.id }"
				method="get">
				<button type="submit">remove</button>
			</f:form>
			</br>
		</c:forEach>
		<h2>change password</h2>

		<f:form  method="POST" action="${contextPath}/changePassword"
			modelAttribute="passwordForm" class="form-signin">
			<spring:bind path="currentPassword">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<f:input type="password" path="currentPassword"
						class="form-control" placeholder="Current password"
						autofocus="true"></f:input>
					<f:errors path="currentPassword"></f:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<f:input type="password" path="password" class="form-control"
						placeholder="Password"></f:input>
					<f:errors path="password"></f:errors>
				</div>
			</spring:bind>

			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<f:input type="password" path="passwordConfirm"
						class="form-control" placeholder="Confirm your password"></f:input>
					<f:errors path="passwordConfirm"></f:errors>
				</div>
			</spring:bind>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</f:form>
	</t:template>
</body>
</html>