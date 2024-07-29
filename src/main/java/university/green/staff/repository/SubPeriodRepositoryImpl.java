package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import university.green.staff.model.SubPeriodDTO;
import university.green.staff.repository.interfaces.SubPeriodRepository;
import university.green.util.DBUtil;

public class SubPeriodRepositoryImpl implements SubPeriodRepository{

	// 수강신청 기간 - 조회
	@Override
	public SubPeriodDTO getSubPeriod(int year,int semester) {
		SubPeriodDTO subPeriodStatus = new SubPeriodDTO();
		final String GET_STATUS=" select * from sub_period_tb where year = ? and semester = ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(GET_STATUS)){
			pstmt.setInt(1, year);
			pstmt.setInt(2, semester);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				subPeriodStatus=SubPeriodDTO.builder().id(rs.getInt("id")).status(rs.getInt("status")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subPeriodStatus;
	}

	// 수강신청 기간 - 시작
	@Override
	public void startSubPeriod(int year, int semester) {
		final String START_PERIOD=" update sub_period_tb set status = 2 where year = ? and semester = ? ";
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(START_PERIOD)){
				pstmt.setInt(1, year);
				pstmt.setInt(2, semester);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 수강신청 기간 - 종료
	@Override
	public void stopSubPeriod(int year, int semester) {
		final String START_PERIOD=" update sub_period_tb set status = 3 where year = ? and semester = ?";
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(START_PERIOD)){
				pstmt.setInt(1, year);
				pstmt.setInt(2, semester);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 수강신청 기간 - 추가
	@Override
	public int addSubPeriod(int year, int semester) {
		final String ADD_SUB_PERIOD=" insert into sub_period_tb(status,year,semester) values (?,?,?) ";
		int check_flag=0;
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try(PreparedStatement pstmt=conn.prepareStatement(ADD_SUB_PERIOD)) {
				pstmt.setInt(1, 1);
				pstmt.setInt(2, year);
				pstmt.setInt(3, semester);
				check_flag=pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check_flag;
	}

}
