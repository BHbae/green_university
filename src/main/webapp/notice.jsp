<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<style type="text/css">
h1{
border-bottom: 2px solid gray;
}
</style>
</head>
<body>
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>학사정보</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="${pageContext.request.contextPath}/notice.jsp" class="selected--menu" >공지사항</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/schedule_tb.jsp">학사일정</a></td>				
				</tr>
				
					<tr>
						<td><a href="${pageContext.request.contextPath}/scheduleCreate.jsp"> 학사일정 등록</a></td>
					</tr>
				
			</table>
		</div>
	</div>




	<h1>공지사항</h1>
	<div class="split--div"></div>


	<!-- 공지 검색 -->



	<!-- 공지 조회 -->



	<form action="/notice/search" method="get" class="form--container">
		<select class="input--box" name="type">
			<option value="title">제목</option>
			<option value="keyword">제목+내용</option>
		</select> <input type="text" name="keyword" class="input--box" placeholder="검색어를 입력하세요"> <input type="submit" class="button" value="검색">
	</form>
	<br>
	
	

	<c:choose>
	<c:when test="${not empty notice}">
	<table class="table" border="1">
		<tr class="first--tr">
				<th>번호</th>
				<th>말머리</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
		</tr>
	<tbody>
	<c:forEach var="notice" items="${noticelist}">
	<tr>
			<td>${notice.id}</td>
			<td>${notice.category}</td>
			<td>${notice.title}</td>
			<td>${notice.content}</td>
			<td>${notice.createdTime}</td>
			<td>${notice.views}</td>
	</tr>
	</c:forEach>
	</tbody>
	</c:when>
  <c:otherwise>
  <p>등록된 사용자가 없습니다.</p>
  </c:otherwise>
  </c:choose>
    
		<tr class="second--tr">
			<td>4</td>
			<td>[일반]</td>
			<td>2023학년도 장애 인식개선 교육(법정의무교육) 안내</td>
			<td>2024-07-18 14:14:25</td>
			<td>11</td>
		</tr>

		<tr class="second--tr">
			<td>3</td>
			<td>[일반]</td>
			<td>Gartner Research(IT 분야 시장분석) 서비스 지원 안내</td>
			<td>2024-07-18 14:14:25</td>
			<td>3</td>
		</tr>






	</table>
	<div class="paging--container">

		<a href="/notice/list/1"> 1</a> &nbsp;&nbsp; 
		<a href="${pageContext.request.contextPath}/noticeCreate.jsp" class="button">등록</a>

	</div>




	<!-- 공지 상세 조회 -->



	<!-- 공지 수정 -->



	<!-- 공지 등록 -->



</body>
</html>