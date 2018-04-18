/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC4370.Controllers;

import java.util.ArrayList;

/**
 *
 * @author LungsSoMuddy
 */
public class ShoppingCart {
    
    
    private ArrayList<Item> cart = new ArrayList<Item>();  
   
    public ShoppingCart(){
        
    }
     
    public void addToCart(Item item){
    
        for(int i = 0; i < cart.size(); i++){
            Item x = cart.get(i);
            if(item.getProductID() == x.getProductID()){
                x.increaseQuantity(item.getQuantity());
                return;
            }
        }
        cart.add(item); 
    }
    
    public ArrayList<Item> getList(){
        return cart;
    }
     
}
