
package com.fianYear.project.icis;
import java.io.*;
import static java.io.FileDescriptor.out;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Abdoulr
 */
public class AdminAuthentication extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminEmail=request.getParameter("adminEmail");
        String adminPassword=request.getParameter("pass");
        HttpSession session=request.getSession();
        session.setAttribute("adminEmail",adminEmail);
        
        Admin admin=new Admin();
        admin.setEmail(adminEmail);
        admin.setPassword(adminPassword);
        Admin.adminAuthentication(admin);
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        out.println("hello book");
    }
    
    
    
}
