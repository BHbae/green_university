package university.green.staff.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import university.green.staff.model.NoticeDTO;
import university.green.util.DBUtil;

public class NoticeRepositoryImpl implements NoticeRepository {

	// SQL
	private static final String INSERT_NOTICE_SQL = " INSERT INTO notice_tb (category, title, content) VALUES (? , ? , ?) ";
	private static final String SELECT_NOTICE_BY_TITLE = " SELECT * FROM notice_tb WHERE title like %?% ";
	private static final String SELECT_NOTICE_BY_TITLE_AND_CONTNET = " SELECT * FROM notice_tb WHERE title like %?% and content like %?% ";
	private static final String DELETE_NOTICE_SQL = "  DELETE FROM notice_tb WHERE id = ? ";
	private static final String SELECT_ALL_NOTICE = " SELECT * FROM notice_tb ";
	private static final String UPDATE_NOTICE_SQL = " UPDATE notice_tb SET title = ? , content = ?  WHERE id = ? ";
	private static final String DATAL_NOTICE_SQL = " select * from notice_tb WHERE id = ? " ;

	@Override // 등록
	public int addNotice(NoticeDTO notice) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()) {

			// 트랜잭션
			conn.setAutoCommit(false);

			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_NOTICE_SQL)) {
				pstmt.setString(1, notice.getCategory());
				pstmt.setString(2, notice.getTitle());
				pstmt.setString(3, notice.getContent());
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

	@Override // 제목 조회
	public List<NoticeDTO> getNoticeBytitle(String title) {
		List<NoticeDTO> titlelist = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()) {

			// 트랜잭션
			conn.setAutoCommit(false);

			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_BY_TITLE)) {
				pstmt.setString(1, title);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					NoticeDTO notice = new NoticeDTO();
					notice = NoticeDTO.builder().id(rs.getInt("id"))
							 .category(rs.getString("category"))
							 .title(rs.getString("title"))
							 .content(rs.getString("content"))
							 .createdTime(rs.getTimestamp("created_time"))
							 .views(rs.getInt("views"))
							 .build();
					titlelist.add(notice);
				}

			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return titlelist;
	}

	@Override // 제목 + 내용 조회
	public List<NoticeDTO> getNoticeBytitleAndcontent(String title, String content) {
		List<NoticeDTO> titlelist = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()) {

			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_BY_TITLE_AND_CONTNET)) {
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					NoticeDTO notice = new NoticeDTO();
					notice = NoticeDTO.builder().id(rs.getInt("id"))
							 .category(rs.getString("category"))
							 .title(rs.getString("title"))
							 .content(rs.getString("content"))
							 .createdTime(rs.getTimestamp("created_time"))
							 .views(rs.getInt("views"))
							 .build();
					titlelist.add(notice);
				}

			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return titlelist;
	}

	@Override // 삭제
	public int deleteNotice(int id) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_NOTICE_SQL)) {
				pstmt.setInt(1, id);
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

	@Override // 전체 조회
	public List<NoticeDTO> getAllNotice() {

		List<NoticeDTO> noticelist = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()) {

			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_NOTICE)) {

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					NoticeDTO notice = new NoticeDTO();
					notice = NoticeDTO.builder().id(rs.getInt("id"))
							 .category(rs.getString("category"))
							 .title(rs.getString("title"))
							 .content(rs.getString("content"))
							 .createdTime(rs.getTimestamp("created_time"))
							 .views(rs.getInt("views"))
							 .build();
					noticelist.add(notice);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return noticelist;
	}

	@Override // 수정
	public int updateNotice(NoticeDTO notice) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_NOTICE_SQL)) {
				pstmt.setString(1, notice.getTitle());
				pstmt.setString(2, notice.getContent());
				pstmt.setInt(3, notice.getId());
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

	// 상세보기
	@Override
	public NoticeDTO detalNotice(int id) {
		NoticeDTO notice = null;
		try (Connection conn = DBUtil.getConnection()) {

			try (PreparedStatement pstmt = conn.prepareStatement(DATAL_NOTICE_SQL)) {

				ResultSet rs = pstmt.executeQuery();

				if(rs.next()) {
					notice = NoticeDTO.builder().id(rs.getInt("id"))
											 .title(rs.getString("title"))
											 .content(rs.getString("content"))
											 .build();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return notice;
	}

}

