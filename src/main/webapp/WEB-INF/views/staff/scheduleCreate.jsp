<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정등록 등록 페이지</title>
<style>
.room--table {
	text-align: center;
	margin-top: 20px;
	margin: 10px;
}
.room--table td {
	padding: 10px;
	width: 300px;
}
.first--tr {
	font-weight: bold;
}
.mouth{
  background-color: #f5f5f5;
}
.line{
}
.container{
margin-top: 100px;
}

.table{
width: 800px;
}

.first--tr {
	background-color: #f7f6f6;
	font-weight: bolder;
	overflow: hidden;
	text-overflow: ellipsis;
}

.button {
	padding: 5px;
	border: 1px solid #031734;
	border-radius: 3px;
	background-color: #031734;
	color: #ccc;
	text-decoration: none;
	margin-left: 770px;
}
</style>
</head>
<body>
<div class="d-flex justify-content-center align-items-start"
	style="min-width: 100em;">
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>학사정보</h2>
		</div>
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/notice">공지사항</a></td>
				</tr>
				<tr>
					<td><a href="/schedule" >학사일정</a></td>				
				</tr>
				
					<tr>
						<td><a href="/schedule/list" class="selected--menu"> 학사일정 등록</a></td>
					</tr>
				
			</table>
		</div>
	</div>

	<main>
	<h1>학사일정</h1>
	
	
	<div class="container">
	<table class="table">	
	<thead>
	<tr class="first--tr">
	<th>ID</th>
	<th>날짜</th>
	<th>내용</th>
	</tr>
	</thead>
	<tbody>
	
	<tr onclick="location.href='/schedule/detail?id=1';">
	<td>1</td>
	 <td>01-27~02-01</td>
	 <td>2023-1학기 예비수강신청</td>
	</tr>
	
	<tr onclick="location.href='/schedule/detail?id=2';">
	<td>2</td>
	 <td>02-13~02-17</td>
	 <td>2023-1학기 수강신청</td>
	</tr>
	
	<tr onclick="location.href='/schedule/detail?id=3';">
	<td>3</td>
	 <td>02-17~02-23</td>
	 <td>2023-1학기 등록</td>
	</tr>
	
	<tr onclick="location.href='/schedule/detail?id=4';">
	<td>4</td>
	 <td>02-22~02-22</td>
	 <td>복학 접수 마감</td>
	</tr>
	
	<tr onclick="location.href='/schedule/detail?id=5';">
	<td>5</td>
	 <td>02-26~02-26</td>
	 <td>졸업예배</td>
	</tr>
	

	

	
	</tbody>
	</table>
	</div>
	<a href="${pageContext.request.contextPath}/notice.jsp"  class="button">목록</a> 
	<a href="/schedule/list?crud=insert" class="button">등록</a>
	
    
    </main>
	

  		<footer>
			<!-- 필요 시 -->
		</footer>

</div>
</body>
</html>