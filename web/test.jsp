<%-- 
    Document   : test
    Created on : 22-Apr-2017, 14:45:07
    Author     : Abdoulr
--%>

<%@page import="java.util.List"%>
<%@page import="com.fianYear.project.icis.Assignments"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Test</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">


    </head>
    <body>
        <div class="container">
            <form class="form-control" action="Testeur" enctype="multipart/form-data" method="POST" >
                <input type="text" name="user" class="form-control" placeholder="username"/><br>
                <input type="file" name="myImage" class="form-control"/><br>

                <button type="submit"  class="form-control btn-default" > submit </button>
            </form>

        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
