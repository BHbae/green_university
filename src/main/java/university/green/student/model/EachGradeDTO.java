package university.green.student.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EachGradeDTO {
	int studentId; // 학생 ID
	int subYear; // 연도
	int semester; // 학기
	int subjectId; // 강의 ID
	String name; // 강의명
	String type; // 강의 구분
	int grades; // 이수 학점
	String grade; // 성적
}
