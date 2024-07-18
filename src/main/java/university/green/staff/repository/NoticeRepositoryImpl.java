package university.green.staff.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.mysql.cj.protocol.x.Notice;

import university.green.util.DBUtil;

public class NoticeRepositoryImpl implements NoticeRepository{
	
	// SQL
	private static final String INSERT_NOTICE_SQL = " INSERT INTO notice_tb (category, title, content) VALUES (? , ? , ?) " ;
	private static final String SELECT_NOTICE_BY_TITLE = " SELECT * FROM notice_tb WHERE title like %?% " ;
	private static final String SELECT_NOTICE_BY_TITLE_AND_CONTNET = " SELECT * FROM notice_tb WHERE title like %?% and content like %?% " ;
	private static final String DELETE_NOTICE_SQL = "  DELETE FROM notice_tb WHERE id = ? " ;
	private static final String SELECT_ALL_NOTICE = " SELECT * FROM notice_tb " ;
	private static final String UPDATE_NOTICE_SQL = " UPDATE notice_tb SET title = ? , content = ?  WHERE id = ? " ;

	@Override // 등록
	public void addNotice(Notice notice) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			
			// 트랜잭션 
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_NOTICE_SQL)){
				
				
				
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override // 제목 조회
	public Notice getNoticeBytitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // 제목 + 내용 조회
	public Notice getNoticeBytitleAndcontent() {
		// TODO Auto-generated method stub 
		return null;
	}

	@Override // 삭제
	public int deleteNotice(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override // 전체 조회
	public List<Notice> getAllNotice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // 수정
	public void updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		
	}

}
