<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>hi world! with jsp's</title>
    </head>
    <body>
        <h1>JSP's</h1>
        <UL>
            <li>App name: ${pageContext.request.contextPath}</li>
            <li>Client browser: ${header["User-Agent"]}</li>
            <li>Session ID: ${cookie.JSESSIONID.value}</li>
            <li>Web server: ${pageContext.servletContext.serverInfo}</li>
            <li>Called by: ${param.appCalled}</li>

            <li> <a href="index.jsp"><< Back to home</a> </li>
        </UL>
    </body>
</html>