package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import university.green.staff.repository.interfaces.BreakAppRepository;
import university.green.student.model.BreakAppDTO;
import university.green.util.DBUtil;

public class BreakAppRepositoryImpl implements BreakAppRepository{

	@Override
	public void addBreakApp(BreakAppDTO breakAppDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBreakApp(BreakAppDTO breakAppDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBreakAppStatus(String status, int principalId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBreakApp(int id, int principalId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 모든 휴학 신청 가져오기
	 */
	@Override
	public List<BreakAppDTO> getAllBreakApp() {
		final String GET_ALL_BREAKAPP=" select * from break_app_tb ";
		List<BreakAppDTO> breakAppList=null;
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(GET_ALL_BREAKAPP)){
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BreakAppDTO breakApp=BreakAppDTO.builder().id(rs.getInt("id")).studentId(rs.getInt("studentId"))
						.studentGrade(rs.getInt("studentGrade")).fromYear(rs.getInt("fromYear")).fromSemester(rs.getInt("fromSemester"))
						.toYear(rs.getInt("toYear")).toSemester(rs.getInt("toSemester")).type(rs.getString("type"))
						.appDate(rs.getDate("date")).status(rs.getString("status")).build();
				breakAppList.add(breakApp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return breakAppList;
	}

}
