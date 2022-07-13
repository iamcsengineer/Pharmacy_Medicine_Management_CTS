<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Date</title>
<style type="text/css">
		body{
			background-image: url('/image/schedulebg3.jpg');
			background-size: 1040px 640px;
		}
	</style>
</head>
<body>
<%@ include file="common/header.jsp"%>
	<div class="container" style="margin-top: 40px;">
		<div class="row justify-content-md-center ">
			<div class="card col-6 " style="width: 40%;/*margin-left: 455px*/">
		 		<img class="card-img-top" src="/image/schedule.jpg" alt="Card image cap" style="background-size: 220px 200px">
  		  		<div class="card-body">
    				<h5 class="card-title" style="text-align: center;">Enter Date</h5>
    			<p class="card-text">
    			<p style="text-align: center;">Appointments Displayed for next 5 days </p> 
    			</p>
    			<form action="/checkSchedules" method="GET" model="Datedto">
	  				<label for="date" style="margin-right:5px">Enter Date:</label>
					  <input type="date" id="date" name="date" style="text-align: center;">
 			   		  <input type="submit" class="btn btn-primary" style="margin-left: 115px;margin-top: 12px;">
				</form>
  		  		 </div>
			</div>
		</div>
	</div>
</body>
</html>