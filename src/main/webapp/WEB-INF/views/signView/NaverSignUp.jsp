<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.liveamonth.liveamonth.constants.EntityConstants.*" %>

<body>
<script src="resources/js/signUp.js"></script>

<section class="ftco-section">
    <div class="container">
        <form action="resultMentNaverSignUp" class="signup-form" name="SignInfo">
            <div class="row justify-content-center">
                <div class="col-md-12 col-lg-12 col-xl-8">
                    <div class="login-wrap p-4 p-md-5">
                        <div class="icon d-flex align-items-center justify-content-center">
                            <span class="fa fa-edit"></span>
                        </div>
                        <h3 class="text-center mb-4">네이버 회원 추가 정보 입력</h3>

                        <form action="#" class="signup-form">
                            <%-- naverID--%>
                            <input type="hidden" name="userID" value = "${naverUser.userID}">
                            <%-- 이름 --%>
                            <div class="form-group mb-3" id="userNameBlock">
                                <label class="label" for="userName">이름</label> <input
                                    type="text" id="userName" class="form-control" onpaste="return false;"
                                    placeholder="이름(한글만 입력가능)" name="userName"
                                    value = "${naverUser.userName}" onkeypress="koreanCheck()">
                            </div>

                            <%-- 닉네임 --%>
                            <div class="form-group mb-3" id="userNicknameBlock">
                                <label class="label" for="userNickname">닉네임</label>
                                <input type="text" id="userNickname" class="form-control" placeholder="닉네임"
                                       onpaste="return false;"
                                       name="userNickname" value = "${naverUser.userNickname}">
<%--                                <button type="button" class="checkNickName">중복확인</button>--%>
<%--                                <p class="nickNameResult">--%>
<%--                                    <span class="nickNameMsg">중복확인을 해주세요.</span>--%>
<%--                                </p>--%>
                            </div>

                            <%--성별--%>
                            <div class="form-group mb-3" id="userSexBlock">
                                <label class="label" for="userSex">성별</label><br> <select
                                    name="userSex" id="userSex" class="form-control" onpaste="return false;"
                                    value = "${naverUser.userSex}">
                                <option value=0>남성</option>
                                <option value=1>여성</option>
                            </select>
                            </div>
                            <br>

                            <div class="form-group mb-1" id="userEmailBlock">
                                <label class="label" for="userEmail">이메일</label>
                                <input type="text" id="userEmail" class="form-control result-email"
                                       onpaste="return false;" name="userEmail" onfocus="this.value='';"
                                       value = "${naverUser.userEmail}">
                                @
                                <input type="text" id="email" name="email" class="form-control" readOnly="true">

                            </div>

                            <div class="form-group mb-1" id="emailBlock">
                                <select name="emailSelected" id="emailSelected" class="form-control"
                                        onchange="email_change()">
                                    <c:forEach var="email" items="${email}">
                                        <option value="${email.label}">${email.label}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <%--출생년도--%>
                            <div class="form-group mb-3" id="userAgeBlock">
                                <label class="label" for="userAge">출생년도</label><br> <input
                                    type="number" class="int form-control" id="userAge"
                                    min="1900" max="2021" maxlength="4" placeholder="생년(4자)" onpaste="return false;"
                                    name="userAge" oninput="maxLengthCheck(this)" value = "${naverUser.userAge}">
                            </div>
                                <div class="form-group mb-3">
                                    <label class="label">약관동의</label><br>
                                    <div>    <span class="msg">수집, 이용할 정보의 내용</span></div>
                                    <div>     <span class="msg">이름, 성별, 출생년도, 이메일 </span></div>
                                    <div>     <span class="msg">수집, 이용 목적</span></div>
                                    <div>     <span class="msg">한달살기 일정 추천 및 마케팅</span></div>
                                    <div>     <span class="msg">개인정보의 보유, 이용기간</span></div>
                                    <div>     <span class="msg">수집, 이용에 관한 동의일로부터 회원 탈퇴시 까지</span></div>
                                    <div>     <span class="msg">동의를 거부할 권리 및 동의를 거부할 경우의 불이익을 받을 수 있습니다.</span></div>
                                    <div>     <span class="msg">귀하는 위 사항에 대하여 동의를 거부할 수 있습니다.
                                  다만 위 개인정보 수집에 관한 동의는 한달살기 사이트 회원가입을 위하여
                                  필수적이므로, 위 사항에 동의하여야만 회원이 될 수 있습니다.</span></div>
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
                                <button type="submit" id="submit"
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
</html>

    <c:if test = "${naverUser.userName != null}">
        <script> unvisibleUserName();</script>
    </c:if>
    <c:if test = "${naverUser.userNickname != null}">
        <script> unvisibleUserNickname();</script>
    </c:if>
    <c:if test = "${naverUser.userAge != 0}">
        <script> unvisibleUserAge();</script>
    </c:if>
    <c:if test = "${naverUser.userSex != null}">
        <script> unvisibleUserSex();</script>
    </c:if>
    <c:if test = "${naverUser.userEmail != null}">
        <script> unvisibleUserEmail();</script>
    </c:if>

