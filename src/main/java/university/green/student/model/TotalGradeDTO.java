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
public class TotalGradeDTO {
	int year; // 수강 연도
	int semester; // 수강 학기
	int registerdGrade; // 신청 학점
	double getGrade; // 취득 학점
	double averageGrade; // 평점 평균

}
