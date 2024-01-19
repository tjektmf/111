<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/resources/js/home.js" var="homeJS"></c:url>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>ㅇㅅㅇ/</h1>
	<hr />
	<h3>quiz. 추첨 버튼을 누르면 랜덤으로 10명의 사원을 골라와서 화면에 출력해주는 기능 (json xml 각각)
	</h3>
	<button id="json1">json</button>
	<button id="xml1"'>xml</button>
	<hr />

	<div id="out"></div>
	<div id="employees"
		style="display: grid; grid-template-columns: 1fr 1fr 1fr;"></div>
	<hr />
	<div id="employees2"
		style="display: grid; grid-template-columns: 1fr 1fr 1fr;"></div>
	<button id="btn1">1</button>
	<button id="btn2">2(JSON)</button>
	<button id="btn3">3(XML)</button>


	<script src="${homeJS}"></script>

</body>
</html>
