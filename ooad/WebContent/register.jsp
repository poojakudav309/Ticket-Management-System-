<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>

</head>
<body>
<form name="regform" action="LoginController" method="post" onsubmit="return regValidate()">
	<br>${message}<br>

	Username  : <input type="text" name="username"> <br>
	<div id="username_error"></div><br>
	First name: <input class="form-control" type="text" name="first_name"><br><br>
	Last name : <input type="text" name="last_name"><br><br>
	Email     :<input type="text" name="email"><br><br>
	Phone     : <input type="text" name="phone"><br><br>
	Team      :<input type="text" name="team"><br><br>
	Role      : <input type="text" name="role"><br><br>
	Gender    :<input type="text" name="gender"><br><br>
	Password  : <input type="password" name="password" id="password"> <br>
	<br>
	Re-Type Password: <input type="password" name="retry-password" id="retry-password"> 
	<br>
	<div id="password_error"></div><br>
	
	<input type="submit" name="submit"  class="btn btn-default" value="register" >
	<input type="reset" name="reset">
	
	</form>
	
</body>
</html>