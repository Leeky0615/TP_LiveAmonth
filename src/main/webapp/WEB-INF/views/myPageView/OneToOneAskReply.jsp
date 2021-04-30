<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.liveamonth.liveamonth.entity.vo.OneToOneAskVO"%>
<body>
<div class="pc-table">
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneToOneAskReplyVOList" items="${oneToOneAskReplyVOList}">
				<tr>
					<td>${oneToOneAskReplyVOList.oneToOneAskNO}</td>
					<td>${oneToOneAskReplyVOList.oneToOneAskCategory}</td>
					<td><a href="writeOneToOneAskReply?oneToOneAskNO=${oneToOneAskReplyVOList.oneToOneAskNO}">${oneToOneAskReplyVOList.oneToOneAskSubject}</a></td>
					<td>${oneToOneAskReplyVOList.oneToOneAskDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>