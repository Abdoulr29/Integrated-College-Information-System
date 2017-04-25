<%-- 
    Document   : logout
    Created on : 27-Mar-2017, 17:36:04
    Author     : Abdoulr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.removeAttribute("username");
            session.invalidate();
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
