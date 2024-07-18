package university.green.student.repository;

import java.util.List;

import university.green.student.model.TuitionDTO;

public interface TuitionRepository {
	
	// 전체 조회, 삭제는 혹시 몰라 만들었습니다.
	
	// 등록금 - 추가
	void addTuition(TuitionDTO tuitionDTO);
	// 등록금 - 수정
	void updateTuition(TuitionDTO tuitionDTO);
	// 등록금 - 삭제
	void deleteTuition(int id);
	// 등록금 - 전체 조회
	List<TuitionDTO> getAllTuition(TuitionDTO tuitionDTO);
	// 등록금 - 학생 ID로 조회
	TuitionDTO getTuitionById(TuitionDTO tuitionDTO);
}
