<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<title>Search</title>
<%@include file="header.jsp" %>

<div id="Search" >
 <h3> Hello : ${username}</h3>
  <p> Search Results</p>


<form method="post" action="TicketDisplayController" id="searchbox">
<input type="text" id="myInput" name="search"  placeholder="Search for tickets." style="width:50%" >
<button type="submit">search</button>
</form>

<h3>My Tickets</h3>

<table class="table table table-hover" id="myTable" style="width:70%" >
<c:forEach items="${object.raised_by_me}" var="l" >
    <tr>
       	<td > ${l.id} </td>
        <td>${l.priority}</td>
        <td>${l.description}</td>
        <td>${l.status}</td>
        <td>${l.type}</td>
       
        <td><button type="submit" onclick="viewComment(this)" name="viewComment" value="comments_${l.id}">View Comments</button></td>      
    </tr>
    
</c:forEach>
</table>

<br>
<br>

<h3>Tickets Assigned to Me</h3>

<table class="table table table-hover" id="myTable2" style="width:70%" >
<tr>
	<th>id</th>
	<th>Priority</th>
	<th>Description</th>
	<th>status</th>
	<th>Type</th>
	<th>Accept</th>
	<th>Deny</th>
	<th>Comments</th>
	
	</tr>
<c:forEach items="${object.assigned_to_me}" var="l" >
    <tr>
        <td class="nr">${l.id}</td>
        <td>${l.priority}</td>
        <td>${l.description}</td>
        <td>${l.status}</td>
        <td>${l.type}</td>
        <td><button type="submit" onclick="resolveTicket(this)" name="approve" value="approve_${l.id}">Approve</button></td>
        <td><button type="submit" onclick="resolveTicket(this)" name="deny" value="deny_${l.id}">Deny</button></td>
       
        <td><button type="submit" onclick="viewComment(this)" name="viewComment" value="comments_${l.id}">View Comments</button></td>            
    </tr>
</c:forEach>
</table>

<h3>Closed Tickets</h3>

<table class="table table table-hover" id="myTable3" style="width:70%" >
<tr>
	<th>id</th>
	<th>Priority</th>
	<th>Description</th>
	<th>status</th>
	<th>Type</th>
	<th>Comments</th>
	
	</tr>
<c:forEach items="${object.closed}" var="l" >
    <tr>
        <td class="nr">${l.id}</td>
        <td>${l.priority}</td>
        <td>${l.description}</td>
        <td>${l.status}</td>
        <td>${l.type}</td>
        <td ><input class="cmt" type="button" value="viewComment" onclick="return viewComment()"></td>      
    </tr>
</c:forEach>
</table>

<h3>Closed Tickets By Me</h3>

<table class="table table table-hover" id="myTable4" style="width:70%" >
<tr>
	<th>id</th>
	<th>Priority</th>
	<th>Description</th>
	<th>status</th>
	<th>Type</th>
	<th>Comments</th>
	
	</tr>
<c:forEach items="${object.closedbyme}" var="l" >
    <tr>
        <td class="nr">${l.id}</td>
        <td>${l.priority}</td>
        <td>${l.description}</td>
        <td>${l.status}</td>
        <td>${l.type}</td>
        <td ><input class="cmt" type="button" value="viewComment" onclick="return viewComment()"></td>      
    </tr>
</c:forEach>
</table>




</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

/*$("#searchbox").submit(function(e) {
    var form = $(this);
    var url = form.attr('action');
    var x=${userId}
    e.preventDefault(); 
    $.ajax({
           type: "post",
           url: url,
           data: form.serialize()+"&userid="+x, // serializes the form's elements.
           success: function(data)
           {
               location.reload(); // show response from the php script.
           }
         });

    // avoid to execute the actual submit of the form.
});*/

function resolveTicket(t) {
	//console.log(t.value);
	var value = t.value.split("_");
	var action = value[0];
	var id = value[1];
	$.ajax({
        url:'ticket',
        type:'put',
        data:{tic_id:id,action:action},
        contentType:'application/json',
        success: function(data) {
        	 window.location='TicketDisplayController';
         
        },
        error: function(xhr){
            alert('something is b0rked')
          
        }
    });
}

$("#com").submit(function(e) {
    var form = $(this);
    var url = form.attr('action');
    var x=${userId}
    e.preventDefault(); 
    $.ajax({
        url:'comment',
        type:'post',
        data:form.serialize()+"&tic_id="+$row,
        success: function(data) {
        	 window.location='comment';
         
        },
        error: function(xhr){
            alert('something is b0rked')
          
        }
    });

    // avoid to execute the actual submit of the form.
});

function viewComment(t) {
	var value = t.value.split("_");
	var action = value[0];
	var id = value[1];
	  
	  console.log(action);
	  console.log(id);
    $.ajax({
        url:'comment?id='+id,
        type:'get',
        success: function(data) {
        	 window.location='comment?id='+id;
         
        },
        error: function(xhr){
            alert('something is b0rked')
          
        }
    });
}




	


</script>

</body>
</html>     
       
       
