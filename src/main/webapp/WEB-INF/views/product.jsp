<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    <head>
    <c:import url="/head-meta"></c:import>
    
    </head>
    <body style=" background-image: url(${pageContext.request.contextPath}/resources/images/bg.jpg); ">
    <c:import url="/head"></c:import>
    
    <body id="d" style bgcolor="aqua">
    <script type="text/javascript">
	

	var myApp = angular.module('myApp',[]);
	
	myApp.controller("abc",function($scope)
	{
		/*$scope.data = [
		               {"ProductId":"1","ProductName":"dairymilk","ProductDescription":"asdasd","ProductCategory":"asd","ProductPrice":"1000","ProductQuantity":"10","ProductImage":"#"},
		               {"ProductId":"2","ProductName":"fivestar","ProductDescription":"asdasd","ProductCategory":"asd","ProductPrice":"1000","ProductQuantity":"10","ProductImage":"#"},
		               {"ProductId":"3","ProductName":"munch","ProductDescription":"asdasd","ProductCategory":"asd","ProductPrice":"1000","ProductQuantity":"10","ProductImage":"#"},
		               {"ProductId":"4","ProductName":"gems","ProductDescrption":"asdasd","ProductCategory":"asd","ProductPrice":"1000","ProdutQuantity":"10","ProductImage":"#"}
		              ];*/
		              
		 $scope.data = ${JSONData};            
		
		$scope.search = '${param.item}';
	});
	
	
	</script>
    
    <body ng-app="myApp" ng-controller="abc">
    
    <%
    if (request.isUserInRole("ADMIN"))
    {
    	%>
    <a href="${pageContext.request.contextPath}/addproduct" class="btn btn-success">Add Product</a>
    <%
    }
    %>
    
    
    <div class="container">
    <div class="col-lg-12">
    			<input type="text" id="search" value="" placeholder="Enter Search Keyword..." class="form-control" ng-model="searchKeyword" ng-init="searchKeyword ='${searchKey}'" />
    		</div>
    	
    	<div class="row" ng-repeat="x in data| filter: searchKeyword">
    		<div class="col-lg-4">
    			<img src="{{x.ProductImage}}"></img>
    		</div>
    		<div class="col-lg-4">
    			<table class="table table-responsive">
    				<tr>
    					<td>Product Name:</td>
    					<td>{{x.ProductName}}</td>
    				</tr>
    				
    				<tr>
    					<td>Product Category:</td>
    					<td>{{x.ProductCategory}}</td>
    				</tr>
    				
    				<tr>
    					<td>Product Price:</td>
    					<td>{{x.ProductPrice}}</td>
    				</tr>
    				
    				
    				
    			</table>
    		</div>
    		<div class="col-lg-4">
    			<a href="${pageContext.request.contextPath}/viewproduct/{{x.ProductId}}" class="btn btn-success">View</a>
    
     <%
    if (request.isUserInRole("ADMIN"))
    {
    	%>
    	
    			<a href="${pageContext.request.contextPath}/updateproduct/{{x.ProductId}}" class="btn btn-info">Update</a>
    			<a href="${pageContext.request.contextPath}/deleteproduct/{{x.ProductId}}" class="btn btn-danger">Delete</a>
    
    <%
    }
    %>
    
    
    		</div>
    	</div>
    </div>
    
    </body>
    </html>
    