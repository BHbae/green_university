<%@page import="university.green.student.model.StudentDTO"%>
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
						<li><a href="/">수업</a>
						<li><a href="${pageContext.request.contextPath}/sugang/listBoards">수강신청</a>
						<li><a href="/">성적</a>
						<li><a href="/">학사 정보</a>
					</ul>
		</nav>
	</header>
<!--  -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainPage.css">
</head>
<body>

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
    <!-- 세부 메뉴 div-->
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>수강신청</h2>
        </div>
        <!-- 메뉴 -->
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/sugang/listBoards">강의 시간표 조회</a></td>
                </tr>
                <tr>
                    <td><a href="/sugang/preApply">예비 수강 신청</a></td>
                </tr>
                <tr>
                    <td><a href="/sugang/SugangApply">수강 신청</a></td>
                </tr>
                <tr>
                    <td><a href="/sugang/ApplyInfo">수강 신청 내역 조회</a></td>
                </tr>
            </table>
        </div>
    </div>

    <!-- 메인 div -->
    <main>
        <h1>수강 신청</h1>
        <div class="split--div"></div>

        <div class="d-flex justify-content-between align-items-start" style="margin-bottom: 50px;">
            <!-- 필터 및 검색 -->
            <div class="sub--filter">
                <form action="${pageContext.request.contextPath}/sugang/search" method="get">
                    <div>
                        <label for="majorType">강의구분</label> 
                        <select name="majorType" id="majorType">
                            <option value="">전체</option>
                            <option value="전공">전공</option>
                            <option value="교양">교양</option>
                        </select>
                        
                        <label for="department">개설학과</label> 
                        <select name="department" id="department">
                            <option value="">전체</option>
                            <option value="컴퓨터공학과">컴퓨터공학과</option>
                            <option value="신소재공학과">신소재공학과</option>
                        </select>
                        
                        <label for="subjectName">강의명</label> 
                        <input type="text" name="subjectName" id="subjectName">
                        	
                            
               
                        
                        <button type="submit">
                            <ul class="d-flex justify-content-center" style="margin: 0;">
                                <li style="height: 24px; margin-right: 2px;">조회</li>
                                <li style="height: 24px;">
                                    <span class="material-symbols-outlined" style="font-size: 18px; padding-top: 4px;">search</span>
                                </li>
                            </ul>
                        </button>
                    </div>
                </form>
            </div>

            <!-- 예비 수강 신청 내역으로 가기 -->
            <a href="/sugang/ApplyInfo"><button class="preStuSubList--button">수강 신청 내역</button></a>
        </div>
        
        <c:choose>
            <c:when test="${not empty boardList}">
                <h4>
                    <span style="font-weight: 600;">강의 목록</span>&nbsp; 
                    <span style="color: gray; font-size: 18px;">[총 ${totalBoards}건]</span>
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
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="subject" items="${boardList}">
                            <tr>
                                <td>${subject.college}</td>
                                <td>${subject.department}</td>
                                <td>${subject.departNum}</td>
                                <td>${subject.majorType}</td>
                                <td class="sub--list--name">${subject.subjectName}</td>
                                <td>${subject.professorName}</td>
                                <td>${subject.grades}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${subject.subjectStart < 10}">
                                            ${subject.subjectDay} 0${subject.subjectStart}:00-${subject.subjectEnd}:00&nbsp;(${subject.room})
                                        </c:when>
                                        <c:otherwise>
                                            ${subject.subjectDay} ${subject.subjectStart}:00-${subject.subjectEnd}:00&nbsp;(${subject.room})
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${subject.currentStudent}</td>
                                <td>${subject.capacity}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${totalPages != null}">
                    <ul class="page--list">
                        <c:forEach var="i" begin="1" end="${totalPages}" step="1">
                            <li>
                                <a href="${pageContext.request.contextPath}/sugang/listBoards?page=${i}" class="${i == currentPage ? 'active' : ''}">${i}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
            </c:when>
            <c:otherwise>
                <p>강의 목록이 없습니다.</p>
            </c:otherwise>
        </c:choose>
    </main>
</div>
</body>

