<%-- 
    Document   : staff
    Created on : 28-Mar-2017, 20:02:29
    Author     : Abdoulr
--%>

<%@page import="com.fianYear.project.icis.StaffBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Staff</title>

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
                    <li class="active"><a href="staff.jsp">Staff</a></li>
                    <li><a href="department.jsp">Department</a></li>
                    <li><a href="sponsor.jsp">Sponsor</a></li>
                    <li><a href="school.jsp">School</a></li>
                    <li><a href="#">Admin</a></li>
                    <li><a href="settings.jsp">Settings</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> <% out.print(session.getAttribute("username"));%></a></li>
                    <li><a href="logout.jsp"><span class="glyphicon glyphicon-off"></span> logout </a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
             <p>Staff List</p>
            <button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#myModal">Create a New staff</button>

            <hr>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Staff ID</th>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Email</th>
                        <th>Telephone</th>
                        <th>Education Level</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <% List<StaffBean> bean = StaffBean.findAllStaff();
                            for (StaffBean i : bean) { %>
                        <td>  <% out.println(i.getStaffId());  %></td>
                        <td> <% out.println(i.getFirstName()); %></td>
                        <td><% out.println(i.getLastName()); %></td>
                        <td>  <% out.println(i.getEmail());  %></td>
                        <td><% out.println(i.getTelephone()); %></td>
                        <td>  <% out.println(i.getEducation_level());  %></td>

                        <td><a href="updateStaff?id=<%out.println(i.getStaffId());%>"><span class="glyphicon glyphicon-pencil"> </span></a></td>
                        <td><a href="deleteStaff?id=<%out.println(i.getStaffId());%>"><span class="glyphicon glyphicon-trash"></span></a></td>
                    </tr>
                </tbody>
                <% }%>
            </table>


        </div>

        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
