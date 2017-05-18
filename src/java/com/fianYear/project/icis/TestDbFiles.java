/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdoulr
 */
public class TestDbFiles {

    private int id;
    private String username;
    private byte[] myImage;

    public static String createMyTest(TestDbFiles x) {

        try {
            Connection con = DbConnection.getConnection();
            String query = "insert into file_upload " + "(name,image)" + " values (?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getUsername());
            pr.setBytes(2, x.getMyImage());
            pr.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted";
    }

    public static TestDbFiles findAllTest(String imgId) {
        TestDbFiles files = null;

        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM file_upload WHERE id='" + imgId + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                files = new TestDbFiles();
                files.setId(rs.getInt(1));
                files.setUsername(rs.getString(2));
                files.setMyImage(rs.getBlob(3).getBytes(1, (int) rs.getBlob(3).length()));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }

    public static TestDbFiles downloadFiles(TestDbFiles myDownload) {
        TestDbFiles files = null;
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM file_upload WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, myDownload.getId());
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                files = new TestDbFiles();
                files.setId(rs.getInt(1));
                files.setUsername(rs.getString(2));
                files.setMyImage(rs.getBlob(3).getBytes(1, (int) rs.getBlob(3).length()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getMyImage() {
        return myImage;
    }

    public void setMyImage(byte[] myImage) {
        this.myImage = myImage;
    }

}
