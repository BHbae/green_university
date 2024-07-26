package university.green.student.model;

import java.sql.Date;

public class EachGradeDTO {
	Date subYear; // 연도
	int semester; // 학기
	int subjectId; // 강의 ID
	String name; // 강의명
	String type; // 강의 구분
	int grades; // 이수 학점
	String grade; // 성적
}
