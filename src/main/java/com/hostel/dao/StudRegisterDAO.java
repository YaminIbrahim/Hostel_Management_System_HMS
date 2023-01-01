package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.hostel.util.DBConn;
import com.hostel.bean.StudRegisterBean;

public class StudRegisterDAO {
    public String registerStudent(StudRegisterBean srBean){
        
        //calling data from bean
        String username = srBean.getUsername();
        String email = srBean.getEmail();
        String password = srBean.getPassword();
        
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DBConn.createConnection();
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM student");
            
            String id = "";
            
            while(rs.next()){
                
                String emailDB = rs.getString("studEmail");
                String idDB = rs.getString("studID");
                
                if(email.equals(emailDB)){
                    id = idDB;
                }//close if
                
            }//close while
            
            
            String query = "UPDATE student SET studUserName=?, studPassword=? WHERE studID=?";
            
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, id);
            
            int i = ps.executeUpdate();
            
            if(i != 0){
                return "SUCCESS";
            }//close if
            
            
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }//close catch
        
        return "register unseccessful";
        
    }//close registerStudent
}//close studRegisterDAO
