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
<title>총 누계 성적</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
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
						<li><a href="/">수업</a>
						<li><a href="/">수강신청</a>
						<li><a href="/">성적</a>
						<li><a href="/">학사 정보</a>
					</ul>
		</nav>
	</header>
<!--  -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainPage.css">
</head>
<body>
<body>

	<h1>총 누계 성적</h1>
	
	<c:if test="${not empty totalList}">
	<h3>평점 평균</h3>
		<table border="1">
			<tr>
				<th>연도</th>
				<th>학기</th>
				<th>신청학점</th>
				<th>취득학점</th>
				<th>평점평균</th>
			</tr>
			<c:forEach var="TotalGradeDTO" items="${totalGradeList}">
				<tr>
					<td>${TotalGradeDTO.subYear}</td>
					<td>${TotalGradeDTO.semester}</td>
					<td>${TotalGradeDTO.subjectId}</td>
					<td>${TotalGradeDTO.name}</td>
					<td>${TotalGradeDTO.type}</td>
					<td>${TotalGradeDTO.grades}</td>
					<td>${TotalGradeDTO.grade}</td>
				</tr>
				</c:forEach>
		</table>
	</c:if>
	
	<c:if test="${empty totalList}">
		<p>조회할 성적 내역이 없습니다.</p>
	</c:if>
</body>
</html>