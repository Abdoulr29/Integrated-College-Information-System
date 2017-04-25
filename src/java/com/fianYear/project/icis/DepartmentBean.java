/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.sql.Date;
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
public class DepartmentBean {

    private String departmentName;
    private String departmentShortName;
    private int departmentID;

    public static String createDepartment(DepartmentBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "insert into departments " + "(name,short_name)" + " values (?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getDepartmentName());
            pr.setString(2, x.getDepartmentShortName());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";
    }

    public static List<DepartmentBean> findAllDepartments() {
        List<DepartmentBean> retrieve = new ArrayList<DepartmentBean>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM departments";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                DepartmentBean bean = new DepartmentBean();
                bean.setDepartmentID(rs.getInt(1));
                bean.setDepartmentName(rs.getString(2));
                bean.setDepartmentShortName(rs.getString(3));
                retrieve.add(bean);

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static String updateDepartment(DepartmentBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "UPDATE  departments SET name=?,short_name=? WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getDepartmentName());
            pr.setString(2, x.getDepartmentShortName());
            pr.setString(3, Integer.toString(x.getDepartmentID()));
            pr.execute();
            con.close();
            return "updated!!!";

        } catch (Exception e) {
            e.printStackTrace();
            return "updaye failed";
        }

    }

    public static String deleteDepartment(DepartmentBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "DELETE FROM departments WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getDepartmentID());
            pr.execute();
            con.close();
            return "deleted";

        } catch (Exception e) {
            e.printStackTrace();
            return "not deleted";
        }

    }

    public static DepartmentBean findOneDepartment(String departmentID) {
        DepartmentBean bean = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM departments WHERE id='"+departmentID+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new DepartmentBean();
                bean.setDepartmentID(rs.getInt(1));
                bean.setDepartmentName(rs.getString(2));
                bean.setDepartmentShortName(rs.getString(3));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentShortName() {
        return departmentShortName;
    }

    public void setDepartmentShortName(String departmentShortName) {
        this.departmentShortName = departmentShortName;
    }

    @Override
    public String toString() {
        return  departmentName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.departmentName != null ? this.departmentName.hashCode() : 0);
        hash = 17 * hash + (this.departmentShortName != null ? this.departmentShortName.hashCode() : 0);
        hash = 17 * hash + this.departmentID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DepartmentBean other = (DepartmentBean) obj;
        if (this.departmentID != other.departmentID) {
            return false;
        }
        if ((this.departmentName == null) ? (other.departmentName != null) : !this.departmentName.equals(other.departmentName)) {
            return false;
        }
        if ((this.departmentShortName == null) ? (other.departmentShortName != null) : !this.departmentShortName.equals(other.departmentShortName)) {
            return false;
        }
        return true;
    }
}
