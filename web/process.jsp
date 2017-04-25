<%-- 
    Document   : process
    Created on : 23-Mar-2017, 13:43:41
    Author     : Abdoulr
--%>

<%@page import="com.fianYear.project.icis.SponsorBean"%>
<%@page import="com.fianYear.project.icis.DepartmentBean"%>
<%@page import="java.util.List"%>
<%@page import="com.fianYear.project.icis.StudentBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Admin</title>

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
                    <li class="active"><a href="process.jsp">Students</a></li>
                    <li><a href="staff.jsp">Staff</a></li>
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
            <p>Student List</p>
            <a href="studentRegistration.jsp" class="btn btn-default btn-lg">Create a New Student</a>
            <hr>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Student ID</th>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>          
                        <th>Telephone</th>
                        <th>D.O.B</th>
                        <th>sex</th>
                        <th>edit</th>
                        <th>delete</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <% List<StudentBean> bean = StudentBean.findAllStudents();
                            for (StudentBean i : bean) { %>
                        <td><% out.println(i.getStudentId());  %></td>
                        <td><% out.println(i.getFirstName()); %></td>
                        <td><% out.println(i.getLastName()); %></td>
                        <td><% out.println(i.getEmail()); %></td>
                        <td><% out.println(i.getTelephone()); %></td>
                        <td><% out.println(i.getDob()); %></td>
                        <td><% out.println(i.getGender()); %></td>
                        <td><a href="updateStudent?id=<%out.println(i.getStudentId());%>"><span class="glyphicon glyphicon-pencil"> </span></a></td>
                        <td><a href="deleteStudent?id=<%out.println(i.getStudentId());%>"><span class="glyphicon glyphicon-trash"></span></a></td>
                    </tr>
                </tbody>
                <% }%>

            </table>


        </div>



        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
