<%@ page import="java.util.List" %>
<%@ page import="Models.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!-- <meta http-equiv="refresh" content="5"> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>CLients</title>
</head>
<body>
<main>
    <article>
        <section>
            <form action="/FinalJSP/client?action=add"  id="clientForm" method="post"  class="form-floating">
                <div class="row g-3 align-items-center">
                    <div class="col-auto">
                        <label for="name" class="col-form-label" >First name:</label>
                        <input type="text" id="name" name="name" class="form-control" >
                    </div>
                </div>

                <div class="row g-3 align-items-center">
                    <div class="col-auto">
                        <label for="lastName" class="col-form-label" >Last name:</label>
                        <input type="text" id="lastName" name="lastName" class="form-control">
                    </div>
                </div>

                <div class="row g-3 align-items-center">
                    <div class="col-auto">
                        <label for="mail" class="col-form-label" >Email:</label>
                        <input type="email" id="mail" name="mail" class="form-control is-invalid">
                    </div>
                </div>

                <div class="row g-3 align-items-center">
                    <div class="col-auto">
                        <label for="phone" class="col-form-label" >Phone:</label>
                        <input type="tel" id="phone" name="phone" class="form-control">
                    </div>
                </div>

                <div class="row g-3 align-items-center">
                    <div class="col-auto">
                        <label for="salary" class="col-form-label" >Salary:</label>
                        <input type="number" id="salary" name="salary" class="form-control">
                    </div>
                </div>

                <input type="submit" value="Save" class="btn btn-dark"/>
            </form>
        </section>
    </article>
    <aside>
        <section>
            <a href="../../FinalJSP/client"> Back to home </a>
        </section>
    </aside>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>