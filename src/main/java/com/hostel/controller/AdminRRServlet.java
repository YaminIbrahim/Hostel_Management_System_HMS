package com.hostel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import com.hostel.util.DBConn;
import com.hostel.bean.AdminRRBean;
import com.hostel.dao.AdminRRDAO;

public class AdminRRServlet extends HttpServlet {

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
        
        //printwriter for out
        PrintWriter out = response.getWriter();
        
        //recall from AdminRoomRegister.jsp form
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNum = request.getParameter("phoneNum");
        String roomNum = request.getParameter("roomNum");
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        String roomType = request.getParameter("room");
        
        //unit testing
        //out.println(fname + lname + email + address + phoneNum + roomNum + checkIn + checkOut + roomType);
        
        //create AdminRRBean object
        AdminRRBean rrBean = new AdminRRBean();
        
        //create AdminRRDAO object
        AdminRRDAO rrDao = new AdminRRDAO();
        
        //studEmail, studFirstName, studLastName, studAddress, studPhoneNum, studRoomNum, studCheckIn, studCheckOut, studRoomType
        
        //send data to mutator AdminRRBean
        rrBean.setEmail(email);
        rrBean.setFname(fname);
        rrBean.setLname(lname);
        rrBean.setAddress(address);
        rrBean.setPhoneNum(phoneNum);
        rrBean.setRoomNum(roomNum);
        rrBean.setCheckIn(checkIn);
        rrBean.setCheckOut(checkOut);
        rrBean.setRoomType(roomType);
        
        //Logic and recall dao
        String roomRegister = rrDao.roomRegister(rrBean);
        
        if(roomRegister.equals("SUCCESS")){
            
            //send to admin crud jsp
            request.getRequestDispatcher("/AdminCRUD.jsp").forward(request, response);
            
        }else{
            
            request.setAttribute("errMessage", roomRegister);
            request.getRequestDispatcher("/AdminRoomRegister.jsp").forward(request, response);
            
        }//close else
    }//close doPost

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
