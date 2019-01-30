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
	<h3>patients page</h3>
	<form style="display: inline;" method="get"
		action="javascript:document.getElementById('logout').submit()">
		<button type="submit">Log out</button>
	</form>
	<f:form style="display: inline;" action="${contextPath }/homepage"
		method="get">
		<button type="submit">homepage</button>
	</f:form>

	</br>
	<h2>patients card</h2>
	<f:form style="display: inline;"
		action="${contextPath }/editpatient/${patient.id }" method="get">
		<button type="submit">edit details</button>
	</f:form>
	<td>${patient.firstName }</td>
	<td>${patient.lastName}</td>

	<h2>visits</h2>
	<f:form style="display: inline;" action="${contextPath }/displayvisits"
		method="get">
		<button type="submit">display visits</button>
	</f:form>
	<f:form style="display: inline;"
		action="${contextPath }/addvisit/${patient.id }" method="get">
		<button type="submit">add visit</button>
	</f:form>
	</br>
	<c:if test="${displayVisits }">

		<c:forEach items="${patient.visits }" var="visit">
			<td>${visit.date }</td>
			<td>${visit.type }</td>
			<td>${visit.therapist.firstName }</td>
			<f:form style="display: inline;"
				action="${contextPath }/editvisit/${visit.id }" method="get">
				<button type="submit">edit visit</button>
			</f:form>
			</br>
		</c:forEach>
	</c:if>
	<c:if test="${!patient.attachements.isEmpty() }">
		<h2>attachements</h2>
		<c:forEach items="${patient.attachements }" var="attachement">
			<td>${attachement.fileName }</td>
			<f:form style="display: inline;"
				action="${contextPath }/downloadFile/${attachement.id }"
				method="get">
				<button type="submit">download</button>
				</br>
			</f:form>
		</c:forEach>
	</c:if>
	<f:form method="POST"
		action="${contextPath }/uploadFile/${ patient.id}?${_csrf.parameterName}=${_csrf.token}"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td><button type="submit">submit</button></td>
			</tr>
		</table>
	</f:form>
	<h2>medical history</h2>
	<f:form style="display: inline;"
		action="${contextPath }/addmedicalhistory/${patient.id }" method="get">
		<button type="submit">add medical history</button>
	</f:form>
	</br>
	<c:forEach items="${listOfMedicalHistory}" var="medicalHistory"
		varStatus="thecount">

		<f:form style="display: inline;"
			action="${contextPath }/displaymedicalhistory/${medicalHistory.medicalHistory.id }"
			method="get">
			<button type="submit">display medical history
				${thecount.count }</button>
		</f:form>
		</br>
		<c:if test="${medicalHistory.displayMedicalHistory }">
			<f:form style="display: inline;"
				action="${contextPath }/editmedicalhistory/${medicalHistory.medicalHistory.id }"
				method="get">
				<button type="submit">edit medical history</button>
			</f:form>
			</br>
			<div>${medicalHistory.medicalHistory.date }</div>
			<div>${medicalHistory.medicalHistory.medication }</div>
			<div>${medicalHistory.medicalHistory.treatment }</div>

			<c:forEach items="${medicalHistory.medicalHistory.hypothesis}"
				var="hypothesis" varStatus="hypo">
				<td>hipoteza ${hypo.count }</td>
				<f:form style="display: inline;"
					action="${contextPath }/edithypothesis/${hypothesis.id }"
					method="get">
					<button type="submit">edit hypothesis</button>
				</f:form>
				</br>
				<td>${hypothesis.description }</td>

				</br>
			</c:forEach>
			<f:form style="display: inline;"
				action="${contextPath }/addhypothesis/${medicalHistory.medicalHistory.id }"
				method="get">
				<button type="submit">add hypothesis</button>
			</f:form>
		</c:if>
		</br>
	</c:forEach>
</body>
</html>