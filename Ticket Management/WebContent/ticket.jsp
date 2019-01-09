
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
	
<!-- 	
&nbsp;&nbsp;&nbsp;	To:  <input type="text" name="to" id="to"><br><br>
&nbsp;&nbsp;&nbsp;	Description:<input type="text" name="description" id="description"><br><br>
&nbsp;&nbsp;&nbsp;	Type: <input type="text" name="type" id="type"><br><br>
	 -->		
	
    <table width="50%" border="0" cellspacing="0" cellpadding="5">
    	<tr>
    	<td  align="left" valign="left">		
			Description:<input type="text" name="description" id="description"><br>
		</td>
	 </tr>
      <tr>
        <td width="41%" align="left" valign="left"> Ticket Type :</td>
        <td width="59%" align="left" valign="left">
          <select name="category1" id="category1">
            <option value="">Select Type</option>
            <option value="it">IT</option>
            <option value="hr">HR</option>
          </select>
        </td>
      </tr>
      <tr>
        <td width="41%" align="left" valign="left">Ticket Category :</td>
        <td width="59%" align="left" valign="left">
          <select name="category2" id="category2">
            <option value="">Select Category</option>
            <option value="software">Software</option>
            <option value="hardware">Hardware</option>
            <option value="leaves">Leaves</option>
          </select>
        </td>
      </tr>
      <tr>
        <td width="41%" align="left" valign="left">Ticket SubType :</td>
        <td width="59%" align="left" valign="left">
          <select name="category3" id="category3">
            <option value="">Select SubType</option>
            <option value="packages">Packages</option>
            <option value="desktopapps">Desktop Apps</option>
            <option value="nmt">Network Monitoring Tools</option>
            <option value="laptop">Laptop</option>
            <option value="desktop">Desktop</option>
            <option value="upto10">upto 10</option>
            <option value="upto20">upto 20</option>
            <option value="upto30">upto 30</option>
          </select>
        </td>
      </tr>
	<tr><td align="left" valign="left">	
	Priority:<input type="text" name="type" id="priority"></td></tr>
</table>
	<input type="submit"  class="btn btn-submit"name="submit" id="submit-ticket" value="submit"><br>
	
	
	
	
	</form>

	
	
</body>
</html>