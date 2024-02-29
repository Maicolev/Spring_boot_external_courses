<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Static JSP</title>
    </head>
    <body>
        <h1>Static JSP</h1>
        <ul>
            <li> <%@include file="noun1.html"%> </li>
            <li> <%@include file="noun2.jsp"%> </li>
        </ul>
    </body>
</html>