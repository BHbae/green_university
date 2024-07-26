package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.staff.repository.interfaces.StuStatRepository;
import university.green.util.DBUtil;

public class StuStatRepositoryImpl implements StuStatRepository{

	@Override
	public List<Integer> getAllStudentForBill() {
		List<Integer> studentIdList=new ArrayList<>();
		final String SELECT_STUDENT_ID_FOR_SEND_BILL=" select sst.student_id from stu_stat_tb as sst where status='재학' ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_STUDENT_ID_FOR_SEND_BILL)){
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				studentIdList.add(rs.getInt("student_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentIdList;
	}

	@Override
	public List<String> getAllStudentStatus() {
		List<String> statusList=new ArrayList<>();
		final String SELECT_ALL_STATUS=" select status from stu_stat_tb ";
		try(Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_ALL_STATUS)) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				statusList.add(rs.getString("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusList;
	}

}
