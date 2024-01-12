<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ㅇㅠㅇ</h1>

<p>파라미터로 보내는 name 값과 이 값을 받는 데이터 모델 클래스의 속성 이름이 일치하면 자동으로 바인딩해줌</p>

<form action="./parameter" method="post">

DEPT_NO : <input type="number" name="department_id" value="50"/> &nbsp;&nbsp;&nbsp;&nbsp;
DEPT_NAME : <input type="text" name="department_name" value="IT Programmer"/> <br />
MGR_NO : <input type="number" name="manager_id" value="105"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
LOC_NO : <input type="number" name="location_id" value="130"/><br />
<input type="submit" value="컨트롤러로 서밋"/>

</form>

<hr />
<form action="./para2" method="post">
EMP_ID : <input type="text" name="employee_id" value="135"/>
<input type="submit" value="전송"/>
</form>

<hr />
<form action="./para3" method="post">
<!-- jsp 의 name -->
EMP_ID : <input type="text" name="employee_id" value="122"/>
<input type="submit" value="전송2"/>
</form>

</body>
</html>