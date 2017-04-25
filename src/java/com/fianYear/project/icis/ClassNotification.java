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
public class ClassNotification {

    private int classNotificationId;
    private Notification notificationID;

    public static String createClassNotification(ClassNotification x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "insert into class_notifications " + "(notificationId)" + " values (?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getNotificationID().getNotificationId());
            pr.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted";
    }

    public static List<ClassNotification> findAllClassNotification() {
        List<ClassNotification> retrieve = new ArrayList<ClassNotification>();
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT *FROM class_notifications";
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                ClassNotification notification = new ClassNotification();
                notification.setClassNotificationId(rs.getInt(1));
                notification.setNotificationID(Notification.findOneNotification(rs.getString(2)));
                retrieve.add(notification);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static String deleteClassNotification(ClassNotification x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "DELETE FROM class_notifications WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, x.getClassNotificationId());
            pr.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data deleted";
    }

    public static ClassNotification findOneClassNotification(String classNotID) {
        ClassNotification cn = null;
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM class_notifications WHERE id='" + classNotID + "'";
            PreparedStatement pr = con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                cn = new ClassNotification();
                cn.setClassNotificationId(rs.getInt(1));
                cn.setNotificationID(Notification.findOneNotification(rs.getString(2)));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cn;
    }

    public static String updateClassNotification(ClassNotification x) {
        try {
            Connection con = DbConnection.getConnection();
            String query = "UPDATE class_notifications SET notificationId=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, x.getNotificationID().getNotificationId());
            ps.setInt(2, x.getClassNotificationId());
            ps.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "data updated";
    }

    public int getClassNotificationId() {
        return classNotificationId;
    }

    public void setClassNotificationId(int classNotificationId) {
        this.classNotificationId = classNotificationId;
    }

    public Notification getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(Notification notificationID) {
        this.notificationID = notificationID;
    }

}
