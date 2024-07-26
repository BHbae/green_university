<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>    
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록금 고지서 발송</title>
</head>
<body>
	<h1>등록금 고지서 발송</h1>
	<h1>휴학 처리</h1>
	<!-- todo - 만약 휴학 신청이 있다면 테이블 생성 -->
		<form action="sendBillLetter" action="${pageContext.request.contextPath}/management/sendBillLetter" method="GET">
			<input type="submit" value="등록금 고지서 발송">
		</form>
		
		<c:if test="${numOfBill>0}">
			alert("${numOfBill} 개의 고지서가 발송되었습니다.");
		</c:if>
</body>
</html>