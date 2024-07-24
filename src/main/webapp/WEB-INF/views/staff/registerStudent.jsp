<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 교직원 - 학생 등록 페이지 -->
<title>학생 등록</title>
</head>
<body>
	<h1>학생 등록</h1>
		<form class="register-student-from" action="${pageContext.request.contextPath}/management/registerSt" method="POST">
			<label for="name">이름</label>
			<input type="text" id="name" name="name" value=""><br>
			
			<label for="birthDate">생년월일</label>
			<input type="text" id="birthDate" name="birthDate" value=""><br>
			
			<label for="gender">성별</label>
			<input type="text" id="gender" name="gender" value=""><br>
			
			<label for="address">주소</label>
			<input type="text" id="address" name="address" value=""><br>
			
			<label for="tel">전화번호</label>
			<input type="text" id="tel" name="tel" value=""><br>
			
			<label for="email">이메일</label>
			<input type="text" id="email" name="email" value=""><br>
			
			<label for="deptId">과 ID</label>
			<input type="text" id="deptId" name="deptId" value=""><br>
			
			<label for="entraceDate">입학일</label>
			<input type="text" id="entraceDate" name="entraceDate" value=""><br>
			
			<input type="submit" value="입력" class="submit-btn">
		</form>
</body>
</html>