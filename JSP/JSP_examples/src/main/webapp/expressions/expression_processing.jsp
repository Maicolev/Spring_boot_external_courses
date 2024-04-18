<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>JSP information</title>
    </head>
    <body>
        <h1>JSP Expressions processing</h1>

        Usuario <%= request.getParameter("txtUser") %>
        <br>
        Password <%= request.getParameter("txtPassword") %>

        <br> <br>
        <a href="../index.jsp"> << Back to home </a>

    </body>
</html>