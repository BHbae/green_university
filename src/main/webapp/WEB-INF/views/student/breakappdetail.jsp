<!-- MY 페이지 내 정보보기 (학생) -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="university.green.student.model.StudentDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<li><a href="${pageContext.request.contextPath}/mystudent/my">MY</a>
				<li><a href="/">수업</a>
				<li><a href="${pageContext.request.contextPath}/sugang/listBoards">수강신청</a>
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
						<td><a href="${pageContext.request.contextPath}/mystudent/my">내 정보 조회</a></td>
					</tr>
					<tr>
						<td><a href="/password">비밀번호 변경</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/mystudent/mybreakapp">휴학 신청</a></td>
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
		<c:if test="${not empty leave}">
			<form action="${pageContext.request.contextPath}/mystudent/deleteapp?id=${leave.id}" method="post">
				<h1>휴학 상세 조회</h1>
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
							<c:if test="${not empty dto}">
								<th>단과대</th>
								<td>${dto.deptname}</td>
								<th>소속</th>
								<td>${dto.collegename}</td>
							</c:if>
						</tr>
						<tr>
							<th>학번</th>
							<td>${principal.id}</td>
							<th>학년</th>
							<td>${principal.grade}학년</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>${principal.tel}</td>
							<th>이름</th>
							<td>${principal.name}</td>
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
							<th>주소</th>
							<td>${principal.address}</td>
							<th>생년월일</th>
							<td>${principal.birthDate}</td>
						</tr>

						<tr>
							<th>기간</th>
							<td>${leave.fromYear}년도${leave.fromSemester}학기부터${leave.toYear}년도 ${leave.toSemester}학기까지</td>
							<th>사유</th>
							<td>${leave.type}</td>
						</tr>
						<tr>
							<th>신청일</th>
							<td>${leave.appDate}</td>
							<th>처리상태</th>
							<td>${leave.status}</td>
						</tr>
					</tbody>
				</table>
				<button type="submit" class="btn btn-dark update--button" onclick="return confirm('휴학신청을 취소하시겠습니까?')">취소하기</button>
			</form>
		</c:if>

	</main>
</div>
</body>
</html>