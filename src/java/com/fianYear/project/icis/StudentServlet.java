package com.fianYear.project.icis;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdoulr
 */
@WebServlet(urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String firstName, lastName, password, dob, gender, email, telephone, nationalId, province, district, sector, cell, village, fatherName, motherName, previousSchool, combination, grade, studentClass, academicYear, sponsorId, departmentId;
            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");
            password = request.getParameter("password");
            dob = request.getParameter("dob");
            gender = request.getParameter("gender");
            email = request.getParameter("email");
            telephone = request.getParameter("telephone");
            nationalId = request.getParameter("nationalId");
            province = request.getParameter("province");
            district = request.getParameter("district");
            sector = request.getParameter("sector");
            cell = request.getParameter("cell");
            village = request.getParameter("village");
            fatherName = request.getParameter("fatherName");
            motherName = request.getParameter("motherName");
            previousSchool = request.getParameter("previousSchool");
            combination = request.getParameter("combination");
            grade = request.getParameter("grade");
            studentClass = request.getParameter("studentClass");
            academicYear = request.getParameter("academicYear");
            sponsorId = request.getParameter("sponsorId");
            departmentId = request.getParameter("departmentId");
            StudentBean bean = new StudentBean();
            bean.setFirstName(firstName);
            bean.setLastName(lastName);
            bean.setPassword(password);
            String date = dob;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
            java.util.Date date1 = dateFormat.parse(date);
            java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
            bean.setEmail(email);
            bean.setDob(sqlStartDate);
            bean.setGender(gender);
            bean.setTelephone(telephone);
            bean.setNationalId(nationalId);
            bean.setProvince(province);
            bean.setDistrict(district);
            bean.setSector(sector);
            bean.setCell(cell);
            bean.setVillage(village);
            bean.setFatherName(fatherName);
            bean.setMotherName(motherName);
            bean.setPreviousSchool(previousSchool);
            bean.setCombination(combination);
            bean.setGrade(Double.parseDouble(grade));
            bean.setStudentClass(studentClass);
            bean.setAcademicYear(academicYear);
            SponsorBean sb = SponsorBean.findOneSponsor(sponsorId);
            bean.setSponsor(sb);
            DepartmentBean db = DepartmentBean.findOneDepartment(departmentId);
            bean.setDepartment(db);
            StudentBean.createStudent(bean);
            response.sendRedirect("process.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
