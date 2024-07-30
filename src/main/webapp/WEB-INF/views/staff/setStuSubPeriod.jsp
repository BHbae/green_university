<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 교직원 - 수강 신청 기간 설정 페이지 -->
<title>수강 신청 기간 설정</title>
</head>
<body>
<h1>휴학 처리</h1>
		<!-- 아직 수강 신청 기간이 아니라면 -->
		<c:if test="${status==0 || status==1}">
			<p>수강 신청 기간 전입니다.</p>
			<form class="setStatus" action="${pageContext.request.contextPath}/management/startStuSub" method="GET">
			<button type="submit">수강 신청 기간 시작</button>
			</form>
		</c:if>
		
		<!-- 만약 수강 신청 기간이 설정되었다면 -->
		<c:if test="${status==2}">
			<p>현재 수강 신청 기간입니다.</p>
			<form class="setStatus" action="${pageContext.request.contextPath}/management/stopStuSub" method="GET">
			<button type="submit">수강 신청 기간 종료</button>
			</form>
		</c:if>		
		
		<!-- 만약 수강 신청 기간이 끝났다면 -->
		<c:if test="${status==3}">
			<p>이번 학기 수강 신청 기간이 종료되었습니다.</p>
		</c:if>
</body>
</html>