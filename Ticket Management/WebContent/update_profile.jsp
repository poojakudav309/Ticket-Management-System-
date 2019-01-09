
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Update Profile</title>
<%@include file="header.jsp" %>



<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   <form id="user_profile" action="updateProfile" method="post" >
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
                        <td><input type="text" id="first_name" name="first_name" value="${userdetails.firstName}"></td>
                      </tr>
                      <tr>
                        <td>Last Name:</td>
                        <td><input type="text" id="last_name" name="last_name" value="${userdetails.lastName}"></td>
                      </tr>
                      <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" id="email" value="${userdetails.email}"></td>
                      </tr>
                   
                       <tr>
                        <td>Phone: </td>
                        <td> <input type="text" name="phone" id="phone" value="${userdetails.phone}"> </td>
                      </tr>
                        <tr>
                        <td>Role:</td>
                        <td><input type="text" name="role" id="role" value="${userdetails.team}"></td>
                      </tr>
                      <tr>
                        <td>Gender: </td>
                        <td><input type="text" name="gender" id="gender" value="${userdetails.gender}"></td>
                      </tr>
                      <tr>
                        <td>Team:</td>
                        <td> ${userdetails.team}</td>
                      </tr>
                     
                    </tbody>
                  </table>
                 <input type="submit" name="submit" value="updateProfile" id="submit-profile">
                </div>
              </div>
            </div>
            
          </div>
          </form>
        </div>


	
</body>
</html>