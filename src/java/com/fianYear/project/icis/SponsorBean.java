/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.sql.Date;
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
public class SponsorBean {

    private int sponserId;
    private String sponsorName;
    private String sponserTelephone;
    private String sponsorEmail;

    public static String createSponsor(SponsorBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "insert into sponsors " + "(sponsor_name,telephone,email)" + " values (?,?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getSponsorName());
            pr.setString(2, x.getSponserTelephone());
            pr.setString(3, x.getSponsorEmail());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";

    }

    public static String updateSponsor(SponsorBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "UPDATE  sponsors SET sponsor_name=?,telephone=?,email=? WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getSponsorName());
            pr.setString(2, x.getSponserTelephone());
            pr.setString(3, x.getSponsorEmail());
            pr.setString(4, Integer.toString(x.getSponserId()));
            pr.execute();
            con.close();
            return "updated!!!";

        } catch (Exception e) {
            e.printStackTrace();
            return "updaye failed";
        }

    }

    public static String deleteSponsor(SponsorBean x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "DELETE FROM sponsors WHERE id=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, Integer.toString(x.getSponserId()));
            pr.execute();
            con.close();
            return "deleted";

        } catch (Exception e) {
            e.printStackTrace();
            return "not deleted";
        }

    }

    public static List<SponsorBean> findAllSponsor() {
        List<SponsorBean> retrieve = new ArrayList<SponsorBean>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM sponsors";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                SponsorBean bean = new SponsorBean();
                bean.setSponserId(rs.getInt(1));
                bean.setSponsorName(rs.getString(2));
                bean.setSponserTelephone(rs.getString(3));
                bean.setSponsorEmail(rs.getString(4));
                retrieve.add(bean);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrieve;
    }

    public static SponsorBean findOneSponsor(String sponsorID) {
        SponsorBean bean = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT * FROM sponsors WHERE id='" + sponsorID + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bean = new SponsorBean();
                bean.setSponserId(rs.getInt(1));
                bean.setSponsorName(rs.getString(2));
                bean.setSponserTelephone(rs.getString(3));
                bean.setSponsorEmail(rs.getString(4));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public int getSponserId() {
        return sponserId;
    }

    public void setSponserId(int sponserId) {
        this.sponserId = sponserId;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getSponserTelephone() {
        return sponserTelephone;
    }

    public void setSponserTelephone(String sponserTelephone) {
        this.sponserTelephone = sponserTelephone;
    }

    public String getSponsorEmail() {
        return sponsorEmail;
    }

    public void setSponsorEmail(String sponsorEmail) {
        this.sponsorEmail = sponsorEmail;
    }

    @Override
    public String toString() {
        return sponsorName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.sponserId;
        hash = 19 * hash + (this.sponsorName != null ? this.sponsorName.hashCode() : 0);
        hash = 19 * hash + (this.sponserTelephone != null ? this.sponserTelephone.hashCode() : 0);
        hash = 19 * hash + (this.sponsorEmail != null ? this.sponsorEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SponsorBean other = (SponsorBean) obj;
        if (this.sponserId != other.sponserId) {
            return false;
        }
        if ((this.sponsorName == null) ? (other.sponsorName != null) : !this.sponsorName.equals(other.sponsorName)) {
            return false;
        }
        if ((this.sponserTelephone == null) ? (other.sponserTelephone != null) : !this.sponserTelephone.equals(other.sponserTelephone)) {
            return false;
        }
        if ((this.sponsorEmail == null) ? (other.sponsorEmail != null) : !this.sponsorEmail.equals(other.sponsorEmail)) {
            return false;
        }
        return true;
    }
    
    

}
