
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<title>add ticket</title>
<%@include file="header.jsp" %>
<body>
<div  id="final_result">
  <strong>${successMessage}</strong>
</div>
<form name="ticketCreate" action="ticket" method="post" >
	<br>
	
	
&nbsp;&nbsp;&nbsp;	To:  <input type="text" name="to" id="to"><br><br>
&nbsp;&nbsp;&nbsp;	Description:<input type="text" name="description" id="description"><br><br>
&nbsp;&nbsp;&nbsp;	Type: <input type="text" name="type" id="type"><br><br>
&nbsp;&nbsp;&nbsp;	Priority:<input type="text" name="type" id="priority"><br><br>
	<input type="submit"  class="btn btn-submit"name="submit" id="submit-ticket" value="submit"><br>
	
	
	
	
	</form>
</body>
</html>