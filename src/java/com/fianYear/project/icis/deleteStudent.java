
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
@WebServlet(urlPatterns={"/deleteStudent"})
public class deleteStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId=request.getParameter("id");
        StudentBean bean=new StudentBean();
        bean.setStudentId(Integer.parseInt(studentId));
        StudentBean.deleteStudents(bean);
        response.sendRedirect("process.jsp");
    }
}
