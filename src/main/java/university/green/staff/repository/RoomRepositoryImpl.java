package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.staff.model.RoomDTO;
import university.green.staff.repository.interfaces.RoomRepositroy;
import university.green.util.DBUtil;

public class RoomRepositoryImpl implements RoomRepositroy {
	
	// sql
	private static final String SELECT_ALL_ROOM = " select * from room_tb " ; 
	private static final String INSERT_ADD_ROOM = " insert into room_tb (id, college_id) values (?, ?) " ; 
	private static final String DELETE_ROOM = " delete from room_tb where id = ?  " ; 
	

	@Override
	public List<RoomDTO> roomList() {
		List<RoomDTO> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ROOM)){
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RoomDTO dto = new RoomDTO().builder()
										   .id(rs.getString("id"))
										   .collegeId(rs.getInt("college_id"))
										   .build();
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int addRoom(RoomDTO dto) {
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_ADD_ROOM)){
				pstmt.setString(1, dto.getId());
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
	public int deleteRoom(String id) {
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_ROOM)){
				pstmt.setString(1, id);
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
