

<%@include file="header.jsp" %>
<form action="ticket" method="get">
<input type="text" id="id"/>
<button type="submit">submit</button>
</form>
<table class="table table-hover" >
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