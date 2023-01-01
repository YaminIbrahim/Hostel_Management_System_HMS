package com.hostel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hostel.bean.LoginBean;
import com.hostel.util.DBConn;

public class LoginDAO {
    
    public String verifyUser(LoginBean loginBean) throws SQLException{
        
        String email = loginBean.getEmail();
        String password = loginBean.getPassword();
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String emailDB = "";
        String passwordDB = "";
        
        try{
            con = DBConn.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select adminEmail, adminPassword from administrator");
            
            while(resultSet.next()){
                
                emailDB = resultSet.getString("adminEmail");
                passwordDB  =resultSet.getString("adminPassword");
                
                //email.equalsIgnoreCase(emailDB) && password.equals(passwordDB)
                //resultSet.getString(3).equalsIgnoreCase(user.getEmail()) && resultSet.getString(4).equals(user.getPassword())
                if(email.equals(emailDB) && password.equals(passwordDB)){
                    return "SUCCESS";
                }//close if
                
            }//close while
            
        }//close try
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }//close catch
        
        return "UNSUCCESS";
    
    }//close verifyUser
    
    
}//close LoginDAO
