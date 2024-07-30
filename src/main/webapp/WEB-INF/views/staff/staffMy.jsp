<!-- MY 페이지 내 정보보기 (학생) -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="university.green.student.model.StudentDTO"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="../resources/css/myInfo.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그린대학교 학사관리시스템</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<style>
</style>
<body>

	<header class="d-flex flex-column">

		<div class="header--top">
			<ul>
				<li class="material--li"><span class="material-symbols-outlined"><i class="material-icons">account_circle</i></span> <c:if test="${not empty principal}">
						<li>${principal.name}님 (${principal.id})님
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
				<li><a href="${pageContext.request.contextPath}/staffmy/my">MY</a>
				<li><a href="${pageContext.request.contextPath}/management/selectStudent">학사관리</a>
				<li><a href="${pageContext.request.contextPath}/college/collegelist">등록</a>
				<li><a href="${pageContext.request.contextPath}/notice/allnotice">학사정보</a>
			</ul>
		</nav>
	</header>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainPage.css">
</head>
<!-- 헤드 부분 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>MY</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tbody>
					<tr>
						<td><a href="${pageContext.request.contextPath}/staffmy/my" class="selected--menu">내 정보 조회</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/staffmy/uppass">비밀번호 변경</a></td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>내 정보 조회</h1>
		<div class="split--div"></div>
		<table border="1" class="input--table">
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
			</colgroup>
			<tbody>
				<tr>
					<th>ID</th>
					<td>230001</td>
					<th>입사 날짜</th>
					<td>2023-01-01</td>
				</tr>
			</tbody>
		</table>
		<table border="1" class="input--table">
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
			</colgroup>
			<tbody>
				<tr>
					<th>성명</th>
					<td>${principal.name}</td>
					<th>생년월일</th>
					<td>${principal.birth_date}</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>${principal.gender}</td>
					<th>주소</th>
					<td>${principal.address}</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${principal.address}</td>
					<th>email</th>
					<td>${principal.email}</td>
				</tr>
			</tbody>
		</table>
		<button type="button" onclick="location.href='/update'" class="btn btn-dark update--button">수정하기</button>

	</main>
</div>
</body>
</html>