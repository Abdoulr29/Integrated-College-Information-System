package com.fianYear.project.icis;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Abdoulr
 */
public class DbConnection {
    public static Connection getConnection(){
    Connection con=null;
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icis", "root", "");
    }catch (Exception e){e.printStackTrace();}
    return con;
    
    }
}




       
