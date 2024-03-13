<%@ page import="java.util.List" %>
<%@ page import="Models.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% List<Client> list = (List<Client>) request.getAttribute("clientList"); %>

<html>
    <head>
        <title>CLients</title>
    </head>
    <body>
        <main>
            <article>
                <section>
                    <table>
                        <caption> Client list </caption>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone number</th>
                            <th>Salary</th>
                            <th>Edit</th>
                        </tr>

                        <%
                            for(Client client : list){
                        %>

                        <tr>
                            <td> <%= client.getId() %> </td>
                            <td> <%= client.getName() + " " + client.getLastName() %> </td>
                            <td> <%= client.getEmail() %> </td>
                            <td> <%= client.getPhoneNumber() %> </td>
                            <td> <%= client.getSalary() %> </td>
                            <td><></td>
                        </tr>

                        <% } %>
                    </table>
                </section>
            </article>
        </main>
    </body>
</html>