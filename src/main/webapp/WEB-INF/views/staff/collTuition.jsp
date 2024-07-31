<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<title>그린대학교 학사관리시스템</title>
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
						<td><a href="${pageContext.request.contextPath}/room/roomlist?action=form">강의실</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/subject/subjectlist?action=form">강의</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/colltuition/colllist?action=form" class="selected--menu">단대별 등록금</a></td>
					</tr>
				</table>
			</div>
		</div>

		<main>
			<h1>단대별 등록금</h1>
		<div class="split--div"></div>
		<div class="select--button">
			<a href="${pageContext.request.contextPath}/colltuition/colllist?action=from" class="button">등록</a> 
			<a href="${pageContext.request.contextPath}/colltuition/colllist?action=update" class="button">수정</a> 
			<a href="${pageContext.request.contextPath}/colltuition/colllist?action=detele" class="button">삭제</a>
		</div>


		<!-- 등록금 입력 -->
		<c:if test="${action.equals(\"from\")}">
		<form action="${pageContext.request.contextPath}/colltuition/addcoll" method="post">
		 	<select name="college_id">
		 		<c:forEach var="college" items="${college}">
		 		<option value="${college.id}">${college.name} </option>
		 		</c:forEach>
		 	</select>
		 	<input type="text" name="amount">
		<button  type="submit">전송</button>
		</form>
		</c:if>
		<!-- 등록금 수정 -->
		<c:if test="${action.equals(\"update\")}">
			<form action="${pageContext.request.contextPath}/colltuition/updatecoll" method="post">
		 	<select name="college_id">
		 		<c:forEach var="college" items="${college}">
		 		<option value="${college.id}">${college.name} </option>
		 		</c:forEach>
		 	</select>
		 	<input type="text" name="amount">
		<button  type="submit">수정</button>
		</form>	
		
		</c:if>

		<!-- 등록금 삭제 -->
		<c:if test="${action.equals(\"detele\")}">
		<form action="${pageContext.request.contextPath}/colltuition/detelecoll" method="post">
		 	<select name="college_id">
		 		<c:forEach var="college" items="${college}">
		 		<option value="${college.id}">${college.name} </option>
		 		</c:forEach>
		 	</select>
		<button  type="submit">삭제</button>
		</form>	
			
		</c:if>

		<!-- 등록금 조회 -->
			<c:if test="${!action.equals(\"detele\")}">
			<div class="form--container">
				<table class="table--container">
				<tbody><tr class="first--tr">
					<th>ID</th>
					<th>단과대</th>
					<th>금액</th>
				</tr>
				<c:forEach var="coll" items="${colltuitionList}">
				
					<tr>
						<td>${coll.id}</td>
						<td>${coll.name}</td>
						<td>${coll.amount}</td>
					</tr>
				
				</c:forEach>
				
					
			</tbody></table>
			</div>
			</c:if>
		</main>
	</div>
</body>
</html>
