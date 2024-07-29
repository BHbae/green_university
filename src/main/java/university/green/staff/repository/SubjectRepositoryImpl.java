package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.staff.model.SubjectDTO;
import university.green.staff.repository.interfaces.SubjectRepository;
import university.green.util.DBUtil;

public class SubjectRepositoryImpl implements SubjectRepository{
	
	// sql
	private static final String SELECT_ALL_SUBJECT = " select * from subject_tb " ;
	private static final String INSERT_ADD_SUBJECT = " INSERT INTO subject_tb (name, professor_id, room_id, dept_id, type, sub_year, semester, sub_day, start_time, end_time, grades, capacity) "
													 + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " ;
	private static final String DELETE_SUBJECT = " delete from subject_tb where id = ? " ;
	private static final String UPDATE_SUBJECT = "  update subject_tb set name= ? , room_id= ? , sub_day= ? , "
												+  "  start_time= ? , end_time= ? , capacity= ? where id= ? " ;
	
	
	

	@Override
	public List<SubjectDTO> subjectList() {
		List<SubjectDTO> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SUBJECT);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SubjectDTO dto = new SubjectDTO();
				dto = SubjectDTO.builder()
								.id(rs.getInt("id"))
								.name(rs.getString("name"))
								.professorId(rs.getInt("professor_id"))
								.roomId(rs.getString("room_id"))
								.deptId(rs.getInt("dept_id"))
								.type(rs.getString("type"))
								.subYear(rs.getInt("sub_year"))
								.semester(rs.getInt("semester"))
								.subDay(rs.getString("sub_day"))
								.startTime(rs.getInt("start_time"))
								.endTime(rs.getInt("end_time"))
								.grades(rs.getInt("grades"))
								.capacity(rs.getInt("capacity"))
								.numOfStudent(rs.getInt("num_of_student"))
								.build();
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void addSubject(SubjectDTO dto) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_ADD_SUBJECT)){
				pstmt.setString(1, dto.getName());
				pstmt.setInt(2, dto.getProfessorId());
				pstmt.setString(3, dto.getRoomId());
				pstmt.setInt(4, dto.getDeptId());
				pstmt.setString(5, dto.getType());
				pstmt.setInt(6, dto.getSubYear());
				pstmt.setInt(7, dto.getSemester());
				pstmt.setString(8, dto.getSubDay());
				pstmt.setInt(9, dto.getStartTime());
				pstmt.setInt(10, dto.getEndTime());
				pstmt.setInt(11, dto.getGrades());
				pstmt.setInt(12, dto.getCapacity());
				rowCount = pstmt.executeUpdate();
				
				
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int updateSubject(SubjectDTO dto) {
		// TODO Auto-generated method stub
	
		return 0;
	}

	@Override
	public int deleteSubject(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
