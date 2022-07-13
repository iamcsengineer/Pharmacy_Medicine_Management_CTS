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
background-image: url("/image/MEDIUMREP.jpg");
background-repeat: no-repeat;
  background-size: 1100px 700px;
   font-family: "Lucida Console", "Courier New", monospace;
}
h1{
color:white;
}
th{
color:rgb(255, 255, 102);

}
</style>
</head>
<body>
	<%-- HEADERS TO BE INCLUDED
	<%@ include file="common/customerHeaderHome.jsp"%> --%>
	<h1>REPRESENTATVES MEETING SCHEDULE</h1>
<table class="table table-bordered">
	<thead class="thead-light">
		<tr>
			<th>Rep Name</th>
			<th>Doctor Name</th>
			<th>Treating Ailment</th>
			<th>Medicine</th>
			<th>Slot Booked</th>
			<th>Date</th>
			<th>Doctor Contact</th>
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