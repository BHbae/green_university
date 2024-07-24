<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기별 학기 성적 조회</title>
</head>
<body>
	<h1>학기별 학기별성적 조회</h1>
	<form action="choose-semester">
		<select name="year" id="year">
			<option>
		</select>
		<select name="semester" id="semester">
			<option>
		</select>
		<select name="semester" id="semester">
			<option>
		</select>
		<button></button>
	</form>
	<c:choose>
		<c:when test="${not empty user}">
		<h2>과목별 성적</h2>
			<table border='1'>
				<tr>
					<th>연도</th>
					<th>학기</th>
					<th>과목번호</th>
					<th>과목명</th>
					<th>강의구분</th>
					<th>학점</th>
				</tr>
				<c:forEach var="grade" items="${gradeList}">
				<tr>
					<td>${grade.year}</td>
					<td>${grade.semester}</td>
					<td>${grade.subId}</td>
					<td>${grade.type}</td>
					<td>$grade.score}</td>
				</tr>
				</c:forEach>
			</table>
		</c:when>
	</c:choose>
	
</body>
</html>