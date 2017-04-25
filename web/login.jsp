<%-- 
    Document   : login
    Created on : 27-Mar-2017, 11:14:29
    Author     : Abdoulr
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <%
            String email = request.getParameter("adminEmail");
            String password = request.getParameter("pass");
            session.setAttribute("username", email);
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from admin where email='" + email + "'");
            if (rs.next()) {
                if (rs.getString(4).equals(password)) {
                    
                    out.println(" welcome " + email); %>
                            <jsp:forward page="process.jsp"/><%
                } else {
                    out.println("Username or passwords are Invalid. Please try again");
                }
            }
        %>
    </body>
</html>
