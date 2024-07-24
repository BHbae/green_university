<!-- MY 페이지 비밀번호 변경 (학생) -->
<%@page import="university.green.professor.model.ProfessorDTO"%>
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
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/myInfo.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mainPage.css">
<style>
table {
	border-collapse: collapse;
}
.table--container {
    display: table;
    width: 500px;
    border: 1px solid #D2D1D1;
    border-width: 1px 0px;
    margin-top: 50px;
    border-spacing: 2px;
    font-size: 1rem;
    font-weight: 400;
    line-height: 3;
    color: #212529;
    text-align: left;
}
.table--container tr{
border-bottom: 1px solid #D2D1D1;
}
</style>
</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admin.css">
<body>

	<header class="d-flex flex-column">
		<div class="header--top">
			<ul>
				<li class="material--li"><span
					class="material-symbols-outlined"><i class="material-icons">account_circle</i></span>
					<c:if test="${not empty principal}">
						<li>${principal.name}님(${principal.id})님
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
				<li><a href="/">수업</a>
				<li><a href="/">수강신청</a>
			</ul>
		</nav>
	</header>
	<!-- 헤드 부분 -->
	<div class="d-flex justify-content-center align-items-start"
		style="min-width: 100em;">
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
							<td><a href="/info/student">내 정보
									조회</a></td>
						</tr>
						<tr>
							<td><a href="/password" class="selected--menu">비밀번호 변경</a></td>
						</tr>
						<tr>
							<td><a href="/break/application">휴학 신청</a></td>
						</tr>
						<tr>
							<td><a href="/break/list">휴학 내역 조회</a></td>
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
			<h1>비밀번호 변경</h1>
			<div class="split--div"></div>
			<form action="/password" method="post" class="form--container">
				<input type="hidden" name="_method" value="put" />
				<table class="table--container">
					<tr>
						<td><label for="beforePassword">현재 비밀번호</label></td>
						<td><input type="password" name="beforePassword"
							class="input--box" id="beforePassword"></td>
					</tr>
					<tr>
						<td><label for="afterPassword">변경할 비밀번호</label></td>
						<td><input type="password" name="afterPassword"
							class="input--box" id="afterPassword"></td>
					</tr>
					<tr>
						<td><label for="passwordCheck">변경할 비밀번호 확인</label></td>
						<td><input type="password" name="passwordCheck"
							class="input--box" id="passwordCheck"></td>
					</tr>
				</table>
				<c:choose>
					<c:when test="${principal.getUserRole().equals(\"staff\")}">
						<div class="button--container">
							<input type="submit" value="입력">
						</div>
					</c:when>
					<c:otherwise>
						<br>
						<button type="submit" class="btn btn-dark update--button">수정하기</button>
					</c:otherwise>
				</c:choose>
			</form>
		</main>
</body>
</html>