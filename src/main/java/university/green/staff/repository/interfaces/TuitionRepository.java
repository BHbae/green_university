package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.student.model.TuitionDTO;

public interface TuitionRepository {
	
	// 등록금 - DB 추가
	void addDbTuition(TuitionDTO tuition);
	// 등록금 - DTO추가
	TuitionDTO addTuition(int StudentId);
	// 등록금 - 수정
	void updateTuition(TuitionDTO tuitionDTO);
	// 등록금 - 삭제
	void deleteTuition(int id);
	// 등록금 - 전체 조회
	List<TuitionDTO> getAllTuition();
	// 등록금 - 학생 ID,연도,학기로 조회
	TuitionDTO getTuitionById(int id,int year, int semester);
	// 등록금 - 학생 ID로 조회
	TuitionDTO getTuitionById(int id);
}
