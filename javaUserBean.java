package CSC4370;

/**
 *
 * @author William Orgertrice, Ayanna Shaheed and Julian Sosa
 */
import java.io.Serializable;
public class javaUserBean implements Serializable{
    //
    private boolean loggedIn;
    private String userName;
    private String passWord;
    //java bean constructor
public javaUserBean(){
    loggedIn=false;
    userName="user";
    passWord="pass";
 }
public javaUserBean(boolean loggedIn,String userName,String passWord ){
    this.loggedIn = loggedIn;
    this.userName = userName;
    this.passWord = passWord;
}
//Get username method 
public String getUserName(){
    //returns the username that can be changed via the set username method
    return userName;
}
//Get password method
public String getPassword(){
    //returns the password that can be changed via the set password method
    return passWord;
}
//Set username method
public void setUsername(String user){
    //changes the username
    userName=user;
}
//Set password method
public void setPassword(String pass){
    //changes the password
    passWord=pass;
}

public boolean isLoggedIn(){
    return loggedIn=true;
}
}