<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html lang="zxx">

<head>
</head>

<body>
	<jsp:include page="/incl/Header.jsp" />
		<div class="container">
			<div class="row">
				<div class="col-lg-12 p-0">
					<div class="pc-table">
						<table>
							<thead>
								<tr>
									<th class="type">스케줄(이미지, 제목)</th>
									<th class="type">장소</th>								
									<th class="type">닉네임</th>
									<th class="type">성별</th>
									<th class="type">나이</th>
									<th class="type">좋아요 수</th>					
								</tr>
							</thead>
							<tbody>
							
							<c:set var="now" value="<%=new java.util.Date()%>" />
							<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set> 		
									
							<c:set var="size" value="${fn:length(UserVOList)}" />						
							<c:forEach var="i" begin="0" end="${size-1}">
									<c:choose>
										<c:when test="${UserVOList[i].getUserSex() eq 'false'}">
											<c:set var="sex" value="남자"/>
										</c:when>
										
										<c:otherwise>
											<c:set var="sex" value="여자"/>
										</c:otherwise>
									</c:choose>		

								<tr>
									<td>
										<div class="title">스케줄 제목</div> 
										<%-- <a href="/otherSchedule?useNO=${UserVOList[i].getUserNO()}&scheduleNO=${ScheduleVOList[i].getScheduleNO()}"><img src="resources/img/property/comparison/comparison-2.jpg" alt=""></a> --%>						
										<a href="/schedule"><img src="resources/img/property/comparison/comparison-2.jpg" alt=""></a>
									</td>
									<td><c:out value="${ScheduleVOList[i].getPlace()}" /></td>
									<td><c:out value="${UserVOList[i].getUserNickname()}" /></td>
									<td><c:out value="${sex}" /></td>
									<td><c:out value="${sysYear-UserVOList[i].getUserAge()}세" /></td>
									<td><c:out value="${ScheduleVOList[i].getScheduleLikeCount()}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
				</div>
			</div>
		</div>

	<jsp:include page="/incl/Footer.jsp" />
</body>
</html>