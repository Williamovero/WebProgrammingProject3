package CSC4370.Controllers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cartbeans implements Serializable {
    
    public cartbeans() {}
   
    int cartID;
    int quantity;
    double price;
   
    public int getCartID() { return cartID; }
   
    public void setCartID(int id) { cartID = id; }
   
    public int getQuantity() { return quantity; }
   
    public void setQuantity(int q) { quantity = q; }
   
    public double getPrice() { return price; }
   
    public void setPrice(double p) { price = p; }
    
    public static boolean addToCart(double price, int quantity)
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement  prep;
            int i;
            try (Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","jsosa","jsosa")) {
                prep = con.prepareStatement ("insert into cart values(cartID,?,?,userIDFK,productIDFK)");
                prep.setInt(1, quantity);
                prep.setDouble(2, price);
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
