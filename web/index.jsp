<%-- 
    Document   : index
    Created on : 17-Apr-2017, 16:30:11
    Author     : Abdoulr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>ICIS</title>
        <script src="vendors/jquery/dist/jquery.js" ></script>
        <link rel="stylesheet" href="build/css/index.css" />
    </head>

    <body>
    
        <div id="tabs">
            <input type="radio" name="tab" id="std" checked>
            <label id="rstd" for="std">Students</label>
            
            <input type="radio" name="tab" id="stf" checked>
            <label id="rstf" for="stf">Staff</label>
               
                
                    <div id="std-login" class="login-form">
                        <h2>Student Login</h2> 
                        <form method="GET" action="studentProcessing.jsp">
                        <input type="text" name="student" placeholder="Email"><br/>
                        <input type="password" name="password" placeholder="Password"><br/>
                        <button class="login-btn" type="submit">Login</button><br/><br/></form>
                        <span><a href="#forget password">Forget Password ?</a></span>
                    
                    </div>
            
                    <div id="stf-login" class="login-form">
                        <h2>Staff Login</h2> 
                        <form action="staffLogin" method="GET">
                        <input type="text" name="staff" placeholder="Username"><br/>
                        <input type="password" name="password" placeholder="Password"><br/>
                        <button class="login-btn" type="submit">Login</button><br/><br/></form>
                        <span><a href="#forget password">Forget Password ?</a></span>
                    </div>
            
        </div>
        
    </body>
</html>
