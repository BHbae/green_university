package university.green.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SugangSubDTO {
	// 수강 신청용 subject 
	private int id; // 학수번호
	private String name; // 강의 이름
	private int professor; // 굥수 이름
	private String roomId; // 강의실
	private int deptId; // 
	private String type; // 전공 or 비전공
	private int subYear; // 강의 년도
	private int semester; // 수업 학기	
	private String subDay; // 강의요일
	private int startTime; // 강의 시작시간
	private int endTime; // 강의 종료 시간
	private int greades; // 학점
	private int capacity; // 정원
	private int numOfStudent; // 신청 인원
	
}
