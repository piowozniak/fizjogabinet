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

		<h2>patients card</h2>
		<f:form style="display: inline;"
			action="${contextPath }/editpatient/${patient.id }" method="get">
			<button type="submit">edit details</button>
		</f:form>
		<f:form style="display: inline;"
			action="${contextPath }/deletepatient/${patient.id }" method="get">
			<button type="submit">delete patient</button>
		</f:form>
		<td>${patient.firstName }</td>
		<td>${patient.lastName}</td>

		<h2>visits</h2>
		<c:if test="${!patient.visits.isEmpty() }">
		<f:form style="display: inline;"
			action="${contextPath }/displayvisits" method="get">
			<button type="submit">display visits</button>
		</f:form>
		</c:if>
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
				<f:form style="display: inline;"
					action="${contextPath }/deletevisit/${visit.id }" method="get">
					<button type="submit">delete visit</button>
				</f:form>
				</br>
			</c:forEach>
		</c:if>
		<h2>attachments</h2>
		<c:if test="${!patient.attachements.isEmpty() }">
			<c:forEach items="${patient.attachements }" var="attachement">
				<td>${attachement.fileName }</td>
				<td>${attachement.description }</td>
				<f:form style="display: inline;"
					action="${contextPath }/downloadFile/${attachement.id }"
					method="get">
					<button type="submit">download</button>

				</f:form>
				<f:form style="display: inline;"
					action="${contextPath }/removeFile/${attachement.id }" method="get">
					<button type="submit">remove</button>
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
					<td><input type="text" name="description" /></td>
				</tr>
				<tr>
					<td><button type="submit">submit</button></td>
				</tr>
			</table>
		</f:form>
		<h2>medical history</h2>
		<f:form style="display: inline;"
			action="${contextPath }/addmedicalhistory/${patient.id }"
			method="get">
			<button type="submit">add medical history</button>
		</f:form>
		</br>
		<c:forEach items="${listOfMedicalHistory}" var="medicalHistory"
			varStatus="thecount">

			<!--  	<f:form style="display: inline;"
			action="${contextPath }/displaymedicalhistory/${medicalHistory.medicalHistory.id }"
			method="get">
			<button type="submit">display medical history
				${thecount.count }</button>
		</f:form>-->
			</br>
			<f:form style="display: inline;"
				action="${contextPath }/editmedicalhistory/${medicalHistory.medicalHistory.id }"
				method="get">
				<button type="submit">edit medical history</button>
			</f:form>
			<f:form style="display: inline;"
				action="${contextPath }/deletemedicalhistory/${medicalHistory.medicalHistory.id }"
				method="get">
				<button type="submit">delete medical history</button>
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
				<f:form style="display: inline;"
					action="${contextPath }/deletehypothesis/${hypothesis.id }"
					method="get">
					<button type="submit">delete hypothesis</button>
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
			</br>
		</c:forEach>
	</t:template>
</body>
</html>