<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Modify</title>
    </head>
    <body>
        <h1>JavaBeans modify with JSP</h1>
        <UL>
            <jsp:useBean id="rectangle" class="utilities.Rectangle" scope="session"/>
            <jsp:setProperty name="rectangle" property="base" value="5"/>
            <jsp:setProperty name="rectangle" property="height" value="10"/>
            <li> <a href="index.jsp"> << Back to home</a> </li>
        </UL>
    </body>
</html>