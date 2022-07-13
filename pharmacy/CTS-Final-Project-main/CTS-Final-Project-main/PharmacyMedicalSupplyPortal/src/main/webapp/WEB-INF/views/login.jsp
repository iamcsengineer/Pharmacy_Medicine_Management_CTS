<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<style type="text/css">
		body{
			background-image: url('/image/login2.jpg');
			background-size: 1040px 640px;
		}
		.round{
			border-radius: 30px;
			border: 2px solid white;
			text-align: center;
			width:40%;
			margin-top: 200px;
			margin-bottom:20px;
		}
	</style>
</head>
<body>
	
<div class="container">
		<div>
			<h3 class="display-4 round">Login</h3>
		</div>
		<form action="/login" method="POST" name="loginform" modelAttribute="userData">
		<input id="username" type="text" name="userid" placeholder="Company ID" class="form-control rounded-pill border-0 shadow-sm px-4" style="width: 40%;">

		<input id="password" type="password" name="upassword" placeholder="Password"
		class="form-control rounded-pill border-0 shadow-sm px-4" style="width: 40%;margin-top: 5px;margin-bottom: 5px;"
		>
		<button type="submit" name="submit" class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm" style="margin-left:150px; ">Sign in</button>
		<div class="text-center d-flex justify-content-between mt-4"><p>${errormsg}</u></p></div>
		</form>
</body>
</html>