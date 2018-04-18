<%@page import="java.sql.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="java.io.*"%>
<jsp:useBean id="beans" class="CSC4370.Controllers.userbeans" scope="session" />
<jsp:setProperty name="beans" property="*" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    <style>
* 
{
    box-sizing: border-box;
}
.columns 
{
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 33.3%;
    padding: 8px;
}
.price 
{
    list-style-type: none;
    border: 1px solid #eee;
    margin: 0;
    padding: 0;
    -webkit-transition: 0.3s;
    transition: 0.3s;
}
.price:hover 
{
    box-shadow: 0 8px 12px 0 rgba(0,0,0,0.2)
}
.price .header 
{
    background-color: blueviolet;
    color: white;
    font-size: 25px;
}
.price li 
{
    border-bottom: 1px solid lightcyan;
    padding: 20px;
    text-align: center;
}
.price .grey 
{
    background-color: lightcyan;
    font-size: 20px;
}
.button 
{
    background-color: #00cc00;
    border: none;
    color: white;
    padding: 10px 25px;
    text-align: center;
    text-decoration: none;
    font-size: 18px;
}
@media only screen and (max-width: 600px) 
{
    .columns 
    {
        width: 100%;
    }
}
#home 
{
    position: absolute;
    top: 0;
    left:0px;
    font-size: 15px;
    color:graytext;
    padding: 5px;
}
</style>
</head>
<body>
<span id="home"><a href="index.htm">Back To Home</a></span>
<h2 style="text-align:center">Vitamins and Dietary Supplements</h2>
<%
    if(beans.isLoggedIn()) {
%>
<p style="text-align:center">Add to your cart the product you would like to purchase.</p>
<%  try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection  con=DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","jsosa","jsosa");
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select * from inventory");      
while(rs.next())
{
%>
<form action="addToCart.jsp" method="Post">
<div class="columns">
  <ul class="price">
    <li class="header"><%=rs.getString("productName")%></li>
    <li class="grey">$<%=rs.getDouble("unitPrice")%></li>
    <input type="hidden" name="unitPrice" value="<%=rs.getDouble("unitPrice")%>">
    <li><%=rs.getInt("inStock")%> Currently in Stock</li>
    <li><%=rs.getString("company")%></li>
    <li><label for="quantity">Quantity</label>
        <input type="number" name="quantity" step="1"  min="1" max="<%=rs.getInt("inStock")%>" value="1">
    <li class="grey">
        <button class="button" type="submit">Add To Cart</button>
    </li>
  </ul>
</div>
</form>
<%  
}
    rs.close();
    st.close();
    con.close();
}
catch(Exception e)
{
    e.printStackTrace();
}
    }else{
%>
<p style="text-align:center"><a href="login.html">Login</a> to purchase our products.</p>
<%  try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection  con=DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","jsosa","jsosa");
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select * from inventory");
while(rs.next())
{
%>
<div class="columns">
  <ul class="price">
    <li class="header"><%=rs.getString("productName")%></li>
    <li class="grey">$<%=rs.getDouble("unitPrice")%></li>
    <li><%=rs.getInt("inStock")%> Currently in Stock</li>
    <li><%=rs.getString("company")%></li>
  </ul>
</div>
<%
}
    rs.close();
    st.close();
    con.close();
}
catch(Exception e)
{
    e.printStackTrace();
}
}
%>
</body>
</html>
