/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fianYear.project.icis;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Abdoulr
 */
public class Admin {

    private String firstname;
    private String lastname;
    private String password;
    private String email;

    public static String createAdmin(Admin x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "insert into admin " + "(firstname,lastname,password,email)" + " values (?,?,?,?)";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getFirstname());
            pr.setString(2, x.getLastname());
            pr.setString(3, x.getPassword());
            pr.setString(4, x.getEmail());
            pr.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data inserted!!!";
    }

    public static String adminAuthentication(Admin x) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
            String query = "SELECT email,password FROM admin WHERE email=? and password=?";
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, x.getEmail());
            pr.setString(2, x.getPassword());
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                System.out.println("Valid login credentials");
            } else {
                System.out.println("Invalid login credentials");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "logged in!!!";
    }
    
    
    
    
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
