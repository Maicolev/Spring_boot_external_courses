<%@ page import="java.util.List" %>
<%@ page import="Models.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <title>CLients</title>
</head>
<body>
<main>
    <article>
        <section>
            <form action="/FinalJSP/client?action=updateEnd" id="clientForm" method="post" class="was-validated">

                <input hidden="hidden" type="text" id="id" name="id" value="${id}">
                <br><br>

                <label for="name">First name:</label>
                <input type="text" id="name" name="name" value="${name}">
                <br><br>

                <label for="lastName">Last name:</label>
                <input type="text" id="lastName" name="lastName" value="${lastName}">
                <br><br>

                <label for="mail">Email:</label>
                <input type="email" id="mail" name="mail" value="${mail}">
                <br><br>

                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="phone" value="${phone}">
                <br><br>

                <label for="salary">Salary:</label>
                <input type="number" id="salary" name="salary" value="${salary}">
                <br><br>

                <input type="submit" value="Save"/>

            </form>
        </section>
    </article>
    <aside>
        <section>
            <a href="../../FinalJSP/client"> Back to home </a>
        </section>
    </aside>
</main>
</body>
</html>