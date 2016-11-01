<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@page isELIgnored="false" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
    <head>
    <c:import url="/head-meta"></c:import>
    <style>
 	body {
   background: url(resources/image/thankyou.jpg) no-repeat center center fixed; 
	}
#xyz{position:relative;}
 </style>
    </head>
    
    <script type="text/javascript">
'use strict';
		var myApp = angular.module('myApp',[]);
	
		myApp.factory('UserService', ['$http', '$q', function($http, $q)
		{
	 
    	return {
         
    		deleteAllFromCart: function(item){
                    return $http.post('http://localhost:8086/trendz/flows/deleteAllFromCart/', item)
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
	
	
	myApp.controller("page4",['$scope', 'UserService' ,function($scope , $UserService)
	{
		$UserService.deleteAllFromCart();
	}]); 
	
</script>
    <c:import url="/head"></c:import>
    <body ng-app="myApp" ng-controller="page4">
    
    <br><br><br><br><br>
<div class="container">
  <a href="${pageContext.request.contextPath}/index" class="btn btn-success btn-lg btn pull-left">
  Home</a>
 <h1>Your order will be dispatched soon</h1>
  </div>
<br>

	</body>