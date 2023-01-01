<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.sql.*"%>
<%@page import="com.hostel.util.DBConn"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Room Registration</title>
        
        <meta charset="windows-1252">
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="styleRR.css">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        
    </head>
    
    <body>
        
        <%
            String id = request.getParameter("id");
            
            Connection con = null;
            Statement statement = null;
            ResultSet resultSet = null;
            
            String sqlQ = "SELECT * FROM student";
            
            String fname = "";
            String lname = "";
            String email = "";
            String address = "";
            String phoneNum = "";
            String roomNum = "";
            String checkIn = "";
            String checkOut = "";
            String roomType = "";
            
            try{
                con = DBConn.createConnection();
                statement = con.createStatement();
                resultSet = statement.executeQuery(sqlQ);
                
                //studID, studUserName, studEmail, studPassword, studFirstName, studLastName, studAddress, studPhoneNum, studRoomNum, studCheckIn, studCheckOut, studRoomType
                while(resultSet.next()){
                    
                    if(id.equals(resultSet.getString("studID"))){
                        fname = resultSet.getString("studFirstName");
                        lname = resultSet.getString("studLastName");
                        email = resultSet.getString("studEmail");
                        address = resultSet.getString("studAddress");
                        phoneNum = resultSet.getString("studPhoneNum");
                        roomNum = resultSet.getString("studRoomNum");
                        checkIn = resultSet.getString("studCheckIn");
                        checkOut = resultSet.getString("studCheckOut");
                        roomType = resultSet.getString("studRoomType");
                    }
                    roomType=roomType.replace(" ", "_");
                }
                
            }catch(SQLException sqle){
                System.out.println(sqle.getMessage());
            }
            
            
        %>
        
        <div class="container">
            <fieldset>
                <legend>
                    Room Registration
                </legend>
                
                <form action="AdminUpdateServlet" method="post">
                    <div class="user-details">
                        
                        <input type="hidden" name="id" value= <% out.println(id); %> >
                        
                        <div class="input-box">
                            <i class="fa fa-address-card"></i>
                            <span class="details">First Name</span>
                            <input type="text" 
                                   placeholder="Enter your first name"
                                   name="firstName"
                                   value=<% out.println(fname); %>
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-address-card"></i>
                            <span class="details">Last Name</span>
                            <input type="text" 
                                   placeholder="Enter your last name"
                                   name="lastName"
                                   value=<% out.println(lname); %>
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-envelope"></i>
                            <span class="details">Email</span>
                            <input type="text" 
                                   placeholder="Enter your educational email"
                                   name="email"
                                   value=<% out.println(email); %>
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-home"></i>
                            <span class="details">Address</span>
                            <input type="text" 
                                   placeholder="Enter your Address"
                                   name="address"
                                   value=<% out.println(address); %>
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-phone"></i>
                            <span class="details">Phone number</span>
                            <input type="text" 
                                   placeholder="Enter your phone number"
                                   name="phoneNum"
                                   value=<% out.println(phoneNum); %>
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-key"></i>
                            <span class="details">Room number</span>
                            <input type="text" 
                                   placeholder="Enter room number"
                                   name="roomNum"
                                   value=<% out.println(roomNum); %>
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-calendar"></i>
                            <span class="details">Check-in date</span>
                            <input type="text"
                                   name="checkIn"
                                   value=<% out.println(checkIn); %>
                                   >
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-calendar"></i>
                            <span class="details">Check-out date</span>
                            <input type="date"
                                   name="checkOut"
                                   value=<% out.println(checkOut); %>
                                   >
                        </div>
                                   
                        <div class="input-box">
                            <i class="fa fa-calendar"></i>
                            <span class="details">Room Type</span>
                            <input type="text"
                                   name="roomType"
                                   value=<% out.println(roomType); %>
                                   >
                        </div>
                        
                    </div>
                                   
                    <div class="button">
                        <input type="submit" value="Save">
                    </div>
                </form>
                
            </fieldset>
        </div>
    </body>
</html>
