package university.green.professor.repositoryinterfaces;

import java.util.List;

import university.green.professor.model.lectureDTO;
import university.green.professor.model.subjectDTO;

public interface lectureList {
	
	// 강의 전체조회 -o 
	List<lectureDTO> lectureAllList(int page, int offset);
	
	// 검색조회 - x
	void lectureSelectList();
	
	// 본인 강의 조회 - o
	List<subjectDTO> myLecture(int professorId);
	
	// 본인 강의 평가 
	void myLectureScore();
	
}
