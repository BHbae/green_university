package university.green.professor.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
				pstmt.setString(1, professorDTO.getName());
				pstmt.setDate(2,professorDTO.getBirthDate());
				pstmt.setString(3, professorDTO.getGender());
				pstmt.setString(4,professorDTO.getAddress());
				pstmt.setString(5,professorDTO.getTel());
				pstmt.setString(6, professorDTO.getEmail());
				pstmt.setInt(7, professorDTO.getDeptId());
				pstmt.setDate(8, professorDTO.getHireDate());
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProfessorDTO> getProfessorByDeptNo(int deptId) {
		final String GET_PROFESSOR_BY_ID=" select * from professor_tb where dept_id =? ";
		List<ProfessorDTO> professorList=new ArrayList<>();
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(GET_PROFESSOR_BY_ID)){
			pstmt.setInt(1, deptId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				professorList.add(ProfessorDTO.builder().id(rs.getInt("id")).name(rs.getString("name")).birthDate(rs.getDate("birth_date"))
						.gender(rs.getString("gender")).address(rs.getString("address")).tel(rs.getString("tel"))
						.email(rs.getString("email")).deptId(rs.getInt("dept_id")).hireDate(rs.getDate("hire_date")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professorList;
	}

	@Override
	public ProfessorDTO getProfessorById(int id) {
		final String GET_PROFESSOR_BY_ID=" select * from professor_tb where id =? ";
		ProfessorDTO professor=new ProfessorDTO();
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(GET_PROFESSOR_BY_ID)){
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				professor=ProfessorDTO.builder().id(rs.getInt("id")).name(rs.getString("name")).birthDate(rs.getDate("birth_date"))
						.gender(rs.getString("gender")).address(rs.getString("address")).tel(rs.getString("tel"))
						.email(rs.getString("email")).deptId(rs.getInt("dept_id")).hireDate(rs.getDate("hire_date")).build();
				System.out.println("professor 확인 : "+professor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professor;
	}

	@Override
	public List<ProfessorDTO> getAllProfessor() {
		List<ProfessorDTO> professorList=new ArrayList<>();
		final String SELECT_ALL_PROFESSOR=" SELECT * FROM professor_tb ORDER BY id limit ? offset ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_ALL_PROFESSOR)){
			pstmt.setInt(1,20);
			pstmt.setInt(2, 5);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				ProfessorDTO professor=ProfessorDTO.builder().id(rs.getInt("id")).name(rs.getString("name")).birthDate(rs.getDate("Birth_date"))
						.gender(rs.getString("gender")).address(rs.getString("address")).tel(rs.getString("tel"))
						.email(rs.getString("email")).deptId(rs.getInt("dept_id")).hireDate(rs.getDate("hire_date")).build();
				professorList.add(professor);
				System.out.println(professor);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return professorList;
	}

	@Override
	public void updateProfessor(ProfessorDTO professorDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProfessor(int id, int principalId) {
		// TODO Auto-generated method stub
		
	}
// 깃 안들어가서 확인용
}
