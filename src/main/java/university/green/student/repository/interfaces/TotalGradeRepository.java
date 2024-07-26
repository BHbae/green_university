package university.green.student.repository.interfaces;

import java.util.List;

import university.green.student.model.TotalGradeDTO;

public interface TotalGradeRepository {
	List<TotalGradeDTO> getAllTotalGrade();
	
	List<TotalGradeDTO> getTotalGradeBySemester();
}
