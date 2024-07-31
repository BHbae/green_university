<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>    
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="../resources/css/myInfo.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 교직원 - 휴학 처리 페이지 -->
<title>휴학 처리</title>
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
				<li><a href="${pageContext.request.contextPath}/college/collegelist">등록</a>
				<li><a href="${pageContext.request.contextPath}/notice/allnotice">학사정보</a>
			</ul>
		</nav>
	</header>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainPage.css">
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>학사 관리</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="${pageContext.request.contextPath}/management/selectStudent">학생 명단 조회</a></td>
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
					<td><a href="${pageContext.request.contextPath}/management/handelBreakApp" class="selected--menu">휴학 처리</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/management/setPeriod">수강 신청 기간 설정</a></td>
				</tr>
			</table>
		</div>
	</div>
	<main>
	<h1>휴학 처리</h1>
	<div class="split--div"></div>
	<div class="d-flex flex-column align-items-center" style="width: 100%">
	<!-- todo - 만약 휴학 신청이 있다면 테이블 생성 -->
		<c:if test="${breakAppList!=null}">
			<table border="1">
			<tr>
				<th>신청일자</th>
				<th>신청자 학번</th>
				<th>구분</th>
				<th>시작학기</th>
				<th>종료 학기</th>
				<th>신청서 확인</th>
			</tr>
			<c:forEach var="BreakAppDTO" items="${breakAppList}">
				<tr>
					<td>${BreakAppDTO.appDate}</td>
					<td>${BreakAppDTO.studentId}</td>
					<td>${BreakAppDTO.type}</td>
					<td>${BreakAppDTO.fromYear}년도 ${BreakAppDTO.fromSemester}학기</td>
					<td>${BreakAppDTO.toYear}년도 ${BreakAppDTO.toSemester}학기</td>
					<td><a href="${pageContext.request.contextPath}/management/handleBreakAppDetail?studentId=${BreakAppDTO.studentId}">Click</a></td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		<c:if test="${breakAppList==null}">
			<p>대기 중인 신청 내역이 없습니다.</p>
		</c:if>
	</div>
	</main>
	
		
</body>
</html>