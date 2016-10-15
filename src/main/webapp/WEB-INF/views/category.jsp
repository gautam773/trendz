<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
    
<html>
<head>
<c:import url="/head-meta"/>

</head>

<body>
<c:import url="/head"/>
<br>

<script type="text/javascript">
	

	var myApp = angular.module('myApp',[]);
	
	myApp.controller("abc",function($scope)
	{
		$scope.data = ${JSONData};
		$scope.search = '${param.item}';
	});

</script>
    
    <body ng-app="myApp" ng-controller="abc">
    
    <% if (request.isUserInRole("ADMIN"))
    			{
    			%>
    			
<a href="${pageContext.request.contextPath}\addcategory"> 
<button type="button" class="btn btn-default" style="background-color:brown;color:white;width:124px;height:38px;">Add Category</button> 
</a>

 <%
    			}
				%>
    <div class="container">
    	<div class="row" ng-repeat="x in data">
    		<div class="col-lg-4">
    			<img src="{{x.CategoryImage}}"></img>
    		</div>
    		<div class="col-lg-4">
    			<table class="table table-responsive">
    				<tr>
    					<td>Category Name:</td>
    					<td>{{x.CategoryName}}</td>
    				</tr>
    				
    				   				
    				
    			</table>
    		</div>
    		<div class="col-lg-4">
    			
    			
    			<a href="${pageContext.request.contextPath}/updatecategory/{{x.CategoryId}}" class="btn btn-info">Update</a>
    			<a href="${pageContext.request.contextPath}/deletecategory/{{x.CategoryId}}" class="btn btn-danger">Delete</a>
    			
    		</div>
    	</div>
    </div>
    