<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 교직원 - 학생 명단 조회 페이지 -->
<title>교수 명단 조회</title>
</head>
<body>
	<h1>교수 명단 조회</h1>
	
	<!-- 검색창 -->
	<form class="searchProfessor" action="${pageContext.request.contextPath}/management/selectSpecificProfessor" method="POST">
		<label for="dept_id">학과 번호</label>
		<input type="text" id="deptId" name="deptId">
		<label for="proId">사번</label>
		<input type="text" id="proId" name="proId">
		<input type="button" value="조회하기">
	</form>
	<c:choose>
		<c:when test="${not empty professorList}">
	<h3>교수 목록</h3>
		<table border="1">
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>학과번호</th>
				<th>고용일</th> 
			</tr>
			<c:forEach var="ProfessorDTO" items="${professorList}">
				<tr>
					<td>${ProfessorDTO.id}</td>
					<td>${ProfessorDTO.name}</td>
					<td>${ProfessorDTO.birthDate}</td>
					<td>${ProfessorDTO.gender}</td>
					<td>${ProfessorDTO.address}</td>
					<td>${ProfessorDTO.tel}</td>
					<td>${ProfessorDTO.email}</td>
					<td>${ProfessorDTO.deptId}</td>
					<td>${ProfessorDTO.hireDate}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	</c:choose>
	
	
</body>
</html>