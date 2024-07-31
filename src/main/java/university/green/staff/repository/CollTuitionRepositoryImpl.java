package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.staff.model.CollTuitionDTO;
import university.green.staff.model.CollTuitionListDTO;
import university.green.staff.model.CollegeDTO;
import university.green.staff.repository.interfaces.CollTuitionRepository;
import university.green.util.DBUtil;

public class CollTuitionRepositoryImpl implements CollTuitionRepository{
	
	// sql
	private static final String SELECT_ALL_COLLTUITION = " select c.id, c.name, t.amount  from college_tb as c join coll_tuit_tb as t on c.id = t.college_id group by c.id order by c.id asc " ;
	private static final String INSERT_ADD_COLLTUITION = " insert into coll_tuit_tb (college_id, amount) values (? , ?) " ;
	private static final String DELETE_COLLTUITION = " delete from coll_tuit_tb where college_id = ? " ;
	private static final String UPDATE_COLLTUITION = " update coll_tuit_tb set  amount = ? where college_id =? " ;
	
	private static final String SELECT_COLLEGE =" select * from college_tb ";
	
	public List<CollegeDTO> selectCollege() {
		List<CollegeDTO> dto = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_COLLEGE)){
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CollegeDTO collegeDTO = CollegeDTO.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.build();
				dto.add(collegeDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	
	@Override
	public List<CollTuitionListDTO> colltuitionList() {
		List<CollTuitionListDTO> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_COLLTUITION);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CollTuitionListDTO dto = new CollTuitionListDTO();
				dto = CollTuitionListDTO.builder()
									.id(rs.getInt("id"))
									.name(rs.getString("name"))
									.amount(rs.getInt("amount"))
									.build();
				list.add(dto);
									
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
   
	@Override
	public int addColltuition(CollTuitionDTO dto) {
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_ADD_COLLTUITION)){
				pstmt.setInt(1, dto.getCollegeId());
				pstmt.setInt(2, dto.getAmount());
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
	public int updateColltuition(CollTuitionDTO dto) {
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_COLLTUITION)){
				pstmt.setInt(1, dto.getAmount());
				pstmt.setInt(2, dto.getCollegeId());
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
	public int deleteColltuition(int collegeId) {
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_COLLTUITION)){
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

}
