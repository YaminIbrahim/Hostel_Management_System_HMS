<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@page import="java.sql.*"%>

<%@page import="com.hostel.bean.LoginBean"%>
<%@page import="com.hostel.dao.LoginDAO"%>
<%@page import="com.hostel.util.DBConn"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        
        <link rel="stylesheet" href="styleProfile.css">
        
        <!-- fontawesome bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.1.1/css/fontawesome.min.css">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        
        <title>Profile</title>
    </head>
    
    <body>
        
        <%
            //request.getAttribute("email");
            String emailHome = request.getParameter("email");
            
            Connection con = null;
            Statement statement = null;
            ResultSet resultSet = null;
                
            String username = "";
            String email = "";
            String fname = "";
            String lname = "";
                
                try{
                    con = DBConn.createConnection();
                    
                    statement= con.createStatement();
                    resultSet = statement.executeQuery("select * from administrator");
                    
                    String emailDB = "";
                    String usernameDB = "";
                    String fnameDB = "";
                    String lnameDB = "";
                    
                    while(resultSet.next()){
                        
                        usernameDB = resultSet.getString("adminUserName");
                        emailDB  =resultSet.getString("adminEmail");
                        fnameDB = resultSet.getString("adminFirstName");
                        lnameDB = resultSet.getString("adminLastName");
                    
                        if(emailDB.equals(emailHome)){
                            username = resultSet.getString(2);
                            email = resultSet.getString(3);
                            fname = resultSet.getString(5);
                            lname = resultSet.getString(6);
                        }//close if
                    }//close while
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
        %>
        
        <div class="profile-card">
            <div class="image-container">
                
                <img src="image\admin.png" style="width: 100%">
                
                <div class="title">
                    <h2><% out.println(username); %></h2>
                </div>
                
            </div>
            
            <div class="main-container">
                <p>
                    <i class="fa fa-user-circle info"></i>
                    <% out.println(username); %>
                </p>
                
                <hr>
                
                <p>
                    <i class="fa fa-address-card info"></i>
                    <% out.println(fname); %>
                </p>
                
                <hr>
                
                <p>
                    <i class="fa fa-address-card info"></i>
                    <% out.println(lname); %>
                </p>
                
                <hr>
                
                <p>
                    <i class="fa fa-envelope info"></i>
                    <% out.println(email); %>
                </p>
                
                <hr>
                
                <p>
                    <i class="fa fa-id-badge info"></i>
                    Administrator
                </p>
                
                
                <form action="AdminHomePage.jsp">
                    <button class="btn">Home</button>
                </form>
            </div>
        </div>
    </body>
</html>
