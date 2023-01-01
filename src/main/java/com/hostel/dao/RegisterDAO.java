package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hostel.bean.RegisterBean;
import com.hostel.util.DBConn;

public class RegisterDAO {
    
    public String registerUser(RegisterBean registerBean){
        
        String username = registerBean.getUsername();
        String email = registerBean.getEmail();
        String password = registerBean.getPassword();
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DBConn.createConnection();
            
            String query = "INSERT INTO administrator (adminUserName, adminEmail, adminPassword) VALUES (?, ?, ?)";
            
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            
            int i = ps.executeUpdate();
            
            if(i != 0){
                return "SUCCESS";
            }//close if
            
        }//close try
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }//close catch
        
        return "register unseccessful";
    }//close registerUser
    
}//close ResiterDAO
