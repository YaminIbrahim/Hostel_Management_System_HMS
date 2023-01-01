package com.hostel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

import com.hostel.bean.StudCrudBean;
import com.hostel.dao.StudCrudDAO;

public class StudCrudServlet extends HttpServlet {

    //create and declare studDAO object
    private StudCrudDAO studDAO;
    
    //init method
    public void init(){
        studDAO = new StudCrudDAO();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Returns the part of this request's URL that calls the servlet.
        String action = request.getServletPath();
        
        //switch the CRUD operation
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertStud(request, response);
                    break;
                case "/delete":
                    deleteStud(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateStud(request, response);
                    break;
                default :
                    //handle list
                    listStud(request, response);
                    break;
            }//close switch
        }catch(SQLException sqle) {
            throw new ServletException(sqle);
        }//close catch
    }//close doGet
    
    //open add student form
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminAddStudent.jsp");
        dispatcher.forward(request, response);
        
    }//close showNewForm
    
    //insert student
    private void insertStud(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        //studUserName, studEmail, studFirstName, studLastName, studAddress, studPhoneNum, studRoomNum, studCheckIn, studCheckOut, studRoomType
        //String username = request.getParameter("username");
        String email = request.getParameter("email");
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String address = request.getParameter("address");
        String phoneNum = request.getParameter("phoneNum");
        String roomNum = request.getParameter("roomNum");
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        String roomType = request.getParameter("room");
        
        
        StudCrudBean studBean = new StudCrudBean (email, fname, lname, address, phoneNum, roomNum, checkIn, checkOut, roomType);
        studDAO.insertStudent(studBean);
        response.sendRedirect("list");
    }
    
    //delete student record
    private void deleteStud(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        studDAO.deleteStud(id);
        response.sendRedirect("list");

    }//close deleteStud
    
    //show edit form
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        StudCrudBean existStud = studDAO.selectStudent(id);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminAddStudent.jsp");
        request.setAttribute("student", existStud);
        dispatcher.forward(request, response);
        
    }//close showEditForm
    
    //update student
    private void updateStud(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String address = request.getParameter("address");
        String phoneNum = request.getParameter("phoneNum");
        String roomNum = request.getParameter("roomNum");
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        String roomType = request.getParameter("room");
        
        StudCrudBean studBean = new StudCrudBean (email, fname, lname, address, phoneNum, roomNum, checkIn, checkOut, roomType);
        studDAO.insertStudent(studBean);
        response.sendRedirect("list");
        
    }//close updateStud
    
    //list student
    //default
    private void listStud(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        
        List < StudCrudBean > listStud = studDAO.selectAllStudent();
        
        request.setAttribute("listStud", listStud);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminStudentList.jsp");
        dispatcher.forward(request, response);
        
    }//close listStud
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
