package university.green.student.model;

// 수강신청 -> 강의 시간표 조회   == 사실상 수업 -> 전체강의 조회랑 같은 기능 
public class SugangDTO {
	private String college_name; //단과 대학
	private String department_name; // 개설학과
	private int student_id;	// 학수번호 
	private String subject_name;	// 강의명
	private String professor_name;	// 담당교수 
	private int grades;	// 이수학점
	
	private String sub_day; // 요일 시간
	private int start_time; // 강의 시작시간
	private int end_time; // 강의 종료 시간
	private String room; // 강의실
	
	private int capacity; // 정원
	private int num_of_student;// 현재인원
	private String notice_file; // 강의 계획서
	
	
}
