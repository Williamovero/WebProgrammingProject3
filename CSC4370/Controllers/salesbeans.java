package CSC4370.Controllers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class salesbeans implements Serializable {
    
    public salesbeans() {}
    
    int orderID;
    double total;
    
    public int getOrderID() { return orderID; }
   
    public void setOrderID(int id) { orderID = id; }
   
    public double getTotal() { return total; }
   
    public void setTotal(double t) { total = t; }

    public boolean addToSales(double total)
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement  prep;
            int i;
            try (Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","root","Over7070")) {
                prep = con.prepareStatement ("insert into cart values(orderID,?,cartIDFK)");
                prep.setDouble(1, total);
                i = prep.executeUpdate();
            }
            return i>0;
        }
        
        catch(ClassNotFoundException | SQLException sqlex)
        {
            System.out.println(sqlex);
            return false;
        } 
    }
}