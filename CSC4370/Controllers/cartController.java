/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC4370.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author William Orgertrice, Ayanna Saheed, Julian Sosa
 */
@WebServlet(name = "cartController", urlPatterns = {"/cartController"})
public class cartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                 
        
        try (PrintWriter out = response.getWriter()) {
              
            //Grab product info from form
            int productId      = Integer.parseInt(request.getParameter("productID"));
            String productName = request.getParameter("productName");
            double unitPrice   = Double.parseDouble(request.getParameter("unitPrice"));
            int quantity       = Integer.parseInt(request.getParameter("quantity")) ;
            String company     = request.getParameter("company");
            
            //Create item object based on form  info 
            Item product = new Item(productId, productName, quantity, unitPrice,company);
            
            //Get Session
            HttpSession session = request.getSession(true);
            ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
            
            //If there is no cart create one
            if(cart == null){  
               cart = new ShoppingCart();  
            }
            //Add item to cart collection
            cart.addToCart(product);
            session.setAttribute("cart", cart);
            
            //Adds cart info to database via cartbean   
            cartbeans userCart = new cartbeans();
            //Cart ID is session ID
            userCart.setCartID(Integer.parseInt(session.getId()));
            userCart.setPrice(unitPrice);
            userCart.setQuantity(quantity);
            userCart.addToCart(unitPrice, quantity);
            out.print(productName + " sucessfully added to cart");
            RequestDispatcher rd=request.getRequestDispatcher("/inventory.html");  
            rd.include(request, response); 
    }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
