<%@ page import="java.util.List" %>
<%@ page import="Models.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% List<Client> list = (List<Client>) request.getAttribute("clientList"); %>

<meta http-equiv="refresh" content="5">
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>CLients</title>
    </head>
    <body>
        <main>
            <h7> <%= request.getAttribute("message") %> </h7>
            <article>
                <section>
                    <caption> Client list </caption>
                    <table class="table table-bordered">
                        <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone number</th>
                                <th>Salary</th>
                                <th>Edit</th>
                                <th>Remove</th>
                            </tr>
                        </thead>
                        <%
                            for(Client client : list){
                        %>

                        <tbody>
                            <tr>
                                <td> <%= client.getId() %> </td>
                                <td> <%= client.getName() + " " + client.getLastName() %> </td>
                                <td> <%= client.getEmail() %> </td>
                                <td> <%= client.getPhoneNumber() %> </td>
                                <td> <%= client.getSalary() %> </td>
                                <td> <form action="/FinalJSP/client?action=updateInit" method="post"> <input hidden="hidden" type="text" name ="idClientUpdate" id="idClientUpdate" value="<%=client.getId()%>">  <input type="submit" value="Edit"/> </form> </td>
                                <td> <form action="/FinalJSP/client?action=remove" method="post"> <input hidden="hidden" type="text" name ="idClientRemove" id="idClientRemove" value="<%=client.getId()%>">  <input type="submit" value="-"/> </form> </td>
                            </tr>
                        </tbody>

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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>