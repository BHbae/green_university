package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.staff.model.SubjectDTO;

// 등록 - 강의
public interface SubjectRepository {
	
	// 전체 리스트
	List<SubjectDTO> subjectList();
	
	// 등록
	int addSubject(SubjectDTO dto);
	
	// 수정
	int updateSubject(SubjectDTO dto);
	
	// 삭제
	int deleteSubject(int id);
	

}
