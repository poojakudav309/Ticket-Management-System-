
<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css"/>


<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet"> 	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">	

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

table,input,p{
	margin-left: 60px;
}
#myInput {
    background-image: url('search_icon.png'); /* Add a search icon to input */
    background-position: 10px 12px; /* Position the search icon */
    background-repeat: no-repeat; /* Do not repeat the icon image */
    width: 100%; /* Full-width */
    font-size: 16px; /* Increase font-size */
    padding: 12px 20px 12px 40px; /* Add some padding */
    border: 1px solid #ddd; /* Add a grey border */
    margin-bottom: 12px; /* Add some space below the input */
}
#myTable {
    border-collapse: collapse; /* Collapse borders */
width: 100%; /* Full-width */
border: 1px solid #ddd; /* Add a grey border */
font-size: 18px; /* Increase font-size */
}

#myTable th, #myTable td {
text-align: right; /* Left-align text */
padding: 12px; /* Add padding */
}

#myTable tr {
/* Add a bottom border to all table rows */
border-bottom: 1px solid #ddd; 
}

#myTable tr.header, #myTable tr:hover {
/* Add a grey background color to the table header and on hover */
background-color: #f1f1f1;
}

* {box-sizing: border-box}
body {font-family: "Lato", sans-serif;}

/* Style the tab */
.tab {
    float: left;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
    width: 20%;
    height: 800px;
}

/* Style the buttons inside the tab */
.tab button 
{
    display: block;
    background-color: inherit;
    color: black;
    padding: 22px 16px;
    width: 100%;
    height: 7%;
    border: none;
    outline: none;
    text-align: left;
    cursor: pointer;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current "tab button" class */
.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    float: right;
    padding: 0px 12px;
    //border: 1px solid #ccc;
    width: 70%;
    border-left: none;
    height: 800px;
}
</style>

</head>
<nav class="navbar navbar-expand-sm bg-info navbar-dark">
  
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/Ticket_Management/TicketDisplayController">Dashbord</a>
      <a class="nav-item nav-link active" href="ticket.jsp">Raise Ticket</a>
      <a class="nav-item nav-link active" href="profile.jsp">Profile</a>
      <a class="nav-item nav-link active"  href="logout.jsp">Logout</a>
    </div>
  </div>
</nav>
<!--  
<body>



    
</body>
</html> 
-->