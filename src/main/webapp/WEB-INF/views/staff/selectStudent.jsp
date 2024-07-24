<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 교직원 - 학생 명단 조회 페이지 -->
<title>학생 명단 조회</title>
<style>
	
.sub--list--table th {
	padding: 3px 9px;
	text-align: center;
}

.sub--list--table td {
	padding: 1px 9px;
	text-align: center;
}

.sub--list--name {
	text-align: left !important;
	padding-right: 20px !important;
}

.sub--filter {
	margin-bottom: 50px;
}

.sub--filter form {
	display: flex;
}

.sub--filter form div {
	background-color: buttonshadow;
	padding: 13px 13px 7px 10px;
}

.sub--filter input[type="number"] {
	width: 57px;
	padding-left: 3px;
}

.sub--filter select[name="deptId"] {
	width: 173px;
}

.sub--filter label {
	margin-right: 5px;
}

.sub--filter input, .sub--filter select {
	margin-right: 10px;
	border-radius: 5px;
	border-width: 1px;
}

.sub--filter button {
	background-color: gray;
	padding: 2px 6px;
	border: none;
	border-radius: 5px;
	color: white;
	height: 28px;
}

.sub--plan--view li a:hover {
	color: black;
}
.paging--container {
	display: flex;
	justify-content: center;
}
	
</style>
</head>
<body>
<
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
	<c:choose>
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
					<td>${StudentDTO.id}</td>
					<td>${StudentDTO.name}</td>
					<td>${StudentDTO.birthDate}</td>
					<td>${StudentDTO.gender}</td>
					<td>${StudentDTO.address}</td>
					<td>${StudentDTO.tel}</td>
					<td>${StudentDTO.email}</td>
					<td>${StudentDTO.deptId}</td>
					<td>${StudentDTO.grade}</td>
					<td>${StudentDTO.semester}</td>
					<td>${StudentDTO.entranceDate}</td>
					<td>${StudentDTO.graduationDate}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	</c:choose>
	
	
</body>
</html>