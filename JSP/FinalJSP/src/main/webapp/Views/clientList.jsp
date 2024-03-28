<%@ page import="java.util.List" %>
<%@ page import="Models.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% List<Client> list = (List<Client>) request.getAttribute("clientList"); %>

<meta http-equiv="refresh" content="40000">
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>CLients</title>
    </head>
    <body>
        <main>
            <%
                if (request.getAttribute("message") != null){
                   %> <div class="bg-warning-subtle"> <h7> <%= request.getAttribute("message") %> </h7> </div>
            <%
                }
            %>
            <div class="row mb-3 text-center">
                <div class="col-md-8 themed-grid-col bg-secondary text-white">
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
                                            <td class="text-center"> <form action="/FinalJSP/client?action=updateInit" method="post"> <input hidden="hidden" type="text" name ="idClientUpdate" id="idClientUpdate" value="<%=client.getId()%>">  <input type="submit" class="btn btn-dark" value="Edit"/> </form> </td>
                                            <td class="text-center" > <form action="/FinalJSP/client?action=remove" method="post"> <input hidden="hidden" type="text" name ="idClientRemove" id="idClientRemove" value="<%=client.getId()%>">  <input type="submit" class="btn btn-danger" value="-"/> </form> </td>
                                        </tr>
                                    </tbody>

                                    <% } %>
                                </table>
                        </section>
                    </article>
                </div>
                <div class="py-5 my-5 col-md-4 themed-grid-col">
                    <aside>
                        <div class="container text-center">
                            <div class="row row-cols-1">
                                <section class="bg-secondary rounded-pill text-white">
                                    Total salary: <%= request.getAttribute("totalSalary") %>
                                </section>

                                <section class="bg-secondary rounded-pill text-white">
                                    Total clients: <%= request.getAttribute("totalClients") %>
                                </section>

                                <section>
                                    <a href="Views/addClient.jsp"> + add client </a>
                                </section>
                            </div>
                        </div>
                    </aside>
                </div>
                <a class="icon-link" href="./client">
                    <svg class="bi" aria-hidden="true"><use xlink:href="#box-seam"></use></svg>
                    Back to home
                </a>
            </div>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>