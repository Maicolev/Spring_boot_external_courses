<%@ page import="utilities.Rectangle" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    Rectangle rectangleRequest = (Rectangle) request.getAttribute("rectangleRequest");
    Rectangle rectangleSession = (Rectangle) request.getSession().getAttribute("rectangleSession");
%>

<html>
    <head>
        <title>MVC with JSP</title>
    </head>
    <body>
    <h1>Variable list - MVC with JSP</h1>
    <h4 style="color: green" > Message: ${message} </h4>
    <UL>

        <%
            if (rectangleSession != null){
        %>
        <li> Rectangle session: </li>
        <ul>
            <li>Base: ${rectangleSession.base}</li>
            <li>Height: ${rectangleSession.height}</li>
            <li>Area: ${rectangleSession.area}</li>
        </ul>
        <%
            }
        %>

        <%
            if (rectangleRequest != null){
        %>
        <li> Rectangle request: </li>
        <ul>
            <li>Base: ${rectangleRequest.base}</li>
            <li>Height: ${rectangleRequest.height}</li>
            <li>Area: ${rectangleRequest.area}</li>
        </ul>
        <%
            }
        %>

    </UL>
    </body>
</html>