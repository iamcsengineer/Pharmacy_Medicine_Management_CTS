<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <style type="text/css">
		body{
			background-image: url('/image/homemedium.jpg');
			background-size: 1040px 650px;
		}
		.col-6{
			width: 40%;
			opacity: 0.9;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<div class="container" style="margin-top: 300px;">
		<div class="row justify-content-md-center ">
			<div class="card col-6 ">
  		  		<div class="card-body">
    				<h5 class="card-title" style="text-align: center;">View Schedule</h5>
    			<p class="card-text">
    			<p style="text-align: center;">Click to view Medical Representative Schedule</p> 
    			</p>
    			<a href="checkSchedule" class="btn btn-primary" style="margin-left: 95px;">View Schedule</a>
    			</div>
			</div>
			<div class="card col-6" style="margin-left: 20px;">
		  		<div class="card-body">
    			<h5 class="card-title" style="text-align: center;">Place Demand</h5>
    			<p class="card-text">
    			<p style="text-align: center;">Place the medicine demand from stock
    			</p> 
    			</p>
    			<a href="/viewDemand" class="btn btn-primary" style="margin-left: 95px;">Place Demand</a>
  		  		</div>
			</div>
		</div>
	</div>
</body>
</html>