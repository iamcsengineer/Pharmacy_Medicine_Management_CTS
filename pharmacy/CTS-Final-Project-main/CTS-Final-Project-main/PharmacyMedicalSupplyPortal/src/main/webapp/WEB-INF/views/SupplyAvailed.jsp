<!DOCTYPE html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="style/viewDemand-style.css">
    <title>Stock Available</title>
    <style>
    body{
    	background-image:url("/image/viewsuppply2.jpg");
    	background-size: 1030px 650px;
    }
    th,td{
    color:black;
    font-weight:bold;
    font-size:18px;
    }
    </style>
</head>

<body>
    <%@ include file="common/header.jsp"%>
      <br>
        <div class="row">
            <div class="col-lg-1"></div>    
            <table class="table table-hover">
			<thead>
				<tr>
					<th style="text-align:center">Pharmacy</th>
					<th style="text-align:center">Medicine</th>
					<th style="text-align:center">Stock Available</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pharmacyList}" var="ph"><br>
					<tr style="border:1px solid white">
						<td style="text-align:center">${ph.pharmacyName}</td>
						<td style="text-align:center">${ph.medicineName}</td>
						<td style="text-align:center">${ph.supplyCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>      
            </div>
</body>
</html>