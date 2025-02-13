<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기 페이지</title>
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
					<td><a href="/notice" class="selected--menu">공지사항</a></td>
				</tr>
				<tr>
					<td><a href="/schedule">학사일정</a></td>				
				</tr>
				
					<tr>
						<td><a href="/schedule/list"> 학사일정 등록</a></td>
					</tr>
				
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>공지사항</h1>
		<div class="split--div"></div>


		<!-- 공지 검색 -->
		


		<!-- 공지 조회 -->
		



		<!-- 공지 상세 조회 -->
		
	<c:choose>
	<c:when test="${not empty noticelist}">
	<table class="table" >
		<tr class="first--tr">
				<th>제목</th>
				<th>내용</th>
	
		</tr>
	<tbody>
	<c:forEach var="notice" items="${noticelist}"  >
	<tr>
			<td>${notice.title}</td>
			<td>${notice.category}</td>

	</tr>
	</c:forEach>
	</tbody>
	</c:when>
  <c:otherwise>
  <p>등록된 내용이 없습니다.</p>
  </c:otherwise>
  </c:choose>
		
		
		
			<div class="container">
				<table class="table">
					<tr class="title">
						<td class="type">제목</td>
						<td>[장학] 2023학년도 교외장학재단 신규장학생 선발 결과 안내</td>
					</tr>
					<tr class="content--container">
						<td class="type">내용</td><br>
						<td> ※ 장학금 공지에 올라온 학교지원 교외장학재단만 해당<br>
							 ※ 각 심사 단계마다 합격자에 한하여 문자 발송<br>
							 ※ 심사 단계 : 접수 중 -> 서류심사 중 -> 면접심사 중 -> 최종선발<br>
							 ※ 완료된 심사 단계만 업데이트 됨<br>
 					<br>
 							○ 2023학년도 1학기<br>
  							 - 관정이종환교육재단 : 접수중 - 서류심사중 - 면접심사중 - 최종선발 <br>
  							 - KC미래장학재단 : 접수중 - 서류심사중 - 최종선발<br>
 							 - 운경재단 : 접수중 - 서류심사중 - 최종선발 <br>
  							 - 송원김영환장학재단 : 접수중 - 서류심사중 - 최종선발 <br>
  			 			   	 - KT랜선야학 : 접수중 - 서류심사중  - 최종선발 <br>
   							 - 운해장학재단 : 접수중 - 서류심사중 - 최종선발 <br>
  							 - 성옥문화재단 : 접수중 - 서류심사중 - 최종선발 <br>
 							 - 보담장학회 : 접수중 - 서류심사중 - 최종선발 <br>
   							 - 김희경유럽정신문화장학재단 : 접수중 - 서류심사중 - 최종선발 <br>
   							 - 양천장학회 : 접수중 - 서류심사중 - 면접심사중  - 최종선발<br><br><br><img alt="" src="/images/uploads/null" width="600" height="800" onerror="this.style.display='none'"></td>
					</tr>
				</table>

				<div class="select--button">
				
						<a href="${pageContext.request.contextPath}/notice.jsp"  class="button">목록</a> 
					<input type="submit" class="button" value="수정">
					<input type="submit" class="button btn-edit" value="삭제">
					
				</div>
			</div>
		


		<!-- 공지 수정 -->
		


		<!-- 공지 등록 -->
		
	</main>

	

  		<footer>
			<!-- 필요 시 -->
		</footer>

</div>

</body>
</html>