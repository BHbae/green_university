package university.green.student.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.student.model.BreakAppDTO;
import university.green.student.model.CoDeDTO;
import university.green.student.repository.interfaces.leaveRepository;
import university.green.util.DBUtil;

public class leaveRepositoryImpl implements leaveRepository {
	
	private static final String CODE_SELECT = " select de.id as deptid , de.name as deptname, co.id as collegeid, co.name as collegename from student_tb as st join department_tb as de on st.dept_id = de.id join college_tb as co on de.college_id = co.id where st.id = ? ";
	private static final String INSERT_LEAVE = " INSERT INTO break_app_tb(student_id,student_grade, from_year,from_semester,to_year,to_semester, type) VALUES(?, ?, ?, ?, ?, ?, ?); ";
	private static final String SELECT_MY_LEAVE = " SELECT * FROM break_app_tb WHERE student_id = ? ";
	private static final String DETAIL_LEAVE = " SELECT * FROM break_app_tb WHERE id = ? ";
	
	@Override
	public CoDeDTO searchCoDe(int studentid) {
		CoDeDTO dto = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(CODE_SELECT)){
			pstmt.setInt(1, studentid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = CoDeDTO.builder()
						.collegeid(rs.getInt("collegeid"))
						.collegename(rs.getString("collegename"))
						.deptid(rs.getInt("deptid"))
						.deptname(rs.getString("deptname"))
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int breakApp(BreakAppDTO dto) {
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_LEAVE)){
				pstmt.setInt(1, dto.getStudentId());
				pstmt.setInt(2, dto.getStudentGrade());
				pstmt.setInt(3, dto.getFromYear());
				pstmt.setInt(4, dto.getFromSemester());
				pstmt.setInt(5, dto.getToYear());
				pstmt.setInt(6, dto.getToSemester());
				pstmt.setString(7, dto.getType());
				
				rowCount = pstmt.executeUpdate();
				
				conn.commit();
				
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public List<BreakAppDTO> breakAppList(int studentid) {
		List<BreakAppDTO> list = new ArrayList<>(); 
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_MY_LEAVE)){
			pstmt.setInt(1, studentid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BreakAppDTO appDTO = new BreakAppDTO();
				appDTO = BreakAppDTO.builder()
						.id(rs.getInt("id"))
						.studentId(rs.getInt("student_id"))
						.studentGrade(rs.getInt("student_grade"))
						.fromYear(rs.getInt("from_year"))
						.fromSemester(rs.getInt("from_semester"))
						.toYear(rs.getInt("to_year"))
						.toSemester(rs.getInt("to_semester"))
						.type(rs.getString("type"))
						.appDate(rs.getDate("app_date"))
						.status(rs.getString("status"))
						.build();
				list.add(appDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BreakAppDTO detailBreakApp(int breakappId) {
		BreakAppDTO dto = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(DETAIL_LEAVE)){
			pstmt.setInt(1, breakappId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = BreakAppDTO.builder()
						.id(rs.getInt("id"))
						.studentId(rs.getInt("student_id"))
						.studentGrade(rs.getInt("student_grade"))
						.fromYear(rs.getInt("from_year"))
						.fromSemester(rs.getInt("from_semester"))
						.toYear(rs.getInt("to_year"))
						.toSemester(rs.getInt("to_semester"))
						.type(rs.getString("type"))
						.appDate(rs.getDate("app_date"))
						.status(rs.getString("status"))
						.build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int deleteBreakApp(int breakappId, int studentid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
