<article>
    <section>
        <div class="modal fade" id="addClientModal">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5">Add new client</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="/FinalJSP/client?action=add"  id="clientForm" method="post"  class="was-validated">
                            <div class="row g-3 align-items-center">
                                <div class="col-auto">
                                    <label for="name" class="col-form-label" >First name:</label>
                                    <input type="text" id="name" name="name" class="form-control" required>
                                </div>
                            </div>

                            <div class="row g-3 align-items-center">
                                <div class="col-auto">
                                    <label for="lastName" class="col-form-label" >Last name:</label>
                                    <input type="text" id="lastName" name="lastName" class="form-control" required>
                                </div>
                            </div>

                            <div class="row g-3 align-items-center">
                                <div class="col-auto">
                                    <label for="mail" class="col-form-label" >Email:</label>
                                    <input type="email" id="mail" name="mail" class="form-control is-invalid" required>
                                </div>
                            </div>

                            <div class="row g-3 align-items-center">
                                <div class="col-auto">
                                    <label for="phone" class="col-form-label" >Phone:</label>
                                    <input type="tel" id="phone" name="phone" class="form-control" required>
                                </div>
                            </div>

                            <div class="row g-3 align-items-center">
                                <div class="col-auto">
                                    <label for="salary" class="col-form-label" >Salary:</label>
                                    <input type="number" id="salary" name="salary" class="form-control" required>
                                </div>
                            </div>
                            <br/>
                            <input type="submit" value="Save" class="btn btn-dark"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</article>