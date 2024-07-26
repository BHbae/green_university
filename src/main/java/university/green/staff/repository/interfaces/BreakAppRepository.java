package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.student.model.BreakAppDTO;

public interface BreakAppRepository {
	// 휴학 - 휴학 신청 추가하기
	void addBreakApp(BreakAppDTO breakAppDTO);
	// 휴학 - 휴학 신청 수정하기
	void updateBreakApp(BreakAppDTO breakAppDTO);
	// 휴학 - 휴학 신청/상태 처리하기
	void updateBreakAppStatus(String status,int principalId);
	// 휴학 - 휴학 신청 삭제하기
	void deleteBreakApp(int id, int principalId);
	// 휴학 - 모든 휴학 신청 가져오기
	List<BreakAppDTO> getAllBreakApp();
}
