package university.green.student.repository;

import java.util.List;

import university.green.student.model.SugangDTO;

public interface SugangRepository {
	List<SugangDTO> listBoard(int limit, int offset);
	int getTotalBoardCount();
}
