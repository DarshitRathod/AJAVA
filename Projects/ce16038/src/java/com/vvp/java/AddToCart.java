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
public class AddToCart extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        ArrayList cartObj =  null;
        
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToCart</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCart at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
            HttpSession session = request.getSession();
            int pid = Integer.parseInt((request.getParameter("pid")));
            int qty = Integer.parseInt((request.getParameter("qty")));
            
            if(session.getAttribute("cart") == null)
            {
                cartObj = new ArrayList();
            }
            else
            {
                cartObj = (ArrayList)session.getAttribute("cart");
            } 
            SelectProducts sp = new SelectProducts(pid,qty);
            cartObj.add(sp);
            session.setAttribute("cart",cartObj);
            response.sendRedirect("ecommerce.html");
            
        } 
        catch(Exception e){
            e.printStackTrace();
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
