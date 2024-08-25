<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" >
        <title> People list </title>
    </head>
    <body>
        <h1>People list</h1>
        <ul>
            <c:forEach items="${people}" var="person">
                <li> ${person.name} ${person.lastName} ${person.age}</li>
            </c:forEach>
        </ul>
    </body>

</html>

