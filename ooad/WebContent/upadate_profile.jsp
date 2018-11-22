<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="header.jsp" %>
<form id="user_profile" >
  <h3> User Name: ${userdetails.username}  </h3>
  <input type="text" value="${userdetails.username}">
 &nbsp; &nbsp; &nbsp;First Name:  <input type="text" value="${userdetails.firstName}"> <br>

 &nbsp; &nbsp; &nbsp;Last Name: <input type="text" value="${userdetails.lastName}"><br>
 &nbsp; &nbsp; &nbsp;Email:  ${userdetails.email}<br>
 &nbsp; &nbsp; &nbsp;Phone:  ${userdetails.phone}<br>
 &nbsp; &nbsp; &nbsp;Role:  ${userdetails.role}<br>
 &nbsp; &nbsp; &nbsp;Gender:  ${userdetails.gender}<br>
 &nbsp; &nbsp; &nbsp;Team:   ${userdetails.team}<br>
  

</form>

</body>
</html>