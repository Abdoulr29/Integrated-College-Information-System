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
public class Marks {

    private int markId;
    private Courses course;
    private RegisteredStudents registeredStudents;
    private int semester;
    private float assessment;
    private float finalExam;

    public static String createMarks(Marks x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "insert into marks  " + "(courseId,registered_studentId,semester,assessments,final_exam)" + " values (?,?,?,?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getCourse().getCourseId());
            pr.setInt(2, x.getRegisteredStudents().getRegNumber());
            pr.setInt(3, x.getSemester());
            pr.setFloat(4, x.getAssessment());
            pr.setFloat(5, x.getFinalExam());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted";
    }

    public static List<Marks> findAllMarks() {
        List<Marks> retrieve = new ArrayList<Marks>();
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM marks";
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Marks marks = new Marks();
                marks.setMarkId(rs.getInt(1));
                marks.setCourse(Courses.findOneCourse(rs.getString(2)));
                marks.setRegisteredStudents(RegisteredStudents.findOneRegisteredStd(rs.getString(3)));
                marks.setSemester(rs.getInt(4));
                marks.setAssessment(rs.getFloat(5));
                marks.setFinalExam(rs.getFloat(6));
                retrieve.add(marks);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retrieve;
    }

    public static String updateMarks(Marks x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "UPDATE marks SET courseId=?,registered_studentId=?,semester=?,assessments=?,final_exam=? WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getCourse().getCourseId());
            pr.setInt(2, x.getRegisteredStudents().getRegNumber());
            pr.setInt(3, x.getSemester());
            pr.setFloat(4, x.getAssessment());
            pr.setFloat(5, x.getFinalExam());
            pr.setInt(6, x.getMarkId());
            pr.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data updated";
    }

    public static String deleteMarks(Marks x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "DELETE FROM marks WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getMarkId());
            pr.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data deleted";
    }

    public static Marks findOneMark(String markID) {
        Marks marks = null;
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT *FROM marks WHERE id='" + markID + "'";
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                marks = new Marks();
                marks.setMarkId(rs.getInt(1));
                marks.setCourse(Courses.findOneCourse(rs.getString(2)));
                marks.setRegisteredStudents(RegisteredStudents.findOneRegisteredStd(rs.getString(3)));
                marks.setSemester(rs.getInt(4));
                marks.setAssessment(rs.getFloat(5));
                marks.setFinalExam(rs.getFloat(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marks;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public RegisteredStudents getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(RegisteredStudents registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public float getAssessment() {
        return assessment;
    }

    public void setAssessment(float assessment) {
        this.assessment = assessment;
    }

    public float getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(float finalExam) {
        this.finalExam = finalExam;
    }

}
