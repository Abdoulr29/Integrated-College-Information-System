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
public class Notification {

    private int notificationId;
    private String message;
    private String url;
    private StaffBean staff;

    public static String createNotification(Notification x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "insert into notifications " + "(message,url,staffId)" + " values (?,?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getMessage());
            pr.setString(2, x.getUrl());
            pr.setInt(3,x.getStaff().getStaffId());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";
    }

    public static List<Notification> findAllNotifications() {
        List<Notification> retrieve = new ArrayList<Notification>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM notifications";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Notification bean = new Notification();
                bean.setNotificationId(rs.getInt(1));
                bean.setMessage(rs.getString(2));
                bean.setUrl(rs.getString(3));
                bean.setStaff(StaffBean.findOneStaff(rs.getString(4)));
                retrieve.add(bean);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    
    public static String deleteNotification(Notification x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "DELETE FROM notifications WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1,x.getNotificationId());
            pr.execute();
            con.close();
            return "deleted";

        } catch (Exception e) {
            e.printStackTrace();
            return "not deleted";
        }

    }

    public static Notification findOneNotification(String notificationId) {
        Notification bean = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM notifications WHERE id='" + notificationId + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new Notification();
                bean.setNotificationId(rs.getInt(1));
                bean.setMessage(rs.getString(2));
                bean.setUrl(rs.getString(3));
                bean.setStaff(StaffBean.findOneStaff(rs.getString(4)));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public StaffBean getStaff() {
        return staff;
    }

    public void setStaff(StaffBean staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return  message ;
    }
    

}
