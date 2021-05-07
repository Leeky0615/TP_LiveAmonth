<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Login Page</h2>
            </div>
        </div>


        <form action="/resultMentFindID" method="post">
            <div class="row justify-content-center">
                <div class="col-md-7 col-lg-5">

                    <div class="d-flex">
                        <div class="w-100">
                            <h3 class="mb-4">Find ID</h3>
                        </div>
                    </div>

                    <div class="form-group mt-3">
                        <input type="text" class="form-control" id="userName" name="userName" required>
                        <label class="form-control-placeholder" for="userName">Name</label>
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