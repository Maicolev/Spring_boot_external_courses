<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Dynamic JSP</title>
</head>
<body>
    <h1>Dynamic JSP</h1>
    <br/>
    <jsp:include page="resource1.jsp" />
    <br/>
    <jsp:include page="resource2.jsp" >
        <jsp:param name="backgroundColor" value="red"/>
    </jsp:include>
</body>
</html>