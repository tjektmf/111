<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
수정할 때 기존에 선택된게 선택된 상태로 나오게함

<c:set value="A/B/C/D/E" var="grades"></c:set>
<select name="fruits_grade" id="">
	<c:forTokens items="${grades}" delims="/" var="grade">
		<c:choose>
			<c:when test="${grade == fruit.grade}">
				<option value="${grade}" selected>  ${grade}  </option>
			</c:when>

			<c:otherwise>
				<option value="${grade}">  ${grade}  </option>
			</c:otherwise>
		</c:choose>
	</c:forTokens>
</select>

 -->




<form action="./update" method="post">
	<table border="2">
		<tr>
			<th>번호</th>
			<td>${coffee.coffee_number}</td>
			<input name="coffee_number" type="hidden" value="${coffee.coffee_number}" />
		</tr>

		<tr>
			<th>커피이름</th>
			<td><input name="coffee_name" type="text" value="${coffee.coffee_name}" /></td>
		</tr>
		<tr>
			<th>커피가격</th>
			<td><input name="coffee_price" type="number" value="${coffee.coffee_price}" /></td>
		</tr>
		<tr>
			<th>커피크기</th>
			<td><input name="coffee_size" type="text" value="${coffee.coffee_size}" /></td>
		</tr>
		<tr>
		<button type="submit">수정</button>
		</tr>

	</table>
</form>

</body>
</html>