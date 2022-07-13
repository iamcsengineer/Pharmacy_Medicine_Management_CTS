<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="style/viewDemand-style.css">
    <title>View Demand</title>
    <style>
    body{
    	background-image:url("/image/viewdemand1.jpg");
    	background-size: 1040px 650px;
    }
    </style>
</head>
<body>
    
    <%@ include file="common/header.jsp"%>
      <br>
    <div class="container">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6 ">
                <div class="card text-center shadow-lg">
					<img class="card-img-top img-fluid" src="/image/viewdemandup1.jpg" style="width:600x;height:300px;" alt="Card image cap">
					<div class="card-body">
                <table>
                    <tr class="odd">
                        
                        <td class="quantity">
                            <form action="/SupplyAvailed">
                            	<label for="med" style="float:left">Enter Medicine Name: </label>
                            	<select id="med" name="name" style="float:right">
    								<option value="Orthoherb">Orthoherb</option>
    								<option value="Cholecalciferol">Cholecalciferol</option>
    								<option value="Gaviscon">Gaviscon</option>
    								<option value="Dolo-650">Dolo-650</option>
    								<option value="Cyclopam">Cyclopam</option>
    								<option value="Hilact">Hilact</option>
  								</select><br><br>
  								<label for="demCount" style="float:left">Enter Demand Count: </label>
                                <input type="number" id="demCount" class="rounded-pill shadow-sm border-0 demand-input" name="demand" required>
                                <br><br>
                                <input type="submit" class="btn float-right btn-outline-light rounded-pill submit-btn" style="background-color:#add8e6;">
                            </form>
                            
                        </td>
                    </tr>
                    
                </table>
               <font color="red" style="text-align:center;">${errorMessage}</font>
            </div>
            </div>
            </div>
		</div>
    </div>
</body>
</html>