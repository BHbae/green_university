<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학사 일정</title>
<link rel="stylesheet" href="#">
<style type="text/css">

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
.month{
  background-color: #f5f5f5;
  border-bottom: 1px solid #666;
}
.line{
  border-bottom: 1px solid #666;	
}
.container{
margin-top: 100px;
}

</style>
</head>
<body>
<main>
	<h1>학사일정</h1>
	<div class="container">
	<div></div>
		
	<table class="room--table">
	<tbody>
	
	<tr>
	<td class="month" width="100px;" rowspan="12">월</td>
	 <td class="line">01-27~02-01</td>
	 <td class="line">2023-1학기 예비수강신청</td>
	</tr>
	
	<tr>
	
	 <td class="line">02-13~02-17</td>
	 <td class="line">2023-1학기 수강신청</td>
	</tr>
	
	<tr>
	
	 <td class="line">02-17~02-23</td>
	 <td class="line">2023-1학기 등록</td>
	</tr>
	
	<tr>
	
	 <td class="line">02-22~02-22</td>
	 <td class="line">복학 접수 마감</td>
	</tr>
	
	<tr>
	
	 <td class="line">02-26~02-26</td>
	 <td class="line">졸업예배</td>
	</tr>
	
	<tr>
	
	 <td class="line">02-27~02-27</td>
	 <td class="line">학위수여식</td>
	</tr>
	
	<tr>
	
	 <td class="line">03-01~03-01</td>
	 <td class="line">삼일절</td>
	</tr>
	
	<tr>
	
	 <td class="line">03-02~03-02</td>
	 <td class="line">개강/교무위원회</td>
	</tr>
	
	<tr>
	
	 <td class="line">03-06~03-08</td>
	 <td class="line">수강신청 확인 및 변경</td>
	</tr>
	
	<tr>
	
	 <td class="line">03-10~03-13</td>
	 <td class="line">2023-1학기 추가등록</td>
	</tr>
	
	<tr>
	
	 <td class="line">03-13~03-17</td>
	 <td class="line">조기졸업 신청</td>
	</tr>
	
	<tr>
	
	 <td class="line">03-15~03-15</td>
	 <td class="line">미등록자 일반 휴학 접수 마감/ 등록금 전액반환 마감</td>
	</tr>
	
	
	</tbody>
	</table>
	
	<a href="${pageContext.request.contextPath}/notice/allnotice"  class="button">목록</a> 
	</div>
	</main>

</body>
</html>