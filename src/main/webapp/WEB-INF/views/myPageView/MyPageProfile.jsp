<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<section class="profile-section spad">
    <div class="container">
        <div class="section-title sidebar-title-b">
            <h4>프로필</h4>
        </div>
        <div class="profile-agent-content">
            <div class="row">
                <div class="col-lg-4">
                    <div class="profile-agent-info">
                        <div class="pi-pic">
                            <c:choose>
                                <c:when test="${userVO.userImage == null}">
                                    <img class="profile-img" type="button" class="board_move_go pointer"
                                         data-toggle="modal" style="float: right;"
                                         data-target="#modifyScheduleContentModal" data-dismiss="modal"
                                         src="https://liveamonth-resources.s3.ap-northeast-2.amazonaws.com/img/user/default.jpg" alt>
                                </c:when>
                                <c:otherwise>
                                    <img class="profile-img" type="button" class="board_move_go pointer"
                                         data-toggle="modal" style="float: right;"
                                         data-target="#modifyScheduleContentModal" data-dismiss="modal"
                                         src=${userVO.getUserImageURL()} alt>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="pi-text">
                            <h5>${userVO.userName}</h5>
                            <span>${userVO.userNickname}</span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
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
                        <label for="fileName">프로필 사진 바꾸기</label>
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