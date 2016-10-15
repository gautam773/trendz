<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@page isELIgnored="false" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
    <head>
    <c:import url="/head-meta"></c:import>
    
    </head>
    <c:import url="/head"></c:import>
    
    <script type="text/javascript">
'use strict';
	var myApp = angular.module('myApp',[]);
	
	///////////////
	
	myApp.factory('UserService', ['$http', '$q', function($http, $q){
	 
    return {
    	
    	fetchAllItems: function(){
                return $http.post('http://localhost:8081/trendz/flows/fetchAllItems/')
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while sending data');
                                    return $q.reject(errResponse);
                                }
                        );
        	}
    };
 
}]);
	
	///////////////
	
	
	myApp.controller("page3",['$scope', 'UserService' ,function($scope , $UserService)
	{
		$scope.TotalPrice = 0;
		$scope.shippingAddress = '';
		$scope.billingAddress = '';
		
			$UserService.fetchAllItems()
        	.then(
                	function(response)
                	{
                		//console.log( response );
                		
                		try
                    	{
                    		$scope.data = response;
                    	}
                    	catch(e)
                    	{
                    		$scope.data = [];
                    	}	
                    	
                    	console.log( $scope.data );
                    	
                    	for(var i=0 ; i < $scope.data.length ; i++ )
                    	{
                    		try
                    		{
                    			$scope.TotalPrice += parseInt($scope.data[i].ProductQty*$scope.data[i].ProductPrice);
                    			$scope.shippingAddress = $scope.data[i].ShippingAddress;
                    			$scope.billingAddress = $scope.data[i].BillingAddress;
                    		}
                    		catch(e)
                    		{
                    			console.log(e);
                    		}
                    			
                    	}
                	}
    	            , 
    	            function(errResponse)
    	            {
    	            	console.error('Error while Sending Data.');
    	            } 
            	); 
			
        	
	}]);
	
</script>
    
    <body ng-app="myApp" ng-controller="page3" style=" background-image: url(${pageContext.request.contextPath}/resources/images/bg.jpg); ">
    
    <br><br><br><br><br>
<div class="container">
  <a href="${flowExecutionUrl}&_eventId=ConfirmOrder" class="btn btn-primary btn-lg btn pull-right">Confirm Order
  <span class="glyphicon glyphicon-chevron-right"></span></a>
  <a href="${flowExecutionUrl}&_eventId=BackToConfirmDetails" class="btn btn-success btn-lg btn pull-left">
  <span class="glyphicon glyphicon-chevron-left"></span>Back To Confirm Details</a>
  </div>
<br>
    
    <!--  -->
     <legend align="center" >Shipping Details</legend>
                    
                    <div class="row" style="margin: auto; width: 45%;">
                        <div class="col-xs-12 col-md-12" >
                            
                            <label>Billing address</label><br><br>
	<textarea rows="5" placeholder="Billing address" class="form-control" style="resize: none;" ng-model="billingAddress">
	</textarea>
                            
                            </div>
                            </div>
                            <br>
                            <div class="row" style="margin: auto; width: 45%;">
                        <div class="col-xs-12 col-md-12">
                            <label>ShippingAddress</label><br><br>
	<textarea rows="5" placeholder="Shipping Address" class="form-control" style="resize: none;" ng-model="shippingAddress">
	</textarea>
	
	
	<label><h2 style="font-family:Monotype Corsiva" ><b>Total Price</b></h2></label><br>
		<textarea rows="2" class="form-control" style="resize: none;font-family:Monotype Corsiva;color:darkblack;font-size:20px" ng-model="TotalPrice" ng-disabled="true"></textarea>
                          </div>
                    </div></table>
                    </div>
       <br><br><br>
<div class="panel panel-primary">
      <div class="panel-heading" align="center"><h4 style="font-family: Perpetua Titling MT">Products You Choose to Buy</h4></div>
    </div>
<div ng-repeat="x in data" style="background-color: rgba(255, 255, 255, 0.5);">

		
<div class="container">
<div class="panel panel-primary">
      
    </div>
   
	
		<div class="row">
		
<div class="col-sm-6">
 <div class="panel panel-primary" >
  
   <div class="panel-body" >
						<img src="${pageContext.request.contextPath}/{{x.ProductImage}}"
							width="100%" class="img img-responsive img-thumbnail"></div>
					</div>
			</div>
			
			<div class="col-sm-6">
				<div class="panel panel-primary">
  
   <div class="panel-body">
		<table class="table" align="center">
		<br>
		<h4 align="center" style="font-weight: bold;" >Product details</h4>
	
				<tr>
				<td>Product Name : </td>
				<td>{{x.ProductName}}</td>
</tr>
	<tr>
				<td>Qty : </td>
				<td>{{x.ProductQty}}</td>
			</tr>

			<tr>

				<td>Price : </td>
				<td>{{x.ProductPrice}}</td>
			</tr>
			
			<tr>

				<td>Total Unit Price : </td>
				<td>{{x.ProductPrice * x.ProductQty }}</td>
			</tr>
			<br>
			
		</table>
		</div>
		</div>
		</div>
</div>
</div>
</div>
		<br>
		<br>
		<br>
    <!--  -->
    
    </body>