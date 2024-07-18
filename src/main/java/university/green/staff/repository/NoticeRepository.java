package university.green.staff.repository;

import java.util.List;

import com.mysql.cj.protocol.x.Notice;

public interface NoticeRepository {

	// 등록
	void addNotice(Notice notice);
	// 제목으로 조회
	Notice getNoticeBytitle(String title);
	// 제목과 내용으로 조회
	Notice getNoticeBytitleAndcontent();
	// 상세 페이지 안에서 삭제
	int deleteNotice(int id);
	// 전체 조회
	List<Notice> getAllNotice();
	// 상세 페이지 안에서 수정
	void updateNotice(Notice notice);
}
