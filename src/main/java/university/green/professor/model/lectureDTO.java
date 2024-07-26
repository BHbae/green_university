package university.green.professor.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class lectureDTO {
	
	private int id; // 학수번호
	private String college; // 단과
	private String department; // 학과
	private int departNum; // 학수번호
	private String majorType; // 전공 or 교양
	private String subjectName; // 강의 이름
	private String professorName; // 강사
	private int grades; // 학점
	private String subjectDay; // 요일
	private int subjectStart; // 강의시작시간
	private int subjectEnd; // 강의종료시간
	private String room; // 강의실
	private int currentStudent; // 신청인원
	private int capacity; // 정원

	
	
	
	
	
}
