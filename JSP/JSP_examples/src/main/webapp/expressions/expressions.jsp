<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>JSP information</title>
    </head>
    <body>
        <h1>JSP Expressions</h1>

        <%= "Concatenation: " + "greetings by JSP's" %>
        <br>

        <%= "Operation: " %> <%= 6 + 6 %>
        <br>

        <%= "Session id with request: "+ request.getSession().getId() %>
        <br>

        <%= "Session id with session: "+ session.getId() %>
        <br>
        <br>

        <form action="expression_processing.jsp" method="post">
            <ul>
                <li>
                    <label for="txtUser">User:</label>
                    <input type="text" id="txtUser" name="txtUser" />
                </li>
                <li>
                    <label for="txtPassword">Password:</label>
                    <input id="txtPassword" name="txtPassword" />
                </li>
                    <input type="submit" value="Send"/>
            </ul>
        </form>

        <a href="../index.jsp"> << Back to home </a>

    </body>
</html>