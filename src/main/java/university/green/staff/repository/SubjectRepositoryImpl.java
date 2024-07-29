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
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public void addSubject(SubjectDTO dto) {
		// TODO Auto-generated method stub
		
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
