package university.green.student.repository.interfaces;

import university.green.student.model.StuSchDTO;

public interface StuSchRepository {
	
	// 학생 id로 sch 알아오기
	StuSchDTO getStuSchById(int id,int semester);
	

}
