<%-- 
    Document   : loginJSP
    Created on : 4 Feb, 2019, 12:58:46 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%
           
                if (request.getParameter("msg") != null) {
                    out.print("Invalid");
            }
          
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Login Page</h2>
        <form name="frm"  target="_blank" method="post" action="logincontroller.do">
            <lable>Name:</lable>
            <input type="text" name="logname" />
            <br/>
            <lable>Password:</lable>
            <input type="password" name="logpassword" />
            <br/>
            <input type="submit" value="Submit" />
            
            <input type="reset" value="Reset" />
            
        </form>
    </body>

      
    
</html>
