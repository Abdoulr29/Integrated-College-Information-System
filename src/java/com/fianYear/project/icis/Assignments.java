package com.fianYear.project.icis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdoulr
 */
public class Assignments {

    private int assignmentId;
    private String url;
    private String name;
    private String description;
    private RegisteredStudents registeredStudents;

    public static String createAssignments(Assignments x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "insert into assignments  " + "(name,description,url,registered_studentId)" + " values (?,?,?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getName());
            pr.setString(2, x.getDescription());
            pr.setString(3, x.getUrl());
            pr.setInt(4, x.getRegisteredStudents().getRegNumber());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted";
    }

    public static List<Assignments> findAllAssignments() {
        List<Assignments> retrieve = new ArrayList<Assignments>();
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM assignments";
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Assignments ass = new Assignments();
                ass.setAssignmentId(rs.getInt(1));
                ass.setName(rs.getString(2));
                ass.setDescription(rs.getString(3));
                ass.setUrl(rs.getString(4));
                ass.setRegisteredStudents(RegisteredStudents.findOneRegisteredStd(rs.getString(5)));
                retrieve.add(ass);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retrieve;
    }

    public static String updateAssignments(Assignments x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "UPDATE assignments SET name=?,description=?,url=?,registered_studentId=? WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
             pr.setString(1, x.getName());
            pr.setString(2, x.getDescription());
            pr.setString(3, x.getUrl());
            pr.setInt(4, x.getRegisteredStudents().getRegNumber());
            pr.setInt(5, x.getAssignmentId());
            pr.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data updated";
    }

    public static String deleteAssignment(Assignments x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "DELETE FROM assignments WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getAssignmentId());
            pr.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data deleted";
    }

    public static Assignments findOneAssignment(String AssID) {
        Assignments ass = null;
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT *FROM assignments WHERE id='" + AssID + "'";
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                ass = new Assignments();
                ass.setAssignmentId(rs.getInt(1));
                ass.setName(rs.getString(2));
                ass.setDescription(rs.getString(3));
                ass.setUrl(rs.getString(4));
                ass.setRegisteredStudents(RegisteredStudents.findOneRegisteredStd(rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ass;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RegisteredStudents getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(RegisteredStudents registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

}
