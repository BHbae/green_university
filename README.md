## < JSP와 JSTL을 활용한 학사정보관리 웹사이트 >
# < 🏫그린 대학교: 학사정보관리 사이트 >
&nbsp; 
&nbsp;
&nbsp;
### 목차
1. 프로젝트 개요
2. 구성원 및 맡은 역할
3. 서비스 환경
4. 사용 라이브러리 및 프로토콜
5. 시퀀스 다이어그램
6. 주요 기능
7. ERD 다이어그램
&nbsp; 
## 1️⃣ 프로젝트 개요
* JSP,JSTL을 사용한 학사정보관리 웹사이트 제작
* 프로젝트 수행을 통한 협업 및 일정 관리 툴 사용법 학습
&nbsp; 
## 2️⃣ 구성원 및 맡은 역할
|이름|역할|맡은 역할|
|------|---|---|
|배병호🐸|팀장| -리더 및 프로젝트 총괄
-DB 설계 및 샘플 데이터 제작
-(학생) 휴학 신청 및 휴학 신청 내역 조회 기능 제작
-(교수) 학기별 강의 및 강의 평가 조회 기능
-(교수) 강의 계획서 수정
-(교수) 강의별 학생 리스트 조회, 출결, 성적 기입 기능  |
|김민경|팀원|  |
|김성후|팀원|  |
|엄송현|팀원|  |
|최이제|팀원|  |
## 3️⃣ 서비스 환경 및 사용 라이브러리
### (1) 서비스 환경
|유형|구분|서비스 배포 환경|
|------|---|---|
|SW|OS| Windows10 |
||Tool| Spring Tool Suite |
||BackEnd| Java 17 7 MySQL 8.0.26 |
||Version/Issue 관리| GitHub & GitBash |
||Communication| Discord & Notion|
### (2) 사용 라이브러리
|라이브러리명|버전명|용도|
|------|---|---|
|HikariCP|HikariCP 5.1.0| Connection Pool을 통한 효율적인 DB 연결 관리 |
|jakarta.servlet.jsp.jstl|jakarta.servlet.jsp.jstl
3.0.0| - |
|jakarta.servlet.jsp.jstl|jakarta.servlet.jsp.jstl
3.0.0| - |
|Lombok|Lombok| 간편한 생성자 및 메서드 사용 |
|MySQL Connector Java|MySQL Connector Java 8.0.21| MySQL 테이블, DAO&DTO, 검색 기능 및 페이징 기능 구현 |
|SLF4J|SLF4J API 2.0.0| 다양한 로깅 프레임워크에 대한 추상화 및 연결 |
|SLF4J|SLF4J simple 2.0.0| SLF4J 인터페이스를 로깅 구현체와 연결 |

## 4️⃣ 사이트맵
### (1) 공통 기능
![Sitemap Example (5)](https://github.com/user-attachments/assets/ee100bab-b1d3-42dd-aea2-fd6dffe1291c)

### (2) 학생 기능
![Sitemap Example](https://github.com/user-attachments/assets/25a5cc2a-b4d2-4d7f-ba09-0bd06e2d6f76)

### (3) 교직원 기능
![Sitemap Example (1)](https://github.com/user-attachments/assets/c54f478e-654a-4b04-bea0-0075a486a850)

### (4) 교수 기능
![Sitemap Example (2)](https://github.com/user-attachments/assets/67040582-2b99-43c6-97f3-2a09708628be)


## 5️⃣ 시퀀스 다이어그램
### (1) 로그인 시퀀스 (직함별로 다른 사이트를 보여주기)
![제목 없는 다이어그램 drawio](https://github.com/user-attachments/assets/64de70dc-b27e-437e-bd74-b1c1ab00955f)
### (2) 예비 수강 신청 시퀀스
### (3) 예비 수강 신청 -> 수강 신청 시퀀스
## 6️⃣
## 7️⃣
## 8️⃣

