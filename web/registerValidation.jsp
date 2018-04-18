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
          String firstName = request.getParameter("firstName");
          String lastName = request.getParameter("lastName");
          String username = request.getParameter("username");
          String password = request.getParameter("password");
          Boolean isAdmin = null!=request.getParameter("admin");
          
          if(userbeans.isRegistered(firstName, lastName, username, password, isAdmin))
          {
            out.println("You have successfully registered!<br/>");
            out.println("Proceed to <a href='login.html'>login</a>.");
          }
          else
          {
            out.println("Invalid entry!<br />");
            out.println("<a href='login.jsp'>Try again.</a>");
          }
        %>
        </h1>
    </body>
</html>
