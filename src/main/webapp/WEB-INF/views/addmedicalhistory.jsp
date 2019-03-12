<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>fizjogabinet</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'yy-mm-dd'
		}).val();
	});
</script>
<style>
</style>
</head>
<body>
	<t:template>
		<div class="container">
			<div class="row">
				<f:form action="${contextPath }/addmedicalhistory" method="post"
					modelAttribute="medicalHistory">
					<h2>Medical history</h2>
					<div class="form-group col-sm-8">

						<f:input placeholder="Date:" class="form-control input-lg"
							id="datepicker" path="date" />
					</div>
					<div class="form-group col-sm-8">

						<f:input placeholder="Medication:" class="form-control input-lg"
							path="medication" />
					</div>
					<div class="form-group col-sm-8">
						Flag:

						<f:select path="flag" class="form-control" items="${flags}" />
					</div>
					<div class="form-group col-sm-8">

						<f:textarea placeholder="Treatment:" class="form-control input-lg"	 rows="4" cols="50"
							path="treatment" />
					</div>

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="well">
						<button class="btn btn-success" type="submit">save</button>
					</div>

					<div>
						<f:hidden path="patient.id" />
						<f:hidden path="id" />
					</div>
				</f:form>


			</div>
			<div class="row">
				<f:form
					action="${contextPath }/displaypatientscard/${medicalHistory.patient.id }"
					method="get">
					<button class="btn btn-primary" type="submit">back</button>
				</f:form>
			</div>
		</div>

	</t:template>
</body>
</html>
