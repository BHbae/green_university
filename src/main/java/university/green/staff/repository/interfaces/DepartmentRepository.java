package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.staff.model.DepartmentDTO;

public interface DepartmentRepository {
	
	// 학과 CRUD
	// 전체 리스트
	List<DepartmentDTO> departmentList();
	
	// 등록
	DepartmentDTO addDepartment();
	
	// 수정
	int updateDepartment();
	
	// 삭제
	int deleteDepartment();
	
	// 리스트 처리
	int getCounte();
	
}
