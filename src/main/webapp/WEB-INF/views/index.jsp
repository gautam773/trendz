<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>

<head>
<c:import url="/head-meta"/>




</head>

<body style=" background-image: url(${pageContext.request.contextPath}/resources/images/bg.jpg); ">

<c:import url="/head"/>




 	<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="${pageContext.request.contextPath}/resources/images/1.jpg" alt="1" width="460" height="200">
      </div>
	  <div class="item">
        <img src="${pageContext.request.contextPath}/resources/images/2.jpg" alt="2" width="460" height="200">
      </div>
	  <div class="item">
        <img src="${pageContext.request.contextPath}/resources/images/3.jpg" alt="3" width="460" height="200">
      </div>
	  </div>
<!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
      
<br>
   	<div style="
                    color: #000000;
                    text-align: center;
                    vertical-align: middle;
                    line-height: 10px;
                    border: 0px solid #FFC706;
                    box-shadow: 5px 25px 40px #555555;
                    font-style: italic;
                    font-weight: bold;
                    font-size: 14px;
                    font-family: Segoe UI, Tahoma, sans-serif;
                    
      				
                " class="container-fluid carousel slide" >
                <div class="row">
                <br>
                <br>
	                <div class="col-md-4">
		                <a href="product?searchKey=Beds" ><div class="img-circle img-responsive nopadding center_img" style="background-image: url(resources/images/7.jpg); background-size: 280px 220px; width: 280px ; height: 220px;" > <a align="center" href="product?searchKey=tshirt" style="line-height: 340px; font-size: 140%; background-color: #CCCCCC;" >&nbsp; Tshirt &nbsp;</a> </div></a>
		                <br><br>
		                <p style="font-weight: none; font-size: 12px; font-style: none; line-height: 20px;">Tshirt makes your life more comfortable</p>
	                </div>
	                
	                <div class="col-md-4">
		                <a href="product?searchKey=Book+Shelves" ><div class="img-circle img-responsive nopadding center_img" style="background-image: url(resources/images/6.jpg); background-size: 280px 220px;background-repeat: no-repeat;width: 280px ; height: 220px;" > <a align="center" href="product?searchKey=shirt" style="line-height: 340px; font-size: 140%; background-color: #CCCCCC;" >&nbsp;Shirt&nbsp;</a> </div></a>
		                <br><br>
		                <p style="font-weight: none; font-size: 12px; font-style: none; line-height: 20px;">Variety of shirts makes you really satisfied</p>
	                </div>
	                
	                <div class="col-md-4">
		                <a href="product?searchKey=Sofas" ><div class="img-circle img-responsive nopadding center_img" style="background-image: url(resources/images/5.jpg); background-size: 280px 220px; width: 280px ; height: 220px;" > <a align="center" href="product?searchKey=trouser" style="line-height: 340px; font-size: 140%;background-color: #CCCCCC;" > &nbsp;Trousers&nbsp; </a> </div></a>
		                <br><br>
		                <p style="font-weight: none; font-size: 12px; font-style: none; line-height: 20px;">Enjoy with the collection of trousers</p>
	                </div>
                
                </div>
                
                
                <br><br>
                
	                
					
				</div>
  	
 	

 	



</body>
</html>
