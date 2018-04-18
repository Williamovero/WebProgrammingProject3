/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC4370.Controllers;

import CSC4370.Controllers.Item;
import CSC4370.Controllers.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LungsSoMuddy
 */
@WebServlet(name = "processOrderController", urlPatterns = {"/processOrderController"})
public class processOrderController extends HttpServlet {

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
            //Get shopping cart from session
            HttpSession session = request.getSession();
            ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
                   
            //If cart is empty go back to inventory page
            if (cart == null){
                out.print("No items in cart");
                RequestDispatcher rd=request.getRequestDispatcher("/inventory.jsp");  
                rd.include(request, response); 
            }else{
                ArrayList<Item> itemList = cart.getList();
                double grandTotal = 0;
                // Shopping cart contents in table
                out.println("<h3>Cart contents</h3>");
                out.println("<table>");
                out.println("<tr><th>Product Id</th><th>Product Name</th><th>Unit Price</th><th>Quantity</th><th>Total</th></tr>");
                //Process cart items
                for(int i = 0; i < itemList.size(); i++){
                    Item item = (Item)itemList.get(i);
                    out.println("<tr><td>"+item.getProductID()+"</td><td>"+item.getProductName()+"</td><td>$"+ item.getUnitPrice()+"</td>"+
                    "<td>"+ item.getQuantity()+"</td>"+
                    "<td>$"+ (item.getUnitPrice()*item.getQuantity())+"</td></tr>");
                    grandTotal += item.getUnitPrice()*item.getQuantity();
                }
                //Cart total
                out.println("<tr><td>Total purchase</td><td></td><td></td><td></td><td>$"+grandTotal+"</td></tr>");
                out.println("</table>");
                //Add sale to database
                salesbeans sale = new salesbeans();
                sale.setOrderID(Integer.parseInt(session.getId()));
                sale.setTotal(grandTotal);
                sale.addToSales(grandTotal);
                
                RequestDispatcher rd=request.getRequestDispatcher("/checkout.jsp");  
                rd.include(request, response); 
            }
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
