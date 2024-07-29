package university.green.student.repository.interfaces;

import java.util.List;

import university.green.student.model.BreakAppDTO;
import university.green.student.model.CoDeDTO;

public interface leaveRepository {
	
	// 자신의 학과, 단과 찾기
	CoDeDTO searchCoDe(int studentid);
	
	// 휴학신청
	int breakApp(BreakAppDTO dto);
	
	// 휴학신청 리스트
	List<BreakAppDTO> breakAppList(int studentid);
	
	// 상세조회
	BreakAppDTO detailBreakApp(int breakappId);
	
	// 휴학 취소
	int deleteBreakApp(int breakappId, int studentid);
	
}
