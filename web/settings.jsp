<%-- 
    Document   : settings
    Created on : 28-Mar-2017, 20:03:06
    Author     : Abdoulr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Settings</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <strong><a class="navbar-brand" href="#">ICIS</a></strong>
                </div>
                <ul class="nav navbar-nav">
                    <li ><a href="process.jsp">Students</a></li>
                    <li><a href="staff.jsp">Staff</a></li>
                    <li><a href="department.jsp">Department</a></li>
                    <li><a href="sponsor.jsp.jsp">Sponsor</a></li>
                    <li><a href="school.jsp">School</a></li>
                    <li><a href="#">Admin</a></li>
                    <li class="active"><a href="settings.jsp">Settings</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> <% out.print(session.getAttribute("username"));%></a></li>
                    <li><a href="logout.jsp"><span class="glyphicon glyphicon-off"></span> logout </a></li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <a href="#" >change password</a></br>
            <button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#myModal">Create a New Department</button>

        </div>

        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
