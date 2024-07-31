<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="university.green.student.model.StudentDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght@400&display=swap">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainPage.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록 - 강의실</title>
<style>
table {
	border-collapse: collapse;
}
.hidden {
	display: none;
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
				<li><a href="${pageContext.request.contextPath}/Login.jsp">로그아웃</a>
			</ul>
		</div>
		
		<nav class="main--menu">
			<a href="${pageContext.request.contextPath}/"><img class="logo" alt="" src="${pageContext.request.contextPath}/resources/ima/logo.png"></a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/">홈</a></li>
				<li><a href="${pageContext.request.contextPath}/">MY</a></li>
				<li><a href="${pageContext.request.contextPath}/management/selectStudent">학사관리</a></li>
				<li><a href="${pageContext.request.contextPath}/college/collegelist">등록</a></li>
				<li><a href="${pageContext.request.contextPath}/notice/allnotice">학사정보</a></li>
			</ul>
		</nav>
	</header>

	<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
		<div class="sub--menu">
			<div class="sub--menu--top">
				<h2>등록</h2>
			</div>
			<div class="sub--menu--mid">
				<table class="sub--menu--table" border="1">
					<tr>
						<td><a href="${pageContext.request.contextPath}/college/collegelist?action=form" >단과대학</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/department/departmentlist?action=form">학과</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/room/roomlist?action=form" class="selected--menu">강의실</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/subject/subjectlist?action=form">강의</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/college/">단대별 등록금</a></td>
					</tr>
				</table>
			</div>
		</div>


	<main>
		<h1>강의실</h1>
		<div class="split--div"></div>
		<div class="select--button">
			<a href="${pageContext.request.contextPath}/room/roomlist?action=form" class="button">등록</a> 
			<a href="${pageContext.request.contextPath}/room/roomlist?action=delete" class="button">삭제</a>
		</div>


			<!-- 강의 등록 -->
				<c:if test="${action.equals(\"form\")}">
				<form action="${pageContext.request.contextPath}/room/roomlist" method="post">
				<div class="insert--form">
						<ul class="d-flex" style="margin: 0;">
							<li style="height: 24px; margin-right: 2px;"><span class="material-symbols-outlined">school</span>
							<li style="height: 24px;"><span class="insert">등록하기</span>
						</ul>
						<input type="text" name="id" class="input--box" placeholder="등록할 강의실을 입력하세요"> <input type="text" name="collegeId" class="input--box" placeholder="단과대 번호를 입력하세요">
						<input type="submit" value="입력" class="button">
					</div>
				</form>
			</c:if>


			<!-- 강의 삭제 -->
			<c:if test="${action.equals(\"delete\")}">
				<form action="${pageContext.request.contextPath}/room/roomlist" method="post">
				<span class="delete">삭제할 강의실을 클릭해주세요</span>
				<table class="table--container">
				<tr class="first--tr">
					<td>강의실</td>
					<td>단과대ID</td>
				</tr>
				<c:forEach var="room" items="${roomList}">
					<tr>
						<td><a href="/admin/roomDelete?id=${room.id}">${room.id}</a></td>
						<td>${room.collegeId}</td>
					</tr>
				</c:forEach>
			</table>
			</form>
			</c:if>


			<!-- 강의 조회 -->
			
				<div class="form--container">
					<table class="table--container">
					<tbody><tr class="first--tr">
						<td>강의실</td>
						<td>단과대ID</td>
					</tr>
					
					<c:forEach var="room" items="${roomList}"> 
					<tr>
						<td>${room.id}</td>
						<td>${room.collegeId}</td>
					</tr>
					</c:forEach>

					</tbody>
					</table>
				</div>
			
	</main>
		</div>
</body>
</html>