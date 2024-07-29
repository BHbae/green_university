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
	
	String findSelectBeforeJoin = " SELECT a.id FROM user_tb AS u JOIN ";
	String findSelectAfterJoin = " AS a ON u.id = a.id WHERE a.name = ? AND a.email = ? ";
	
	String findPwsSelectBeforeJoin = " SELECT u.password FROM user_tb AS u JOIN ";
	String findPwsSelectAfterJoin = " AS a ON u.id = a.id WHERE a.name = ? AND a.email = ? ";
	
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

	@Override
	public String findIdDtail(String name, String email, String userRole) {
		String id = null;
		String query = null;
		String table = null;
		
		if(userRole.equalsIgnoreCase("student")) {
			table = " student_tb ";
			query = findSelectBeforeJoin + table + findSelectAfterJoin;
		} else if(userRole.equalsIgnoreCase("staff")) {
			table = " staff_tb ";
			query = findSelectBeforeJoin + table + findSelectAfterJoin;
		} else if(userRole.equalsIgnoreCase("professor")) {
			table = " professor_tb ";
			query = findSelectBeforeJoin + table + findSelectAfterJoin;
		}
		
		System.out.println(query);
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("a.id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public FindIdDtoCom FindIdCom(String name, int id) {
		FindIdDtoCom dto = null;
		
		return null;
	}

	@Override
	public String findPasswordDtail(String name, int id, String email, String userRole) {
		String password = null;
		String query = null;
		String table = null;
		
		if(userRole.equalsIgnoreCase("student")) {
			table = " student_tb ";
			query = findPwsSelectBeforeJoin + table + findPwsSelectAfterJoin;
		} else if(userRole.equalsIgnoreCase("staff")) {
			table = " staff_tb ";
			query = findPwsSelectBeforeJoin + table + findPwsSelectAfterJoin;
		} else if(userRole.equalsIgnoreCase("professor")) {
			table = " professor_tb ";
			query = findPwsSelectBeforeJoin + table + findPwsSelectAfterJoin;
		}
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				password = rs.getString("password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(query);
		System.out.println(password);
		return password;
	}


}
