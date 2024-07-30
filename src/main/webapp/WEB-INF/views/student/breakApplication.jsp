<!-- MY 페이지 휴학 신청 (학생) -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="university.green.student.model.StudentDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>    
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
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>MY</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/info/student">내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="/password">비밀번호 변경</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/mystudent/mybreakapp" class="selected--menu">휴학 신청</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/mystudent/mybreakapplist">휴학 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/tuition/list">등록금 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/tuition/payment">등록금 납부 고지서</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>휴학 신청</h1>
		<div class="split--div"></div>

		<div class="d-flex flex-column align-items-center" style="width: 100%">
			<form action="${pageContext.request.contextPath}/mystudent/appbreak" method="post" class="d-flex flex-column align-items-center">
				<div class="document--layout">
					<h3>휴학 신청서</h3>
					<table border="1">
						<c:if test="${not empty college}">
						<tr>
							<th>단 과 대</th>
							<td>${college.deptname}</td>
							<th>학 과</th>
							<td>${college.collegename}</td>
						</tr>
						</c:if>
						<tr>
							<th>학 번</th>
							<td>${principal.id}</td>
							<th>학 년</th>
							<td>${principal.grade}학년<input type="hidden" name="studentGrade" value="${student.grade}">
							</td>
						</tr>
						<tr>
							<th>전 화 번 호</th>
							<td>${principal.tel}</td>
							<th>성 명</th>
							<td>${principal.name}</td>
						</tr>
						<tr>
							<th>주 소</th>
							<td colspan="3">${principal.address}</td>
						</tr>
						<tr>
							<th>기 간</th>
							<td colspan="3"><select name="fromYear">
									<option value="2024" selected>2024
							</select>년도 <select name="fromSemester">
									<option value="1" selected>1
									<option value="2">2
							</select>학기부터 &nbsp; 
							<select name="toYear">
									<option value="2024" selected>2024
									<option value="2025">2025
							</select>년도 <select name="toSemester">
									<option value="1">1
									<option value="2" selected>2
							</select>학기까지
							</td>
						</tr>
						<tr>
							<th>휴 학 구 분</th>
							<td colspan="3"><input type="radio" name="type" value="일반" id="일반" checked> <label for="일반" style="margin: 0">일반휴학</label> &nbsp; <input type="radio"
								name="type" value="임신·출산·육아" id="임신"> <label for="임신" style="margin: 0">임신·출산·육아휴학</label> &nbsp; <input type="radio" name="type" value="질병" id="질병"> <label
								for="질병" style="margin: 0">질병휴학</label> &nbsp; <input type="radio" name="type" value="창업" id="창업"> <label for="창업" style="margin: 0">창업휴학</label> &nbsp; <input
								type="radio" name="type" value="군입대" id="군입대"> <label for="군입대" style="margin: 0">군입대휴학</label></td>
						</tr>
						<tr>
							<td colspan="4">
								<p>위와 같이 휴학하고자 하오니 허가하여 주시기 바랍니다.</p> <br>
								<p><%=String.format("%tY년 %tm월 %td일", new Date(), new Date(), new Date())%></p>
							</td>
						</tr>
					</table>
				</div>
				<button type="submit" class="btn btn-dark" onclick="return confirm('휴학을 신청하시겠습니까?')">신청하기</button>
			</form>
		</div>
	</main>
</div>
</body>
</html>