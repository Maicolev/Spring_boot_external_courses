
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <title>JSP information</title>
</head>
<body>
<h1>JSP Scriptlest</h1>

<% out.println("Concatenation: " + "greetings by JSP's"); %>
<br>

<%
    String applicationRoute = request.getContextPath();
    out.println("Aplication name: " + applicationRoute);
%>
<br>
<br>

<%

    if (session.isNew()){
%>
        The session is new
<%
    }
    else{
%>
        Welcome back
<%}%>
<br>
<br>

<form action="scriptlest_processing.jsp" method="post">
    <ul>
        <li>
            <label for="txtColor">Please type a color: </label>
            <input type="text" id="txtColor" name="txtColor" />
        </li>
        <input type="submit" value="Change color"/>
    </ul>
</form>

<a href="../index.jsp"> << Back to home </a>

</body>
</html>