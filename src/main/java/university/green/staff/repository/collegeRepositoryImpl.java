package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.staff.model.CollegeDTO;
import university.green.staff.repository.interfaces.collegeRepository;
import university.green.util.DBUtil;

// 등록 - 단과대학
public class collegeRepositoryImpl implements collegeRepository {

	private static final String SELECT_ALL_COLLEGE = " select * from college_tb ";
	private static final String INSERT_ADD_COLLEGE = " INSERT INTO college_tb(name) VALUES ( ? ) ";
	private static final String DELETE_COLLEGE = " DELETE from college_tb WHERE id = ? ";

	@Override
	public List<CollegeDTO> listCollege() {
		List<CollegeDTO> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_COLLEGE)){
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CollegeDTO dto = new CollegeDTO();
				dto = CollegeDTO.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.build();
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteCollege(int collegeId) {
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_COLLEGE)){
				pstmt.setInt(1, collegeId);
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
	public int addCollege(String name) {
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_ADD_COLLEGE)){
				pstmt.setString(1, name);
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

	
	
	
	

}
