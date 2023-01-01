<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@page import="java.sql.*"%>
<%@page import="com.hostel.util.DBConn"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Delete Page</title>
    </head>
    
    <body>
        
        <%
            String id = request.getParameter("id");
            
            Connection con = null;
            Statement statement = null;
            
            String sqlQ = "DELETE FROM student WHERE studID=" + id;
            
            try{
                con = DBConn.createConnection();
                statement = con.createStatement();
                
                statement.execute(sqlQ);
                
                request.setAttribute("id", id);
                request.getRequestDispatcher("/AdminCRUD.jsp").forward(request, response);
                
                
            }catch(SQLException sqle){
                System.out.println(sqle.getMessage());
            }
            
            
        %>
        
        
        
        
    </body>
</html>
