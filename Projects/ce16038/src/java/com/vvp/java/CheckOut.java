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
public class CheckOut extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
            String address = request.getParameter("address");
            int contact = Integer.parseInt(request.getParameter("contact"));
            String pymode = request.getParameter("pymode");
            if(pymode.equals("cod"))
            {
                  ArrayList cartObj = (ArrayList)session.getAttribute("cart");
                   if(cartObj == null)
                   {    
                       out.println("your cart is empty.");
                        return;
                   }
                   else
                   {
                       for(int i=0;i<cartObj.size();i++){
                       SelectProducts temp = (SelectProducts)cartObj.get(i);
                       Products p = (Products)Products.products.get(new Integer(temp.pid));
                       
                       p.qty = p.qty-temp.qty;
                       if(p.qty<0){
                           p.qty += temp.qty;
                           out.println(p.getProductName()+":only "+p.qty+" Products are available");
                       }
                       else{
                           out.println(p.getProductName()+" Done....");
                       }
                       Products.products.put(new Integer(temp.pid),p);
                       }
                   }

            }
            else{
                out.println("This service is Coming Soon.....!!");
                response.sendRedirect("checkout.html");
            }
        }
         finally { 
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
