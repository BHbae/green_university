package university.green.student.repository.interfaces;

import java.util.List;

import university.green.student.model.PreSugangListDTO;
import university.green.student.model.SugangDTO;
import university.green.student.model.SugangSubDTO;

public interface SugangRepository {
	// 페이지 총 갯수
	int getTotalBoardCount();
	
    //////////////////////////////////////////////
	// 강의 시간표 조회
	List<SugangDTO> listBoard(int limit, int offset);
	// 강의 시간표 검색
	List<SugangDTO> searchBoard(String majorType, String department, String subjectName, int limit, int offset);
	
	//////////////////////////////////////////////
	// 예비 수강 
	List<SugangDTO> preApply(int limit, int offset);
	// 예비 수강 시간표 검색
	List<SugangDTO> preSearchBoard(String majorType, String department, String subjectName, int limit, int offset);
	
	// 예비수강 등록
	int AddPreSugang (int studentId, int subjectId);
	
	// 예비수강 취소
	void SubtractPreSugang (int studentId, int subjectId);
	
	// 예비 확인  
	List<PreSugangListDTO> CheckPreSugang (); 
	
	
	
	// 예비수강 신청 현재정원 +
	void StudentPlus(int id);
	
	// 예비수강 신청 현재정원 -
	void StudentMinus(int id);
	
	// 수강 신청 요구 확인
	
	// 학생 ID 기준 예비수강 조회 
	List<PreSugangListDTO> CheckById(int studentId);
	
	
	////////////////////////////////////////////////
	// 수강신청
	List<SugangDTO> SugangApply(int limit, int offset);
	
	///////////////////////////////////////////////
	// 수강신청 내역 조회
	List<SugangDTO> ApplyInfo(int limit, int offset);
	
	
}
