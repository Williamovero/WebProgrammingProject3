<%@page import="CSC4370.Controllers.userbeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beans" class="CSC4370.Controllers.userbeans" scope="session" />
<jsp:setProperty name="beans" property="*" />  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1 style="text-align: center">
        <%
          String username = request.getParameter("username");
          String password = request.getParameter("password");
          beans.login(username, password);
          if(userbeans.isLoggedIn())
          {
            out.println("You have successfully logged in as "+ userbeans.getUsername()+"!<br/>");
            out.println("Proceed to <a href='index.htm'>home</a>.");
          }
          else
          {
            out.println("Invalid entry!<br />");
            out.println("<a href='login.html'>Try again.</a>");
          }
        %>
        </h1>
    </body>
</html>
