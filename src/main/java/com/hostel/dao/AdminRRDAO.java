package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hostel.bean.AdminRRBean;
import com.hostel.util.DBConn;

public class AdminRRDAO {
    
    public String roomRegister(AdminRRBean stud){
        
        //studEmail, studFirstName, studLastName, studAddress, studPhoneNum, studRoomNum, studCheckIn, studCheckOut, studRoomType
        String email = stud.getEmail();
        String fname = stud.getFname();
        String lname = stud.getLname();
        String address = stud.getAddress();
        String phoneNum = stud.getPhoneNum();
        String roomNum = stud.getRoomNum();
        String checkIn = stud.getCheckIn();
        String checkOut = stud.getCheckOut();
        String roomType = stud.getRoomType();
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DBConn.createConnection();
            
            String query = "INSERT INTO student (studEmail, studFirstName, studLastName, studAddress, studPhoneNum, studRoomNum, studCheckIn, studCheckOut, studRoomType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, address);
            ps.setString(5, phoneNum);
            ps.setString(6, roomNum);
            ps.setString(7, checkIn);
            ps.setString(8, checkOut);
            ps.setString(9, roomType);
            
            int i = ps.executeUpdate();
            
            if(i != 0){
                return "SUCCESS";
            }//close if
            
            
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }//close catch
        
        return "room egister unseccessful";
    }//close roomRegister
    
}//close AdminRRDAO
