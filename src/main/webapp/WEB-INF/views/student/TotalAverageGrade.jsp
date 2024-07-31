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
<title>총 누계 성적</title>

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
<style>
table {
	border-collapse: collapse;
}

.list--table th {
	padding: 3px 12px;
	width: 150px;
	text-align: center;
	background-color: #F0EFEF;
}

.list--table td {
	padding: 1px 5px;
}

.info--update--form {
	margin-left: 20px;
}

.update--table td {
	padding: 5px 10px;
}

.update--table label {
	margin-bottom: 2px;
}

.button--td {
	text-align: center;
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
					<td><a href="${pageContext.request.contextPath}/studentGrade/selectSemester">학기별 성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/studentGrade/totalGrade" class="selected--menu">총 누계 성적 조회</a></td>
				</tr>
			</table>
		</div>
	</div>
<body>
<!--  -->
<main>
	<h1>총 누계 성적</h1>
	<div class="split--div"></div>
		<div class="d-flex flex-column align-items-center" style="width: 100%">
	<c:if test="${not empty totalGradeList}">
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
					<td>${TotalGradeDTO.year}</td>
					<td>${TotalGradeDTO.semester}</td>
					<td>${TotalGradeDTO.registerdGrade}</td>
					<td>${TotalGradeDTO.getGrade}</td>
					<td>${TotalGradeDTO.averageGrade}</td>
				</tr>
				</c:forEach>
		</table>
	</c:if>
	
	<c:if test="${empty totalList}">
		<p>조회할 성적 내역이 없습니다.</p>
	</c:if>
	</div>
</main>

</body>
</html>