<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Room Registration</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    
    <body>
        
        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #222433">
                
                <div>
                    <a href="https://www.javaguides.net" class="navbar-brand" style="color: #fff"> Hostel Management System </a>
                </div>

                <ul class="navbar-nav">
                    <li>
                        <a href="<%=request.getContextPath()%>/list" class="nav-link" style="color: #89CFF0"> Student </a>
                    </li>
                </ul>
                
            </nav>
        </header>
                
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    
                    <c:if test="${student != null}">
                        <form action="update" method="post">
                    </c:if>
                            
                    <c:if test="${student == null}">
                        <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${student != null}">
                                Edit Student
                            </c:if>
                                
                            <c:if test="${student == null}">
                                Add New Student
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${student != null}">
                        <input type="hidden" name="id" value="<c:out value='${student.studID}' />" />
                    </c:if>
                    
                    <fieldset class="form-group">
                        <label>Email</label> <input type="text" value="<c:out value='${student.studEmail}' />" class="form-control" name="email">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>First Name</label> <input type="text" value="<c:out value='${student.studFirstName}' />" class="form-control" name="fname">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Last Name</label> <input type="text" value="<c:out value='${student.studLastName}' />" class="form-control" name="lname">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Address</label> <input type="text" value="<c:out value='${student.studAddress}' />" class="form-control" name="address">
                    </fieldset>
                    
                    <fieldset class="form-group">
                        <label>Phone Number</label> <input type="text" value="<c:out value='${student.studPhoneNum}' />" class="form-control" name="phoneNum">
                    </fieldset>
                    
                    <fieldset class="form-group">
                        <label>Room Number</label> <input type="text" value="<c:out value='${student.studRoomNum}' />" class="form-control" name="roomNum">
                    </fieldset>
                    
                    <fieldset class="form-group">
                        <label>Check-In</label> <input type="date" value="<c:out value='${student.studCheckIn}' />" class="form-control" name="checkIn">
                    </fieldset>
                    
                    <fieldset class="form-group">
                        <label>Check-Out</label> <input type="date" value="<c:out value='${student.studCheckOut}' />" class="form-control" name="checkOut">
                    </fieldset>
                    
                    <fieldset class="form-group">
                        <label>Room Type</label> <input type="text" value="<c:out value='${student.studRoomType}' />" class="form-control" name="roomtype">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                    </form>
                    </div>
                </div>
            </div>
    </body>
</html>
