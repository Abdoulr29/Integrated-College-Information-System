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
public class StaffBean {

    private int staffId;
    private String firstName;
    private String lastName;
    private String middle_name;
    private String password;
    private String email;
    private String telephone;
    private String education_level;

    public static String createStaff(StaffBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "insert into staff " + "(firstname,lastname,email,password,telephone,education_level,middlename)" + " values (?,?,?,?,?,?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getFirstName());
            pr.setString(2, x.getLastName());
            pr.setString(3, x.getEmail());
            pr.setString(4, x.getPassword());
            pr.setString(5, x.getTelephone());
            pr.setString(6, x.getEducation_level());
            pr.setString(7, x.getMiddle_name());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";

    }

    public static String updateStaff(StaffBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "UPDATE  staff SET firstname=?,lastname=?,email=?,password=?,telephone=?,education_level=?,middlename=? WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getFirstName());
            pr.setString(2, x.getLastName());
            pr.setString(3, x.getEmail());
            pr.setString(4, x.getPassword());
            pr.setString(5, x.getTelephone());
            pr.setString(6, x.getEducation_level());
            pr.setString(7, x.getMiddle_name());
            pr.setString(8, Integer.toString(x.getStaffId()));
            pr.execute();
            con.close();
            return "updated!!!";

        } catch (Exception e) {
            e.printStackTrace();
            return "updaye failed";
        }

    }

    public static String deleteStaff(StaffBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "DELETE FROM staff WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, Integer.toString(x.getStaffId()));
            pr.execute();
            con.close();
            return "deleted";

        } catch (Exception e) {
            e.printStackTrace();
            return "not deleted";
        }

    }

    public static List<StaffBean> findAllStaff() {
        List<StaffBean> retrieve = new ArrayList<StaffBean>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM staff";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                StaffBean bean = new StaffBean();
                bean.setStaffId(rs.getInt(1));
                bean.setFirstName(rs.getString(2));
                bean.setLastName(rs.getString(3));
                bean.setEmail(rs.getString(4));
                bean.setPassword(rs.getString(5));
                bean.setTelephone(rs.getString(6));
                bean.setEducation_level(rs.getString(7));
                bean.setMiddle_name(rs.getString(8));
                retrieve.add(bean);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }
    public static StaffBean  findOneStaff(String staffId) {
        StaffBean bean = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM staff WHERE id='"+staffId+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new StaffBean();
                bean.setStaffId(rs.getInt(1));
                bean.setFirstName(rs.getString(2));
                bean.setLastName(rs.getString(3)); 
                bean.setEmail(rs.getString(4));
                bean.setPassword(rs.getString(5));
                bean.setTelephone(rs.getString(6));
                bean.setEducation_level(rs.getString(7));
                bean.setMiddle_name(rs.getString(8));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    
    

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.staffId;
        hash = 89 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 89 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 89 * hash + (this.middle_name != null ? this.middle_name.hashCode() : 0);
        hash = 89 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 89 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 89 * hash + (this.telephone != null ? this.telephone.hashCode() : 0);
        hash = 89 * hash + (this.education_level != null ? this.education_level.hashCode() : 0);
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
        final StaffBean other = (StaffBean) obj;
        if (this.staffId != other.staffId) {
            return false;
        }
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if ((this.middle_name == null) ? (other.middle_name != null) : !this.middle_name.equals(other.middle_name)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.telephone == null) ? (other.telephone != null) : !this.telephone.equals(other.telephone)) {
            return false;
        }
        if ((this.education_level == null) ? (other.education_level != null) : !this.education_level.equals(other.education_level)) {
            return false;
        }
        return true;
    }
    
    

}
