package university.green.staff.repository;

import java.util.List;

import university.green.staff.model.Notice;


// 공지사항DTO
public interface NoticeRepository {

	// 등록
	int addNotice(Notice notice);
	// 제목으로 조회
	List<Notice> getNoticeBytitle(String title);
	// 제목과 내용으로 조회
	List<Notice> getNoticeBytitleAndcontent(String title, String content);
	// 상세 페이지 안에서 삭제
	int deleteNotice(int id);
	// 전체 조회
	List<Notice> getAllNotice();
	// 상세 페이지 안에서 수정
	int updateNotice(Notice notice);
}
