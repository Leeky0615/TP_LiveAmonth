<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="resources/css/myPage.css" type="text/css">
<section class="profile-section spad">
    <div class="container">
        <div class="profile-agent-content">
            <div class="row">
                <div class="col-lg-2">
                    <c:choose>
                        <c:when test="${userVO.userImage == null}">
                            <div class="ih-item circle effect13 top_to_bottom"><a data-toggle="modal" href="#modifyScheduleContentModal">
                                <div class="img"><img src="https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/user/default.jpg"
                                                      alt="img">
                                </div>
                                <div class="info">
                                    <div class="info-back">
                                        <h3>${userVO.userNickname}</h3>
                                        <p>프로필 이미지 변경</p>
                                    </div>
                                </div>
                            </a></div>
                        </c:when>
                        <c:otherwise>
                            <div class="ih-item circle effect13 top_to_bottom"><a data-toggle="modal" href="#modifyScheduleContentModal">
                                <div class="img"><img src="${userVO.getUserImageURL()}" alt="img"></div>
                                <div class="info">
                                    <div class="info-back">
                                        <h3>${userVO.userNickname}</h3>
                                        <p>프로필 이미지 변경</p>
                                    </div>
                                </div>
                            </a></div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-lg-3">
                    <div class="profile-agent-widget">
                        <ul>
                            <li>이름 <span>${userVO.userName}</span></li>
                            <li>닉네임 <span>${userVO.userNickname}</span></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="profile-agent-widget">
                        <ul>
                            <li>나이 <span>${userVO.getUserRealAge()}세</span></li>
                            <li>성별 <span>${userVO.getUserSexToString()}</span></li>
                            <li>Email <span>${userVO.userEmail}</span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="modal fade" id="modifyScheduleContentModal" role="dialog"
     aria-labelledby="modifyUserImageLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modifyUserImageLabel">프로필 이미지 변경</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="img">
                    <div class="title_image" id="imgViewArea">
                        <c:choose>
                            <c:when test="${userVO.userImage == null}">
                                <img id="imgArea" class="profile_img" src="https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/user/default.jpg"
                                     style="height: 200px;width: 200px;border-radius: 50%;"class="profile_image">
                            </c:when>
                            <c:otherwise>
                                <img  id="imgArea" src="${userVO.getUserImageURL()}"
                                      style="height: 200px;width: 200px;border-radius: 50%;" class="profile_img">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="filebox">
                    <form action="modifyUserImage" id="form" name="form"
                          method="post" enctype="multipart/form-data" autocomplete="off">
                        <label for="fileName" type="button">파일 선택</label>
                        <input type="file" id="fileName" name="fileName" accept="image/*" style="display:none" required />
                        <button type="submit" class="site-btn">업로드</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#imgArea').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
    $(":input[name='fileName']").change(function() {
        if( $(":input[name='fileName']").val() == '' ) {
            $('#imgArea').attr('src' , '');
        }
        $('#imgViewArea').css({ 'display' : '' });
        readURL(this);
    });
    // 이미지 에러 시 미리보기영역 미노출
    function imgAreaError(){
        $('#imgViewArea').css({ 'display' : 'none' });
    }
</script>