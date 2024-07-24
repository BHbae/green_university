<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 교직원 - 학생 등록 페이지 -->
<title>직원 등록</title>
</head>
<body>
	<h1>직원 등록</h1>
		<form class="register-staff-from" action="${pageContext.request.contextPath}/management/registerSf" method="POST">
			<label for="name">이름</label>
			<input type="text" id="name" name="name"><br>
			
			<label for="birthDate">생년월일</label>
			<input type="date" id="birthDate" name="birthDate"><br>
			
			<label for="gender">성별</label>
			<input type="text" id="gender" name="gender"><br>
			
			<label for="address">주소</label>
			<input type="text" id="address" name="address"><br>
			
			<label for="tel">전화번호</label>
			<input type="text" id="tel" name="tel"><br>
			
			<label for="email">이메일</label>
			<input type="text" id="email" name="email"><br>
			
			<input type="submit" value="입력" class="submit-btn">
		</form>
</body>
</html>