<%-- commentaries --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>


<html>
<head>
    <title>hi world! with jsp's</title>
</head>
<body>
<h1>JSP's</h1>
<form action="declarations_processing.jsp" method="post">
    <ul>
        <li>
            <label for="txtUser">Please type a user: </label>
            <input type="text" id="txtUser" name="txtUser" />
        </li>
        <input type="submit" value="Send User"/>
    </ul>
</form>
</body>
</html>