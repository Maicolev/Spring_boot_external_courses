<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    String backgroundColor = request.getParameter("backgroundColor");
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Dynamic JSP resource 2</title>
    </head>
    <body bgcolor="<%=backgroundColor %>" ></body>
</html>