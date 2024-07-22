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
			<label for="student-name">이름</label>
			<input type="text" id="student-name" name="student-name" value="">
			
			<label for="student-birth-date">생년월일</label>
			<input type="text" id="student-birth-date" name="student-birth-date" value="">
			
			<label for="student-gender">성별</label>
			<input type="text" id="student-gender" name="student-gender" value="">
			
			<label for="student-address">주소</label>
			<input type="text" id="student-address" name="student-address" value="">
			
			<label for="student-tel">전화번호</label>
			<input type="text" id="student-tel" name="student-tel" value="">
			
			<label for="student-email">이메일</label>
			<input type="text" id="student-email" name="student-email" value="">
			
			<input type="submit" value="입력" class="submit-btn">
		</form>
</body>
</html>