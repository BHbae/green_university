package university.green.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//학생-과목별 성적 DTO

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StuSubDTO {
	private int id; // 학생-과목별 성적 ID
	private int student_id; // 학생 ID
	private int subject_id; // 과목 ID
	private int grade; // 성적
	private int complete_grade; // 
}
