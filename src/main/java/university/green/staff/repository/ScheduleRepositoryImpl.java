package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import university.green.staff.model.ScheduleDTO;
import university.green.util.DBUtil;

public class ScheduleRepositoryImpl implements ScheduleRepository{

	// SQL
	private static final String INSERT_SCHEDULE_SQL = " insert into schedule_tb (start_day, end_day, information) values (?, ?, ?); " ;
	
	
	@Override
	public int addSchedule(ScheduleDTO schedule) {
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SCHEDULE_SQL)){
				pstmt.setDate(1, schedule.getStartDay());
				pstmt.setDate(2, schedule.getEndDay());
				pstmt.setString(3, schedule.getInformation());
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
