package com.fianYear.project.icis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdoulr
 */
public class AdminLogin extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String firstname = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Admin admin=new Admin();
        admin.setFirstname(firstname);
        admin.setLastname(lastName);
        admin.setPassword(password);
        admin.setEmail(email);
        Admin.createAdmin(admin);
    }
    
    
    
}
