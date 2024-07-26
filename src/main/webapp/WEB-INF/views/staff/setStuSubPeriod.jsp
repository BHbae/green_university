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
	<c:choose>
		<!-- 아직 수강 신청 기간이 아니라면 -->
		<c:when test="${StuSubStatus==0}">
			<p>수강 신청 기간 전입니다.</p>
			<form class="setStatus" action="${pageContext.request.contextPath}/management/startStuSub" method="GET">
			<input type="button" id="setPeriod1" name="setPeriod1">
			</form>
		</c:when>
		
		<!-- 만약 수강 신청 기간이 설정되었다면 -->
		<c:when test="${StuSubStatus==1}">
			<p>현재 수강 신청 기간입니다.</p>
			<form class="setStatus" action="${pageContext.request.contextPath}/management/stopStuSub" method="GET">
			<input type="button" id="setPeriod2" name="setPeriod2">
			</form>
		</c:when>
		
		<!-- 만약 수강 신청 기간이 끝났다면 -->
		<c:otherwise>
			<p>이번 학기 수강 신청 기간이 종료되었습니다.</p>
			<form class="setStatus" action="${pageContext.request.contextPath}/management/sfinishedStuSub" method="GET">
			<input type="button" id="setPeriod3" name="setPeriod3">
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>