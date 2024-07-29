package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.staff.model.StuStatDTO;

public interface StuStatRepository {
	
	// 재학 중인 모든 학생 가져오기
	List<Integer> getAllStudentForBill();
	// 재학 중인 모든 학생 스테이터스 가져오기
	List<String> getAllStudentStatus();

}
