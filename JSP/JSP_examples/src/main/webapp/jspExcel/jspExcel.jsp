<%@page errorPage="../errors/errorManagement.jsp" %>
<%@page import="utilities.Conversions, java.util.Date"%>
<%@page contentType="application/vnd.ms-excel" %>
<%
    String fileName = "report.xls";
    response.setHeader("Content-Disposition", "inline; filename =" + fileName);
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Excel report</title>
    </head>

    <body>
        <h1>Excel report</h1>
        <br/>

        <table border="1">
            <tr>
                <th>Course</th>
                <th>Description</th>
                <th>Date</th>
            </tr>
            <tr>
                <td>1. Java fundamentals</td>
                <td>We will learn the basic syntax of java</td>
                <td> <%= Conversions.format(new Date()) %> </td>
            </tr>
            <tr>
                <td>2. Programming with java</td>
                <td>We will practice concepts of the programing oriented to objects</td>
                <td> <%= Conversions.format(new Date()) %> </td>
            </tr>
        </table>
    </body>

</html>