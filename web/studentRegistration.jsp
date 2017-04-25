<%-- 
    Document   : studentRegistration
    Created on : 10-Apr-2017, 11:35:26
    Author     : Abdoulr
--%>

<%@page import="com.fianYear.project.icis.DepartmentBean"%>
<%@page import="com.fianYear.project.icis.SponsorBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Student Registration</title>

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
                    <li class="active" ><a href="process.jsp">Students</a></li>
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
            <p>Student Registration Form</p>

            <hr>
            <form  role="form" action="StudentServlet" method="GET" >
                <input type="text" class="form-control" name="firstName" placeholder="firstName"/><br>
                <input type="text" class="form-control" name="lastName" placeholder="lastName"/><br>
                <input type="password" class="form-control" name="password" placeholder="password"/><br>
                <input type="date" class="form-control" name="dob"/><br>
                <select class="form-control" name="gender"> 
                    <option>Male</option>
                    <option>Female</option>
                </select></br>
                <input type="email" class="form-control" name="email" placeholder="email"/><br>
                <input type="text" class="form-control" name="telephone" placeholder="telephone"/><br>
                <input type="text" class="form-control" name="nationalId" placeholder="nationalID"/><br>
                <input type="text" class="form-control" name="province" placeholder="province"/><br>
                <input type="text" class="form-control" name="district" placeholder="district"/><br>
                <input type="text" class="form-control" name="sector" placeholder="sector"/><br>
                <input type="text" class="form-control" name="cell" placeholder="cell"/><br>
                <input type="text" class="form-control" name="village" placeholder="village"/><br>
                <input type="text" class="form-control" name="fatherName" placeholder="father's name "/><br>
                <input type="text" class="form-control" name="motherName" placeholder="mother's name"/><br>
                <input type="text" class="form-control" name="previousSchool" placeholder="previousSchool"/><br>
                <input type="text" class="form-control" name="combination" placeholder="combination"/><br>
                <input type="text" class="form-control" name="grade" placeholder="grade"/><br>
                <input type="text" class="form-control" name="studentClass" placeholder="studentClass"/><br>
                <input type="text" class="form-control" name="academicYear" placeholder="academicYear"/><br>
                <select name="sponsorId"  class="form-control">
                    <%
                        List<SponsorBean> sponsorBeans = SponsorBean.findAllSponsor();
                        for (SponsorBean p : sponsorBeans) { %>
                    <option value="<%out.print(p.getSponserId());%>">  <% out.println("<li>" + p.getSponsorName());
                                        }%>
                    </option> 

                </select></br>

                <select name="departmentId"  class="form-control">
                    <%
                        List<DepartmentBean> departmentBeans = DepartmentBean.findAllDepartments();
                        for (DepartmentBean p : departmentBeans) { %>

                    <option value="<%out.print(p.getDepartmentID()); %>">  <% out.println("<li>" + p.getDepartmentName());
                                        }%>
                    </option> 

                </select></br>
                <button type="submit"  class="btn-default"> submit</button> 
            </form>

        </div>

        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
