package com.hostel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.hostel.model.DBConnection;
import com.hostel.model.User;
import javax.servlet.RequestDispatcher;

public class AddStudentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddStudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddStudentServlet at " + request.getContextPath() + "</h1>");
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
        
        String loginBtn = "login";
        String regisBtn = "register";
        
        try{
            dbconn.connect();
            
            //out.println(dbconn.connectionResult());
            
            if(regisBtn.equalsIgnoreCase(request.getParameter("register"))){
                //prepare statement for SQL code
                PreparedStatement ps;
                ps = dbconn.getConnection().prepareStatement("insert into student(studUserName, studEmail, studPassword) values(?, ?, ?)");
        
                //assign value to respective column
                ps.setString(1, request.getParameter("username"));
                ps.setString(2, request.getParameter("email"));
                ps.setString(3, request.getParameter("password"));

                ps.executeUpdate();
            
                out.println("Information successfully inserted");
                
                //dispatch to StudLoginRegister.jsp to login
                RequestDispatcher view = request.getRequestDispatcher("StudLoginRegister.jsp");
                view.forward(request, response);
            }//close register
            
            if(loginBtn.equalsIgnoreCase(request.getParameter("login"))){
                
                ResultSet resultSet = dbconn.getStatement().executeQuery("select * from student");
                
                String loginEmail = request.getParameter("loginEmail");
                String loginPassword = request.getParameter("loginPassword");
                
                //business logic
                User user = new User();
                user.setEmail(loginEmail);
                user.setPassword(loginPassword);
                
                int pass = 0;
                
                while(resultSet.next()){
                    if(resultSet.getString(3).equalsIgnoreCase(user.getEmail()) && resultSet.getString(4).equals(user.getPassword())){
                        pass = 1;
                        break;
                    }
                }//close while
                
                if(pass == 1){
                    //Store the data on the request-scope
                    request.setAttribute("userProfile", user);
                    
                    //dispatch to StudHomePage.jsp
                    RequestDispatcher view = request.getRequestDispatcher("StudHomePage.jsp");
                    view.forward(request, response);
                }else{
                    out.println("INVALID PASSWORD");
                    out.println(" ");
                    out.println("OR");
                    out.println(" ");
                    out.println("YOU HAVE NOT REGISTER");
                }
                
            }//close login
            
            dbconn.closeConnection();
            
        }//close try
        catch(SQLException se){
            System.out.println(se.getMessage());
        }//close catch se
        catch(Exception e){
            System.out.println(e.getMessage());
        }//close catch e
        
    }//close doPost()

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
