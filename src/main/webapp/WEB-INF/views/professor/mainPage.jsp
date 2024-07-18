<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그린대학교 학사관리시스템</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
</style>
</head>
<body>
	<header class="d-flex flex-column">
		<div class="header--top">
			<ul>
				<li class="material--li"><span class="material-symbols-outlined">account_circle</span>
				<li>김근호님 (23000001)
				<li style="margin: 0 15px;">ㅣ
				<li class="material--li"><span style="color: #9BD2EC;" class="material-symbols-outlined">logout</span>
				<li><a href="/logout">로그아웃</a>
			</ul>
		</div>

		<nav class="main--menu">
			<a href="/"><img class="logo" alt="" src="/images/logo.png"></a>
			<!-- userRole에 따라 메뉴 다르게 표시 -->
			
				

				
					<ul>
						<li><a href="/">홈</a>
						<li><a href="/info/professor">MY</a>
						<li><a href="/subject/list/1">수업</a>
						<li><a href="/notice">학사정보</a>
					</ul>
				

				
			

		</nav>
	</header>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="/css/mainPage.css">

<script>
	
</script>

</head>
<body onLoad="javascript:pop()">

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">

	<div>
		<img alt="" src="/images/main_photo.jpg" class="main--page--img">
		<div class="d-flex justify-content-center align-items-start">
			<div class="main--page--div">
				<div class="d-flex">
					<!-- 공지사항 -->
					<div class="main--page--notice">
						<h3>
							<a href="/notice">공지사항</a>
						</h3>
						<div class="main--page--split"></div>
						<table>
							
								<tr>
									<td><a href="/notice/read?id=6">[장학]&nbsp;2023학년도 교외장학재단 신규장학생 선발 결과 안내</a></td>
									<td>2024-07-18
								</tr>
							
								<tr>
									<td><a href="/notice/read?id=5">[일반]&nbsp;2023학년도 1학기 코로나 19 특별휴학 시행 안내</a></td>
									<td>2024-07-18
								</tr>
							
								<tr>
									<td><a href="/notice/read?id=4">[일반]&nbsp;2023학년도 장애 인식개선 교육(법정의무교육) 안내</a></td>
									<td>2024-07-18
								</tr>
							
								<tr>
									<td><a href="/notice/read?id=3">[일반]&nbsp;Gartner Research(IT 분야 시장분석) 서비스 지원 안내</a></td>
									<td>2024-07-18
								</tr>
							
								<tr>
									<td><a href="/notice/read?id=2">[장학]&nbsp;2023학년도 보건장학회 연구지원장학생 선발 안내</a></td>
									<td>2024-07-18
								</tr>
							
						</table>
					</div>
					<div class="main--page--calander">
						<h3>
							<a href="/schedule">학사일정</a>
						</h3>
						<div class="main--page--split"></div>
						<table>
							
								<tr>
									<td>01-27&nbsp;-&nbsp;02-01</td>
									<td>2023-1학기 예비수강신청</td>
								</tr>
							
								<tr>
									<td>02-13&nbsp;-&nbsp;02-17</td>
									<td>2023-1학기 수강신청</td>
								</tr>
							
								<tr>
									<td>02-17&nbsp;-&nbsp;02-23</td>
									<td>2023-1학기 등록</td>
								</tr>
							
								<tr>
									<td>02-22&nbsp;-&nbsp;02-22</td>
									<td>복학 접수 마감</td>
								</tr>
							
								<tr>
									<td>02-26&nbsp;-&nbsp;02-26</td>
									<td>졸업예배</td>
								</tr>
							
								<tr>
									<td>02-27&nbsp;-&nbsp;02-27</td>
									<td>학위수여식</td>
								</tr>
							
						</table>

					</div>
				</div>
			</div>
			<div>
				<!-- 사용자 간단한 프로필 -->
				<div class="main--page--profile">
					<ul class="d-flex align-items-start" style="margin: 0;">
						<li><span class="material-symbols-rounded" style="margin-top: 2px;">person</span>&nbsp;&nbsp;
						<li style="font-weight: 600; font-size: 18px;">김근호님,&nbsp;환영합니다.
					</ul>
					<hr style="width: 100%;">
						
							
							
							
								<table>
									<tr>
										<td>이메일</td>
										<td>tenco@green.com</td>
									</tr>
									<tr>
										<td>소속</td>
										<td>컴퓨터공학과 교수</td>
									</tr>
								</table>
								<div class="profile--button--div">
									<a href="/info/professor"><button>마이페이지</button></a>
									<a href="/logout"><button>로그아웃</button></a>
								</div>
							
						
				</div>
				<br>
				
					
					
				
			</div>
		</div>
	</div>
</div>

  		<footer>
			COPYRIGHT(C) 2023 <a href="https://github.com/seoyounglee0105/university_management_project">GREAN UNIVERSITY</a>. ALL RIGHTS RESERVED.
		</footer>

</div>

</body>
</html>