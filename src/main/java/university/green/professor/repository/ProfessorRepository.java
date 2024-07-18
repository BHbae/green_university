package university.green.professor.repository;

<<<<<<< HEAD
import university.green.LoginDto;

public interface ProfessorRepository {
	int userId(LoginDto professorId);

=======
import java.util.List;

import university.green.staff.model.StaffDTO.ProfessorDTO;

public interface ProfessorRepository {
	// 교수 추가
	void addProfessor(ProfessorDTO professorDTO);
	// 교수 - 학과 번호로 조회
	List<ProfessorDTO> getProfessorByDeptNo(int deptId);
	// 교수 - 사번으로 조회
	ProfessorDTO getProfessorById(int id);
	// 교수 - 전체 교수 조회
	List<ProfessorDTO> getAllProfessor();
	// 교수 - 정보 수정
	void updateProfessor(ProfessorDTO professorDTO);
	// 교수 - 정보 삭제
	void deleteProfessor(int id,int principalId);
>>>>>>> b0e7350265a04c19bedf044ab27f2db7e1711e15
}
