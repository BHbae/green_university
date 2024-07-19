<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 페이지</title>
</head>
<body>
	
		<h1>공지사항</h1>
		<div class="split--div"></div>


		<!-- 공지 검색 -->
		


		<!-- 공지 조회 -->
		
			<form action="/notice/search" method="get" class="form--container">
				<select class="input--box" name="type">
					<option value="title">제목</option>
					<option value="keyword">제목+내용</option>
				</select>
				<input type="text" name="keyword" class="input--box" placeholder="검색어를 입력하세요"> 
				<input type="submit" class="button" value="검색">
			</form>
			<table class="table">
				
					
						<tr class="first--tr">
							<td>번호</td>
							<td>말머리</td>
							<td>제목</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
						
							
						
							<tr class="second--tr" >
								<td>4</td>
								<td>[일반]</td>
								<td>2023학년도 장애 인식개선 교육(법정의무교육) 안내</td>
								<td>2024-07-18 14:14:25</td>
								<td>11</td>
							</tr>
						
							<tr class="second--tr" >
								<td>3</td>
								<td>[일반]</td>
								<td>Gartner Research(IT 분야 시장분석) 서비스 지원 안내</td>
								<td>2024-07-18 14:14:25</td>
								<td>3</td>
							</tr>
						
							<tr class="second--tr">
								<td>2</td>
								<td>[장학]</td>
								<td>2023학년도 보건장학회 연구지원장학생 선발 안내</td>
								<td>2024-07-18 14:14:25</td>
								<td>2</td>
							</tr>
						
							<tr class="second--tr">
								<td>1</td>
								<td>[학사]</td>
								<td>2023학년도 1학기 학생예비군 전입 신고 안내</td>
								<td>2024-07-18 14:14:25</td>
								<td>3</td>
							</tr>
						
					
					
				
			</table>
			<div class="paging--container">
			
				<a href="/notice/list/1"> 1</a> &nbsp;&nbsp;
			
				
					<a href="/notice?crud=write" class="button">등록</a>
				
			</div>
		



		<!-- 공지 상세 조회 -->
		


		<!-- 공지 수정 -->
		


		<!-- 공지 등록 -->
		


</body>
</html>