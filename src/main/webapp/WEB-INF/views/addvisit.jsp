<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>PhysioClinic</title>
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
				<div class="col-sm-5">
					<f:form action="${contextPath }/addvisit" method="post"
						modelAttribute="visit">
						<div>${visit.id }</div>
						<h2>Visit</h2>
						<div class="form-group col-sm-8">

							<f:input class="form-control input-lg" placeholder="Date:"
								id="datepicker" path="date" />
						</div>
						<div class="form-group col-sm-8">
							Therapist:
							<f:select class="form-control input-lg" path="therapist.id"
								items="${therapists}" itemLabel="firstName" itemValue="id" />
						</div>
						<div class="form-group col-sm-8">
							Type of visit:
							<f:select class="form-control input-lg" path="type"
								items="${ typeOfVisit}" />
						</div>
						<div>
							<f:hidden path="patient.id" />
							<f:hidden value="${visit.id}" path="id" />
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="well">
							<button class="btn btn-success" type="submit">save</button>
						</div>

					</f:form>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="row">
					<f:form
						action="${contextPath }/displaypatientscard/${visit.patient.id }"
						method="get">
						<button class="btn btn-primary" type="submit">cancel</button>
					</f:form>
				</div>
			</div>
		</div>



	</t:template>
</body>
</html>
