package CSC4370.Controllers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userbeans implements Serializable {
    
    public userbeans() {}
    
    private static int userID;
    private static String username;
    private static String password;
    private static String firstName;
    private static String lastName;
    private static boolean isAdmin;
    public static boolean loggedIn = false;
    public static boolean registered = false;

    public static boolean isLoggedIn() { return loggedIn; }
   
    public static boolean isRegistered() { return registered; }
    
    public String getFirstName() { return firstName; }
   
    public void setFirstName(String f) { firstName = f; }
   
    public  String getLastName() { return lastName; }
   
    public void setLastName(String l) { lastName = l; }
   
    public static int getUserID() { return userID; }
   
    public void setUserID(int id) { userID = id; }
    
    public static String getUsername() { return username; }
   
    public void setUsername(String u) { username = u; }
    
    public  String getPassword() { return password; }
   
    public void setPassword(String p) { password = p; }
    
    public boolean isAdmin() { return isAdmin; }
    
    public void setIsAdmin(boolean a) { isAdmin = a; }
   
    public boolean login(String username, String password)
    {             
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","root","Over7070"); 
                    PreparedStatement prep = con.prepareStatement("select * from users where password=? and username=?")) {
                prep.setString(1,password);
                prep.setString(2,username);
                ResultSet rs = prep.executeQuery();
                loggedIn = rs.next();
            }
        }
        
        catch(ClassNotFoundException | SQLException sqlex)
        {
            loggedIn = false;  
        }  
        
        return loggedIn;
   }
   
   public static void logout()
   {
        loggedIn = false;
   }
   
   public static boolean register(String firstName, String lastName, String username, String password, Boolean isAdmin) {
       
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            int  i;
            try (Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","root","Over7070"); 
                PreparedStatement prep = con.prepareStatement ("insert into users values(userID,?,?,?,?,?)")) {
                prep.setString(1, password);
                prep.setString(2, firstName);
                prep.setString(3, lastName);
                prep.setBoolean(4, isAdmin);
                prep.setString(5, username);
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
