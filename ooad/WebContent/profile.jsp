
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="header.jsp" %>

<div id="user_profile" >
  <h3> User Name: ${userdetails.username}  </h3>
 &nbsp; &nbsp; &nbsp;First Name: ${userdetails.firstName} <br>
 &nbsp; &nbsp; &nbsp;Last Name:  ${userdetails.lastName}<br>
 &nbsp; &nbsp; &nbsp;Email:  ${userdetails.email}<br>
 &nbsp; &nbsp; &nbsp;Phone:  ${userdetails.phone}<br>
 &nbsp; &nbsp; &nbsp;Role:  ${userdetails.role}<br>
 &nbsp; &nbsp; &nbsp;Gender:  ${userdetails.gender}<br>
 &nbsp; &nbsp; &nbsp;Team:   ${userdetails.team}<br>
  

</div>
<a href="update_profile.jsp">update profile</a>
</body>
</html>