<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.liveamonth.liveamonth.entity.dto.CalendarDTO"%>
<%@page import="java.util.*"%>

<html lang="ko">
<head>
<title>insert Schedule</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!-- jquery datepicker -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<!-- jquery datepicker 끝 -->
<meta http-equiv="content-type" content="text/html; charset=utf-8">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-
	ggOyROiXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link href="/resources/css/schedule.css" rel="stylesheet"
	type="text/css">
	<script src="/resources/js/schedule.js"></script>
<script src="/resources/js/board.js"></script>
<script type="text/javaScript" language="javascript"></script>
<jsp:include page="/incl/Header.jsp" />

</head>
<body>
	<form name="calendarFrm" id="calendarFrm" action="schedule"
		method="GET">
		<input type="hidden" name="year" value="${todayInformation.searchYear}" />
		<input type="hidden" name="month" value="${todayInformation.searchMonth-1}" />
		<script>
			var message = "${message}";
			console.log(message);
			if (message != "") {
				alert(message);
			}
		</script>
		<div class="calendar">

			<!--날짜 네비게이션  -->
			<div class="navigation">
			
				<a class="before_after_year"
					href="./schedule?year=${todayInformation.searchYear-1}&month=${todayInformation.searchMonth-1}">
					&lt;&lt; <!-- 이전해 -->
				</a> 
				<a class="before_after_month"
					href="./schedule?year=${todayInformation.beforeYear}&month=${todayInformation.beforeMonth}">
					&lt; <!-- 이전달 -->
				</a> 
				<span class="this_month"> &nbsp;${todayInformation.searchYear}. <c:if
						test="${todayInformation.searchMonth<10}">0</c:if>${todayInformation.searchMonth}
				</span>
				 <a class="before_after_month"
					href="/schedule?year=${todayInformation.afterYear}&month=${todayInformation.afterMonth}">
					<!-- 다음달 --> &gt;
				</a> 
				<a class="before_after_year"
					href="/schedule?year=${todayInformation.searchYear+1}&month=${todayInformation.searchMonth-1}">
					<!-- 다음해 --> &gt;&gt;
				</a>
				<span>
				<div>
				<button type="button" class="site-btn" data-toggle="modal" style="float: right;"
			data-target="#addScheduleModal" >스케줄 등록</button>
			</div>
			</span>
			</div>
				
			<!-- <div class="today_button_div"> -->
			<!-- <input type="button" class="today_button" onclick="javascript:location.href='/calendar.do'" value="go today"/> -->
			<!-- </div> -->
			<table class="calendar_body">

				<thead>
					<tr bgcolor="#CECECE">
						<td class="day sun">일</td>
						<td class="day">월</td>
						<td class="day">화</td>
						<td class="day">수</td>
						<td class="day">목</td>
						<td class="day">금</td>
						<td class="day sat">토</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach var="dateList" items="${dateList}"
							varStatus="dateStatus">
							<c:choose>
								<c:when test="${dateList.value=='today'}">
									<c:if test="${dateStatus.index%7==0}">
										<tr>
									</c:if>
									<td class="today">
										<div class="date"></div>
								</c:when>
								<c:when test="${dateStatus.index%7==6}">
									<td class="sat_day">
										<div class="sat"></div>
								</c:when>
								<c:when test="${dateStatus.index%7==0}">
					</tr>
					<tr>
						<td class="sun_day">
							<div class="sun">
								</c:when>
								<c:otherwise>
									<td class="normal_day">
										<div class="date"></div>
								</c:otherwise>
								</c:choose>
								${dateList.date}
							</div>
							<div>
								<c:forEach var="scheduleList"
									items="${dateList.scheduleDataArray}"
									varStatus="scheduleDataArrayStatus">
									<div class="hoverScheduleSubject" data-toggle="modal" data-target="#addScheduleModal">

										<a href="#"> 
										<span class="thick">${scheduleList.scheduleContentSubject}
										
										</span>
										
										</a>
									</div>

								</c:forEach>
							</div>
						</td>
						</c:forEach>
				</tbody>

			</table>
		</div>
	</form>
	
	<div class="modal fade" id="addScheduleModal" role="dialog"
		aria-labelledby="addScheduleLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addScheduleLabel">스케줄 등록</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<div class="info">하루에 최대 4개의 스케쥴만 등록할 수 있습니다.</div>
					<form name="addSchedule" action="addSchedule">
						<input type="hidden" name="year" value="${todayInformation.searchYear}" />
						<input type="hidden" name="month"
							value="${todayInformation.searchMonth-1}" />
						<div class="contents">
							
							<div class="text_subject">제목 :</div>
							<div class="text_desc">
								<input type="text" name="scheduleContentSubject" class="text_type1" />
							</div>
							
							<div class="text_subject">날짜 :</div>
							<div class="text_desc">
								<input type="date" name="scheduleContentDate" class="text_type1"
									id="testDatepicker" />
							</div>

							<div class="text_subject">내용 :</div>
							<div class="text_area_desc">
								<textarea name="scheduleContentDesc" class="textarea_type1" rows="6"></textarea>
							</div>
							
							<div class="text_subject">금액 :</div>
							<div class="text_desc">
								<input type="number" name="scheduleContentCost" class="textarea_type1"/>
							</div>
							
							<div>
							<button type="button" class="board_move_go pointer"
								onclick="addScheduleButton();">일정등록</button>
							<button type="button" class="board_move_go pointer"
								data-dismiss="modal">취소</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<div width="100%">
			<jsp:include page="/incl/Footer.jsp" />
		</div>
</body>
</html>