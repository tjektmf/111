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
	<h3>Sticky Note</h3>

	<table border="2">
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>쓴사람</th>
			<th>조회수</th>
			<th>date</th>
		</tr>

		<c:forEach items="${board}" var="board">
		<tr>
			<td>${board.board_id}</td>
			<td><a href="./modify?board_id=${board.board_id}">${board.board_title}</a></td>
			<td>${board.board_writer}</td>
			<td>${board.view_count}</td>
			<td>${board.write_date}</td>
		</tr>
		</c:forEach>


	</table>
	<button onclick="location.href='./write'">글쓰기</button>


</body>

</html>