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

<style>
</style>
</head>
<body>
	<t:template>
		<div class="container">
			<div class="row">
				<div class="col-sm-7">
					<f:form action="${contextPath }/addtherapist" method="post"
						modelAttribute="therapist">
						<h2>Therapist</h2>
						<div class="form-group col-sm-8">

							<f:input placeholder="Firstname:" path="firstName"
								class="form-control input-lg" />
						</div>
						<div class="form-group col-sm-8">

							<f:input placeholder="Lastname:" path="lastName"
								class="form-control input-lg" />
						</div>
						<div class="form-group col-sm-8">

							<f:input placeholder="E-mail:" path="email"
								class="form-control input-lg" />
						</div>
						<div class="form-group col-sm-8">

							<f:input placeholder="Phonenumber:" path="phoneNumber"
								class="form-control input-lg" />
						</div>
						<div>
							<f:hidden path="id" />
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="well">
							<button class="btn btn-success" type="submit">save</button>
						</div>

					</f:form>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-7">
					<f:form action="${contextPath }/controlpanel" method="get">
						<button class="btn btn-primary" type="submit">back</button>
					</f:form>
				</div>
			</div>
		</div>
	</t:template>
</body>
</html>
