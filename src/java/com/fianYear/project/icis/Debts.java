package com.fianYear.project.icis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sun.reflect.generics.visitor.Reifier;

/**
 *
 * @author Abdoulr
 */
public class Debts {

    private int debtsId;
    private String debtsName, description;
    private int dueAmount, paidAmount, balance;
    private RegisteredStudents registeredStudents;

    public static String createDebts(Debts x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "insert into debts  " + "(name,due_amount,paid_amount,balance,description,registered_studentId)" + " values (?,?,?,?,?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getDebtsName());
            pr.setInt(2, x.getDueAmount());
            pr.setInt(3, x.getPaidAmount());
            pr.setInt(4, x.getBalance());
            pr.setString(5, x.getDescription());
            pr.setInt(6, x.getRegisteredStudents().getRegNumber());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted";
    }

    public static List<Debts> findAllDebts() {
        List<Debts> retrieve = new ArrayList<Debts>();
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM debts";
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Debts debts = new Debts();
                debts.setDebtsId(rs.getInt(1));
                debts.setDebtsName(rs.getString(2));
                debts.setDueAmount(rs.getInt(3));
                debts.setPaidAmount(rs.getInt(4));
                debts.setBalance(rs.getInt(5));
                debts.setDescription(rs.getString(6));
                debts.setRegisteredStudents(RegisteredStudents.findOneRegisteredStd(rs.getString(7)));
                retrieve.add(debts);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static String updateDebts(Debts x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "UPDATE debts SET name=?,due_amount=?,paid_amount=?,balance=?,description=?,registered_studentId=? WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getDebtsName());
            pr.setInt(2, x.getDueAmount());
            pr.setInt(3, x.getPaidAmount());
            pr.setInt(4, x.getBalance());
            pr.setString(5, x.getDescription());
            pr.setInt(6, x.getRegisteredStudents().getRegNumber());
            pr.setInt(7, x.getDebtsId());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data updated";
    }

    public static String deleteDebts(Debts x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "DELETE FROM debts WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getDebtsId());
            pr.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "deleted";
    }

    public static Debts findOneDebt(String DebtID) {
        Debts debts = null;
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT *FROM debts WHERE id='" + DebtID + "'";
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                debts = new Debts();
                debts.setDebtsId(rs.getInt(1));
                debts.setDebtsName(rs.getString(2));
                debts.setDueAmount(rs.getInt(3));
                debts.setPaidAmount(rs.getInt(4));
                debts.setBalance(rs.getInt(5));
                debts.setDescription(rs.getString(6));
                debts.setRegisteredStudents(RegisteredStudents.findOneRegisteredStd(rs.getString(7)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return debts;
    }

    public int getDebtsId() {
        return debtsId;
    }

    public void setDebtsId(int debtsId) {
        this.debtsId = debtsId;
    }

    public String getDebtsName() {
        return debtsName;
    }

    public void setDebtsName(String debtsName) {
        this.debtsName = debtsName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(int dueAmount) {
        this.dueAmount = dueAmount;
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

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public RegisteredStudents getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(RegisteredStudents registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

}
