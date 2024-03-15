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
            <h4> <%= request.getAttribute("message") %> </h4>
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
                            <th>Remove</th>
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
                            <td> <form action="/FinalJSP/client?action=updateInit" method="post"> <input hidden="hidden" type="text" name ="idClientUpdate" id="idClientUpdate" value="<%=client.getId()%>">  <input type="submit" value="Edit"/> </form> </td>
                            <td> <form action="/FinalJSP/client?action=remove" method="post"> <input hidden="hidden" type="text" name ="idClientRemove" id="idClientRemove" value="<%=client.getId()%>">  <input type="submit" value="-"/> </form> </td>
                        </tr>

                        <% } %>
                    </table>
                </section>
            </article>
            <aside>
                <section>
                    Total salary <%= request.getAttribute("totalSalary") %>
                </section>

                <section>
                    Total clients <%= request.getAttribute("totalClients") %>
                </section>

                <section>
                    <a href="Views/addClient.jsp"> + add client </a>
                    <a href="./client"> Back to home </a>
                </section>
            </aside>
        </main>
    </body>
</html>