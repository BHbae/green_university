package university.green;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import university.green.util.DBUtil;

public class UserRepositoryImpl implements UserRepository{

	private static final String SELECT_USER =" select * from user_tb WHERE id = ? AND password = ?; ";
	
	@Override
	public LoginDto userId(int id, String password) {
		LoginDto dto = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_USER)){
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
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

	@Override
	public LoginDto user_role(LoginDto role) {
		// TODO Auto-generated method stub
		return null;
	}

}
