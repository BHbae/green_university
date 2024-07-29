<!-- MY 페이지 등록금 내역 조회 (학생) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="university.green.student.model.StudentDTO"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그린대학교 학사관리시스템</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
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
			<a href="/"><img class="logo" alt="" src="resources/ima/logo.png"></a>
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
				<tr>
					<td><a href="/info/student">내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="/password">비밀번호 변경</a></td>
				</tr>
				<tr>
					<td><a href="/break/application">휴학 신청</a></td>
				</tr>
				<tr>
					<td><a href="/break/list">휴학 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/tuition/list" class="selected--menu">등록금 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/tuition/payment">등록금 납부 고지서</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>등록금 내역 조회</h1>
		<div class="split--div"></div>
		<c:choose>
				<c:when test="<!-- 추가예정 -->">
					<table border="1" class="list--table">
						<thead>
							<tr>
								<th>등록연도</th>
								<th>등록학기</th>
								<th>장학금 유형</th>
								<th>등록금</th>
								<th>장학금</th>
								<th>납입금</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="tuition" items="<!-- 추가예정 -->">
								<tr>
									<td>2024년</td>
									<td>1학기</td>
									<c:choose>
										<%-- 장학금 지원 대상이 아니라면 --%>
										<c:when test="null">
											<td>해당 없음</td>
										</c:when>
										<c:otherwise>
											<td><!-- 추가예정 -->유형</td>
										</c:otherwise>
									</c:choose>
									<td><!-- 추가예정 --></td>
									<c:choose>
										<%-- 장학금 지원 대상이 아니라면 --%>
										<c:when test="<!-- 추가예정 -->">
											<td>0</td>
										</c:when>
										<c:otherwise>
											<td><!-- 추가예정 --></td>
										</c:otherwise>
									</c:choose>
									<td><!-- 추가예정 --></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</c:when>
			<c:otherwise>
				<p class="no--list--p">등록금 납부 내역이 없습니다.</p>
			</c:otherwise>
		</c:choose>
	</main>
</div>
</body>
</html>

