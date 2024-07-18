# < 🏫그린 대학교: JSP와 JSTL을 활용한 학사정보관리 웹사이트 >
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
&nbsp; 
## 2️⃣ 구성원 및 맡은 역할
|이름|역할|맡은 역할|
|------|---|---|
|배병호🐸|팀장|  |
|김민경|팀원|  |
|김성후|팀원|  |
|엄송현|팀원|  |
|최이제|팀원|  |
## 3️⃣ 서비스 환경
|유형|구분|서비스 배포 환경|
|------|---|---|
|SW|OS| Windows10 |
||Tool| Spring Tool Suite |
||BackEnd| Java 17 7 MySQL 8.0.26 |
||Version/Issue 관리| GitHub & GitBash |
||Communication| Discord & Notion|
## 4️⃣ 사용 라이브러리 및 프로토콜
### (1) 사용 라이브러리
|라이브러리명|버전명|용도|
|------|---|---|
|HikariCP|HikariCP 5.1.0| Connection Pool을 통한 효율적인 DB 연결 관리 |
|jakarta.servlet.jsp.jstl|jakarta.servlet.jsp.jstl
3.0.0| Connection Pool을 통한 효율적인 DB 연결 관리 |
|jakarta.servlet.jsp.jstl|jakarta.servlet.jsp.jstl
3.0.0| Connection Pool을 통한 효율적인 DB 연결 관리 |
|Lombok|Lombok| 간편한 생성자 및 메서드 사용 |
|MySQL Connector Java|MySQL Connector Java 8.0.21| MySQL 테이블, DAO&DTO, 검색 기능 및 페이징 기능 구현 |
|SLF4J|SLF4J API 2.0.0| 다양한 로깅 프레임워크에 대한 추상화 및 연결 |
|SLF4J|SLF4J simple 2.0.0| SLF4J 인터페이스를 로깅 구현체와 연결 |
### (2) 사용 프로토콜
|기능명|프로토콜명|용도|
|------|---|---|
|회원가입|/sendDB/| User 데이터 생성 및 카드 랜덤 5개 증정 |
||/login/| User 데이터 조회 후 success/wrong 출력 |
|경매|/bid/| 상품 현재 가격 변경 (최고가) |
||/cash/| 충전 후 User 보유 포인트 동기화|
||BackEnd| 경매에 상품 판매 |
## 5️⃣ 시퀀스 다이어그램
