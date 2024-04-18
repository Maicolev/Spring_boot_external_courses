<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%
    String color = request.getParameter("txtColor");
%>
<html>
<head>
    <title>JSP information</title>
</head>
<body bgcolor=<%=color %>>
<h1>JSP Scriptlest processing</h1>

Background color: <%=color%>
<br> <br>
<a href="../index.jsp"> << Back to home </a>

</body>
</html>