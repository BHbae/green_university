package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.staff.model.CollTuitionDTO;
import university.green.staff.model.CollTuitionListDTO;
import university.green.staff.model.CollegeDTO;

public interface CollTuitionRepository {
	
	// 등록 - 단대별 등록금
	
	// 전체 리스트
	List<CollTuitionListDTO> colltuitionList();
	
	// SELECT_COLLEGE
	List<CollegeDTO> selectCollege(); 
	
	// 등록
	int addColltuition(CollTuitionDTO dto);
	
	// 수정
	int updateColltuition(CollTuitionDTO dto);
	
	// 삭제
	int deleteColltuition(int collegeId);
	
}
