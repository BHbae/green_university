package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.staff.model.Staff_tb;
import university.green.staff.repository.interfaces.StaffRepository;
import university.green.util.DBUtil;

public class StaffRepositoryImpl implements StaffRepository{

	@Override
	public void addStaff(Staff_tb staff) {
		final String ADD_STAFF=" INSERT INTO staff_tb (name, birth_date, gender, address, tel, email, hire_date) "
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		Staff_tb newStaff=null;
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(ADD_STAFF)){
				pstmt.setString(1, staff.getName());
				pstmt.setDate(2,staff.getBirth_date());
				pstmt.setString(3, staff.getGender());
				pstmt.setString(4, staff.getAddress());
				pstmt.setString(5, staff.getTel());
				pstmt.setString(6, staff.getEmail());
				pstmt.setDate(7, staff.getHire_date());
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

	@Override
	public void updateStaff(Staff_tb staffDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStaffForPassword(String password, int principalId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Staff_tb> getAllStaff() {
		List<Staff_tb> staffList=new ArrayList<>();
		final String SELECT_ALL_STAFF=" SELECT * FROM staff_tb ORDER BY id limit ? offset ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_ALL_STAFF)){
			pstmt.setInt(1,10);
			pstmt.setInt(2,5);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Staff_tb staff=Staff_tb.builder().name(rs.getString("name")).birth_date(rs.getDate("birth_date"))
						.gender(rs.getString("gender")).address(rs.getString("address")).tel(rs.getString("tel"))
						.email(rs.getString("email")).hire_date(rs.getDate("hire_date")).build();
				staffList.add(staff);			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffList;
	}

	@Override
	public List<Staff_tb> getStaffByID(int id) {
		List<Staff_tb> staffList=new ArrayList<>();
		final String SELECT_ALL_STAFF=" SELECT * FROM staff_tb where id = ? ORDER BY id limit ? offset ?";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt=conn.prepareStatement(SELECT_ALL_STAFF)){
			pstmt.setInt(1,id);
			pstmt.setInt(2,10);
			pstmt.setInt(3,5);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Staff_tb staff=Staff_tb.builder().name(rs.getString("name")).birth_date(rs.getDate("birth_date"))
						.gender(rs.getString("gender")).address(rs.getString("address")).tel(rs.getString("tel"))
						.email(rs.getString("email")).hire_date(rs.getDate("hire_date")).build();
				staffList.add(staff);			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffList;
	}

}
