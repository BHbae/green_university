package university.green.professor.repository;

import university.green.LoginDto;

public interface ProfessorRepository {
	int userId(LoginDto professorId);

}
