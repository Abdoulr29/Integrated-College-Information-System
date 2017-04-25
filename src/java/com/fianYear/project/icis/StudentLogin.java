/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Abdoulr
 */
@WebServlet(urlPatterns = {"/StudentLogin"})
public class StudentLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String student = request.getParameter("student");
        String password = request.getParameter("password");
        HttpSession  session=request.getSession();
        session.setAttribute("students", student);
        StudentBean bean=new StudentBean();
        bean.setEmail(student);
        bean.setPassword(password);
       // StudentBean.studentAuthentication(bean);
        response.sendRedirect("studentPanel.jsp");
        
    }
     
       

}
