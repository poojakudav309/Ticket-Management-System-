
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Profile</title>
<%@include file="header.jsp" %>



<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">${username}</h3>
            </div>
            <div class="panel-body col-md-10">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="default.png" class="img-circle img-responsive"> </div>
                
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>First Name:</td>
                        <td>${userdetails.firstName}</td>
                      </tr>
                      <tr>
                        <td>Last Name:</td>
                        <td><p>${userdetails.lastName}</p></td>
                      </tr>
                      <tr>
                        <td>Email:</td>
                        <td>${userdetails.email}</td>
                      </tr>
                   
                       <tr>
                        <td>Phone: </td>
                        <td>${userdetails.phone}</td>
                      </tr>
                        <tr>
                        <td>Role:</td>
                        <td>${userdetails.role}</td>
                      </tr>
                      <tr>
                        <td>Gender: </td>
                        <td>${userdetails.gender}</td>
                      </tr>
                      <tr>
                        <td>Team:</td>
                        <td> ${userdetails.team}</td>
                      </tr>
                     
                    </tbody>
                  </table>
                  <a href="update_profile.jsp" class="btn btn-primary" >Update Profile</a>
                </div>
              </div>
            </div>
            
          </div>
        </div>


	
</body>
</html>