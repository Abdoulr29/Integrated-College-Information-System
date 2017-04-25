<%-- 
    Document   : index
    Created on : 20-Mar-2017, 16:21:48
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
        <title> ICIS </title>

        <!-- Bootstrap -->
        
      <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/myCss.css" rel="stylesheet">
    

    </head>
    <body>
        <div id="loginBox" > 

            <form  class="form-horizontal " role="form" action="login.jsp" method="POST">
                <div class="form-group"> 
                    <label for="email" class="col-sm-2 control-label" style="color: white;">Email</label> 
                    <div class="col-lg-10"> 
                        <input type="text" class="form-control" name="adminEmail"  
                               placeholder="Enter your email"> 
                    </div> 
                </div> 
                <div class="form-group"> 
                    <label for="password" class="col-sm-2 control-label" style="color: white;">Password </label> 
                    <div class="col-lg-10"> 
                        <input type="password" class="form-control " name="pass"  
                               placeholder="Enter Password"> 
                    </div> 
                </div> 
                <div class="form-group"> 
                    <div class="col-sm-offset-2 col-sm-10"> 
                        <button type="submit" class="btn btn-default">Sign in</button> 

                    </div> 
                </div> 

            </form>   
            
        <!--    <a data-toggle="modal" data-target="#myModal" href="#">sign up</a> -->

            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title"> Admin </h4>
                        </div>
                        <div class="modal-body">
                            <form  role="form" action="AdminLogin" method="GET" >
                                <input type="text" class="form-control" name="firstname" placeholder="firstname"/><br>
                                <input type="text" class="form-control" name="lastname" placeholder="lastname"/><br>
                                <input type="password" class="form-control" name="password" placeholder="password"/><br>
                                <input type="email" class="form-control" name="email" placeholder="email"/><br>
                                <button type="submit" value="submit" class="btn-primary"> submit</button> 
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
