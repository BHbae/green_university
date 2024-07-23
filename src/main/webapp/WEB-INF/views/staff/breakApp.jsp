<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 교직원 - 휴학 처리 페이지 -->
<title>휴학 처리</title>
</head>
<body>
	<h1>휴학 처리</h1>
	<c:choose>
		<!-- todo - 만약 휴학 신청이 있다면 테이블 생성 -->
		<c:otherwise>
			<p>대기 중인 신청 내역이 없습니다.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>