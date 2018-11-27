
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="header.jsp" %>


<div margin="40px">
<table	 class="table" >
<c:forEach items="${com}" var="l">
		<div class="well">
      <div class="media">
      	<a class="pull-left" href="#">
    		<img class="media-object" src="default.png" width="100px" height="100px">
  		</a>
  		<div class="media-body">
    		<h4 class="media-heading"><b>${l.username} </b></h4>
          <p class="text-right">${l.username} </p>
          <p><h3>${l.post}</h3> </p>
          <ul class="list-inline list-unstyled">
  			<li><span><i class="glyphicon glyphicon-calendar"></i> ${l.date} </span></li>
            <li>|</li>
            <span><i class="glyphicon glyphicon-comment"></i> ${l.time} </span>
            <li>|</li>
            <span><i class="glyphicon glyphicon-comment"></i> ${l.username} </span>
            <li>|</li>
			</ul>
       </div>
    </div>
  </div>
  
</c:forEach>
</table>
</div>
<div>
<form id="add_comment" class="form-group" action="comment">
 <textarea class="form-control" rows="3" placeholder="Write your comment here!" id="post1" name="post1"></textarea>
 <button type="submit" id="bt">Share</button>
</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

$("#add_comment").submit(function(e) {
    var form = $(this);
    var url = form.attr('action');
    var x=${userId}
    e.preventDefault(); 
    $.ajax({
           type: "POST",
           url: url,
           data: form.serialize()+"&userid="+x+"&tic_id="+21, // serializes the form's elements.
           success: function(data)
           {
               location.reload(); // show response from the php script.
           }
         });

    // avoid to execute the actual submit of the form.
});



</script>
</body>
</html>