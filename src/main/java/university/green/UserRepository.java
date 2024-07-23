package university.green;

import university.green.professor.model.ProfessorDTO;
import university.green.staff.model.StaffDTO;
import university.green.student.model.StudentDTO;

public interface UserRepository {
	
	// 로그인 확인
	LoginDto userId(int id, String password);
	
	// 상세정보
	// 학생 
	StudentDTO studentDtail(int id);
	
	// 교수
	ProfessorDTO professorDtail(int id);
	
	// 교직원
	StaffDTO staffDtail(int id);
	
	
}
