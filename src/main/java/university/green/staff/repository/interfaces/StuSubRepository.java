package university.green.staff.repository.interfaces;

import java.util.List;

import university.green.student.model.StuSubDTO;

public interface StuSubRepository {
	// 학생별 성적 - 추가
	void addStuSubRepository(StuSubDTO stuSubDto);
	// 학생별 성적 - 조회 (ID)
	StuSubDTO getStuSubByID(int studentId);
	// 학생별 성적 - 조회 (Student Id)
	List<StuSubDTO> getStuSubByStuId(int stuId);
	// 학생별 성적 - 조회 (All)
	List<StuSubDTO> getAllStuSub();
	// 학생별 성적 - 수정
	void updateStuSub(StuSubDTO stuSubDto);
	// 학생별 성적 - 삭제
	void deleteStuSub(int id);
}
