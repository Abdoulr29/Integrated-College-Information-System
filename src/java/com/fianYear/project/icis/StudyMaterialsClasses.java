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
public class StudyMaterialsClasses {

    private int studyClassId;
    private StudyMaterials studyMaterial;
    private StudentClasses classes;
    
    public static String createClassMaterials(StudyMaterialsClasses x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "insert into study_materials_classes " + "(study_materialId,classId)" + " values (?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getStudyMaterial().getStudyMaterialId());
            pr.setInt(2, x.getClasses().getStudentClassId());
            pr.execute();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";
    }
    
    public static List<StudyMaterialsClasses> findAllClassMaterials() {
        List<StudyMaterialsClasses> retrieve = new ArrayList<StudyMaterialsClasses>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM study_materials_classes";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                StudyMaterialsClasses bean = new StudyMaterialsClasses();
                bean.setStudyClassId(rs.getInt(1));
                bean.setStudyMaterial(StudyMaterials.findOneStudyMaterials(rs.getString(2)));
                bean.setClasses(StudentClasses.findOneClass(rs.getString(3)));
                retrieve.add(bean);
            }
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }
    
    public static String updateStudyMaterialsClasses(StudyMaterialsClasses x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "UPDATE  study_materials_classes SET study_materialId=?,classId=? WHERE studyClassId=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getStudyMaterial().getStudyMaterialId());
            pr.setInt(2, x.getClasses().getStudentClassId());
            pr.setInt(3, x.getStudyClassId());
            pr.execute();
            con.close();
            return "updated!!!";
            
        } catch (Exception e) {
            e.printStackTrace();
            return "updaye failed";
        }
        
    }
    
    public static String deleteStudyMaterialClass(StudyMaterialsClasses x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "DELETE FROM study_materials_classes WHERE studyClassId=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, Integer.toString(x.getStudyClassId()));
            pr.execute();
            con.close();
            return "deleted";
            
        } catch (Exception e) {
            e.printStackTrace();
            return "not deleted";
        }
        
    }
    
    public static StudyMaterialsClasses findOneClassMaterial(String classMaterialId) {
        StudyMaterialsClasses bean = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM study_materials_classes WHERE studyClassId='" + classMaterialId + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new StudyMaterialsClasses();
                bean.setStudyClassId(rs.getInt(1));
                bean.setStudyMaterial(StudyMaterials.findOneStudyMaterials(rs.getString(2)));
                bean.setClasses(StudentClasses.findOneClass(rs.getString(3)));
            }
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    
    public int getStudyClassId() {
        return studyClassId;
    }
    
    public void setStudyClassId(int studyClassId) {
        this.studyClassId = studyClassId;
    }
    
    public StudyMaterials getStudyMaterial() {
        return studyMaterial;
    }
    
    public void setStudyMaterial(StudyMaterials studyMaterial) {
        this.studyMaterial = studyMaterial;
    }
    
    public StudentClasses getClasses() {
        return classes;
    }
    
    public void setClasses(StudentClasses classes) {
        this.classes = classes;
    }
    
}
