<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:url value="/assets/board/css/list.css" var="listCSS"></c:url>
<meta charset="UTF-8">
<title>자유게시판</title>
<link rel="stylesheet" href="${listCSS}" />
</head>
<body>
	<h1>목록</h1>

<c:if test="${!empty boards}">
	<div class="board-list">
		<c:forEach items="${boards}" var="board">
			<div class="board-id">${board.board_id}</div>
			<div class="board-title">
				<a href="./detail?board_id=${board.board_id}">${board.board_title}</a> 
				<a onclick="window.open('./replyPop?board_id=${board.board_id}', '_blank', 'width=600, height=300')">&nbsp;[${board.reply_count}]</a></div>
			<div class="board-writer">${board.board_writer}</div>
			<div class="write-date">${board.write_date}</div>
			<div class="view-count">${board.view_count}</div>
		</c:forEach>
	</div>
</c:if>
<hr />
<a href="./write">글쓰기</a>

</body>
</html>