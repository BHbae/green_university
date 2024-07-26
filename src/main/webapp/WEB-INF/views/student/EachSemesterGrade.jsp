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
<title>학기별 학기 성적 조회</title>
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
						<li><a href="/">수업</a>
						<li><a href="/">수강신청</a>
						<li><a href="/">성적</a>
						<li><a href="/">학사 정보</a>
					</ul>
		</nav>
	</header>
	
			<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="${pageContext.request.contextPath}/notice.jsp" class="selected--menu" >공지사항</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/schedule_tb.jsp">학사일정</a></td>				
				</tr>
				
					<tr>
						<td><a href="${pageContext.request.contextPath}/scheduleCreate.jsp"> 학사일정 등록</a></td>
					</tr>
				
			</table>
		</div>
	</div>
<!--  -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainPage.css">
</head>
<body>
	<h1>학기별 성적 조회</h1>
	<c:if test="${not empty EachGradeList}">
	<form action="choose-semester" action="${pageContext.request.contextPath}/studentGrade/selectSepcificSubject">
		<select name="year" id="year">
			<option>2021년</option>
			<option>2022년</option>
			<option>2023년</option>
			<option>2024년</option>
		</select>
		<select name="semester" id="semester">
			<option>1학기</option>
			<option>2학기</option>
		</select>
		<select name="semester" id="semester">
			<option>전체</option>
			<option>전공</option>
			<option>교양</option>
		</select>
		<button></button>
	</form>
		<h2>과목별 성적</h2>
			<table border='1'>
				<tr>
					<th>연도</th>
					<th>학기</th>
					<th>과목번호</th>
					<th>과목명</th>
					<th>강의구분</th>
					<th>학점</th>
				</tr>
				<c:forEach var="EachGradeDTO" items="${EachGradeList}">
					<tr> 
						<td>${EachGradeDTO.subYear}</td>
						<td>${EachGradeDTO.semester}</td>
						<td>${EachGradeDTO.subjectId}</td>
						<td>${EachGradeDTO.name}</td>
						<td>${EachGradeDTO.type}</td>
						<td>${EachGradeDTO.grade}</td>
					</tr>
				</c:forEach>
			</table>
	</c:if>
	
	<c:if test="${empty EachGradeList}">
		<p>조회할 성적 내역이 존재하지 않습니다.</p>
	</c:if>
	<footer>
			COPYRIGHT(C) 2023 <a href="https://github.com/BHbae/green_university.git">GREAN UNIVERSITY</a>. ALL RIGHTS RESERVED.
	</footer>
	
</body>
</html>