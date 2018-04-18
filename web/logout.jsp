<%@page import="CSC4370.Controllers.userbeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beans" class="CSC4370.Controllers.userbeans" scope="session" />
<jsp:setProperty name="beans" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%
          userbeans.logout();
        %>
        <h1 style="text-align: center">
            You have successfully logged out!<br>
            Return to <a href='index.html'>home</a>.
        </h1>
    </body>
</html> 

