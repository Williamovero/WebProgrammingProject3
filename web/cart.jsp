<%@page import="CSC4370.Controllers.inventorybeans"%>
<%@page import="CSC4370.Controllers.userbeans"%>
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
        <title>Cart</title>
<style>
table 
{
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    border: 1px solid #ddd;
}
th
{
    color: blueviolet;
}
th, td 
{
    text-align: center;
    padding: 16px;
}

tr:nth-child(even) 
{
    background-color: lightcyan;
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
    <h2 style="text-align: center">My Shopping Cart</h2>
    <%
    try 
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con=DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","jsosa","jsosa");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from cart");
    %>
    <table>
        <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
    <%
    while(rs.next())
    {
    %>
        <tr>
            <td><%inventorybeans.getProductName();%></td>
            <td><%=rs.getInt("quantity")%></td>
            <td><%=rs.getDouble("price")%></td>
        </tr>
<%
    }
%>
    </table>
<%
    rs.close();
    st.close();
    con.close();
}
catch(Exception e)
{
    e.printStackTrace();
}
%>
</body>
</html>
