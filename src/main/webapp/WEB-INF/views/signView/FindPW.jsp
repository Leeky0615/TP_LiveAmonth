<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<section class="ftco-section">
    <div class="container">
        <form action="/ResultMentFindPW" method="post">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <h2 class="heading-section">Login Page</h2>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-md-7 col-lg-5">
                    <div class="d-flex">
                        <div class="w-100">
                            <h3 class="mb-4">Find PW</h3>
                        </div>
                    </div>
                    <div class="form-group mt-3">
                        <input type="text" class="form-control" id="userID" name="userID" required>
                        <label class="form-control-placeholder" for="userID">ID</label>
                    </div>
                    <div class="form-group mt-3">
                        <input type="text" class="form-control" id="userEmail" name="userEmail" required>
                        <label class="form-control-placeholder" for="userEmail">Email</label>
                    </div>

                    <div class="form-group">
                        <button type="submit" id=findBtn class="form-control btn btn-primary rounded submit px-3">find
                        </button>
                        <p></p>

                    </div>
                </div>
            </div>
        </form>
    </div>
</section>