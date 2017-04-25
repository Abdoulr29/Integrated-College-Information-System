/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.sql.Connection;
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
public class Permissions {

    private int permissionId;
    private RoleBean role;
    private StaffBean staff;

    public static String createPermission(Permissions x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "insert into permissions " + "(roleId,staffId)" + " values (?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getRole().getRoleId());
            pr.setInt(2, x.getStaff().getStaffId());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";
    }

    public static List<Permissions> findAllPermissions() {
        List<Permissions> retrieve = new ArrayList<Permissions>();
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM permissions";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Permissions bean = new Permissions();
                bean.setPermissionId(rs.getInt(1));
                bean.setRole(RoleBean.findOneRole(rs.getString(2)));
                bean.setStaff(StaffBean.findOneStaff(rs.getString(3)));
                retrieve.add(bean);

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static String updatePermissions(Permissions x) {
        try {

            Connection con = DbConnection.getConnection();
            String query = "UPDATE  permissions SET roleId=?,staffId=? WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getRole().getRoleId());
            pr.setInt(2, x.getStaff().getStaffId());
            pr.setInt(3, x.getPermissionId());
            pr.execute();
            con.close();
            return "updated!!!";

        } catch (Exception e) {
            e.printStackTrace();
            return "updaye failed";
        }

    }

    public static String deletePermission(Permissions x) {
        try {

            Connection con = DbConnection.getConnection();
            String query = "DELETE FROM permissions WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getPermissionId());
            pr.execute();
            con.close();
            return "deleted";

        } catch (Exception e) {
            e.printStackTrace();
            return "not deleted";
        }

    }

    public static Permissions findOnePermission(String permId) {
        Permissions bean = null;
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM permissions WHERE id='" + permId + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new Permissions();
                bean.setPermissionId(rs.getInt(1));
                bean.setRole(RoleBean.findOneRole(rs.getString(2)));
                bean.setStaff(StaffBean.findOneStaff(rs.getString(3)));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public RoleBean getRole() {
        return role;
    }

    public void setRole(RoleBean role) {
        this.role = role;
    }

    public StaffBean getStaff() {
        return staff;
    }

    public void setStaff(StaffBean staff) {
        this.staff = staff;
    }

}
