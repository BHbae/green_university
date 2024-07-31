package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.staff.model.CollegeDTO;
import university.green.staff.model.DepartmentDTO;

public interface DepartmentRepository {
	
	// 학과 CRUD
	// 전체 리스트
	
	List<DepartmentDTO> departmentList();
	
	// 카테고리
	List<CollegeDTO> CategoryList();
	
	// 등록
	 int addDepartment(DepartmentDTO dto);
	
	// 수정
	int updateDepartment(DepartmentDTO dto);
	
	// 삭제
	int deleteDepartment(int id);
	
	// 리스트 처리
	int getCounte();
	
}
