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
	<h3>
		quiz. 추첨 버튼을 누르면 랜덤으로 10명의 사원을 골라와서 화면에 출력해주는 기능 (json xml 각각)
	</h3>
	<h3>
		quiz2. REST 방식으로 coffee 테이블에 insert, update, delete 를 구현
	</h3>
	
	<button id="loa">로아</button>
	
	<form action="/rest/putCafe" id="putForm"></form>
	<form action="/rest/deleteCafe" id="delForm"></form>
	<button id="coffee1">POST</button>
	<button id="coffee2" >PUT</button>
	<button id="coffee3" >DELETE</button>
	<hr />
	
	<button id="quiz2_1">insert post</button>
	<button id="quiz2_2">update put</button>
	<button id="quiz2_3">delete delete</button>
	<!-- 
	input 태그를 하나 만들어서 JS 에서 입력된 값을 활용함
	폼으로 보내 파라미터를 활용하거나 그런 형식이 아니기 때문에 name 은 필요없음
	JS에서 활용하기 위한 id 값만 있으면 되는듯
	 -->
	<input id="modify-coffee_number" type="number" placeholder="    coffee_number"/>
	
	<hr />
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
	<button id="btn4">4(PUT방식 xhttp요청)</button>


	<script src="${homeJS}"></script>

</body>
</html>
