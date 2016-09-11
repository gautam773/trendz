<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
<c:import url="/head-meta" />
</head>
<body>
<c:import url="/head" />
 
<div class="form">
<script type="text/css">
					</script>

<div class="container">
	<div class="row">
		<div class="col-lg-12 col-centered">
			<div class="table-responsive">

				<c:if test="${success != null}">
					<div class="alert alert-success">
						<p>${success}</p>
					</div>
				</c:if>

				<c:if test="${error != null}">
					<div class="alert alert-danger">
						<p>${error}</p>
					</div>
				</c:if>
<body id="d" >
				<form:form action="AddUser" method="POST" modelAttribute="User">
					<table style="width: 80%;" class="table center">
						
						<tr>
							<td><form:label path="username" for="username">Username:</form:label></td>
							<td><form:input path="username" type="text"
									class="form-control" id="username" /></td>
							<td class="alert alert-danger"><form:errors path="username" /></td>
						</tr>

						<tr>
							<td><form:label path="password" for="password">Password:</form:label></td>
							<td><form:input path="password" type="password"
									class="form-control" id="password" /></td>
							<td class="alert alert-danger"><form:errors path="password" /></td>
						</tr>

						<tr>
							<td><form:label path="cpassword" for="cpassword">Confirm Password:</form:label></td>
							<td><form:input path="cpassword" type="password"
									class="form-control" id="cpassword" /></td>
							<td class="alert alert-danger"><form:errors path="cpassword" /></td>
						</tr>

						<tr>
							<td><form:label path="email" for="email">Email address:</form:label></td>
							<td><form:input path="email" type="email"
									class="form-control" id="email" autofocus="true" /></td>
							<td class="alert alert-danger"><form:errors path="email" /></td>
						</tr>
						
						<tr>
							<td><form:label path="phone" for="phone">Phone:</form:label></td>
							<td><form:input path="phone" type="phone"
									class="form-control" id="phone" /></td>
							<td class="alert alert-danger"><form:errors path="phone" /></td>
						</tr>

						<tr>
							<td><form:label path="location" for="location">Address:</form:label></td>
							<td><form:textarea path="location" class="form-control"
									id="location"></form:textarea></td>
							<td class="alert alert-danger"><form:errors path="location" /></td>
						</tr>

						<tr>
							<td colspan="2">
								<div class="row">
									<div class="col-md-2 col-md-offset-5">
										<button type="submit" class="btn btn-default">Submit</button>
									</div>
								</div>
							</td>
						</tr>

					</table>
				</form:form>
				</body>
			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>