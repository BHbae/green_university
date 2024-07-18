package university.green.student.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 휴학 신청 DTO

@Data
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BreakAppDTO {
	private int id; // 휴학 ID
	private int student_id; // 학생 ID
	private int student_grade; // 학년
	private int from_year; // 시작 년도
	private int from_semester; // 시작 학기
	private int to_year; // 종료 년도
	private int to_semester; // 종료 학기
	private String type; // 신청 이유(일반휴학, 가사휴학...)
	private Date app_date; // 휴학일
	private String status; // 처리상태 (신청 확인)
}
