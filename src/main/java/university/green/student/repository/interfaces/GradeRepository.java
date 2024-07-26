package university.green.student.repository.interfaces;

import java.util.List;

import university.green.student.model.EachGradeDTO;
import university.green.student.model.TotalGradeDTO;

public interface GradeRepository {
	// 모든 성적 들고오기
	List<EachGradeDTO> getAllEachGrade(int id);
	// 학기별로 성적 조회하기
	List<EachGradeDTO> getEachGradeBySemester(int id, int year,int semester);
	// 학기별 누계 성적 조회 (단일)
	TotalGradeDTO getTotalGrade(int id,int year, int semester);
	// 학기별 누계 성적 조회 (리스트)
	List<TotalGradeDTO> getAllTotalGrade(int id,int year, int semester);
}
