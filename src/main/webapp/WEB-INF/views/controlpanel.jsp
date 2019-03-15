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
<title>PhysioClinic</title>
</head>

<body onload='document.loginForm.username.focus();'>
	<t:template>

		<div class="container">
			<div class="row">
				<div class="col-sm-5">
					<f:form style="display: inline;"
						action="${contextPath}/addtherapist" method="get">
						<button class="btn btn-primary" type="submit">add therapist</button>
					</f:form>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th style="text-align: center;" colspan="2">Therapists</th>

							</tr>
							<tr>
								<th>Name</th>
								<th style="width:40%;"></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${therapists}" var="therapist">
								<tr>
									<td>${therapist.firstName } ${therapist.lastName }</td>
									<td style="text-align: center;"><f:form
											style="display: inline;"
											action="${contextPath }/edittherapist/${therapist.id }"
											method="get">
											<button class="btn btn-info" type="submit">edit</button>
										</f:form> <f:form style="display: inline;"
											action="${contextPath }/deletetherapist/${therapist.id }"
											method="get">
											<button class="btn btn-danger" type="submit">remove</button>
										</f:form></td>
								</tr>
							</c:forEach>

						</tbody>

					</table>
				</div>
				<div class="col-sm-5">
					<h3>change password</h3>

					<f:form method="POST" action="${contextPath}/changePassword"
						modelAttribute="passwordForm" class="form-signin">
						<spring:bind path="currentPassword">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<f:input type="password" path="currentPassword"
									class="form-control input-lg" placeholder="Current password"
									autofocus="true"></f:input>
								<f:errors path="currentPassword"></f:errors>
							</div>
						</spring:bind>

						<spring:bind path="password">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<f:input type="password" path="password"
									class="form-control input-lg" placeholder="Password"></f:input>
								<f:errors path="password"></f:errors>
							</div>
						</spring:bind>

						<spring:bind path="passwordConfirm">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<f:input type="password" path="passwordConfirm"
									class="form-control input-lg"
									placeholder="Confirm your password"></f:input>
								<f:errors path="passwordConfirm"></f:errors>
							</div>
						</spring:bind>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
					</f:form>

				</div>
			</div>
		</div>



	</t:template>
</body>
</html>