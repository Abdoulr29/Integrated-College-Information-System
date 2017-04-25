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
public class StudentClasses {

    private int StudentClassId;
    private String name;
    private DepartmentBean department;

    public static String createStudentClass(StudentClasses x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "insert into classes " + "(name,departmentId)" + " values (?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getName());
            pr.setString(2, Integer.toString(x.getDepartment().getDepartmentID()));
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";

    }

    public static List<StudentClasses> findAllClasses() {
        List<StudentClasses> retrieve = new ArrayList<StudentClasses>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM classes";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                StudentClasses bean = new StudentClasses();
                bean.setStudentClassId(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setDepartment(DepartmentBean.findOneDepartment(rs.getString(3)));
                retrieve.add(bean);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static String updateClasses(StudentClasses x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "UPDATE  classes SET name=?,departmentId=? WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getName());
            pr.setString(2, Integer.toString(x.getDepartment().getDepartmentID()));
            pr.setInt(3, x.getStudentClassId());
            pr.execute();
            con.close();
            return "updated!!!";

        } catch (Exception e) {
            e.printStackTrace();
            return "update failed";
        }

    }

    public static String deleteClasses(StudentClasses x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "DELETE FROM classes WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, Integer.toString(x.getStudentClassId()));
            pr.execute();
            con.close();
            return "deleted";

        } catch (Exception e) {
            e.printStackTrace();
            return "not deleted";
        }
    }

    public static StudentClasses findOneClass(String studentClassId) {
        StudentClasses bean = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM classes WHERE id='" + studentClassId + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new StudentClasses();
                bean.setStudentClassId(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setDepartment(DepartmentBean.findOneDepartment(rs.getString(3)));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public int getStudentClassId() {
        return StudentClassId;
    }

    public void setStudentClassId(int StudentClassId) {
        this.StudentClassId = StudentClassId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentBean getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentBean department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    

}
