package university.green.professor.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import university.green.professor.model.ProfessorDTO;
import university.green.professor.repositoryinterfaces.ProfessorRepository;
import university.green.util.DBUtil;

public class ProfessorRepositoryimpl implements ProfessorRepository{

	@Override
	public void addProfessor(ProfessorDTO professorDTO) {
		final String ADD_PROFESSOR=" INSERT INTO professor_tb (name, birth_date,gender,address,tel,email,dept_id,hire_date) "
				+ "values ( ?, ?, ?, ?, ?, ?, ?, ? )";
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(ADD_PROFESSOR)){
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<ProfessorDTO> getProfessorByDeptNo(int deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfessorDTO getProfessorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfessorDTO> getAllProfessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProfessor(ProfessorDTO professorDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProfessor(int id, int principalId) {
		// TODO Auto-generated method stub
		
	}

}
