<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>총 누계 성적</title>
</head>
<body>
	<h1>총 누계 성적</h1>
	
	<c:when test="${not empty totalList}">
	<h3>평점 평균</h3>
		<table border="1">
			<tr>
				<th>연도</th>
				<th>학기</th>
				<th>신청학점</th>
				<th>취득학점</th>
				<th>평점평균</th>
			</tr>
			<c:forEach var="StudentDTO" items="${totalList}">
				<tr>
					<td><c:out value="${studentDTO.id}"/></td>
					<td><c:out value="${studentDTO.name}"/></td>
					<td><c:out value="${studentDTO.birth_date}"/></td>
					<td><c:out value="${studentDTO.gender}"/></td>
					<td><c:out value="${studentDTO.address}"/></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
</body>
</html>