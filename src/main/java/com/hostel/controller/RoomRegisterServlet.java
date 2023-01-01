package com.hostel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.hostel.model.DBConnection;
import javax.servlet.RequestDispatcher;

public class RoomRegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RoomRegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RoomRegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        PrintWriter out = response.getWriter();
        
        DBConnection dbconn = new DBConnection("root", "1234");
        
        try{
            //connect with database
            dbconn.connect();
            
            ResultSet resultSet = dbconn.getStatement().executeQuery("select * from student");
            
            //out.println(dbconn.connectionResult());
            
            String updateSql = "UPDATE  student SET     studFirstName=?, studLastName=?, studAddress=?, studPhoneNum=?, studRoomNum=?, studCheckIn=?, studCheckOut=?, studRoomType=? WHERE   studEmail=?";
            
            PreparedStatement ps;
            ps = dbconn.getConnection().prepareStatement(updateSql);
                
            //assign value to respective column
            ps.setString(1, request.getParameter("firstName"));
            ps.setString(2, request.getParameter("lastName"));
            ps.setString(3, request.getParameter("address"));
            ps.setString(4, request.getParameter("phoneNum"));
            ps.setString(5, request.getParameter("roomNum"));
            ps.setString(6, request.getParameter("checkIn"));
            ps.setString(7, request.getParameter("checkOut"));
            ps.setString(8, request.getParameter("room"));
            ps.setString(9, request.getParameter("email"));
                
            ps.executeUpdate();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RoomRegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("SUCCSSFULLY REGISTERED");
            out.println("<a href='StudHomePage.jsp'>HOME</a>");
            out.println("</body>");
            out.println("</html>");
                
            //dispatch to StudLoginRegister.jsp to login
            //RequestDispatcher view = request.getRequestDispatcher("StudHomePage.jsp");
            //view.forward(request, response);
            
            //close connection
            dbconn.closeConnection();
        }//close try
        catch(SQLException se){
            System.out.println(se.getMessage());
        }//close catch se
        catch(Exception e){
            System.out.println(e.getMessage());
        }//close catch e
    }//close doPost

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
