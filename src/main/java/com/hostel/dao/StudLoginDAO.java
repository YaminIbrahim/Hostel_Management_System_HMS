package com.hostel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hostel.util.DBConn;
import com.hostel.bean.StudLoginBean;

public class StudLoginDAO {
    
    public String verifyStudent(StudLoginBean studBean){
        
        String email = studBean.getEmail();
        String password = studBean.getPassword();
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String emailDB = "";
        String passwordDB = "";
        
        try{
            con = DBConn.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT studEmail, studPassword FROM student");
            
            while(resultSet.next()){
                
                emailDB = resultSet.getString("studEmail");
                passwordDB = resultSet.getString("studPassword");
                
                if(email.equals(emailDB) && password.equals(passwordDB)){
                    return "SUCCESS";
                }//close if
                
            }//close while
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }//close catch
        
        return "UNSUCCESS";
        
    }//close verifyStudent
}//close StudLoginDAO
