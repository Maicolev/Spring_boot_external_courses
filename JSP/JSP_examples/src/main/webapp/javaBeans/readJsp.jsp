<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Read</title>
</head>
<body>
<h1>JavaBeans read with JSP</h1>
<UL>
    <jsp:useBean id="rectangle" class="utilities.Rectangle" scope="session"/>
    <br/>
    Base value: <jsp:getProperty name="rectangle" property="base"/>
    <br/>
    Height value: <jsp:getProperty name="rectangle" property="height"/>
    <br/>
    Area value: <jsp:getProperty name="rectangle" property="area"/>
    <br/>
    <li> <a href="index.jsp"> << Back to home</a> </li>
</UL>
</body>
</html>