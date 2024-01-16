<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ㅇㅅㅇ/</title>
<link rel="stylesheet" href="/css/write.css" />
</head>
<body>
	<h2>write</h2>

	<form action="./table" method="post">
<div id="main">
		<div id="member">
			<div>ID</div>
			<div>
				<input name="board_writer" type="text" placeholder="이름" />
			</div>
			<div>PW</div>
			<div>
				<input name="board_password" type="password" placeholder="비밀번호" />
			</div>
			</div>
			<div>
				<input name="board_title" type="text" placeholder="제목" />
			</div>
			<div>
				<textarea name="board_content" rows="3" cols="20" placeholder="할말"></textarea>
			</div>
			<div><button type="submit">글쓰기</button></div>
</div>
	</form>
	
	<script src="/resources/board/css/write.css"></script>
</body>
</html>