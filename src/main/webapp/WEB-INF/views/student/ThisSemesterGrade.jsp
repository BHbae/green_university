<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>금학기 성적 조회</title>
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

	<c:choose>
		<c:when test="${not empty user}">
		<h2>과목별 성적</h2>
			<table border='1'>
				<tr>
					<th>연도</th>
					<th>학기</th>
					<th>과목번호</th>
					<th>과목명</th>
					<th>강의구분</th>
					<th>학점</th>
					<th>성적</th>
					<th>강의평가</th>
				</tr>
				<c:forEach var="GradeDTO" items="${gradeList}">
				<tr>
					<td>${GradeDTO.subYear}</td>
					<td>${GradeDTO.semester}</td>
					<td>${GradeDTO.subjectId}</td>
					<td>${GradeDTO.name}</td>
					<td>${GradeDTO.type}</td>
					<td>${GradeDTO.grades}</td>
					<td>${GradeDTO.grade}</td>
					<td><a href=#>Click</a></td>
				</tr>
				</c:forEach>
			</table>
			<p>*강의 평가 후 성적 조회 가능</p>
			<hr>
			<h2>누계 성적</h2>
			<table border='1'>
				<tr>
				<th>연도</th>
				<th>학기</th>
				<th>신청학점</th>
				<th>취득학점</th>
				<th>성적평균</th>
				</tr>
			</table>
		</c:when>
		<c:forEach var="GradeDTO" items="${gradeList}">
				<tr>
					<td>${GradeDTO.subYear}</td>
					<td>${GradeDTO.semester}</td>
					<td>${GradeDTO.subjectId}</td>
					<td>${GradeDTO.name}</td>
					<td>${GradeDTO.type}</td>
					<td>${GradeDTO.grades}</td>
					<td>${GradeDTO.grade}</td>
				</tr>
				</c:forEach>
	</c:choose>
<footer>
			COPYRIGHT(C) 2023 <a href="https://github.com/BHbae/green_university.git">GREAN UNIVERSITY</a>. ALL RIGHTS RESERVED.
		</footer>
</body>
</html>