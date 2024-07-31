<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>   
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght@400&display=swap">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기별 학기 성적 조회</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<style>
.document--layout h3 {
	font-weight: 600;
	margin-bottom: 30px;
}

.document--layout tr:last-of-type td {
	padding: 18px 8px 2px;
}

.align-items-center {
	align-items: center !important;
}

.flex-column {
	flex-direction: column !important;
}

table {
	border-collapse: collapse;
}

.btn {
	display: inline-block;
	font-weight: 400;
	color: #212529;
	text-align: center;
	vertical-align: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	background-color: transparent;
	border: 1px solid transparent;
	padding: .375rem .75rem;
	font-size: 1rem;
	line-height: 1.5;
	border-radius: .25rem;
	color: #fff;
	background-color: #343a40;
	border-color: #343a40;
	transition: color .15s ease-in-out, background-color .15s ease-in-out,
		border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

.document--layout {
	border: 1px solid #4c4b4b;
	padding: 50px 30px 30px 30px;
	text-align: center;
	margin-bottom: 30px;
}

.document--layout th {
	text-align: center;
	padding: 2px 20px;
}

.document--layout td {
	text-align: right;
	padding: 2px 8px 2px 50px;
}
</style>
</head>
<body>
<header class="d-flex flex-column">

		<div class="header--top">
			<ul>
				<li class="material--li"><span class="material-symbols-outlined"><i class="material-icons">account_circle</i></span> <c:if test="${not empty principal}">
						<li>${principal.name}님(${principal.id})님
					</c:if>
				<li style="margin: 0 15px;">
				<li class="material--li"><span style="color: #9BD2EC;" class="material-symbols-outlined"><i class="material-icons">logout</i></span>
				<li><a href="/green/Login.jsp">로그아웃</a>
			</ul>
		</div>

		<nav class="main--menu">
			<a href="/"><img class="logo" alt="" src="../resources/ima/logo.png"></a>
			<!-- userRole에 따라 메뉴 다르게 표시 -->
			<ul>
				<li><a href="${pageContext.request.contextPath}">홈</a>
				<li><a href="${pageContext.request.contextPath}/mystudent/my">MY</a>
				<li><a href="${pageContext.request.contextPath}">수업</a>
				<li><a href="${pageContext.request.contextPath}/sugang/listBoards">수강신청</a>
				<li><a href="${pageContext.request.contextPath}/studentGrade/gradeOfThisSemester">성적</a>
				<li><a href="${pageContext.request.contextPath}/notice/allnotice">학사정보</a>
			</ul>
		</nav>
	</header>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainPage.css">
</head>
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>성적</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="${pageContext.request.contextPath}/studentGrade/gradeOfThisSemester">이번 학기 성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/studentGrade/selectSemester" class="selected--menu">학기별 성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/studentGrade/totalGrade">총 누계 성적 조회</a></td>
				</tr>
			</table>
		</div>
	</div>
<body>
<main>
	<h1>학기별 성적 조회</h1>
	<div class="split--div"></div>
		<div class="d-flex flex-column align-items-center" style="width: 100%">
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
	</div>
</main>
	
	
	
</body>
</html>