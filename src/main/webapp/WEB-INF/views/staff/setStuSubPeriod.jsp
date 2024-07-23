<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 교직원 - 수강 신청 기간 설정 페이지 -->
<title>수강 신청 기간 설정</title>
</head>
<body>
<h1>휴학 처리</h1>
	<c:choose>
		<!-- 만약 수강 신청 기간이 설정되지 않았다면 -->
		<p>현재 수강 신청 기간입니다.</p>
		
		<!-- 만약 수강 신청 기간이 설정되었다면 -->
		
		<!-- 만약 수강 신청 기간이 끝났다면 -->
		<c:otherwise>
			<p>이번 학기 수강 신청 기간이 종료되었습니다.</p>
			<!-- 버튼 사라지게 하기 -->
		</c:otherwise>
	</c:choose>
</body>
</html>