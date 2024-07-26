<%@page import="university.green.staff.model.StaffDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>    
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!DOCTYPE html>
<html>
<!-- header 부분 따로 include 만들어서 학생 스탭한테 넣어줘야함  -->
<head>
<meta charset="UTF-8">
<title>그린대학교 학사관리시스템</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<style>
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
			<a href="/"><img class="logo" alt="" src="resources/ima/logo.png"></a>
			<!-- userRole에 따라 메뉴 다르게 표시 -->			
					<ul>
						<li><a href="/">홈</a>
						<li><a href="/">MY</a>
<<<<<<< HEAD
						<li><a href="/">학사관리</a>
						<li><a href="/">등록</a>
=======
						<li><a href="${pageContext.request.contextPath}/management/selectStudent">학사관리</a>
						<li><a href="${pageContext.request.contextPath}/college/collegelist">등록</a>
>>>>>>> d1291726cb407779e17498d58abb5cabc9940081
						<li><a href="${pageContext.request.contextPath}/notice/allnotice">학사정보</a>
					</ul>
		</nav>
	</header>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainPage.css">
</head>
<body>
<!-- 헤드 부분 -->

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">

	<div>
		<img alt="" src="resources/ima/main_photo.jpg" class="main--page--img">
		<div class="d-flex justify-content-center align-items-start">
			<div class="main--page--div">
				<div class="d-flex">
					<!-- 공지사항 -->
					<div class="main--page--notice">
						<h3>
							<a href="/notice">공지사항</a><!-- 페이지이동 -->
						</h3>
						<div class="main--page--split"></div>
						<table>
							
								<tr><!-- 페이지이동 -->
									<td><a href="/notice/read?id=6">[장학]&nbsp;2023학년도 교외장학재단 신규장학생 선발 결과 안내</a></td>
									<td>2024-07-18
								</tr>
							
								<tr><!-- 페이지이동 -->
									<td><a href="/notice/read?id=5">[일반]&nbsp;2023학년도 1학기 코로나 19 특별휴학 시행 안내</a></td>
									<td>2024-07-18
								</tr>
							
								<tr><!-- 페이지이동 -->
									<td><a href="/notice/read?id=4">[일반]&nbsp;2023학년도 장애 인식개선 교육(법정의무교육) 안내</a></td>
									<td>2024-07-18
								</tr>
							
								<tr><!-- 페이지이동 -->
									<td><a href="/notice/read?id=3">[일반]&nbsp;Gartner Research(IT 분야 시장분석) 서비스 지원 안내</a></td>
									<td>2024-07-18
								</tr>
							
								<tr><!-- 페이지이동 -->
									<td><a href="/notice/read?id=2">[장학]&nbsp;2023학년도 보건장학회 연구지원장학생 선발 안내</a></td>
									<td>2024-07-18
								</tr>
							
						</table>
					</div>
					<div class="main--page--calander">
						<h3>
							<a href="/schedule">학사일정</a><!-- 페이지이동 -->
						</h3>
						<div class="main--page--split"></div>
						<table>
							
								<tr>
									<td>01-27&nbsp;-&nbsp;02-01</td>
									<td>2023-1학기 예비수강신청</td>
								</tr>
							
								<tr>
									<td>02-13&nbsp;-&nbsp;02-17</td>
									<td>2023-1학기 수강신청</td>
								</tr>
							
								<tr>
									<td>02-17&nbsp;-&nbsp;02-23</td>
									<td>2023-1학기 등록</td>
								</tr>
							
								<tr>
									<td>02-22&nbsp;-&nbsp;02-22</td>
									<td>복학 접수 마감</td>
								</tr>
							
								<tr>
									<td>02-26&nbsp;-&nbsp;02-26</td>
									<td>졸업예배</td>
								</tr>
							
								<tr>
									<td>02-27&nbsp;-&nbsp;02-27</td>
									<td>학위수여식</td>
								</tr>
							
						</table>

					</div>
				</div>
			</div>
			<div>
				<!-- 사용자 간단한 프로필 -->
				<c:if test="${not empty principal}">
				<div class="main--page--profile">
					<ul class="d-flex align-items-start" style="margin: 0;">
						<li><span class="material-symbols-rounded" style="margin-top: 2px;">person</span>&nbsp;&nbsp;
						<li style="font-weight: 600; font-size: 18px;">${principal.name}님,&nbsp;환영합니다.
					</ul>
					<hr style="width: 100%;">
						
							
							
							
								<table>
									<tr>
										<td>이메일</td>
										<td>${principal.email}</td>
									</tr>
									<tr>
										<td>소속</td>
										<!-- TODO 수정 -->
										<td>교직원</td>
									</tr>
								</table>
								<div class="profile--button--div">
									<a href="/info/professor"><button>마이페이지</button></a><!-- 페이지이동 -->
									<a href="/logout"><button>로그아웃</button></a>
								</div>
							
						
				</div>
				</c:if>
				<br>
				
					
					
				
			</div>
		</div>
	</div>
</div>

  		<footer>
			COPYRIGHT(C) 2023 <a href="https://github.com/BHbae/green_university.git">GREAN UNIVERSITY</a>. ALL RIGHTS RESERVED.
		</footer>

</div>

</body>
</html>