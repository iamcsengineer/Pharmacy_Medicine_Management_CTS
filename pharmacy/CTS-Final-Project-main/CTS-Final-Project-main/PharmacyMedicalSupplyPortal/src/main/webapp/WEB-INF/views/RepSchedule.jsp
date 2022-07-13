<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Appointment Schedule</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/name.css/" type="text/css" />
<script src="/js/bootstrap.min.js"></script>
<style type="text/css">
body{
background-image: url("/image/schedulepic3.jpg");
background-repeat: no-repeat;
  background-size: 1100px 700px;
  font-family: serif;
}
h4{
color:#ffbd03;
text-align:center;
font-size:28px;
font-weight:bold;
}
th{
color:rgb(255, 255, 102);
}
tr{
font-size:18px;
font-weight:bold;}
</style>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<h4>REPRESENTATIVES MEETING SCHEDULE</h4>
<table class="table table-hover" style="margin-top:124px">
	<thead >
		<tr>
			<th style="color:red;">Rep Name</th>
			<th style="color:red;">Doctor Name</th>
			<th style="color:red;">Treating Ailment</th>
			<th style="color:red;">Medicine</th>
			<th style="color:red;">Slot Booked</th>
			<th style="color:red;">Date</th>
			<th style="color:red;">Doctor Contact</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${schedule}" var="schedule">
		<tr>
			<th scope="row">${schedule.getMedicalRepName()}
			<th>${schedule.getDoctorName()}
			<th>${schedule.getTreatingAilment()}
			<th>${schedule.getMedicine()}
			<th>${schedule.getMeetingSlot()}
			<th>${schedule.getDate_Of_Meeting()}
			<th>${schedule.getDoctorNumber()}
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>