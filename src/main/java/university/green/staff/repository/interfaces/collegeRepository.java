package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.staff.model.CollegeDTO;

public interface collegeRepository {
	
	// 단과 CRUD
	// 전체 조회
	List<CollegeDTO> listCollege();
	
	// 삭제
	int deleteCollege(int collegeId);
	
	// 등록
	int addCollege(String name);
	
	
	
}
