package com.hostel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import com.hostel.util.DBConn;

public class AdminUpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNum = request.getParameter("phoneNum");
        String roomNum = request.getParameter("roomNum");
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        String roomType = request.getParameter("roomType");
        
        PrintWriter out = response.getWriter();
        
        //out.println(id + fname + lname + email + address + phoneNum + roomNum + checkIn + checkOut + roomType);
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String sqlQ = "UPDATE student SET studEmail=?, studFirstName=?, studLastName=?, studAddress=?, studPhoneNum=?, studRoomNum=?, studCheckIn=?, studCheckOut=?, studRoomType=? WHERE studID=?";
        
        try{
            con = DBConn.createConnection();
            statement = con.createStatement();
            
            PreparedStatement ps = con.prepareStatement(sqlQ);
            
            ps.setString(1, email);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, address);
            ps.setString(5, phoneNum);
            ps.setString(6, roomNum);
            ps.setString(7, checkIn);
            ps.setString(8, checkOut);
            ps.setString(9, roomType);
            ps.setString(10, id);
            
            ps.executeUpdate();
            
            request.setAttribute("id", id);
            request.getRequestDispatcher("/AdminCRUD.jsp").forward(request, response);
            
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
