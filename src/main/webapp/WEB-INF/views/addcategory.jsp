<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<head>
<c:import url="/head-meta"></c:import>

</head>
<c:import url="/head"></c:import>
<body>
<script type="text/css">
					</script>

<div class="container">
	<div class="row">
		<div class="col-lg-12 col-centered">
			<div class="table-responsive">

				
<body id="d" style bgcolor="aqua">
				<form:form action="AddCategoryToDB" method="POST"
					modelAttribute="Category" enctype="multipart/form-data">
					
					<table style="width: 80%;" class="table center">
						
						<tr>
							<td><form:label path="categoryName" for="categoryName">categoryName:</form:label></td>
							<td><form:input path="categoryName" type="text"
									class="form-control" id="categoryName" /></td>
							<td class="alert alert-danger"><form:errors path="categoryName" /></td>
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
			</div>
		</div>
	</div>
</div>