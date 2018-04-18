<%-- 
    Document   : login
    Created on : Apr 8, 2018, 2:59:57 AM
    Author     : William Orgertrice, Ayanna Shaheed and Julian Sosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Login JSP Page</title>
    </head>
    <body>
        <form action="loginController" style= "border:1px solid #ccc" method="POST">
  <div class="container">
    <h1>Login</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    
    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label>
    
    <div class="clearfix">
        <button type="button" class="cancelbtn"><a href="redirect.jsp" style="text-decoration: none; color: black;">Cancel</a></button>
      <button type="submit" class="signupbtn">Login</button>
    </div>
    <div class="container" style="background-color: lightcyan">
        New user? <a href="register.jsp">Create an Account.</a>
        </div>
  </div>
</form>
        <script src="Project3.js">
            
        </script>
    </body>
</html>
