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
	
	// 아이디 찾기
	String findIdDtail(String name, String email, String userRole);
	
	// 아이디 찾기 complete
	FindIdDtoCom FindIdCom(String name, int id);
	
	// 비밀번호 찾기
	String findPasswordDtail(String name, int id , String email, String userRole);
}
