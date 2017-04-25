<%-- 
    Document   : department
    Created on : 27-Mar-2017, 17:39:14
    Author     : Abdoulr
--%>

<%@page import="java.util.List"%>
<%@page import="com.fianYear.project.icis.DepartmentBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>department</title>

        <!-- Bootstrap -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

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
                    <li class="active"><a href="department.jsp">Department</a></li>
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
            <p>Department List</p>
            <button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#myModal">Create a New Department</button>


            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title"> create new department </h4>
                        </div>
                        <div class="modal-body">
                            <form  role="form" action="DepartmentServlet" method="GET" >
                                <input type="text" class="form-control" name="departmentName" placeholder="name"/><br>
                                <input type="text" class="form-control" name="shortName" placeholder="Short_Name"/><br>
                                <button type="submit"  class="btn-default"> submit</button> 
                            </form>
                        </div>

                    </div>

                </div>
            </div>

            <hr>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Department ID</th>
                        <th>Name</th>
                        <th>Short-Name</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <% List<DepartmentBean> bean = DepartmentBean.findAllDepartments();
                            for (DepartmentBean i : bean) { %>
                        <td>  <% out.println(i.getDepartmentID());  %></td>
                        <td> <% out.println(i.getDepartmentName()); %></td>
                        <td><% out.println(i.getDepartmentShortName()); %></td>
                        <td><a href="updateDepartment?id=<%out.println(i.getDepartmentID());%>"><span class="glyphicon glyphicon-pencil"> </span></a></td>
                        <td><a href="deleteDepartment?id=<%out.println(i.getDepartmentID());%>"><span class="glyphicon glyphicon-trash"></span></a></td>
                    </tr>
                </tbody>
                <% }%>
            </table>
        </div>


        <script src="js/bootstrap.js"></script>
    </body>
</html>
