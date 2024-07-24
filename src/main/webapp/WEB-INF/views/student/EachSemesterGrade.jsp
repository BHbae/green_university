<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기별 학기 성적 조회</title>
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
	<h1>학기별 학기별성적 조회</h1>
	<form action="choose-semester">
		<select name="year" id="year">
			<option>
		</select>
		<select name="semester" id="semester">
			<option>
		</select>
		<select name="semester" id="semester">
			<option>
		</select>
		<button></button>
	</form>
	<c:choose>
		<c:when test="${true}">
		<h2>과목별 성적</h2>
		<form class="select-period" action="${pageContext.request.contextPath}/studentGrade/selectSepcificSubject" method="POST">
			<select size="3"> <!-- 연도 -->
			</select>
			<select size="3"> <!-- 학기 -->
			</select>
			<select size="3"> <!-- 전공/교양 -->
			</select>
			<input type="submit" value="조회" class="submit-btn">
		</form>
		
			<table border='1'>
				<tr>
					<th>연도</th>
					<th>학기</th>
					<th>과목번호</th>
					<th>과목명</th>
					<th>강의구분</th>
					<th>학점</th>
				</tr>
				<c:forEach var="grade" items="${gradeList}">
				<tr>
					<td>${grade.year}</td>
					<td>${grade.semester}</td>
					<td>${grade.subId}</td>
					<td>${grade.type}</td>
					<td>$grade.score}</td>
				</tr>
				</c:forEach>
		</c:when>
	</c:choose>
	<footer>
			COPYRIGHT(C) 2023 <a href="https://github.com/BHbae/green_university.git">GREAN UNIVERSITY</a>. ALL RIGHTS RESERVED.
		</footer>
	
</body>
</html>