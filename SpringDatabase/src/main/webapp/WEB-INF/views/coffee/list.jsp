<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="" />
</head>
<body>
	<h1>카페</h1>

	<table border="1">

		<tr>
			<th>coffee_number</th>
			<th>coffee_name</th>
			<th>coffee_price</th>
			<th>coffee_size</th>
			<th>ㅇㅅㅇ</th>

		</tr>

		<c:forEach items="${coffee}" var="coffee">
			<tr>
				<td>${coffee.coffee_number}</td>
				<td>${coffee.coffee_name}</td>
				<td>${coffee.coffee_price}</td>
				<td>${coffee.coffee_size}</td>
			<th><button onclick="location.href='./update?coffee_number=${coffee.coffee_number}';">수정</button></th>
			</tr>
		</c:forEach>


	</table>


</body>
</html>