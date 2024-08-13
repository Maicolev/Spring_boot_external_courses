<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" >
        <title> App list </title>
    </head>
    <body>
        <h1>User list</h1>
        <ul>
            <c:forEach items="${users}" var="user">
                <li> ${user.username} ${user.password} </li>
            </c:forEach>
        </ul>
    </body>

</html>

