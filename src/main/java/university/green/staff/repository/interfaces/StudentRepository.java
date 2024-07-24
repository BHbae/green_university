package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.student.model.StudentDTO;

public interface StudentRepository {

	// 학생 추가
	void addStudent(StudentDTO studentDTO);
	// 학생 - 학과 번호로 조회
	List<StudentDTO> getStudentByDeptId(int deptId);
	// 학생 - ID로 조회
	StudentDTO getStudentById(int id);
	// 학생 - ID와 학과 번호로 조회
	StudentDTO getStudentByDeptidAndId(int deptId, int id);
	// 학생 - 전체 학생 조회
	List<StudentDTO> getAllStudent();
	// 학생 - 정보 수정
	void updateStudent(StudentDTO studentDTO);
	// 학생 - 정보 삭제
	void deleteStudent(int id, int principalId);
}
