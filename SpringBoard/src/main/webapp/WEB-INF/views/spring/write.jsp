<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ㅇㅅㅇ/</title>
<link rel="stylesheet" href="/resources/board/css/write.css" />
</head>
<body>
	<h2>write</h2>

	<form action="./table" method="post">
<div id="main">
		<div id="member">
			<div>id</div>
			<div>
				<input id="board_writer" type="text" placeholder="이름" />
			</div>
			<div>pw</div>
			<div>
				<input id="board_password" type="password" placeholder="비밀번호" />
		</div>
			</div>
			<div>
				<input id=board_context type="text" placeholder="할말" />
			</div>
			<div><button type="submit">글쓰기</button></div>
</div>
	</form>
	
	<script src="/resources/board/css/write.css"></script>
</body>
</html>