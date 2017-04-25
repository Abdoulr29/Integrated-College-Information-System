/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdoulr
 */
public class RegisteredStudents {

    private int regNumber;
    private StudentClasses studentClasses;
    private StudentBean studentBean;
    private String academic_year;

    public static String createRegisteredStd(RegisteredStudents x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "insert into registered_students " + "(id,classId,academic_year,studentId)" + " values (?,?,?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getRegNumber());
            pr.setInt(2, x.getStudentClasses().getStudentClassId());
            pr.setString(3, x.getAcademic_year());
            pr.setInt(4, x.getStudentBean().getStudentId());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted";
    }

    public static String autoRegistrationNumber() {
        String UG = "UR-21700001";
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT MAX(id) FROM registered_students";
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                String id = rs.getString(1);
                DecimalFormat df = new DecimalFormat("UR-21700000");
                int num = Integer.parseInt(id.substring(2));
                num++;
                UG = df.format(num);
            } else {
                UG = "UR-21700001";
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return UG;
    }

    public static List<RegisteredStudents> findAllRegisteredStd() {
        List<RegisteredStudents> retrieve = new ArrayList<RegisteredStudents>();
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM registered_students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RegisteredStudents bean = new RegisteredStudents();
                bean.setRegNumber(rs.getInt(1));
                bean.setStudentClasses(StudentClasses.findOneClass(rs.getString(2)));
                bean.setAcademic_year(rs.getString(3));
                bean.setStudentBean(StudentBean.findOneStudent(rs.getString(4)));
                retrieve.add(bean);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static RegisteredStudents findOneRegisteredStd(String stdId) {
        RegisteredStudents bean = null;
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM registered_students WHERE id='" + stdId + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new RegisteredStudents();
                bean.setRegNumber(rs.getInt(1));
                bean.setStudentClasses(StudentClasses.findOneClass(rs.getString(2)));
                bean.setAcademic_year(rs.getString(3));
                bean.setStudentBean(StudentBean.findOneStudent(rs.getString(4)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public StudentClasses getStudentClasses() {
        return studentClasses;
    }

    public void setStudentClasses(StudentClasses studentClasses) {
        this.studentClasses = studentClasses;
    }

    public StudentBean getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    @Override
    public String toString() {
        return    regNumber+" "+ studentClasses +" "+ studentBean ;
    }
    

}
