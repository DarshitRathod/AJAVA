<%-- 
    Document   : calculator
    Created on : 4 Feb, 2019, 12:15:13 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calc Page</title>
        </head>
        <h2>Caclulator</h2><br/><br/>
        <body>
            <form method="post" name="calcfrm">
                <label>Enter No_1</label> 
                <input type="number" name="no1" /><br/>
                <label>Enter No_2</label> 
                <input type="number" name="no2" /><br/>
                <input type="submit" value="+" name="op">
                <input type="submit" value="-" name="op">
                <input type="submit" value="*" name="op">
                <input type="submit" value="/" name="op">
            </form>
    </body>
    <% 
        if(request.getParameter("op")!= null)
        {    
            int no1 = Integer.parseInt(request.getParameter("no1"));
            int no2 = Integer.parseInt(request.getParameter("no2"));
            String op = request.getParameter("op");
             

            switch(op.charAt(0))
            {
                case '+': out.println(no1 + no2);
                          break;

                case '-': out.println(no1 - no2);
                          break;

                case '*': out.println(no1 * no2);
                          break;

                case '/': out.println(no1 / no2);
                          break;          

            }
        }    
     %>
</html>

