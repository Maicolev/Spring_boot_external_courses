<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>


<%!
    private String user = "Empty";
%>

<%
    user = request.getParameter("txtUser");
%>

<%!
    public String getUser()
    {
        return this.user;
    }
%>

<html>
<head>
    <title>JSP information</title>
</head>
<body>
<h1>JSP Declarations processing</h1>

Print by method: <%=this.getUser()%>
Print by attribute: <%= user%>
<br> <br>
<a href="../index.jsp"> << Back to home </a>

</body>
</html>