/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
            pr.executeQuery();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted";
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
