package university.green.student.repository.interfaces;

import java.util.List;

import university.green.student.model.EachGradeDTO;

public interface GradeRepository {
	// 모든 성적 들고오기
	List<EachGradeDTO> getAllEachGrade(int id);
	// 학기별로 성적 조회하기
	List<EachGradeDTO> getEachGradeBySemester(int id, int semester);
}
