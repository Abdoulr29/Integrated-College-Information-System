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
public class Fees {

    private int feeId;
    private String feeName;
    private double dueAmount;
    private double atLeastAmount;
    private String feeDescription;
    private DepartmentBean department;

    public static String createFees(Fees x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "insert into fees " + "(name,departmentId,due_amount,atleast_amount,description)" + " values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, x.getFeeName());
            ps.setInt(2, x.getDepartment().getDepartmentID());
            ps.setDouble(3, x.getDueAmount());
            ps.setDouble(4, x.getAtLeastAmount());
            ps.setString(5, x.getFeeDescription());
            ps.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted";
    }

    public static List<Fees> findAllFees() {
        List<Fees> retrieve = new ArrayList<Fees>();
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM fees";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fees bean = new Fees();
                bean.setFeeId(rs.getInt(1));
                bean.setFeeName(rs.getString(2));
                bean.setDepartment(DepartmentBean.findOneDepartment(rs.getString(3)));
                bean.setDueAmount(rs.getDouble(4));
                bean.setAtLeastAmount(rs.getDouble(5));
                bean.setFeeDescription(rs.getString(6));
                retrieve.add(bean);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static Fees findOneFee(String feeID) {
        Fees fee = null;
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM fees WHERE id='" + feeID + "'";
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                fee = new Fees();
                fee.setFeeId(rs.getInt(1));
                fee.setFeeName(rs.getString(2));
                fee.setDepartment(DepartmentBean.findOneDepartment(rs.getString(3)));
                fee.setDueAmount(rs.getDouble(4));
                fee.setAtLeastAmount(rs.getDouble(5));
                fee.setFeeDescription(rs.getString(6));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fee;
    }

    public static String updateFees(Fees x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getFeeName());
            pr.setInt(2, x.getDepartment().getDepartmentID());
            pr.setDouble(3, x.getDueAmount());
            pr.setDouble(4, x.getAtLeastAmount());
            pr.setString(5, x.getFeeDescription());
            pr.setInt(6, x.getFeeId());
            pr.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data updated";
    }

    public static String deleteFees(Fees x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "DELETE FROM fees WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getFeeId());
            pr.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data deleted";
    }

    public int getFeeId() {
        return feeId;
    }

    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public double getAtLeastAmount() {
        return atLeastAmount;
    }

    public void setAtLeastAmount(double atLeastAmount) {
        this.atLeastAmount = atLeastAmount;
    }

    public String getFeeDescription() {
        return feeDescription;
    }

    public void setFeeDescription(String feeDescription) {
        this.feeDescription = feeDescription;
    }

    public DepartmentBean getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentBean department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return  feeName ;
    }
    
    

}
