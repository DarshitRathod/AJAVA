/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Lenovo
 */
public class ViewCart extends HttpServlet {
   
   public void init(ServletConfig config) throws ServletException {
        
     Products.initData();
    }
    
    
    
    
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewCart</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewCart at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
            HttpSession session = request.getSession();
            ArrayList cartObj = (ArrayList)session.getAttribute("cart");
            
            if(cartObj == null)
            {
                out.print("Your Cart is Empty....!!");
            }
            else
            {
                out.println("<html>");
                out.println("<body>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<th>SR.NO</th>");
                out.println("<th>ProductName</th>");
                out.println("<th>QTY</th>");
                out.println("<th>Price</th>");
                out.println("<th>Subtotal</th>");
                out.println("</tr>");
                double grandTotal=0;
                for(int i=0;i<cartObj.size();i++)
                {
                    SelectProducts temp = (SelectProducts)cartObj.get(i);
                    Products p =(Products) Products.products.get(new Integer(temp.pid));
                    
                    double price = p.getPrice();
                    double subtotal = price * temp.qty;
                    
                    out.println("<tr>");
                    out.println("<td>" + (i + 1) +"</td>");
                    out.println("<td>" + p.getProductName() + "</td>");
                    out.println("<td>" + temp.qty + "</td>");
                    out.println("<td>" + price + "</td>");
                    out.println("<td>" + subtotal + "</td><br/>");
                    grandTotal += subtotal;
                    out.println("</tr>");
                   // out.println("<td>" + subtotal+ "</td>");
                    
                }
                out.println("<tr>");
                out.println("<th colspan='4'>GrandTotal" +"</th>");
                out.println("<td>"+grandTotal+"</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("<br/><br/>");
                out.println("</body>");
                out.println("</html>");
                 out.println("<div style='float:right; margin-right:76%;'>"+"<a href='checkout.html'>Checkout</a>"+"</div>");
                
            }
            
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
