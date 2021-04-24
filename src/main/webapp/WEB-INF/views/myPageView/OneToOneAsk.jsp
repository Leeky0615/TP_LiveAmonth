<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.liveamonth.liveamonth.entity.vo.OneToOneAskVO"%>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의</title>



<jsp:include page="/incl/Header.jsp" />
</head>

<body>
<div class="pc-table">
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneToOneAskVOList" items="${oneToOneAskVOList}">
				<tr>
					<td>${oneToOneAskVOList.oneToOneAskNO}</td>
					<td>${oneToOneAskVOList.oneToOneAskCategory}</td>
					<td><a href="#">${oneToOneAskVOList.oneToOneAskSubject}</a></td>
					<td>${oneToOneAskVOList.oneToOneAskDate}</td>
					<td>${oneToOneAskVOList.oneToOneAskViewCount}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	</div>
	<form action="oneToOneAskWrite" method=post class="cc-form">
		<button type="submit" class="site-btn">문의하기</button>
	</form>



	<jsp:include page="/incl/Footer.jsp" />
</body>
</html>