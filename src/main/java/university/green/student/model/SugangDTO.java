package university.green.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 수강신청 -> 강의 시간표 조회   == 사실상 수업 -> 전체강의 조회랑 같은 기능 

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SugangDTO {
	private String college; //단과 대학
	private String department; // 개설학과
	private int departNum;	// 학수번호 
	private String subjectName;	// 강의명
	private String professorNmae;	// 담당교수 
	private int grades;	// 이수학점
	
	private String subjectDay; // 요일 시간
	private int subjectStart; // 강의 시작시간
	private int subjectEnd; // 강의 종료 시간
	private String room; // 강의실
	
	private int capacity; // 정원
	private int currentStudent;// 현재인원
	
	
}
