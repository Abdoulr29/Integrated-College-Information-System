/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdoulr
 */
@WebServlet(urlPatterns = {"/updateDepartment"})
public class updateDepartment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        DepartmentBean bean = new DepartmentBean();
        bean.setDepartmentID(Integer.parseInt(id));
        bean.setDepartmentName("madrid");
        bean.setDepartmentShortName("cvs");
        DepartmentBean.updateDepartment(bean);
        response.sendRedirect("department.jsp");
    }
}
