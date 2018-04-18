<%-- 
    Document   : register
    Created on : Apr 8, 2018, 3:01:34 AM
    Author     : William Orgertrice, Ayanna Shaheed and Julian Sosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beans" class="CSC4370.Controllers.userbeans" scope="session" />
<jsp:setProperty name="beans" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <!-- Responsive Layout -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="Project3.css">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <!-- Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet'  type='text/css'>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login.jsp" style="border:1px solid #ccc" method="POST">
  <div class="container">
      <table border="1">
          <tr>
    <h1>Sign Up</h1>
      </tr>
      <tr>
    <p>Please fill in this form to create an account.</p>
</tr>

    <label for="email"><strong>Email</strong></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label for="psw"><strong>Password</strong></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

    <label for="psw-repeat"><strong>Repeat Password</strong></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" required>

    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label>

    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
      </table>
  </div>
</form>
    </body>
</html>
