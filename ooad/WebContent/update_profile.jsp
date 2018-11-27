
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="header.jsp" %>
<div>
<form id="user_profile" >
  <h3> User Name: ${userdetails.username}  </h3>
  <input type="hidden" value="${userdetails.username}">
 &nbsp; &nbsp; &nbsp;First Name:  <input type="text" value="${userdetails.firstName}"> <br>

 &nbsp; &nbsp; &nbsp;Last Name: <input type="text" value="${userdetails.lastName}"><br>
 &nbsp; &nbsp; &nbsp;Email:  <input type="text" value="${userdetails.email}"><br>
 &nbsp; &nbsp; &nbsp;Phone:  <input type="text" value="${userdetails.phone}"> <br>
 &nbsp; &nbsp; &nbsp;Role: <input type="text" value="${userdetails.role}"> <br>
 &nbsp; &nbsp; &nbsp;Gender: <input type="text" value="${userdetails.gender}"> <br>
 &nbsp; &nbsp; &nbsp;Team:   <input type="text" value="${userdetails.team}"> <br>
  
<button type="submit">update</button>
</form>
</div>
</body>
</html>