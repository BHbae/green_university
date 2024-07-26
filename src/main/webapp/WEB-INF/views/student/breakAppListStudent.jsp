<!-- MY 페이지 휴학 내역 조회 (학생) -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="university.green.student.model.StudentDTO"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그린대학교 학사관리시스템</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
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
				<li><a href="/">홈</a>
				<li><a href="/">MY</a>
				<li><a href="/">수업</a>
				<li><a href="/">수강신청</a>
				<li><a href="/">성적</a>
				<li><a href="/">학사 정보</a>
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
						<td><a href="/info/student">내 정보 조회</a></td>
					</tr>
					<tr>
						<td><a href="/password">비밀번호 변경</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/mystudent/mybreakapp" >휴학 신청</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/mystudent/mybreakapplist" class="selected--menu">휴학 내역 조회</a></td>
					</tr>
					<tr>
						<td><a href="/tuition/list">등록금 내역 조회</a></td>
					</tr>
					<tr>
						<td><a href="/tuition/payment">등록금 납부 고지서</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 메인 div -->
	<main>
		<h1>휴학 내역 조회</h1>
		<div class="split--div"></div>
				
				<table border="1" class="list--table">
					<thead>
						<tr>
							<th>신청일자</th>
							<th>구분</th>
							<th>휴학시작</th>
							<th>휴학종료</th>
							<th>신청서 확인</th>
							<th>상태</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="AppList" items="${AppList}">
							<tr>
								<td>${AppList.appDate}</td>
								<td>${AppList.type}</td>
								<td>${AppList.fromYear}년도 ${AppList.fromSemester}학기 </td>
								<td>${AppList.toYear}년도 ${AppList.toSemester}학기 </td>
								<td><a href="${pageContext.request.contextPath}/mystudent/mybreakappdetail?id=${AppList.id}">Click</a></td>
								
								<c:if test="${AppList.status.equals(\"처리중\")}">
								<td>처리중</td>
								</c:if>
								<c:if test="${AppList.status.equals(\"승인\")}">
								<td>승인</td>
								</c:if>
								<c:if test="${AppList.status.equals(\"거부\")}">
								<td>거부</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${empty AppList}">
				<p class="no--list--p">휴학 신청 내역이 없습니다.</p>
				</c:if>
	</main>
</div>
</body>
</html>