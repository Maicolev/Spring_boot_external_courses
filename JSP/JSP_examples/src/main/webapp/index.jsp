<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>hi world! with jsp's</title>
    </head>
    <body>
        <h1>JSP's</h1>
        <UL>
            <li> <% out.print("Hi world with scriplets"); %> </li>
            <li> ${"Hi world with expression language (EL)"} </li>
            <li> <%= "Hi world with expressions" %> </li>
            <li> <c:out value = "Hi world with JSTL"/></li>
        </UL>
    </body>
</html>