<%@page import="CSC4370.Controllers.cartbeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beans" class="CSC4370.Controllers.userbeans" scope="session" />
<jsp:setProperty name="beans" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <%
            Double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Double price = quantity*unitPrice;
            if(cartbeans.addToCart(price, quantity))
            {
        %>
        <h1 style="text-align: center">Successfully added to the cart!<br>
            Continue <a href="shop.jsp">shopping</a> or go to your <a href="cart.jsp">cart</a>.</h1>
        <%
            }else{
        %>
                <h1 style="text-align: center">Error! Could not add to cart.<br>
                Return <a href="index.htm">home</a>.</h1> 
        <%
            }
        %>
    </body>
</html>
