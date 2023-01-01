<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
        
        <div class="container">
            <fieldset>
                <legend>
                    Room Registration
                </legend>
                
                <form action="AdminRRServlet" method="post">
                    <div class="user-details">
                        
                        <div class="input-box">
                            <i class="fa fa-address-card"></i>
                            <span class="details">First Name</span>
                            <input type="text" 
                                   placeholder="Enter student first name"
                                   name="firstName"
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-address-card"></i>
                            <span class="details">Last Name</span>
                            <input type="text" 
                                   placeholder="Enter student last name"
                                   name="lastName"
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-envelope"></i>
                            <span class="details">Email</span>
                            <input type="text" 
                                   placeholder="Enter student educational email"
                                   name="email"
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-home"></i>
                            <span class="details">Address</span>
                            <input type="text" 
                                   placeholder="Enter student Address"
                                   name="address"
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-phone"></i>
                            <span class="details">Phone number</span>
                            <input type="text" 
                                   placeholder="Enter student phone number"
                                   name="phoneNum"
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-key"></i>
                            <span class="details">Room number</span>
                            <input type="text" 
                                   placeholder="Enter student number"
                                   name="roomNum"
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-calendar"></i>
                            <span class="details">Check-in date</span>
                            <input type="date"
                                   name="checkIn"
                                   required>
                        </div>
                        
                        <div class="input-box">
                            <i class="fa fa-calendar"></i>
                            <span class="details">Check-out date</span>
                            <input type="date"
                                   name="checkOut">
                        </div>
                        
                    </div>
                    
                    <div class="room-details">
                        <input type="radio" name="room" id="dot-1" value="2 person room">
                        <input type="radio" name="room" id="dot-2" value="4 person room">
                        <input type="radio" name="room" id="dot-3" value="8 person room">
                        <input type="radio" name="room" id="dot-4" value="Dorm">
                        <i class="fa fa-bed"></i>
                        <span class="room-type">Room type</span>
                        <div class="category">
                            <label for="dot-1">
                                <span class="dot one"></span>
                                <span class="room">2 Person Room</span>
                            </label>
                            
                            <label for="dot-2">
                                <span class="dot two"></span>
                                <span class="room">4 Person Room</span>
                            </label>
                            
                            <label for="dot-3">
                                <span class="dot three"></span>
                                <span class="room">8 Person Room</span>
                            </label>
                            
                            <label for="dot-4">
                                <span class="dot four"></span>
                                <span class="room">Dorm</span>
                            </label>
                        </div>
                    </div>
                    
                    <div class="button">
                        <input type="submit" value="Register">
                    </div>
                    
                </form>
            </fieldset>
        </div>
    </body>
</html>
