<%@page import="university.green.staff.model.StaffDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!DOCTYPE html>
<html>
<!-- header 부분 따로 include 만들어서 학생 스탭한테 넣어줘야함  -->
<head>
<meta charset="UTF-8">
<title>그린대학교 학사관리시스템</title>
<link rel="stylesheet" type="text/css"
	href`="${pageContext.request.contextPath}/resources/css/main.css">
<style>
table {
	border-collapse: collapse;
}

.room--table {
	text-align: center;
	margin-top: 20px;
	margin: 10px;
}

.room--table td {
	padding: 10px;
	width: 300px;
}

.first--tr {
	font-weight: bold;
}

.mouth {
	background-color: #f5f5f5;
}

.line {
	
}

.container {
	margin-top: 100px;
}

.table {
	width: 800px;
}

.first--tr {
	background-color: #f7f6f6;
	font-weight: bolder;
	overflow: hidden;
	text-overflow: ellipsis;
}

.button {
	padding: 5px;
	border: 1px solid #031734;
	border-radius: 3px;
	background-color: #031734;
	color: #ccc;
	text-decoration: none;
	margin-left: 770px;
}
tbody {
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    text-indent: initial;
    border-spacing: 2px;
}
</style>
</head>
<body>

	<header class="d-flex flex-column">
		<div class="header--top">
			<ul>
				<li class="material--li"><span
					class="material-symbols-outlined"><i class="material-icons">account_circle</i></span>
					<c:if test="${not empty principal}">
						<li>${principal.name}님 (${principal.id})님
					</c:if>
				<li style="margin: 0 15px;">
				<li class="material--li"><span style="color: #9BD2EC;"
					class="material-symbols-outlined"><i class="material-icons">logout</i></span>
				<li><a href="/green/Login.jsp">로그아웃</a>
			</ul>
		</div>

		<nav class="main--menu">
			<a href="/"><img class="logo" alt="" src="resources/ima/logo.png"></a>
			<!-- userRole에 따라 메뉴 다르게 표시 -->
			<ul>
				<li><a href="/">홈</a>
				<li><a href="/">MY</a>
				<li><a
					href="${pageContext.request.contextPath}/management/selectStudent">학사관리</a>
				<li><a href="/">등록</a>
				<li><a href="${pageContext.request.contextPath}/notice/notice">학사정보</a>
			</ul>
		</nav>
	</header>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/resources/css/mainPage.css">


	<!-- 헤드 부분 -->

	<div class="d-flex justify-content-center align-items-start"
		style="min-width: 100em;">
		<div class="sub--menu">
			<div class="sub--menu--top">
				<h2>학사정보</h2>
			</div>
			<div class="sub--menu--mid">
				<table class="sub--menu--table" border="1">
					<tr>
						<td><a href="/notice">공지사항</a></td>
					</tr>
					<tr>
						<td><a href="/schedule">학사일정</a></td>
					</tr>
						<tr>
							<td><a href="/schedule/list" class="selected--menu">
									학사일정 등록</a></td>
						</tr>
				</table>
			</div>
		</div>
		<main>
				<form action="/" method="post">
					<table class="table">
						<thead>
							<tr class="first--tr">
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>시작날짜</td>
								<td><input type="date" name="startDay"></td>
							</tr>
							<tr>
								<td>종료날짜</td>
								<td><input type="date" name="endDay"></td>
							</tr>
							<tr>
								<td class="td">내용</td>
								<td class="info"><input type="text" name="information"
									class="textbox"></td>
							</tr>
						</tbody>
					</table>
					<button class="button">등록</button>
				</form>
		</main>
	</div>
</body>
</html>

