package com.fianYear.project.icis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdoulr
 */
@WebServlet(name = "DepartmentServlet", urlPatterns = {"/DepartmentServlet"})
public class DepartmentServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String departmentName = request.getParameter("departmentName");
        String departmentShortName = request.getParameter("shortName");

        DepartmentBean bean = new DepartmentBean();
        bean.setDepartmentName(departmentName);
        bean.setDepartmentShortName(departmentShortName);
        DepartmentBean.createDepartment(bean);
        response.sendRedirect("department.jsp");

    }

}
