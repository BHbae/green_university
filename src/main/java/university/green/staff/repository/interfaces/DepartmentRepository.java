package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.staff.model.DepartmentDTO;

public interface DepartmentRepository {
	
	// 학과 CRUD
	// 전체 리스트
	
	List<DepartmentDTO> departmentList();
	
	// 등록
	 void addDepartment(DepartmentDTO dto);
	
	// 수정
	int updateDepartment(DepartmentDTO dto);
	
	// 삭제
	int deleteDepartment(int id);
	
	// 리스트 처리
	int getCounte();
	
}
