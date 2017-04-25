<%-- 
    Document   : studentProcessing
    Created on : 18-Apr-2017, 07:30:25
    Author     : Abdoulr
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.fianYear.project.icis.DbConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <%
            String email = request.getParameter("student");
            String password = request.getParameter("password");
            session.setAttribute("student", email);
            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from students where email='" + email + "'");
            if (rs.next()) {
                if (rs.getString(4).equals(password)) {
                    
                    out.println(" welcome " + email); %>
                    <jsp:forward page="studentPanel.jsp"/><%
                } else {
                    out.println("Username or passwords are Invalid. Please try again");
                }
            }
        %>
    </body>
</html>
