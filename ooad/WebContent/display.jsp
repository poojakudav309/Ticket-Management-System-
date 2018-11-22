<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Display Ticket</title>
<%@include file="header.jsp" %>
<form action="ticket" method="get">
<input type="text" id="id"/>
<button type="submit">submit</button>
</form>
<table class="table table-dark table-hover" >
<c:forEach items="${list}" var="l">
    <tr>
       
        <td>${l.priority}</td>
       
        <td>${l.description}</td>
        <td>${l.status}</td>
        <td>${l.type}</td>
        
       
       
    </tr>
    
</c:forEach>
</table>
</body>
</html>