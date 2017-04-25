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
public class RoleBean {

    private int roleId;
    private String name;

    public static String createRoles(RoleBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "insert into roles " + "(name)" + " values (?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getName());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";
    }

    public static List<RoleBean> findAllRoles() {
        List<RoleBean> retrieve = new ArrayList<RoleBean>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM roles";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RoleBean bean = new RoleBean();
                bean.setRoleId(rs.getInt(1));
                bean.setName(rs.getString(2));
                retrieve.add(bean);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static String updateRole(RoleBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "UPDATE  roles SET name=? WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getName());
            pr.setInt(2, x.getRoleId());
            pr.execute();
            con.close();
            return "updated!!!";

        } catch (Exception e) {
            e.printStackTrace();
            return "updaye failed";
        }

    }

    public static String deleteRole(RoleBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "DELETE FROM roles WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getRoleId());
            pr.execute();
            con.close();
            return "deleted";

        } catch (Exception e) {
            e.printStackTrace();
            return "not deleted";
        }

    }

    public static RoleBean findOneRole(String roleId) {
        RoleBean bean = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM roles WHERE id='" + roleId + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new RoleBean();
                bean.setRoleId(rs.getInt(1));
                bean.setName(rs.getString(2));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
