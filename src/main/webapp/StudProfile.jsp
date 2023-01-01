<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@page import="java.sql.*"%>

<%@page import="com.hostel.bean.StudLoginBean"%>
<%@page import="com.hostel.dao.StudLoginDAO"%>
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
            String address = "";
            String phoneNum = "";
            String roomNum = "";
            String checkIn = "";
            String checkOut = "";
            String roomType = "";
                
            try{
                con = DBConn.createConnection();
                    
                statement= con.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM student");
                    
                while(resultSet.next()){
                    
                    if(emailHome.equals(resultSet.getString(3))){
                        username = resultSet.getString(2);
                        email = resultSet.getString(3);
                        fname = resultSet.getString(5);
                        lname = resultSet.getString(6);
                        address = resultSet.getString(7);
                        phoneNum = resultSet.getString(8);
                        roomNum = resultSet.getString(9);
                        checkIn = resultSet.getString(10);
                        checkOut = resultSet.getString(11);
                        roomType = resultSet.getString(12);
                    }//close if
                    
                }//close while
            }catch(Exception e){
                System.out.println(e.getMessage());
            }//close catch
        %>
        <div class="profile-card">
            <div class="image-container">
                
                <img src="image\student.png" style="width: 100%">
                
                <div class="title">
                    <h2><% out.println(username); %></h2>
                </div>
                
            </div>
            
            <div class="main-container">
                <p>
                    <i class="fa fa-user-circle info"></i>
                    <% out.print(fname + " " + lname); %>
                </p>
                
                <hr>
                
                <p>
                    <i class="fa fa-phone info"></i>
                    <% out.print(phoneNum); %>
                </p>
                
                <hr>
                
                <p>
                    <i class="fa fa-envelope info"></i>
                    <% out.print(emailHome); %>
                </p>
                
                <hr>
                
                <p>
                    <i class="fa fa-id-badge info"></i>
                    Student
                </p>
                
                <hr>
                
                <p>
                    <i class="fa fa-bed info"></i>
                    <% out.print(roomNum); %>
                </p>
                
                <hr>
                
                <p>
                    <i class="fa fa-bed info"></i>
                    <% out.print(roomType); %>
                </p>
                
                <form action="StudHomePage.jsp">
                    <button class="btn">Home</button>
                </form>
            </div>
        </div>
    </body>
</html>
