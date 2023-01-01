<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        
        <title>Student Record</title>
        
        <style type="text/css">
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@100;300&display=swap');
            
            body{
                padding: 0px;
                margin: 0;
                font-family: 'Poppins', sans-serif;
                background-color: #222433;
            }
    
            table{
                position: absolute;
                left: 50%;
                top: 50%;
                transform: translate(-50%, -50%);
                border-collapse: collapse;
                width: 93%;
                height: 200px;
                border: 1px solid #fff;
                box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.5), -1px -1px 8px rgba(0, 0, 0, 0.5);
            }
    
            tr{
                color: #fff;
                transition: all .2s ease-in;
                cursor: pointer;
            }
    
            th,
            td{
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #fff;
            }
    
            #header{
                background-color: #4169e1;
                color: #fff;
            }
    
            h1{
                font-weight: 600;
                text-align: center;
                background-color: #4169e1;
                color: #fff;
                padding: 10px 0px;
                border-radius: 10px;
            }
    
            tr:hover{
                color: #000;
                background-color: #f5f5f5;
                transform: scale(1.02);
                box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2), -1px -1px 8px rgba(0, 0, 0, 0.2);
            }
    
            @media only screen and (max-width: 768px) {
                table{
                    width: 100%;
                }
            }
            
            p{
                color: #89CFF0;
                position: absolute;
                left: 50%;
                top: 5%;
                transform: translate(-50%, -50%);
            }
        </style>
        
    </head>
    
    <body>
        
        <sql:setDataSource var="studentBill"
                           driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/hostel"
                           user="root"
                           password="1234"
                           />
        
        <sql:query var="stud" dataSource="${studentBill}">
            SELECT * 
            FROM   student;
        </sql:query>
            
        <div align="centre">
            <table>
                    
                <!-- header -->
                <caption>
                    <h1>Student Record</h1>
                </caption>
                    
                <!-- header -->
                <tr id="header">
                    <th>ID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <th>Room Number</th>
                    <th>Check-in Date</th>
                    <th>Check-out Date</th>
                    <th>Room Type</th>
                </tr>
                    
                <c:forEach var="s" items="${stud.rows}">
                    <tr>
                        <td> <c:out value="${s.studID}" /> </td>
                        <td> <c:out value="${s.studUserName}" /> </td>
                        <td> <c:out value="${s.studEmail}" /> </td>
                        <td> <c:out value="${s.studFirstName}" /> </td>
                        <td> <c:out value="${s.studLastName}" /> </td>
                        <td> <c:out value="${s.studAddress}" /> </td>
                        <td> <c:out value="${s.studPhoneNum}" /> </td>
                        <td> <c:out value="${s.studRoomNum}" /> </td>
                        <td> <c:out value="${s.studCheckIn}" /> </td>
                        <td> <c:out value="${s.studCheckOut}" /> </td>
                        <td> <c:out value="${s.studRoomType}" /> </td>
                    </tr>
                </c:forEach>
            </table>
            
            <!-- <p><i>Please use ctrl+F to find your detail</i></p> -->
            
        </div>
    </body>
</html>
