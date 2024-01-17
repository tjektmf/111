<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ㅇㅅㅇ/</title>
</head>
<body>

<form action="./write" method="post">
	<table border="3">

		<tr>
			<th>제목</th>
			<th><input name="board_title" type="text" /></th>
		</tr>
		<tr>
			<th>쓴사람</th>
			<th><input name="board_writer" type="text" /></th>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input name="board_password" type="password" size="5" placeholder="4자리 이하" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td align="center"><textarea name="board_content" id="" cols="32" rows="3"></textarea></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="글쓰기"/></td>
		</tr>

	</table>
</form>

</body>
</html>