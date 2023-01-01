package com.hostel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import com.hostel.bean.StudRegisterBean;
import com.hostel.dao.StudRegisterDAO;
import com.hostel.bean.StudLoginBean;
import com.hostel.dao.StudLoginDAO;

public class StudLoginRegisterServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        String loginBtn = "login";
        String regisBtn = "register";
        
        //register
        if(regisBtn.equalsIgnoreCase(request.getParameter("register"))){
            
            //recall from form
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            //create StudRegisterBean object
            StudRegisterBean registerBean = new StudRegisterBean();

            //create StudRegisterDAO object
            StudRegisterDAO registerDAO = new StudRegisterDAO();

            //send data to mutator RegisterBean
            registerBean.setUsername(username);
            registerBean.setEmail(email);
            registerBean.setPassword(password);

            //Logic
            String userRegister = registerDAO.registerStudent(registerBean);
            
            if(userRegister.equalsIgnoreCase("SUCCESS")){
                request.getRequestDispatcher("/StudLoginRegister.jsp").forward(request, response);
            }//close if
            else{
                request.setAttribute("errMessage", userRegister);
                request.getRequestDispatcher("/StudLoginRegister.jsp").forward(request, response);
            }//close else
            
        }//close if register
        
        //login
        if(loginBtn.equalsIgnoreCase(request.getParameter("login"))){
            
            //recall from form
            String email = request.getParameter("loginEmail");
            String password = request.getParameter("loginPassword");
            
            //create object loginBean
            StudLoginBean loginBean = new StudLoginBean();
            
            //send email and password to the loginBean object to store
            loginBean.setEmail(email);
            loginBean.setPassword(password);
            
            //create object loginDAO
            StudLoginDAO loginDAO = new StudLoginDAO();
            
            try{
                //calling verifyUser()
                String verifyAcc = loginDAO.verifyStudent(loginBean);
                
                if(verifyAcc.equalsIgnoreCase("SUCCESS")){
                    //send to home page
                    request.setAttribute("email", email);
                    request.getRequestDispatcher("/StudHomePage.jsp").forward(request, response);
                }//close if
                else{
                    request.setAttribute("errMessage", verifyAcc);
                    request.getRequestDispatcher("/StudLoginRegister.jsp").forward(request, response);
                    //out.println("WRONG PASSWORD");
                }//close else
            }//close try
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            
            
            
            
        }//close if login
        
        
        
        
        
        
        
        
        
        
        
    }//close doPost

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
