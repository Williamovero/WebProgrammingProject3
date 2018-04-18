/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC4370.Controllers;

/**
 *
 * @author LungsSoMuddy
 */
public class Item {
    private int productID;
    private String productName;
    private String company;
    private double unitPrice;
    private int inStock;
    private int quantity;
    
    public Item(){
        
    }
    public Item(int id, String name, int quantity, double price, String company){
        productID = id;
        productName = name;
        this.quantity = quantity;
        this.company = company;
        unitPrice = price;
    }
    
    public void setProductID(int id){
        productID = id;
    }
    
    public int getProductID(){
        return productID;
    }
    
    public void setProductName(String name){
        productName = name;
    }
    
    public String getProductName(){
        return productName;
    }
    
    public void increaseQuantity(int x){
        quantity += x;
    }
    
    public int getQuantity(){
       return quantity; 
    }
    
    public double getUnitPrice(){
       return unitPrice; 
    }
    
    
    public void setUnitPrice(double price){
        unitPrice = price;
        
    }
}
