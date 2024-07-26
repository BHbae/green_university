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
<!-- 교직원 - 휴학 처리 페이지 -->
<title>휴학 처리</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	
	<header class="d-flex flex-column">
		<div class="header--top">
			<ul>
				<li class="material--li"><span class="material-symbols-outlined"><i class="material-icons">account_circle</i></span>
				<c:if test="${not empty principal}">
   				 <li> ${principal.name}님 (${principal.id})님
				</c:if>
				<li style="margin: 0 15px;">
				<li class="material--li"><span style="color: #9BD2EC;" class="material-symbols-outlined"><i class="material-icons">logout</i></span>
				<li><a href="/green/Login.jsp">로그아웃</a>
			</ul>
		</div>

		<nav class="main--menu">
			<a href="/"><img class="logo" alt="" src="resources/ima/logo.png"></a>
			<!-- userRole에 따라 메뉴 다르게 표시 -->			
					<ul>
						<li><a href="/">홈</a>
						<li><a href="/">MY</a>
						<li><a href="/">학사관리</a>
						<li><a href="/">등록</a>
						<li><a href="${pageContext.request.contextPath}/notice/notice">학사정보</a>
					</ul>
		</nav>
	</header>
	<h1>휴학 처리</h1>
	<c:choose>
		<!-- todo - 만약 휴학 신청이 있다면 테이블 생성 -->
		<c: when test="${breakList!=null}">
			<table border="1">
			<tr>
				<th>신청일자</th>
				<th>신청자 학번</th>
				<th>구분</th>
				<th>시작학기</th>
				<th>종료 학기</th>
				<th>신청서 확인</th>
			</tr>
			<c:forEach var="BreakAppDTO" items="${breakAppList}">
				<tr>
					<td>${BreakAppDTO.appDate}</td>
					<td>${ProfessorDTO.studentId}</td>
					<td>${ProfessorDTO.type}</td>
					<td>${ProfessorDTO.fromYear} 년도 ${ProfessorDTO.fromSemester}학기</td>
					<td>${ProfessorDTO.toYear} 년도 ${ProfessorDTO.toSemester}학기</td>
					<td><a href=#>Click</a></td>
				</tr>
			</c:forEach>
		</table>
		</c:>
		<c:otherwise>
			<p>대기 중인 신청 내역이 없습니다.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>