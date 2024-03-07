<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>MVC with JSP</title>
    </head>
    <body>
        <h1>MVC with JSP</h1>
        <UL>
            <li> Request variable: ${variableTest1} </li>
            <li> Session variable: ${variableTest2} </li>
            <li> Rectangle: </li>
                <ul>
                    <li>Base: ${rectangle.base}</li>
                    <li>Height: ${rectangle.height}</li>
                    <li>Area: ${rectangle.area}</li>
                </ul>
        </UL>
    </body>
</html>