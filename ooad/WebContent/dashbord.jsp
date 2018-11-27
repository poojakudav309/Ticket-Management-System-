<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>


<%@include file="header.jsp" %>

<div id="Dashboard" >
  <h3> Hello : ${username}</h3>
  <p > Dashboard</p>



<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for tickets." style="width:50%" >
<table class="table table table-hover" id="myTable" style="width:70%" >
<c:forEach items="${list}" var="l" >
    <tr>
       	<td class="id"> ${l.id} </td>
        <td>${l.priority}</td>
        <td>${l.description}</td>
        <td>${l.status}</td>
        <td>${l.type}</td>
        <td ><button class="cmt" >view comments</button></td>
               
    </tr>
    
</c:forEach>
</table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

$(".cmt").click(function(e) {
    	  e.preventDefault(); 
    $.ajax({
           type: "GET",
           url: "comment",
           data: "tic_id="+21 // serializes the form's elements.
           
         });

    // avoid to execute the actual submit of the form.
});


function myFunction() {
	  // Declare variables 
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    } 
	  }
	}


</script>

</body>
</html>     
       
       
