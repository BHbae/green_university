<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록금 고지서 발송</title>
</head>
<body>
	<h1>등록금 고지서 발송</h1>
	<h1>휴학 처리</h1>
	<c:choose>
		<!-- todo - 만약 휴학 신청이 있다면 테이블 생성 -->
		<form action="sendBill" action="${pageContext.request.contextPath}/management/sendBillLetter" method="GET">
		<input type="submit" value="등록금 고지서 발송">
		</form>
		
	</c:choose>
</body>
</html>