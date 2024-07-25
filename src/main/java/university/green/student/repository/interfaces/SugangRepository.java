package university.green.student.repository.interfaces;

import java.util.List;

import university.green.student.model.SugangDTO;

public interface SugangRepository {
	// 강의 시간표 조회
	List<SugangDTO> listBoard(int limit, int offset);
	
	// 강의 시간표 구분 조회
	List<SugangDTO> searchBoard(String majorType, String department, String subjectName, int limit, int offset);
	
	// 페이지 총 갯수
	int getTotalBoardCount();
	
	// 예비 수강 
	List<SugangDTO> preApply(int limit, int offset);
	
	// 예비수강 예역 조회
	
	
	// 수강신청
	List<SugangDTO> SugangApply(int limit, int offset);
	
	
	// 수강신청 내역 조회
	List<SugangDTO> ApplyInfo(int limit, int offset);
	
	
}
