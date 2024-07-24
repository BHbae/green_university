package university.green;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.Builder;
import university.green.professor.model.ProfessorDTO;
import university.green.staff.model.StaffDTO;
import university.green.student.model.StudentDTO;
import university.green.util.DBUtil;

public class UserRepositoryImpl implements UserRepository{

	private static final String SELECT_USER =" select * from user_tb WHERE id = ? AND password = ? ";
	private static final String SELECT_STUDENT = " select * from student_tb WHERE id = ? ";
	private static final String SELECT_PROFESSOR = " select * from professor_tb WHERE id = ? ";
	private static final String SELECT_STAFF = " select * from staff_tb WHERE id = ? ";
	
	
	@Override
	public LoginDto userId(int id, String password) {
		LoginDto dto = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_USER)){
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = LoginDto.builder()
						.id(rs.getInt("id"))
						.password(rs.getString("password"))
						.user_role(rs.getString("user_role"))
						.build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public StudentDTO studentDtail(int id) {
		StudentDTO dto = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDENT)){
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = StudentDTO.builder()
							.id(rs.getInt("id"))
							.name(rs.getString("name"))
							.birthDate(rs.getDate("birth_date"))
							.gender(rs.getString("gender"))
							.address(rs.getString("address"))
							.tel(rs.getString("tel"))
							.email(rs.getString("email"))
							.deptId(rs.getInt("dept_id"))
							.grade(rs.getInt("grade"))
							.semester(rs.getInt("semester"))
							.entranceDate(rs.getDate("entrance_date"))
							.graduationDate(rs.getDate("graduation_date"))
							.build();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public ProfessorDTO professorDtail(int id) {
		ProfessorDTO dto = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_PROFESSOR)){
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = ProfessorDTO.builder()
							.id(rs.getInt("id"))
							.name(rs.getString("name"))
							.birthDate(rs.getDate("birth_date"))
							.gender(rs.getString("gender"))
							.address(rs.getString("address"))
							.tel(rs.getString("tel"))
							.email(rs.getString("email"))
							.deptId(rs.getInt("dept_id"))
							.hireDate(rs.getDate("hire_date"))
							.build();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public StaffDTO staffDtail(int id) {
		StaffDTO dto = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_STAFF)){
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = StaffDTO.builder()
							.id(rs.getInt("id"))
							.name(rs.getString("name"))
							.birth_date(rs.getDate("birth_date"))
							.gender(rs.getString("gender"))
							.address(rs.getString("address"))
							.tel(rs.getString("tel"))
							.email(rs.getString("email"))
							.build();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
