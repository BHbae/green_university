<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 교직원 - 학생 등록 페이지 -->
<title>학생 등록</title>
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
	<h1>학생 등록</h1>
		<form class="register-student-from" action="${pageContext.request.contextPath}/management/registerSt" method="POST">
			<label for="name">이름</label>
			<input type="text" id="name" name="name" value=""><br>
			
			<label for="birthDate">생년월일</label>
			<input type="date" id="birthDate" name="birthDate" value=""><br>
			
			<label for="gender">성별</label>
			<input type="text" id="gender" name="gender" value=""><br>
			
			<label for="address">주소</label>
			<input type="text" id="address" name="address" value=""><br>
			
			<label for="tel">전화번호</label>
			<input type="text" id="tel" name="tel" value=""><br>
			
			<label for="email">이메일</label>
			<input type="text" id="email" name="email" value=""><br>
			
			<label for="deptId">과 ID</label>
			<input type="text" id="deptId" name="deptId" value=""><br>
			
			<label for="entranceDate">입학일</label>
			<input type="date" id="entranceDate" name="entranceDate" value=""><br>
			
			<input type="submit" value="입력" class="submit-btn">
		</form>
</body>
</html>