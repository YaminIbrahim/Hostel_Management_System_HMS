<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Student record</title>
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

        <div class="row">

            <div class="container">
                <h3 class="text-center">List of Student</h3>
                
                <hr>
                
                <div class="container text-left">
                    <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Student</a>
                </div>
                
                <br>
                
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Email</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Address</th>
                            <th>Phone Number</th>
                            <th>Room Number</th>
                            <th>Check In</th>
                            <th>Check out</th>
                            <th>Room Type</th>
                        </tr>
                    </thead>
            
                    <tbody>
                        <c:forEach var="student" items="${listStud.rows}">
                            <tr>
                                <td>
                                    <c:out value="${student.studID}" />
                                </td>
                                
                                <td>
                                    <c:out value="${student.studEmail}" />
                                </td>
                                
                                <td>
                                    <c:out value="${student.studFirstName}" />
                                </td>
                                
                                <td>
                                    <c:out value="${student.studLastName}" />
                                </td>
                                
                                <td>
                                    <c:out value="${student.studAddress}" />
                                </td>
                                
                                <td>
                                    <c:out value="${student.studPhoneNum}" />
                                </td>
                                
                                <td>
                                    <c:out value="${student.studRoomNum}" />
                                </td>
                                
                                <td>
                                    <c:out value="${student.studCheckIn}" />
                                </td>
                                
                                <td>
                                    <c:out value="${student.studCheckOut}" />
                                </td>
                                
                                <td>
                                    <c:out value="${student.studRoomType}" />
                                </td>
                                
                                <td>
                                    <a href="edit? id=<c:out value='${student.studID}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
                                    <a href="delete? id=<c:out value='${student.studID}' />">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
