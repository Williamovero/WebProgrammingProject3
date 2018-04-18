package CSC4370.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class inventorybeans implements Serializable {
    
    public ArrayList<Object> inventory;
    private int productID;
    private String productName;
    private String company;
    private double unitPrice;
    private int inStock;
   
    public int getProductID() { return productID; }
   
    public void setProduct(int id) { productID = id; }
   
    public String getProductName() { return productName; }
   
    public void setProductName(String pn) { productName = pn; }
   
    public String getCompany() { return company; }
   
    public void setCompany(String c) { company = c; }
    
    public double getUnitPrice() { return unitPrice; }
   
    public void setUnitPrice(double up) { unitPrice = up; }
    
    public int getInStock() { return inStock; }
   
    public void setInStock(int is) { inStock = is; }
    
    public ArrayList displayinventory(ArrayList<Object> inventory)
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection  con=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","root","Over7070");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from inventory");     
            while(rs.next()) {
                return inventory;
            }       
        }
        catch(ClassNotFoundException | SQLException sqlex)
        {
            System.out.println(sqlex);
        } 
        return null;
    }
}
