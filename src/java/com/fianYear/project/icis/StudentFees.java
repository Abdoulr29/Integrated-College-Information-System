package com.fianYear.project.icis;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdoulr
 */
public class StudentFees {

    private int studentFeeId;
    private Date paidDate;
    private int paidAmount;
    private int balance;
    private StudentBean student;
    private Fees fee;
    private int bankSlipNumber;

    public static String createStudentFees(StudentFees x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "insert into student_fees " + "(date,paid_amount,balance,studentId,feeId,bank_slip_number)" + " values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, x.getPaidDate());
            ps.setInt(2, x.getPaidAmount());
            ps.setInt(3, x.getBalance());
            ps.setInt(4, x.getStudent().getStudentId());
            ps.setInt(5, x.getFee().getFeeId());
            ps.setInt(6, x.getBankSlipNumber());
            ps.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "data inserted";
    }

    public static List<StudentFees> findAllStudentFees() {
        List<StudentFees> retrieve = new ArrayList<StudentFees>();
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT *FROM student_fees";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                StudentFees fees = new StudentFees();
                fees.setStudentFeeId(rs.getInt(1));
                fees.setPaidDate(rs.getDate(2));
                fees.setPaidAmount(rs.getInt(3));
                fees.setBalance(rs.getInt(4));
                fees.setStudent(StudentBean.findOneStudent(rs.getString(5)));
                fees.setFee(Fees.findOneFee(rs.getString(6)));
                fees.setBankSlipNumber(rs.getInt(7));
                retrieve.add(fees);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static String updateStudentFees(StudentFees x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "UPDATE class_notifications SET date=?,paid_amount=?,balance=?,studentId=?,feeId=?,bank_slip_number=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, x.getPaidDate());
            ps.setInt(2, x.getPaidAmount());
            ps.setInt(3, x.getBalance());
            ps.setInt(4, x.getStudent().getStudentId());
            ps.setInt(5, x.getFee().getFeeId());
            ps.setInt(6, x.getBankSlipNumber());
            ps.setInt(7, x.getStudentFeeId());
            ps.execute();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "data updated";
    }

    public static String deleteStudentFees(StudentFees x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "DELETE FROM student_fees WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, x.getStudentFeeId());
            ps.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data deleted";

    }

    public static StudentFees findOneStudentFee(String studentFeeId) {
        StudentFees fees = null;
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT *FROM student_fees WHERE id='" + studentFeeId + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fees = new StudentFees();
                fees.setStudentFeeId(rs.getInt(1));
                fees.setPaidDate(rs.getDate(2));
                fees.setPaidAmount(rs.getInt(3));
                fees.setBalance(rs.getInt(4));
                fees.setStudent(StudentBean.findOneStudent(rs.getString(5)));
                fees.setFee(Fees.findOneFee(rs.getString(6)));
                fees.setBankSlipNumber(rs.getInt(7));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fees;
    }

    public int getStudentFeeId() {
        return studentFeeId;
    }

    public void setStudentFeeId(int studentFeeId) {
        this.studentFeeId = studentFeeId;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public int getBalance() {
        return balance;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public StudentBean getStudent() {
        return student;
    }

    public void setStudent(StudentBean student) {
        this.student = student;
    }

    public Fees getFee() {
        return fee;
    }

    public void setFee(Fees fee) {
        this.fee = fee;
    }

    public int getBankSlipNumber() {
        return bankSlipNumber;
    }

    public void setBankSlipNumber(int bankSlipNumber) {
        this.bankSlipNumber = bankSlipNumber;
    }

}
