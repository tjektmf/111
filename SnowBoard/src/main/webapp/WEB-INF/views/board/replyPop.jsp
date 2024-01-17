<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ㅇㅅㅇ/</title>
</head>
<body>
	댓글이야~~
	<hr />

	<table>
		<tr>
			<th>쓴사람</th>
			<th>하는말</th>
			<th>비밀번호</th>
			<th>쓴날짜</th>
		</tr>
		<c:forEach items="${reply}" var="board">
			<tr>
				<th>${board.reply_writer}</th>
				<th>${board.reply_content}</th>
				<th><input type="password" size="5"
					placeholder="${board.reply_password}" /></th>
				<th>${board.reply_date}</th>
			</tr>
		</c:forEach>

	</table>




</body>
</html>