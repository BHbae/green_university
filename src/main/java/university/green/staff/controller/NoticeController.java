package university.green.staff.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.staff.model.Notice;
import university.green.staff.repository.NoticeRepository;
import university.green.staff.repository.NoticeRepositoryImpl;

import java.io.IOException;

// URL 매핑 수정
@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeRepository noticeRepository;

	@Override
	public void init() throws ServletException {
		noticeRepository = new NoticeRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		String action = request.getPathInfo();


		// 화면 이동, 조회(상세페이지)(조회수), 페어징 기능 // 상세보기 -> 세션 처리
		switch (action) {
		// 공지사항 조회
		case "/notice":
			handleNotice(request, response, session);

			break;
		// 학사일정 조회
		case "/schedule":
			handleSchedule(request, response, session);

			break;

		// 페이징 처리
		case "/list":
			handleList(request, response, session);

			break;

		default:
			break;
		}

	}

	// 공지사항 조회
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
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		

		switch (action) {
		// 공지사항 등록 처리
		case "/notice":
			handleCreateNotice(request,response,session);
			break;
		// 학사일정 등록 처리
		case "/schedule":
			handleCreateSchedule(request,response,session);
			break;

		default:
			break;
		}
	}

	// 공지사항 등록 처리
	private void handleCreateNotice(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	// 학사일정 등록 처리
	private void handleCreateSchedule(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO 유효성 검사 (모든 값이 not null)
		
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
//		Notice notice = Notice.builder().
//		
		
	}

}// end of main
