<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<meta http-equiv="refresh" content="2" />

<html>
    <head>
        <title>JSTL</title>
    </head>
    <body>
    <h1>JSTL Core (Jsp Standard Tag Library)</h1>

    <!-- name variable with jstl -->
    <c:set var="name" value ="NameTest" />
    Name variable: <c:out value="${name}"/>
    <br/>
    <br/>

    <!-- html variable with jstl, the escapexml attribute avoid to the program print h4 tag  -->
    Html variable:
    <c:out value="<h4> Hi </h4>" escapeXml="false"/>
    <br/>
    <br/>

    <c:set var="flag" value="true" />

    <c:if test="${flag}">
        The flag is true. - if
    </c:if>
    <br/>
    <br/>

    <c:if test="${param.option != null}">
        <c:choose>
            <c:when test="${param.option == 6}">
                Param = 6 is selected
            </c:when>
            <c:when test="${param.option == 7}">
                Param = 7 is selected
            </c:when>
            <c:otherwise>
                Unknown option: ${para-option}
            </c:otherwise>
        </c:choose>
    </c:if>
    <br>

    <%
        String names[] = {"Jaqueline", "Sofia", "Kelly"};
        request.setAttribute("names", names);
    %>

    Name list:
    <br/>
    <ul>
        <c:forEach var="person" items="${names}">
            <li>
                ${person}
            </li>
        </c:forEach>
    </ul>
    </body>
</html>