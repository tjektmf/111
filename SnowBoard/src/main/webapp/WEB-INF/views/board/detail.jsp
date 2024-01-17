<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ㅇㅅㅇ NO.${board.board_id}</title>
</head>
<body>

	<table border="3">

		<tr>
			<th>글 번호</th>
			<th>${board.board_id}</th>
		</tr>
		<tr>
			<th>조회수</th>
			<th>${board.view_count}</th>
		</tr>
		<tr>
			<th>제목</th>
			<th>${board.board_title}</th>
		</tr>
		<tr>
			<th>쓴사람</th>
			<th>${board.board_writer}</th>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" size="5" placeholder="4자리 이하" /> <input type="text" placeholder="${board.board_password}" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td align="center"><textarea name="" id="" cols="32" rows="3">${board.board_content}</textarea></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${board.write_date}</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="file" /></td>
		</tr>
		<tr>
			<th>최근 수정일</th>
			<td>???</td>
		</tr>

	</table>
	
	<hr />
	
	<c:forEach items="${reply}" var="reply">
	${reply.reply_writer} >> ${reply.reply_content} <br />
	</c:forEach>
	
	
	
	<hr />
	
	<form action="./replyAdd" method="post">
		ID <input name="reply_writer" type="text" size="5" />
		PW <input name="reply_password"type="password"  size="5"/><br />
		<textarea name= "reply_content" rows="2" cols="30"></textarea>
		<input name="board_id" type="hidden" value="${board.board_id}" /> <br />
		<input type="text"  placeholder="${board.board_id}"/>
	<button type="submit">댓글쓰기</button>
	</form>

</body>
</html>