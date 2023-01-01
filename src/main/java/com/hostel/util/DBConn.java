package com.hostel.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
    
    public static Connection createConnection(){
        
        Connection con = null;
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/hostel";
        String dbUsername = "root";
        String dbPassword = "1234";
        
        try{
            
            try{
                Class.forName(dbDriver);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }//close catch
            
            con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            
        }//close try
        catch(Exception e){
            System.out.println(e.getMessage());
        }//close catch
        
        return con;
        
    }//close createConnection
}//close DBConn
