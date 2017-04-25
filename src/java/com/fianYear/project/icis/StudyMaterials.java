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
public class StudyMaterials {

    private int studyMaterialId;
    private String studyMaterialName;
    private String studyMaterialDesc;
    private String studyMaterialUrl;
    private StaffBean staff;

    public static String createStudyMaterial(StudyMaterials x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "insert into study_materials " + "(name,description,url,staffId)" + " values (?,?,?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getStudyMaterialName());
            pr.setString(2, x.getStudyMaterialDesc());
            pr.setString(3, x.getStudyMaterialUrl());
            pr.setInt(4, x.getStaff().getStaffId());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";
    }

    public static List<StudyMaterials> findAllMaterials() {
        List<StudyMaterials> retrieve = new ArrayList<StudyMaterials>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM study_materials";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                StudyMaterials bean = new StudyMaterials();
                bean.setStudyMaterialId(rs.getInt(1));
                bean.setStudyMaterialName(rs.getString(2));
                bean.setStudyMaterialDesc(rs.getString(3));
                bean.setStudyMaterialUrl(rs.getString(4));
                bean.setStaff(StaffBean.findOneStaff(rs.getString(5)));
                retrieve.add(bean);

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static String updateStudyMaterials(StudyMaterials x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "UPDATE  study_materials SET name=?,description=?,url=?,staffId=? WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getStudyMaterialName());
            pr.setString(2, x.getStudyMaterialDesc());
            pr.setString(3, x.getStudyMaterialUrl());
            pr.setInt(4, x.getStaff().getStaffId());
            pr.setInt(5, x.getStudyMaterialId());
            pr.execute();
            con.close();
            return "updated!!!";

        } catch (Exception e) {
            e.printStackTrace();
            return "updaye failed";
        }

    }

    public static String deleteStudyMaterials(StudyMaterials x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "DELETE FROM study_materials WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getStudyMaterialId());
            pr.execute();
            con.close();
            return "deleted";

        } catch (Exception e) {
            e.printStackTrace();
            return "not deleted";
        }

    }

    public static StudyMaterials findOneStudyMaterials(String studyMaterialId) {
        StudyMaterials bean = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM study_materials WHERE id='" + studyMaterialId + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new StudyMaterials();
                bean.setStudyMaterialId(rs.getInt(1));
                bean.setStudyMaterialName(rs.getString(2));
                bean.setStudyMaterialDesc(rs.getString(3));
                bean.setStudyMaterialUrl(rs.getString(4));
                bean.setStaff(StaffBean.findOneStaff(rs.getString(5)));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public int getStudyMaterialId() {
        return studyMaterialId;
    }

    public void setStudyMaterialId(int studyMaterialId) {
        this.studyMaterialId = studyMaterialId;
    }

    public String getStudyMaterialName() {
        return studyMaterialName;
    }

    public void setStudyMaterialName(String studyMaterialName) {
        this.studyMaterialName = studyMaterialName;
    }

    public String getStudyMaterialDesc() {
        return studyMaterialDesc;
    }

    public void setStudyMaterialDesc(String studyMaterialDesc) {
        this.studyMaterialDesc = studyMaterialDesc;
    }

    public String getStudyMaterialUrl() {
        return studyMaterialUrl;
    }

    public void setStudyMaterialUrl(String studyMaterialUrl) {
        this.studyMaterialUrl = studyMaterialUrl;
    }

    public StaffBean getStaff() {
        return staff;
    }

    public void setStaff(StaffBean staff) {
        this.staff = staff;
    }

}
