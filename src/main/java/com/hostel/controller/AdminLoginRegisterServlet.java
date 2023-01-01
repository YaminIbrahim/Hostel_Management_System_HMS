package com.hostel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import com.hostel.bean.RegisterBean;
import com.hostel.dao.RegisterDAO;

import com.hostel.bean.LoginBean;
import com.hostel.dao.LoginDAO;

@WebServlet(name = "AdminLoginRegisterServlet", urlPatterns = {"/AdminLoginRegisterServlet"})
public class AdminLoginRegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminLoginRegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminLoginRegisterServlet at " + request.getContextPath() + "</h1>");
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
        
        String loginBtn = "login";
        String regisBtn = "register";
        
        //register
        if(regisBtn.equalsIgnoreCase(request.getParameter("register"))){
            
            //recall from form
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            //create RegisterBean object
            RegisterBean registerBean = new RegisterBean();

            //create RegisterDAO object
            RegisterDAO registerDAO = new RegisterDAO();

            //send data to mutator RegisterBean
            registerBean.setUsername(username);
            registerBean.setEmail(email);
            registerBean.setPassword(password);

            //Logic
            String userRegister = registerDAO.registerUser(registerBean);
            
            if(userRegister.equalsIgnoreCase("SUCCESS")){
                request.getRequestDispatcher("/AdminLoginRegister.jsp").forward(request, response);
            }//close if
            else{
                //request.setAttribute("errMessage", userRegister);
                //request.getRequestDispatcher("/AdminLoginRegister.jsp").forward(request, response);
                out.println("UNSUCCESS");
            }//close else
            
        }//close if register
        
        //login
        if(loginBtn.equalsIgnoreCase(request.getParameter("login"))){
            
            //recall from form
            String email = request.getParameter("loginEmail");
            String password = request.getParameter("loginPassword");
            
            //create object loginBean
            LoginBean loginBean = new LoginBean();
            
            //send email and password to the loginBean object to store
            loginBean.setEmail(email);
            loginBean.setPassword(password);
            
            //create object loginDAO
            LoginDAO loginDAO = new LoginDAO();
            
            try{
                //calling verifyUser()
                String verifyAcc = loginDAO.verifyUser(loginBean);
                
                if(verifyAcc.equalsIgnoreCase("SUCCESS")){
                    //send to home page
                    request.setAttribute("email", email);
                    request.getRequestDispatcher("/AdminHomePage.jsp").forward(request, response);
                }//close if
                else{
                    request.setAttribute("errMessage", verifyAcc);
                    request.getRequestDispatcher("/AdminLoginRegister.jsp").forward(request, response);
                    //out.println("WRONG PASSWORD");
                }//close else
            }//close try
            catch(SQLException sqle){
                System.out.println(sqle.getMessage());
            }
            
            
            
            
        }//close if login
        
    }//close doPost

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
