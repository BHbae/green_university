<%@ page import="university.green.student.model.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그린대학교 학사관리시스템</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<style>
table {
	border-collapse: collapse;
}
</style>
</head>
<body>

	<header class="d-flex flex-column">
		<div class="header--top">
			<ul>
				<li class="material--li"><span class="material-symbols-outlined"> <i class="material-icons">account_circle</i>
				</span> <c:if test="${not empty principal}">
					${principal.name}님 (${principal.id})님
				</c:if></li>
				<li style="margin: 0 15px;"></li>
				<li class="material--li"><span style="color: #9BD2EC;" class="material-symbols-outlined"> <i class="material-icons">logout</i>
				</span></li>
				<li><a href="${pageContext.request.contextPath}/Login.jsp">로그아웃</a></li>
			</ul>
		</div>
		<nav class="main--menu">
			<a href="/"><img class="logo" alt="" src="${pageContext.request.contextPath}/resources/ima/logo.png"></a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/mainStudent.jsp">홈</a>
				<li><a href="${pageContext.request.contextPath}/mystudent/my">MY</a>
				<li><a href="/">수업</a>
				<li><a href="${pageContext.request.contextPath}/sugang/listBoards">수강신청</a>
				<li><a href="${pageContext.request.contextPath}/studentGrade/gradeOfThisSemester">성적</a>
				<li><a href="/">학사 정보</a>
			</ul>
		</nav>
	</header>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainPage.css">

	<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
		<div class="sub--menu">
			<div class="sub--menu--top">
				<h2>수강신청</h2>
			</div>
			<div class="sub--menu--mid">
				<table class="sub--menu--table" border="1">
					<tr>
						<td><a href="${pageContext.request.contextPath}/sugang/listBoards">강의 시간표 조회</a></td>
					</tr>
					<tr>
						<td><a class="selected--menu" href="${pageContext.request.contextPath}/sugang/preApply">예비 수강 신청</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/sugang/SugangApply">수강 신청</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/sugang/ApplyInfo">수강 신청 내역 조회</a></td>
					</tr>
				</table>
			</div>
		</div>

		<main>
			<h1>예비 수강 신청</h1>
			<div class="split--div"></div>
			<div class="d-flex justify-content-between align-items-start" style="margin-bottom: 50px;">
				<div class="sub--filter">
					<form action="${pageContext.request.contextPath}/sugang/preSearch" method="get">
						<div>
							<label for="majorType">강의구분</label> <select name="majorType" id="majorType">
								<option value="">전체</option>
								<option value="전공">전공</option>
								<option value="교양">교양</option>
							</select> <label for="department">개설학과</label> <select name="department" id="department">
								<option value="">전체</option>
								<option value="컴퓨터공학과">컴퓨터공학과</option>

								<option value="전자공학과">전자공학과</option>

								<option value="화학공학과">화학공학과</option>

								<option value="기계공학과">기계공학과</option>

								<option value="신소재공학과">신소재공학과</option>

								<option value="철학과">철학과</option>

								<option value="국사학과">국사학과</option>

								<option value="언어학과">언어학과</option>

								<option value="국어국문학과">국어국문학과</option>

								<option value="영어영문학과">영어영문학과</option>

								<option value="심리학과">심리학과</option>

								<option value="정치외교학과">정치외교학과</option>

								<option value="사회복지학과">사회복지학과</option>

								<option value="언론정보학과">언론정보학과</option>

								<option value="인류학과">인류학과</option>

								<option value="경영학과">경영학과</option>

								<option value="경제학과">경제학과</option>

								<option value="회계학과">회계학과</option>

								<option value="농업경영학과">농업경영학과</option>

								<option value="무역학과">무역학과</option>


							</select> <label for="subjectName">강의명</label> <input type="text" name="subjectName" list="subjectName">
							<datalist id="subjectName">
								<option value="데이터통신">
								<option value="딥러닝의 기초">
								<option value="컴퓨터의 개념 및 실습">
								<option value="컴퓨터 프로그래밍">
								<option value="공학설계 입문">
								<option value="반도체 공학">
								<option value="융합전자연구">
								<option value="기초 전기실험">
								<option value="물리화학">
								<option value="반응공학">
								<option value="사고와 표현">
								<option value="과학과 기술">
								<option value="고체역학">
								<option value="자유정의진리">
								<option value="정보적 사고">
								<option value="CAD기초">
								<option value="에너지재료">
								<option value="나노재료합성">
								<option value="신소재공학개론">
								<option value="신소재기초실습">
								<option value="칸트철학">
								<option value="불교철학사">
								<option value="대륙합리론">
								<option value="심리철학">
								<option value="역사학개론">
								<option value="동아시아사">
								<option value="한국근대사">
								<option value="한국사입문">
								<option value="의미론">
								<option value="형태론">
								<option value="컴퓨터언어학">
								<option value="이태리어">
								<option value="고전문학연습">
								<option value="국어정서법">
								<option value="한국현대작가론">
								<option value="국문학개론">
								<option value="중세영문학">
								<option value="영어발달사">
								<option value="현대영국소설론">
								<option value="영문학입문">
								<option value="일반심리학">
								<option value="적응심리학">
								<option value="성격심리학">
								<option value="인지심리학">
								<option value="비교정치론">
								<option value="외교정책론">
								<option value="국제정치경제론">
								<option value="한국정치론">
								<option value="현대사회심리">
								<option value="인간행동과 사회환경">
								<option value="사회복지학개론">
								<option value="사회복지행정론">
								<option value="언론정보학개론">
								<option value="방송의이해">
								<option value="광고의이해">
								<option value="한국언론사">
								<option value="문화인류학">
								<option value="세계화와 다문화주의">
								<option value="의료인류학">
								<option value="도시와문화">
								<option value="기업경영의이해">
								<option value="경영학원론">
								<option value="마케팅의 이해">
								<option value="마케팅 조사론">
								<option value="경제학원론">
								<option value="미시경제학">
								<option value="거시경제학">
								<option value="신자유주의 경제학">
								<option value="재무회계">
								<option value="회계감사">
								<option value="원가회계">
								<option value="관리회계">
								<option value="농업생산경제학">
								<option value="농산물 가격분석">
								<option value="농산물 유통학">
								<option value="농업 정책론">
								<option value="무역상무론">
								<option value="국제경영학">
								<option value="국제무역론 입문">
								<option value="한국무역법">
							</datalist>

							<button type="submit">
								<ul class="d-flex justify-content-center" style="margin: 0;">
									<li style="height: 24px; margin-right: 2px;">조회</li>
									<li style="height: 24px;"><span class="material-symbols-outlined" style="font-size: 18px; padding-top: 4px;"></span></li>
								</ul>
							</button>
						</div>
					</form>
				</div>

				<a href="${pageContext.request.contextPath}/sugang/ApplyInfo"><button class="preStuSubList--button">예비 수강 신청 내역</button></a>
			</div>

			<c:choose>
				<c:when test="${not empty preBoardList}">
					<h4>
						<span style="font-weight: 600;">강의 목록</span>&nbsp; <span style="color: gray; font-size: 18px;">[총 ${totalBoards}건]</span>
					</h4>
					<table border="1" class="sub--list--table">
						<thead>
							<tr>
								<th>단과대학</th>
								<th>개설학과</th>
								<th>학수번호</th>
								<th>강의구분</th>
								<th style="width: 200px;">강의명</th>
								<th>담당교수</th>
								<th>학점</th>
								<th>요일시간 (강의실)</th>
								<th>현재인원</th>
								<th>정원</th>
								<th>신청</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="subject" items="${preBoardList}">
								<tr>
									<td>${subject.college}</td>
									<td>${subject.department}</td>
									<td>${subject.departNum}</td>
									<td>${subject.majorType}</td>
									<td class="sub--list--name">${subject.subjectName}</td>
									<td>${subject.professorName}</td>
									<td>${subject.grades}</td>
									<td><c:choose>
											<c:when test="${subject.subjectStart < 10}">
											${subject.subjectDay} 0${subject.subjectStart}:00-${subject.subjectEnd}:00&nbsp;(${subject.room})
										</c:when>
											<c:otherwise>
											${subject.subjectDay} ${subject.subjectStart}:00-${subject.subjectEnd}:00&nbsp;(${subject.room})
										</c:otherwise>
										</c:choose></td>
									<td>${subject.currentStudent}</td>
									<td>${subject.capacity}</td>
									<td class="sub--list--button--row"><c:choose>
											<c:when test="${subject.currentStudent >= subject.capacity}">
												<button type="button" style="background-color: white; color: gray" disabled>신청마감</button>
											</c:when>
											<c:otherwise>
					<c:set var="isEnrolled" value="false"/>
					<c:forEach var="preSugang" items="${PreSugangList}">
						<c:if test="${subject.departNum == preSugang.subjectId && preSugang.studentId eq principal.id}">
							<c:set var="isEnrolled" value="true"/>
						</c:if>
					</c:forEach>
					<c:choose>
						<c:when test="${isEnrolled}">
							<form action="${pageContext.request.contextPath}/sugang/StudentMinus" method="post">
								<input type="hidden" name="id" value="${subject.id}"> 
								<input type="hidden" name="stuId" value="${principal.id}"> 
								<input type="hidden" name="action" value="StudentMinus">
								<button type="submit" style="background-color: #FF5733;">취소</button>
							</form>
						</c:when>
						<c:otherwise>
							<form action="${pageContext.request.contextPath}/sugang/StudentPlus" method="post">
								<input type="hidden" name="id" value="${subject.id}"> 
								<input type="hidden" name="action" value="StudentPlus">
								<button type="submit" style="background-color: #548AC2;">신청</button>
							</form>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
										</c:choose></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<c:if test="${totalPages != null}">
						<ul class="page--list">
							<c:forEach var="i" begin="1" end="${totalPages}" step="1">
								<li><a href="${pageContext.request.contextPath}/sugang/preApply?page=${i}" class="${i == currentPage ? 'active' : ''}">${i}</a></li>
							</c:forEach>
						</ul>
					</c:if>
				</c:when>
				<c:otherwise>
					<p>검색된 강의가 없습니다.</p>
				</c:otherwise>
			</c:choose>
		</main>
	</div>
</body>
</html>
