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
<!-- 교직원 - 학생 명단 조회 페이지 -->
<title>학생 명단 조회</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<style>
	
.sub--list--table th {
	padding: 3px 9px;
	text-align: center;
}

.sub--list--table td {
	padding: 1px 9px;
	text-align: center;
}

.sub--list--name {
	text-align: left !important;
	padding-right: 20px !important;
}

.sub--filter {
	margin-bottom: 50px;
}

.sub--filter form {
	display: flex;
}

.sub--filter form div {
	background-color: buttonshadow;
	padding: 13px 13px 7px 10px;
}

.sub--filter input[type="number"] {
	width: 57px;
	padding-left: 3px;
}

.sub--filter select[name="deptId"] {
	width: 173px;
}

.sub--filter label {
	margin-right: 5px;
}

.sub--filter input, .sub--filter select {
	margin-right: 10px;
	border-radius: 5px;
	border-width: 1px;
}

.sub--filter button {
	background-color: gray;
	padding: 2px 6px;
	border: none;
	border-radius: 5px;
	color: white;
	height: 28px;
}

.sub--plan--view li a:hover {
	color: black;
}
.paging--container {
	display: flex;
	justify-content: center;
}

</style>
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
			<a href="/"><img class="logo" alt="" src="../resources/ima/logo.png"></a>
			<!-- userRole에 따라 메뉴 다르게 표시 -->			
					<ul>
						<li><a href="/">홈</a>
						<li><a href="/">MY</a>
						<li><a href="${pageContext.request.contextPath}/management/selectStudent">학사관리</a>
						<li><a href="/">등록</a>
						<li><a href="${pageContext.request.contextPath}/notice/notice">학사정보</a>
					</ul>
		</nav>
	</header>
	<!-- 헤드 부분 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>MY</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="${pageContext.request.contextPath}/management/selectStudent" >학사관리</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/management/selectStudent" class="selected--menu">학생 명단 조회</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/management/selectProfessor">교수 명단 조회</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/management/registerStudent">학생 등록</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/management/registerProfessor">교수 등록</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/management/registerStaff">직원 등록</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/management/sendBill">등록금 고지서 발송</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/management/handelBreakApp">휴학 처리</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/management/setPeriod">수강 신청 기간 설정</a></td>
				</tr>
			</table>
		</div>
	</div>
	<main>
		<h1>학생 명단 조회</h1>
	
	<!--/green/management/selectStudent-->
	<!-- 검색창 -->
	<form class="selectSpecifictStudent" action="${pageContext.request.contextPath}/management/selectSpecifictStudent" method="POST">
		<label for="deptId">학과 번호</label>
		<input type="text" id="deptId" name="deptId">
		<label for="stuId">학번</label>
		<input type="text" id="stuId" name="stuId">
		<input type="submit" value="조회하기">
	</form>
	<form action="selectStudent" action="${pageContest.request.contextpath}/management/selectStudent" method="GET">
		<input type="submit" value="새학기 업데이트">
	</form>
	<c:choose>
		<c:when test="${not empty studentList}">
	<h3>학생 목록 </h3>
		<div class="container">
			<table border="1">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>학과번호</th>
				<th>학년</th>
				<th>입학일</th>
				<th>졸업일(졸업예정일)</th>
			</tr>
			<c:forEach var="StudentDTO" items="${studentList}">
				<tr>
					<td>${StudentDTO.id}</td>
					<td>${StudentDTO.name}</td>
					<td>${StudentDTO.birthDate}</td>
					<td>${StudentDTO.gender}</td>
					<td>${StudentDTO.address}</td>
					<td>${StudentDTO.tel}</td>
					<td>${StudentDTO.email}</td>
					<td>${StudentDTO.deptId}</td>
					<td>${StudentDTO.grade}</td>
					<td>${StudentDTO.semester}</td>
					<td>${StudentDTO.entranceDate}</td>
					<td>${StudentDTO.graduationDate}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	</c:choose>
		</div>
	</main>
	<footer>
		COPYRIGHT(C) 2023 <a href="https://github.com/BHbae/green_university.git">GREAN UNIVERSITY</a>. ALL RIGHTS RESERVED.
	</footer>
	
	
</body>
</html>