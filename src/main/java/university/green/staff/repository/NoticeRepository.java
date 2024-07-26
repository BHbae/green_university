package university.green.staff.repository;

import java.sql.Date;
import java.util.List;

import university.green.staff.model.NoticeDTO;
import university.green.staff.model.ScheduleDTO;


// 공지사항DTO
public interface NoticeRepository {

	// 등록
	int addNotice(NoticeDTO notice);
	// 제목으로 조회
	List<NoticeDTO> getNoticeBytitle(String title);
	// 제목과 내용으로 조회
	List<NoticeDTO> getNoticeBytitleAndcontent(String title, String content);
	// 상세 페이지 안에서 삭제
	int deleteNotice(int id);
	// 전체 조회
	List<NoticeDTO> getAllNotice(int limit, int offset);
	// 상세 페이지 안에서 수정
	int updateNotice(NoticeDTO notice);
<<<<<<< HEAD
	// 상세 페이지로 이동
	NoticeDTO detalNotice(int id);
=======
	// 공지사항 전체보기 페이징 카운트
	int countNotice();
	
	// 학사일정 전체보기
	List<ScheduleDTO> scheduleAll();
	
	// 학사일정 등록 
	int addSchedule(ScheduleDTO addaddSchedule,int staffId);
	
	
	
	
	
	
>>>>>>> d1291726cb407779e17498d58abb5cabc9940081
}


