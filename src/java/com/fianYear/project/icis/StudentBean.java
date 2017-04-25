/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdoulr
 */
public class StudentBean {

    private int studentId;
    private String firstName, lastName, password, email, gender, telephone, nationalId, province, district, sector, cell, village, fatherName, motherName, previousSchool, combination, studentClass, academicYear;
    private double grade;
    private DepartmentBean department;
    private SponsorBean sponsor;
    private Date dob;

    public static String createStudent(StudentBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "insert into students " + "(firstname,lastname,password,dob,gender,email,telephone,nationalId,province,district,sector,cell,village,father_name,mother_name,previous_school,combination,grade,class,academic_year,sponsorId,departmentId)" + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getFirstName());
            pr.setString(2, x.getLastName());
            pr.setString(3, x.getPassword());
            //  java.sql.Date date = new java.sql.Date(x.getDob().getTime());
            pr.setDate(4, new java.sql.Date(x.getDob().getTime()));
            pr.setString(5, x.getGender());
            pr.setString(6, x.getEmail());
            pr.setString(7, x.getTelephone());
            pr.setString(8, x.getNationalId());
            pr.setString(9, x.getProvince());
            pr.setString(10, x.getDistrict());
            pr.setString(11, x.getSector());
            pr.setString(12, x.getCell());
            pr.setString(13, x.getVillage());
            pr.setString(14, x.getFatherName());
            pr.setString(15, x.getMotherName());
            pr.setString(16, x.getPreviousSchool());
            pr.setString(17, x.getCombination());
            pr.setString(18, Double.toString(x.getGrade()));
            pr.setString(19, x.getStudentClass());
            pr.setString(20, x.getAcademicYear());
            pr.setString(21, Integer.toString(x.getSponsor().getSponserId()));
            pr.setString(22, Integer.toString(x.getDepartment().getDepartmentID()));

            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";

    }

    public static String deleteStudents(StudentBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, Integer.toString(x.getStudentId()));
            pr.execute();
            con.close();
            return "deleted";

        } catch (Exception e) {
            e.printStackTrace();
            return "not deleted";
        }

    }

/*    public static boolean studentAuthentication(String email, String pass) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT email,password WHERE email='" + email + "' AND password='" + pass + "'";
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                if (rs.getString(7).equals(email) && rs.getString(4).equals(pass)) {
                } else {
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
return true;
    }*/

    public static List<StudentBean> findAllStudents() {
        List<StudentBean> retrieve = new ArrayList<StudentBean>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                StudentBean bean = new StudentBean();
                bean.setStudentId(rs.getInt(1));
                bean.setFirstName(rs.getString(2));
                bean.setLastName(rs.getString(3));
                bean.setPassword(rs.getString(4));
                //  String date = rs.getString(5);
                //  SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-dd-MM");
                //  java.util.Date date1 = sdf1.parse(date);
                //  java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
                bean.setDob(rs.getDate(5));
                bean.setGender(rs.getString(6));
                bean.setEmail(rs.getString(7));
                bean.setTelephone(rs.getString(8));
                bean.setNationalId(rs.getString(9));
                bean.setProvince(rs.getString(10));
                bean.setDistrict(rs.getString(11));
                bean.setSector(rs.getString(12));
                bean.setCell(rs.getString(13));
                bean.setVillage(rs.getString(14));
                bean.setFatherName(rs.getString(15));
                bean.setMotherName(rs.getString(16));
                bean.setPreviousSchool(rs.getString(17));
                bean.setCombination(rs.getString(18));
                bean.setGrade(Double.parseDouble(rs.getString(19)));
                bean.setStudentClass((rs.getString(20)));
                bean.setAcademicYear(rs.getString(21));
                bean.setSponsor(SponsorBean.findOneSponsor(rs.getString(22)));
                bean.setDepartment(DepartmentBean.findOneDepartment(rs.getString(23)));

                retrieve.add(bean);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static StudentBean findOneStudent(String studentID) {
        StudentBean bean = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM students WHERE id='" + studentID + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new StudentBean();
                bean.setStudentId(rs.getInt(1));
                bean.setFirstName(rs.getString(2));
                bean.setLastName(rs.getString(3));
                bean.setPassword(rs.getString(4));
                bean.setDob(rs.getDate(5));
                bean.setGender(rs.getString(6));

                //  String date = rs.getString(6);
                // SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-dd-MM");
                // java.util.Date date1 = sdf1.parse(date);
                // java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
                bean.setEmail(rs.getString(7));
                bean.setTelephone(rs.getString(8));
                bean.setNationalId(rs.getString(9));
                bean.setProvince(rs.getString(10));
                bean.setDistrict(rs.getString(11));
                bean.setSector(rs.getString(12));
                bean.setCell(rs.getString(13));
                bean.setVillage(rs.getString(14));
                bean.setFatherName(rs.getString(15));
                bean.setMotherName(rs.getString(16));
                bean.setPreviousSchool(rs.getString(17));
                bean.setCombination(rs.getString(18));
                bean.setGrade(rs.getDouble(19));
                bean.setStudentClass(rs.getString(20));
                bean.setAcademicYear(rs.getString(21));
                bean.setSponsor(SponsorBean.findOneSponsor(rs.getString(22)));
                bean.setDepartment(DepartmentBean.findOneDepartment(rs.getString(23)));

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getPreviousSchool() {
        return previousSchool;
    }

    public void setPreviousSchool(String previousSchool) {
        this.previousSchool = previousSchool;
    }

    public String getCombination() {
        return combination;
    }

    public void setCombination(String combination) {
        this.combination = combination;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public DepartmentBean getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentBean department) {
        this.department = department;
    }

    public SponsorBean getSponsor() {
        return sponsor;
    }

    public void setSponsor(SponsorBean sponsor) {
        this.sponsor = sponsor;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
