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
	
		myApp.factory('UserService', ['$http', '$q', function($http, $q)
		{
	 
    	return {
    		getUserAddress: function(){
                return $http.post('http://localhost:8081/trendz/flows/getUserAddress/')
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
    		,
            updateAddresses: function(item){
                    return $http.post('http://localhost:8081/trendz/flows/updateAddresses/', item)
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
	
	
	myApp.controller("page2",['$scope', 'UserService' ,function($scope , $UserService)
	{
		$scope.shippingAddress = '';
		$scope.billingAddress = '';
        
		$UserService.getUserAddress()
    	.then
    	(
    			function(response)
    			{
    				console.log(response);
    				
    				$scope.shippingAddress = response.shippingAddress;
    				$scope.billingAddress = response.billingAddress;
    				
    				
    			}
    			,
    			 
 	            function(errResponse)
 	            {
 	            	console.error('Error while Getting Addresses.');
 	            } 
    	);
		
		$scope.updated = '';
		
        $scope.UpdateAddresses = function()
        {
        	$scope.data = { "shippingAddress" : $scope.shippingAddress , "billingAddress" : $scope.billingAddress };
        	
        	console.log( $scope.data );
        	
        	$UserService.updateAddresses( JSON.stringify( $scope.data ) )
        	.then
        	(
        			function(response)
        			{
        				console.log(response);
        				
        				$scope.updated = response.status;
        				
        				window.setTimeout(function()
        				{
        					$scope.$apply( $scope.updated = '' );
        				},3000);
        				
        			}
        			,
        			 
     	            function(errResponse)
     	            {
     	            	console.error('Error while Sending Data.');
     	            } 
        	);
        }
	}]); 
	
</script>
    
    <body ng-app="myApp" ng-controller="page2"  style=" background-image: url(${pageContext.request.contextPath}/resources/images/bg.jpg); ">
     <br><br><br><br><br>
<div class="container">
  <a href="${flowExecutionUrl}&_eventId=ViewCompleteOrder" class="btn btn-primary btn-lg btn pull-right">View Complete Order
  <span class="glyphicon glyphicon-chevron-right"></span></a>
  <a href="${flowExecutionUrl}&_eventId=BackToCart" class="btn btn-success btn-lg btn pull-left">
  <span class="glyphicon glyphicon-chevron-left"></span>Back To Cart</a>
  </div>
<br>

<form >
					    	
            <legend>Shipping Details</legend>
                    
                    <div class="row" style="margin: auto; width: 45%;">
                        <div class="col-xs-12 col-md-12">
                            
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
                          </div>
                    </div>
                    
                    			  <br><br><br>
          
                    <input type="button" value="Update" class="btn btn-success" ng-click="UpdateAddresses()" ng-disabled="shippingAddress=='' || billingAddress==''">
                        <label class="alert alert-success" ng-show="updated=='updated'">Updated</label>
                        <br><br><br><br><br><br>
            </form>   

    </body>