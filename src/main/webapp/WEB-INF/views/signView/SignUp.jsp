<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<body>
<section class="ftco-section">
    <div class="container">
        <form action=resultMentSignUp method="post" class="signup-form" name="SignInfo" onsubmit="return checkValue()">
            <div class="row justify-content-center">
                <div class="col-md-7 col-lg-6 col-xl-5">
                    <div class="login-wrap p-4 p-md-5">
                        <div class="icon d-flex align-items-center justify-content-center">
                            <span class="fa fa-edit"></span>
                        </div>
                        <h3 class="text-center mb-4">회원 가입</h3>

                        <form action="#" class="signup-form">
                            <%--아이디--%>
                            <div class="form-group mb-3">
                                <label class="label" for="userID">ID</label>
                                <input type="text" id="userID" class="form-control" placeholder="ID" name="userID"
                                       engAndNumOnly>
                                <button type="button" class="checkID">중복확인</button>
                                <p class="result">
                                    <span class="msg">중복확인을 해주세요.</span>
                                </p>
                            </div>

                            <%--비밀번호 --%>
                            <div class="form-group mb-3">
                                <label class="label" for="userPassword">password</label> <input
                                    type="password" id="userPassword"
                                    class="form-control" placeholder="Password" onpaste="return false;"
                                    oncopy="return false;" onchange = "checkPassword()"
                                    name="userPassword"> <span toggle="#password-field"
                                                               class="fa fa-fw fa-eye field-icon toggle-password"></span>
                            </div>

                            <%-- 이름 --%>

                            <div class="form-group mb-3">
                                <label class="label" for="checkUserPassword">Check password</label>
                                <input type="password" id="checkUserPassword"
                                    class="form-control" placeholder="checkPassword" onpaste="return false;"
                                    oncopy="return false;" onchange = "checkPassword()" name="checkUserPassword">
                                <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                <span class="checkPassword" id="checkPassword">비밀번호 확인</span>
                            </div>

                            <div class="form-group mb-3">
                                <label class="label" for="userName">이름</label> <input
                                    type="text" id="userName" class="form-control" onpaste="return false;"
                                    placeholder="이름(한글만 입력가능)" name="userName" onkeypress="koreanCheck()">
                            </div>

                            <%-- 닉네임 --%>
                            <div class="form-group mb-3">
                                <label class="label" for="userNickname">닉네임</label>
                                <input type="text" id="userNickname" class="form-control" placeholder="닉네임" onpaste="return false;"
                                       name="userNickname">
                                <button type="button" class="checkNickName">중복확인</button>
                                <p class="nickNameResult">
                                    <span class="nickNameMsg">중복확인을 해주세요.</span>
                                </p>
                            </div>

                            <%--성별--%>
                            <div class="form-group mb-3" id="userSexBlock">
                                <label class="label" for="userSex">성별</label><br> <select
                                    name="userSex" id="userSex" class="form-control" onpaste="return false;">
                                <option value=0>남성</option>
                                <option value=1>여성</option>
                            </select>
                            </div>
                            <br>
<%--                        출생년도--%>
                            <div class="form-group mb-3">
                                <label class="label" for="userAge">출생년도</label><br> <input
                                    type="number" class="int form-control" id="userAge"
                                    min="1900" max="2021" maxlength="4" placeholder="생년(4자)" onpaste="return false;"
                                    name="userAge" oninput="maxLengthCheck(this)">
                            </div>

                                <div class="form-group mb-3" >
                                    <label class="label" for="userEmail">이메일</label>
                                    <input type="text" id="userEmail" class="form-control result-email" onpaste="return false;" name="userEmail" onfocus="this.value='';">
                                    @
                                    <input type="text" id="email" name="email" class="form-control" readOnly="true">

                                </div>

                                <div class="form-group mb-3" id="emailBlock">
                                    <select name="emailSelected" id="emailSelected" class="form-control" onchange="email_change()">
                                        <c:forEach var="email" items="${email}">
                                            <option value="${email.label}">${email.label}</option>
                                        </c:forEach>
                                    </select>
                                </div>


                            <div class="form-group d-md-flex">
                                <div class="w-100 text-left">
                                    <label class="checkbox-wrap checkbox-primary">
                                        I agree all statements in terms of service
                                        <input type="checkbox" checked name="agreeCheck">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                            </div>

                            <div class="form-group">
                                <button type="submit" id="submit" disabled="disabled"
                                        class="form-control btn btn-primary rounded submit px-3">
                                    Sign Up
                                </button>
                            </div>
                        </form>
                        <p> I'm already a member!
                            <a data-toggle="tab" href="#signin">Sign In</a>
                        </p>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
</body>
