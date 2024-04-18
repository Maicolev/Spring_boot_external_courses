<%@page isErrorPage="true" %>
<%@page import="java.io.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error management</title>
    </head>

    <body>
        <h1>Error management</h1>
        <br/>
            An error has ocurred: <%= exception.getMessage()%>
        <br/>

        <textarea cols="60" rows="30">
            <% exception.printStackTrace(new PrintWriter(out)); %>
        </textarea>

    </body>

</html>