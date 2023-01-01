<%@page contentType="text/html" pageEncoding="windows-1252"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Error page</title>
    </head>
    
    <body>
        <center>
            <h1>ERROR</h1>
            <p><%= exception.getMessage() %></p>
        </center>
    </body>
</html>
