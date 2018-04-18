<%-- 
    Document   : inventory
    Created on : Apr 8, 2018, 3:03:01 AM
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
        <title>JSP Page</title>
    </head>
    <body>
    <form action="../src/java/CSC4370/cartController.java">
        <input type="text" name="quantity" >
        <input type="hidden" name="productID" value="1">
        <input type="hidden" name="name" value="1">
        <input type="hidden" name="company" value="1">
        <input type="hidden" name="unitPrice" value="1">
        <input type="submit" value ="Add to cart">
    </form>    
    <form action="../src/java/CSC4370/cartController.java">
        <input type="text" name="quantity" >
        <input type="hidden" name="productID" value="1">
        <input type="hidden" name="name" value="1">
        <input type="hidden" name="company" value="1">
        <input type="hidden" name="unitPrice" value="1">
        <input type="submit" value ="Add to cart">
    </form>    
    </body>
</html>
