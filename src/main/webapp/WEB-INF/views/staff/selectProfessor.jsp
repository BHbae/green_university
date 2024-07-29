<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>    
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 교직원 - 교수 명단 조회 페이지 -->
<title>교수 명단 조회</title>
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
			<a href="/"><img class="logo" alt="" src="resources/ima/logo.png"></a>
			<!-- userRole에 따라 메뉴 다르게 표시 -->			
					<ul>
						<li><a href="/">홈</a>
						<li><a href="/">MY</a>
						<li><a href="/">학사관리</a>
						<li><a href="/">등록</a>
						<li><a href="${pageContext.request.contextPath}/notice/notice">학사정보</a>
					</ul>
		</nav>
	</header>
	<h1>교수 명단 조회</h1>
	
	<!-- 검색창 -->
	<form class="searchProfessor" action="${pageContext.request.contextPath}/management/selectSpecificProfessor" method="POST">
		<label for="deptId">학과 번호</label>
		<input type="text" id="deptId" name="deptId">
		<label for="proId">사번</label>
		<input type="text" id="proId" name="proId">
		<input type="submit" value="조회하기">
	</form>
	<c:choose>
		<c:when test="${not empty professorList}">
	<h3>교수 목록</h3>
		<table border="1">
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>학과번호</th>
				<th>고용일</th> 
			</tr>
			<c:forEach var="ProfessorDTO" items="${professorList}">
				<tr>
					<td>${ProfessorDTO.id}</td>
					<td>${ProfessorDTO.name}</td>
					<td>${ProfessorDTO.birthDate}</td>
					<td>${ProfessorDTO.gender}</td>
					<td>${ProfessorDTO.address}</td>
					<td>${ProfessorDTO.tel}</td>
					<td>${ProfessorDTO.email}</td>
					<td>${ProfessorDTO.deptId}</td>
					<td>${ProfessorDTO.hireDate}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	</c:choose>
	
	
</body>
</html>