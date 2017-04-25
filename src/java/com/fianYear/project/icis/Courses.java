/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdoulr
 */
public class Courses {

    private int courseId;
    private String courseName;
    private String courseCode;
    private int semester;
    private int credits;
    private float passingMarks;
    private StaffBean staff;
    private StudentClasses classes;

    public static String createCourses(Courses x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "insert into courses " + "(course_name,course_code,semester,credits,pass_marks,staffId,classId)" + " values (?,?,?,?,?,?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getCourseName());
            pr.setString(2, x.getCourseCode());
            pr.setInt(3, x.getSemester());
            pr.setInt(4, x.getCredits());
            pr.setFloat(5, x.getPassingMarks());
            pr.setInt(6, x.getStaff().getStaffId());
            pr.setInt(7, x.getClasses().getStudentClassId());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";
    }

    public static List<Courses> findAllCourses() {
        List<Courses> retrieve = new ArrayList<Courses>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM courses";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Courses bean = new Courses();
                bean.setCourseId(rs.getInt(1));
                bean.setCourseName(rs.getString(2));
                bean.setCourseCode(rs.getString(3));
                bean.setSemester(rs.getInt(4));
                bean.setCredits(rs.getInt(5));
                bean.setPassingMarks(rs.getFloat(6));
                bean.setStaff(StaffBean.findOneStaff(rs.getString(7)));
                bean.setClasses(StudentClasses.findOneClass(rs.getString(8)));
                retrieve.add(bean);

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static String updateCourse(Courses x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "UPDATE  courses SET course_name=?,course_code=?,semester=?,credits=?,pass_marks=?,staffId=?,classId=? WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getCourseName());
            pr.setString(2, x.getCourseCode());
            pr.setInt(2, x.getSemester());
            pr.setInt(2, x.getCredits());
            pr.setFloat(2, x.getPassingMarks());
            pr.setInt(2, x.getStaff().getStaffId());
            pr.setInt(2, x.getClasses().getStudentClassId());
            pr.setInt(3, x.getCourseId());
            pr.execute();
            con.close();
            return "updated!!!";

        } catch (Exception e) {
            e.printStackTrace();
            return "updaye failed";
        }

    }

    public static String deleteCourse(Courses x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "DELETE FROM courses WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, Integer.toString(x.getCourseId()));
            pr.execute();
            con.close();
            return "deleted";

        } catch (Exception e) {
            e.printStackTrace();
            return "not deleted";
        }

    }

    public static Courses findOneCourse(String courseId) {
        Courses bean = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM courses WHERE id='" + courseId + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new Courses();
                bean.setCourseId(rs.getInt(1));
                bean.setCourseName(rs.getString(2));
                bean.setCourseCode(rs.getString(3));
                bean.setSemester(rs.getInt(4));
                bean.setCredits(rs.getInt(5));
                bean.setPassingMarks(rs.getFloat(6));
                bean.setStaff(StaffBean.findOneStaff(rs.getString(7)));
                bean.setClasses(StudentClasses.findOneClass(rs.getString(8)));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public float getPassingMarks() {
        return passingMarks;
    }

    public void setPassingMarks(float passingMarks) {
        this.passingMarks = passingMarks;
    }

    public StaffBean getStaff() {
        return staff;
    }

    public void setStaff(StaffBean staff) {
        this.staff = staff;
    }

    public StudentClasses getClasses() {
        return classes;
    }

    public void setClasses(StudentClasses classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return courseName ;
    }
    

}
