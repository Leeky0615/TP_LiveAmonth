<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<div class="container bootdey">
    <div class="col-lg-7">
        <div class="section-title">
            <h4>Comments</h4>
        </div>
    </div>
    <div class="col-md-12 bootstrap snippets">
        <div class="panel">
            <jsp:include page="../replyView/ReplyWriter.jsp">
                <jsp:param value="${otherScheudleAndLikeCount.scheduleNO}" name="scheduleNO"/>
                <jsp:param value="0" name="scheduleReplyNO"/>
            </jsp:include>
        </div>
        <div class="panel">
            <div class="panel-body">
                <c:forEach var="scheduleVOReply" items="${scheduleVOReplyList}">
                    <c:if test="${scheduleVOReply.scheduleReply.scheduleReplyRefNO == 0 || scheduleVOReply.NO == scheduleVOReplyList[0].NO}">
                        <div class="media-block">
                            <a class="media-left" href="#">
                                <img class="img-circle img-sm" alt="Profile Picture"
                                     src="${scheduleVOReply.userVO.getUserImageURL()}"></a>
                            <div class="media-body">
                                <c:choose>
                                    <c:when test="${scheduleVOReply.scheduleReply.scheduleReplyRefNO == 0}">
                                        <jsp:include page="../replyView/Reply.jsp">
                                            <jsp:param value="${otherScheduleAndLikeCount.scheduleNO}"
                                                       name="scheduleNO"/>
                                            <jsp:param value="${scheduleVOReply.userVO.userNickname}" name="userNickname"/>
                                            <jsp:param value="${scheduleVOReply.scheduleReply.scheduleReplyNO}"
                                                       name="scheduleReplyNO"/>
                                            <jsp:param value="${scheduleVOReply.scheduleReply.scheduleReplyDate}"
                                                       name="scheduleReplyDate"/>
                                            <jsp:param value="${scheduleVOReply.scheduleReply.scheduleReplyDesc}"
                                                       name="scheduleReplyDesc"/>
                                            <jsp:param value="${scheduleVOReply.scheduleReply.userNO}" name="userNO"/>
                                        </jsp:include>
                                    </c:when>
                                    <c:when test="${scheduleVOReply.NO == scheduleVOReplyList[0].NO}">
                                        <c:set var="beforePageScheduleReplyNO"
                                               value="${scheduleVOReply.scheduleReply.scheduleReplyRefNO}"></c:set>
                                        <div class="media-body">
                                            <p>
                                                <br>
                                                &nbsp;&nbsp;이전 페이지의 대댓글입니다.
                                            </p>
                                        </div>
                                        <hr>
                                    </c:when>
                                </c:choose>

                                <c:forEach var="scheduleVOReplyRef" items="${scheduleVOReplyList}">
                                    <c:if test="${scheduleVOReply.scheduleReply.scheduleReplyNO == scheduleVOReplyRef.scheduleReply.scheduleReplyRefNO || beforePageScheduleReplyNO == scheduleVOReplyRef.scheduleReply.scheduleReplyRefNO}">
                                        <div>
                                            <div class="media-block">
                                                <a class="media-left" href="#">
                                                    <img class="img-circle img-sm" alt="Profile Picture"
                                                         src="${scheduleVOReplyRef.userVO.getUserImageURL()}"></a>
                                                <div class="media-body">
                                                    <jsp:include page="../replyView/Reply.jsp">
                                                        <jsp:param value="${otherScheduleAndLikeCount.scheduleNO}"
                                                                   name="scheduleNO"/>
                                                        <jsp:param value="${scheduleVOReplyRef.userVO.userNickname}"
                                                                   name="userNickname"/>
                                                        <jsp:param
                                                                value="${scheduleVOReplyRef.scheduleReply.scheduleReplyNO}"
                                                                name="scheduleReplyNO"/>
                                                        <jsp:param
                                                                value="${scheduleVOReplyRef.scheduleReply.scheduleReplyDate}"
                                                                name="scheduleReplyDate"/>
                                                        <jsp:param
                                                                value="${scheduleVOReplyRef.scheduleReply.scheduleReplyDesc}"
                                                                name="scheduleReplyDesc"/>
                                                        <jsp:param value="${scheduleVOReplyRef.scheduleReply.userNO}"
                                                                   name="userNO"/>
                                                        <jsp:param
                                                                value="${scheduleVOReplyRef.scheduleReply.scheduleReplyRefNO}"
                                                                name="checkScheduleReplyRefNO"/>
                                                    </jsp:include>
                                                    <hr>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>
                                <c:set var="beforePageScheduleReplyNO" value="null"></c:set>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
                <jsp:include page="Paging.jsp">
                    <jsp:param value="${otherScheduleAndLikeCount.scheduleNO}" name="scheduleNO"/>
                    <jsp:param value="${paging.page}" name="page"/>
                    <jsp:param value="${paging.beginPage}" name="beginPage"/>
                    <jsp:param value="${paging.endPage}" name="endPage"/>
                    <jsp:param value="${paging.prev}" name="prev"/>
                    <jsp:param value="${paging.next}" name="next"/>
                </jsp:include>
            </div>
        </div>
    </div>
</div>
</body>

