<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 교직원 - 학생 명단 조회 페이지 -->
<title>학생 명단 조회</title>
</head>
<body>
	<h1>학생 명단 조회</h1>
	
	<!--/green/management/selectStudent-->
	<!-- 검색창 -->
	<form action="" method="GET">
		<label for="dept_id">학과 번호</label>
		<input type="text" id="dept_id" name="dept_id" value="">
		<label for="stu_id">학번</label>
		<input type="text" id="stu_id" name="stu_id" value="">
		<input type="button" value="조회하기">
	</form>
	<c:when test="${not empty studentList}">
	<h3>학생 목록</h3>
		<table border="1">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>학과번호</th>
				<th>학년</th>
				<th>입학일</th>
				<th>졸업일(졸업예정일)</th>
			</tr>
			<c:forEach var="StudentDTO" items="${studentList}">
				<tr>
					<td><c:out value="${studentDTO.id}"/></td>
					<td><c:out value="${studentDTO.name}"/></td>
					<td><c:out value="${studentDTO.birth_date}"/></td>
					<td><c:out value="${studentDTO.gender}"/></td>
					<td><c:out value="${studentDTO.address}"/></td>
					<td><c:out value="${studentDTO.tel}"/></td>
					<td><c:out value="${studentDTO.email}"/></td>
					<td><c:out value="${studentDTO.dept_id}"/></td>
					<td><c:out value="${studentDTO.grade}"/></td>
					<td><c:out value="${studentDTO.semester}"/></td>
					<td><c:out value="${studentDTO.entrance_date}"/></td>
					<td><c:out value="${studentDTO.graduation_date}"/></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	
	
</body>
</html>