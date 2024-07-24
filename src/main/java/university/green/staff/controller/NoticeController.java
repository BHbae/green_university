package university.green.staff.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.staff.model.NoticeDTO;
import university.green.staff.repository.NoticeRepository;
import university.green.staff.repository.NoticeRepositoryImpl;

// URL 매핑 수정
@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeRepository noticeRepository;

	@Override
	public void init() throws ServletException {
		noticeRepository = new NoticeRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		// 화면 이동, 조회(상세페이지)(조회수), 페어징 기능 // 상세보기 -> 세션 처리
		// 상세 페이지 이동
		switch (action) {
		// 공지사항 검색 조회
		case "/notice":
			handleNotice(request, response, session);
			break;
		// 공지사항 조회
		case "/allnotice":
			showViewNotice(request, response, session);
			break;
		// 학사일정 조회
		case "/schedule":
			handleSchedule(request, response, session);

			break;

		// 페이징 처리
		case "/list":
			handleList(request, response, session);

			break;
		case "/createNotice": // 등록 누르면 이동 -> 등록 페이지로
			showCreateNoticeForm(request, response, session);

			break;
		case "/view": // 상세보기 페이지 이동
			showViewPage(request, response, session);

			break;

		default:
			break;
		}

	}

	// 공지사항 전체 조회
	private void showViewNotice(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		
		List<NoticeDTO> noticelist = noticeRepository.getAllNotice();
		
		request.setAttribute("noticelist", noticelist);
		System.out.println(noticelist);
		//request.getRequestDispatcher("/WEB-INF/views/staff/notice.jsp").forward(request, response);
		request.getRequestDispatcher("/notice.jsp").forward(request, response);
	}

	// 상세보기 페이지로 이동
	private void showViewPage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

		request.getRequestDispatcher("/WEB-INF/views/staff/noticeView.jsp").forward(request, response);

	}

	// 등록 페이지로 이동
	private void showCreateNoticeForm(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/noticeCreate.jsp").forward(request, response);

	}

	// 공지사항 검색 조회
	private void handleNotice(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		
		
//		request.getRequestDispatcher("").forward(request, response);
	}

	// 학사일정 조회
	private void handleSchedule(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

//		request.getRequestDispatcher("").forward(request, response);
	}

	// 페이징 처리
	private void handleList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		int page = 1;
		int pageSize = 10; // 게시글 수

		try {
			String pageStr = request.getParameter("page");
			if (pageStr != null) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}

		int offset = (page - 1) * 10;

//		List<Notice> noticeList = noticeRepository.getAllNotice();
//		int totalNotices = noticeRepository.getAllNotice();

//		request.getRequestDispatcher("").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		String action = request.getPathInfo();

		switch (action) {
		// 공지사항 등록 처리
		case "/notice":
			handleCreateNotice(request, response, session);
			break;
		// 학사일정 등록 처리
		case "/schedule":
			handleCreateSchedule(request, response, session);
			break;

		default:
			break;
		}
	}

	// 공지사항 등록 처리
	private void handleCreateNotice(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// id??
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		if (category != null || title != null || content != null) {

		}

	}

	// 학사일정 등록 처리
	private void handleCreateSchedule(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO 유효성 검사 (모든 값이 not null)

		// 시작 날짜, 종료 날짜, 내용
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String startDay = request.getParameter("startDay");
		Integer.parseInt(startDay); 
		
		
		noticeRepository.addNotice(null);
		

		// TODO date 변환

	}

}// end of main
