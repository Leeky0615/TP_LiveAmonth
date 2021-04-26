<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.liveamonth.liveamonth.entity.vo.OneToOneAskVO"%>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의</title>
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
				<th>버튼</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneToOneAskReplyVOList" items="${oneToOneAskReplyVOList}">
				<tr>
					<td>${oneToOneAskReplyVOList.oneToOneAskNO}</td>
					<td>${oneToOneAskReplyVOList.oneToOneAskCategory}</td>
					<td><a href="oneToOneAskReplyWrite?oneToOneAskNO=${oneToOneAskReplyVOList.oneToOneAskNO}">${oneToOneAskReplyVOList.oneToOneAskSubject}</a></td>
					<td>${oneToOneAskReplyVOList.oneToOneAskDate}</td>
					<td>${oneToOneAskReplyVOList.oneToOneAskViewCount}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	</div>
</body>
</html>