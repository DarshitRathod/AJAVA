/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;

import java.io.*;
import java.net.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Lenovo
 */
public class StudentValidation extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8;text/javascript");
        PrintWriter out = response.getWriter();
        
  
        
        try {
            
        String userpassword = request.getParameter("userpassword");
        String userconfirmpassword = request.getParameter("userconfirmpassword");
        String useremail = request.getParameter("useremail");
        String usernumber = request.getParameter("usernumber");
        int usersem = Integer.parseInt(request.getParameter("usersem"));
        String userbranch = request.getParameter("userbranch");
        String usercollege = request.getParameter("usercollege");
            
                        //------------------password Validation-----------------------
                        if(userpassword.equals(userconfirmpassword)== false)
                        {
                            
                            //out.print("Password Invalid");
                            response.sendRedirect("studentvalidation.html");
                            
                        }
                
                
                        //--------------------Email Valdiation---------------------------
                        int firstCharacter = useremail.codePointAt(0);
				
			if(firstCharacter<97 || firstCharacter>122)
			{
                                
				response.sendRedirect("studentvalidation.html");
			}	
			
			if(useremail.indexOf('@')<0)
			{
                            
				response.sendRedirect("studentvalidation.html");
			}
			
				String emailComponant[] = useremail.split("@");
			
			for(int i=0;i<emailComponant[0].length();i++)
			{
				int tempCode = emailComponant[0].codePointAt(i);
				
				if((tempCode<45 || tempCode>47) && (tempCode<48 || tempCode>57) && (tempCode<94 || tempCode>96) && (tempCode<65 || tempCode>90) && (tempCode<97 || tempCode>122))
				{
                                        
					response.sendRedirect("studentvalidation.html");
				}
			}	
			if(emailComponant[1].indexOf(".")<3)
			{
                                
				response.sendRedirect("studentvalidation.html");
			}
                  
                        //-------------------Phone Number Validation--------------
                        if (usernumber.matches("[0-9]+")== false)
                        {
                            
                            response.sendRedirect("studentvalidation.html");
                        }   
                        
                        //-----------------Semester Validation--------------------
                        if(usersem<=1 ||  usersem>=8)
                        {
                                
                                response.sendRedirect("studentvalidation.html");
                        }    
                                
                        //-----------------Branch Validation--------------------        
                        if(userbranch.equals("it")==false && userbranch.equals("ce")==false && userbranch.equals("ec")==false)
                        {
                            
                            response.sendRedirect("studentvalidation.html");
                        }    
                        
                        //----------------college Validation----------------------
                        for(int i=0 ; i<usercollege.length() ; i++)
                        {    
                            int college = usercollege.codePointAt(i);
                            
                                    if(college>32 && college<46 || college>57 && college<65 || college>90 && college<97)
                                    {
                            
                                        response.sendRedirect("studentvalidation.html");
                                    }
                        }
                         out.print("Accepted..!!");
                         
        }
        catch(NumberFormatException n)
        {
            response.sendRedirect("studentvalidation.html");
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
