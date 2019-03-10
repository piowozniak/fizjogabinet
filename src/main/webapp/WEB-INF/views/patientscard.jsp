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
		<div class="jumbotron text-center">
			<h3>Patients card</h3>
			<h1>${patient.firstName }${patient.lastName}</h1>
			<f:form style="display: inline;"
				action="${contextPath }/editpatient/${patient.id }" method="get">
				<button class="btn btn-info" type="submit">edit details</button>
			</f:form>
			<f:form style="display: inline;"
				action="${contextPath }/deletepatient/${patient.id }" method="get">
				<button class="btn btn-danger" type="submit">delete patient</button>
			</f:form>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-sm-7">
					<div class="well">
						<h3>Details</h3>
						<p>Firstname: ${patient.firstName }</p>
						<p>Lastname: ${patient.lastName }</p>
						<p>Date of birth: ${patient.dateOfBirth }</p>
						<p>Phonenumber: ${patient.phoneNumber }</p>
					</div>
					<div class="well">

						<f:form style="display: inline;"
							action="${contextPath }/addmedicalhistory/${patient.id }"
							method="get">
							<button class="btn btn-info" type="submit">add medical
								history</button>
						</f:form>
						</br>
						<c:forEach items="${listOfMedicalHistory}" var="medicalHistory"
							varStatus="thecount">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th style="text-align: center; font-size: 24px;" colspan="4">Medical
											history ${thecount.count }</th>
									</tr>
									<tr
										class="${medicalHistory.medicalHistory.flag == 'G' ? 'alert alert-danger' : '' }">
										<th>Date</th>
										<th>Medication</th>
										<th>Treatment</th>
										<th></th>
									</tr>

								</thead>
								<tbody>
									<tr>
										<td>${medicalHistory.medicalHistory.date }</td>
										<td>${medicalHistory.medicalHistory.medication }</td>
										<td>${medicalHistory.medicalHistory.treatment }</td>
										<td style="text-align: center;"><f:form
												style="display: inline;"
												action="${contextPath }/editmedicalhistory/${medicalHistory.medicalHistory.id }"
												method="get">
												<button class="btn btn-info" type="submit">edit</button>
											</f:form> <f:form style="display: inline;"
												action="${contextPath }/deletemedicalhistory/${medicalHistory.medicalHistory.id }"
												method="get">
												<button class="btn btn-danger" type="submit">delete</button>
											</f:form></td>
									</tr>
								</tbody>
							</table>
							<f:form style="display: inline;"
								action="${contextPath }/addhypothesis/${medicalHistory.medicalHistory.id }"
								method="get">
								<button class="btn btn-info" type="submit">add
									hypothesis</button>
							</f:form>
							<table style="padding-left: 50px;" class="table table-bordered">
								<thead>
									<tr>
										<th colspan="2" style="text-align: center;">Hypothesis</th>
									</tr>
									<tr>
										<th>Description</th>
										<th style="width: 30%;"></th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${medicalHistory.medicalHistory.hypothesis}"
										var="hypothesis" varStatus="hypo">
										<tr>
											<td>${hypothesis.description }</td>
											<td style="text-align: center;"><f:form
													style="display: inline;"
													action="${contextPath }/edithypothesis/${hypothesis.id }"
													method="get">
													<button class="btn btn-info" type="submit">edit</button>
												</f:form> <f:form style="display: inline;"
													action="${contextPath }/deletehypothesis/${hypothesis.id }"
													method="get">
													<button class="btn btn-danger" type="submit">delete</button>
												</f:form></td>
										</tr>
									</c:forEach>


								</tbody>
							</table>
						</c:forEach>
					</div>
					<div class="well">
						<f:form method="POST"
							action="${contextPath }/uploadFile/${ patient.id}?${_csrf.parameterName}=${_csrf.token}"
							enctype="multipart/form-data">
							<table>
								<tr>
									<td><input type="file" name="file" /></td>


									<td><input class="form-control input-lg" type="text"
										placeholder="" name="description" /></td>


									<td><button class="btn btn-info" type="submit">submit</button></td>
								</tr>
							</table>
						</f:form>
						<c:if test="${!patient.attachements.isEmpty() }">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th colspan="3" style="text-align: center;">Attachments</th>
									</tr>
									<tr>
										<th>File</th>
										<th>Description</th>
										<th style="width: 33%;"></th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<c:forEach items="${patient.attachements }" var="attachement">

											<td>${attachement.fileName }</td>
											<td>${attachement.description }</td>
											<td style="text-align: center;"><f:form
													style="display: inline;"
													action="${contextPath }/downloadFile/${attachement.id }"
													method="get">
													<button class="btn btn-info" type="submit">download</button>

												</f:form> <f:form style="display: inline;"
													action="${contextPath }/removeFile/${attachement.id }"
													method="get">
													<button class="btn btn-danger" type="submit">remove</button>
												</f:form></td>
										</c:forEach>
									</tr>
								</tbody>
							</table>
						</c:if>
					</div>

				</div>

				<div class="col-sm-5">
					<h3>Visits</h3>
					<f:form style="display: inline;"
						action="${contextPath }/addvisit/${patient.id }" method="get">
						<button class="btn btn-info" type="submit">add visit</button>
					</f:form>
					<c:if test="${!patient.visits.isEmpty() }">
						<f:form style="display: inline;"
							action="${contextPath }/displayvisits" method="get">
							<button class="btn btn-info" type="submit">display
								visits</button>
						</f:form>

						</br>
					</c:if>
					<c:if test="${displayVisits }"></c:if>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Date</th>
									<th>Type</th>
									<th>Therapist</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${patient.visits }" var="visit">
									<tr>
										<td>${visit.date }</td>
										<td>${visit.type }</td>
										<td>${visit.therapist.firstName }</td>
										<td><f:form style="display: inline;"
												action="${contextPath }/editvisit/${visit.id }" method="get">
												<button class="btn btn-info" type="submit">edit</button>
											</f:form> <f:form style="display: inline;"
												action="${contextPath }/deletevisit/${visit.id }"
												method="get">
												<button class="btn btn-danger" type="submit">delete</button>
											</f:form></td>
									</tr>
								</c:forEach>


							</tbody>
						</table>
					
				</div>
			</div>


		</div>



	</t:template>
</body>
</html>