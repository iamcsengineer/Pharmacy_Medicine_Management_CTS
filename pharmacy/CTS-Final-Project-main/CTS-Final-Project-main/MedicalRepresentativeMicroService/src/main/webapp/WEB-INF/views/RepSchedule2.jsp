<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Appointment Schedule</title>
</head>
<body>

<table>
	<tr>
		<th>Rep Name</th>
		<th>Doctor Name</th>
		<th>Treating Ailment</th>
		<th>Medicine</th>
		<th>Slot Booked</th>
		<th>Date</th>
		<th>Doctor Contact</th>
	</tr>
	<tbody>
		<c:forEach items="${schedule}" var="detail">
		<tr>
			<th>${schedule.getMedicalRepName()}
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