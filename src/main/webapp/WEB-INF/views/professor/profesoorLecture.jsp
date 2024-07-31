<!-- MY 페이지 휴학 신청 (학생) -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="university.green.student.model.StudentDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>그린대학교 학사관리시스템</title>
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
				<li><a href="${pageContext.request.contextPath}/professor/my">MY</a>
				<li><a href="${pageContext.request.contextPath}/lecture/lectureAll">수업</a>
				<li><a href="">학사정보</a>
			</ul>
		</nav>
	</header>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainPage.css">
</head>
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
					<td><a href="${pageContext.request.contextPath}/lecture/lectureAll" class="selected--menu">전체강의 조회</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/lecture/mylecture">내강의 조회</a></td>
				</tr>
				<tr>
					<td><a href="/">내강의 평가</a></td>
				</tr>

			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>전체강의 조회</h1>
		<div class="split--div"></div>

		<div class="d-flex flex-column align-items-center" style="width: 100%">
			<form action="/break/application" method="post" class="d-flex flex-column align-items-center">
				<div class="document--layout">
					<h3>전체 강의 목록</h3>
					<table border="1">
						<tr>
							<th>단과학대</th>
							<th>컴퓨터공학과</th>
							<th>학수번호</th>
							<th>강의구분</th>
							<th>강의명</th>
							<th>담당교수</th>
							<th>학점</th>
							<th>수강인원</th>
							<th>정원</th>
							<th>강의계획서</th>

						</tr>
						<c:forEach var="lectureList" items="${lectureList}">
							<tr>
								<td><c:out value="${lectureList.id}" /></td>
								<td><c:out value="${lectureList.college}" /></td>
								<td><c:out value="${lectureList.departNum}" /></td>
								<td><c:out value="${lectureList.majorType}" /></td>
								<td><c:out value="${lectureList.subjectName}" /></td>
								<td><c:out value="${lectureList.professorName}" /></td>
								<td><c:out value="${lectureList.grades}" /></td>
								<td><c:out value="${lectureList.subjectDay}" /></td>
								<td><c:out value="${lectureList.subjectStart}" /></td>
								<td><c:out value="${lectureList.subjectEnd}" /></td>
								<td><c:out value="${lectureList.room}" /></td>
								<td><c:out value="${lectureList.currentStudent}" /></td>
								<td><c:out value="${lectureList.capacity}" /></td>
							</tr>
						</c:forEach>
						<br>
						<div class="pagination">
							<!-- index for  -->
							<c:forEach begin="1" end="${totalPage}" var="i">
								<c:choose>
									<c:when test="${ i == page }">
										<span class="current-page">${i}</span>
									</c:when>
									<c:otherwise>
										<span><a href="${pageContext.request.contextPath}/lecture/lectureAll?page=${i}">${i}</a></span>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>

					</table>
				</div>

			</form>
		</div>
	</main>
</div>
</body>
</html>