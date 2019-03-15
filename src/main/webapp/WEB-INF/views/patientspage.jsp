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
<title>PhysioClinic</title>
</head>
<body onload='document.loginForm.username.focus();'>

	<t:template>
		<div class="container">
			<f:form class="form-inline" style="display: inline;"
				action="${contextPath }/searchpatient" method="get">
				<input name="search" placeholder="Search" class="form-control" />
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-search"></span> Search
				</button>
			</f:form>
			</br> </br>
			<table class="table table-striped">
				<thead>
					<tr>
						<th colspan="4" style="text-align: center; font-size: 24px;">List
							of patients:</th>
					</tr>
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Phone</th>
						<th style="width: 30%;"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allPatients}" var="patient">
						<tr>
							<td>${patient.firstName }</td>
							<td>${patient.lastName }</td>
							<td>${patient.phoneNumber }</td>
							<td><f:form style="display: inline;"
									action="${contextPath }/displaypatientscard/${patient.id }"
									method="get">
									<button type="submit" class="btn btn-primary">details</button>
								</f:form> <f:form style="display: inline;"
									action="${contextPath }/editpatient/${patient.id }"
									method="get">
									<button type="submit" class="btn btn-info">edit
										details</button>
								</f:form>
								<f:form style="display: inline;"
									action="${contextPath }/deletepatient/${patient.id }"
									method="get">
									<button class="btn btn-danger" type="submit">delete
										patient</button>
								</f:form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</t:template>

</body>
</html>