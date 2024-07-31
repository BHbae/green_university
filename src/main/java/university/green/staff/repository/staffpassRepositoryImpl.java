package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import university.green.LoginDto;
import university.green.staff.repository.interfaces.staffpassRepository;
import university.green.util.DBUtil;

public class staffpassRepositoryImpl implements staffpassRepository {

	private static final String UPDATE_PASSWORD =" UPDATE user_tb set password = ? WHERE id = ? ";
	private static final String SELECT_PASSWORD =" SELECT * FROM user_tb WHERE id = ? AND password = ? ";
	
	@Override
	public int setPassword(int principalid, int setPassword) {
		int rowCout = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_PASSWORD)){
				pstmt.setInt(1, setPassword);
				pstmt.setInt(2, principalid);
				rowCout = pstmt.executeUpdate();
				
				conn.rollback();
				
			} catch (Exception e) {
				conn.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return rowCout;
	}

	@Override
	public LoginDto stafflogin(int id, int Password) {
		LoginDto dto = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_PASSWORD)){
			pstmt.setInt(1, id);
			pstmt.setInt(2, Password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = LoginDto.builder()
						.id(rs.getInt("id"))
						.password(rs.getString("password"))
						.user_role(rs.getString("user_role"))
						.build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

}
