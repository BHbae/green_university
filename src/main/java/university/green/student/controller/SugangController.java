package university.green.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.student.model.PreSugangListDTO;
import university.green.student.model.StudentDTO;
import university.green.student.model.SugangDTO;
import university.green.student.repository.SugangRepositoryImpl;
import university.green.student.repository.interfaces.SugangRepository;
@WebServlet ("/sugang/*")
public class SugangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SugangRepository sugangRepository; 
	
    @Override
    public void init() throws ServletException {
    	sugangRepository = new SugangRepositoryImpl();
    	
    }
    
    public SugangController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session=request.getSession();
		
		switch (action) {
		case "/listBoards":
			handleListBoards(request, response, session);
			break;
		case "/search":
			SearchSugangBoard(request, response, session);
			break;
		case "/preApply":
			PreSugangApply(request, response, session);
			break;
		case "/preSearch":
			preSearchBoard(request, response, session);
			break;
		case "/ApplyInfo":
			ApplyInfo(request, response, session);
			break;
		case "/CheckPreSugang":
			handelCheckPreSugang(request, response, session);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
		
	}
	
	/**
	 * 예비 수강 신청 및 취소 상태 확인
	 * @param request
	 * @param response
	 * @param session
	 */
	private void handelCheckPreSugang(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 예비 수강신청 검색
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void preSearchBoard(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int page = 1;
		int pageSize = 20;
		String pageStr = request.getParameter("page");
		String majorType = request.getParameter("majorType");
		String department = request.getParameter("department");
		String subjectName = request.getParameter("subjectName");
		
		try {
			if(pageStr != null ) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}
		int offset = (page -1) * pageSize;
		
		
		int totalBoards = sugangRepository.getTotalBoardCount();
		
		int totalPages = (int) Math.ceil((double)totalBoards / pageSize);
		
		
		List<SugangDTO> preSearchBoard = sugangRepository.preSearchBoard(majorType, department, subjectName, pageSize, offset);
		request.setAttribute("preBoardList", preSearchBoard);
		request.setAttribute("currentPage", page);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("totalBoards", totalBoards);
		System.out.println(preSearchBoard);
		
		request.getRequestDispatcher("/WEB-INF/views/student/PreApplication.jsp").forward(request, response);
	}
		
	

	/**
	 * 페이징 처리
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void handleListBoards(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int page = 1;
		int pageSize = 20;
		String pageStr = request.getParameter("page");
		
		try {
			if(pageStr != null ) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}
		int offset = (page -1) * pageSize;
		
		
		int totalBoards = sugangRepository.getTotalBoardCount();
		
		int totalPages = (int) Math.ceil((double)totalBoards / pageSize);
		
		
		List<SugangDTO> boardList = sugangRepository.listBoard(pageSize, offset);
		request.setAttribute("boardList", boardList);
		request.setAttribute("currentPage", page);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("totalBoards", totalBoards);
		System.out.println(boardList);
		
		request.getRequestDispatcher("/WEB-INF/views/student/application.jsp").forward(request, response);
	}

	/**
	 * 수강신청 이력 조회
	 * @param request
	 * @param response
	 */
	private void ApplyInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}
	
	

	/**
	 * 수강신청 조회 기능
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void SearchSugangBoard(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int page = 1;
		int pageSize = 20;
		String pageStr = request.getParameter("page");
		String majorType = request.getParameter("majorType");
		String department = request.getParameter("department");
		String subjectName = request.getParameter("subjectName");
		
		try {
			if(pageStr != null ) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}
		int offset = (page -1) * pageSize;
		
		
		int totalBoards = sugangRepository.getTotalBoardCount();
		
		int totalPages = (int) Math.ceil((double)totalBoards / pageSize);
		
		
		List<SugangDTO> searchBoard = sugangRepository.searchBoard(majorType, department, subjectName, pageSize, offset);
		request.setAttribute("boardList", searchBoard);
		request.setAttribute("currentPage", page);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("totalBoards", totalBoards);
		System.out.println(searchBoard);
		
		request.getRequestDispatcher("/WEB-INF/views/student/application.jsp").forward(request, response);
	}
	
	/**
	 * 예비 수강신청
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void PreSugangApply(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int page = 1;
		int pageSize = 20;
		String pageStr = request.getParameter("page");
		StudentDTO student = (StudentDTO)session.getAttribute("principal");
		
		try {
			if(pageStr != null ) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}
		int offset = (page -1) * pageSize;
		
		
		int totalBoards = sugangRepository.getTotalBoardCount();
		
		int totalPages = (int) Math.ceil((double)totalBoards / pageSize);
		
		//  전체 과목 리스트
		List<SugangDTO> preBoardList = sugangRepository.preApply(pageSize, offset);
		request.setAttribute("preBoardList", preBoardList);
		request.setAttribute("currentPage", page);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("totalBoards", totalBoards);
		System.out.println("전체강의 조회: "+preBoardList);
		System.out.println("내 id 확인: "+student.getId());
		
		// 내가 수강신청한 
		List<PreSugangListDTO> PreSugangList = sugangRepository.CheckById(student.getId()); // 예비 수강신청
		request.setAttribute("PreSugangList", PreSugangList);
		System.out.println("내 수강신청 목록: "+PreSugangList);
		request.getRequestDispatcher("/WEB-INF/views/student/PreApplication.jsp").forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("Requested action: " + action);
		HttpSession session=request.getSession();
		
		switch (action) {
		case "/SugangApply":
			SugangApply(request, response, session);
			break;
		case "/StudentPlus":
			HandleStudentPlus(request, response, session);
			break;
		case "/StudentMinus":
			HandleStudentMinus(request, response, session);
			break;
		case "/AddPreSugang":
			System.out.println("프리수강");
			HandleAddPreSugang(request, response, session);
			break;
		case "/SubtractPreSugang":
			HandleSubtractPreSugang(request, response, session);
			break;		
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
		
	}
	
	/**
	 * 예비 수강 목록 삭제 (취소)
	 * @param request
	 * @param response
	 * @param session
	 */
	private void HandleSubtractPreSugang(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 예비 수강 목록 추가 (등록)
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void HandleAddPreSugang(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		System.out.println(sugangRepository.AddPreSugang(studentId, subjectId));
		
		
		List<PreSugangListDTO> PreSugangList = sugangRepository.CheckById(studentId); // 예비 수강신청
		request.setAttribute("PreSugangList", PreSugangList);
		
		
		System.out.println(PreSugangList);
	
		
//		request.getRequestDispatcher("/WEB-INF/views/student/PreApplication.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/sugang/preApply");
		
	}

	/**
	 * 신청 취소시 현재정원 감소
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void HandleStudentMinus(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id")); // sub_id
		StudentDTO dto = (StudentDTO)session.getAttribute("principal"); 
        int stuId = dto.getId(); // stuId
        
        List<PreSugangListDTO> checkList=sugangRepository.CheckById(stuId);
        for(int i=1; i<checkList.size()+1; i++) {
        	PreSugangListDTO check= checkList.get(i);
        	if(check.getSubjectId()==id) {
        		System.out.println("수강 신청 취소 튕김");
        		System.out.println("중복 수강신청 취소 불가!!");

                response.sendRedirect(request.getContextPath()  + "/sugang/preApply");
        		return;
        	} else {
        		System.out.println("수강 신청 취소 완료");
        		 sugangRepository.StudentMinus(id);
                 sugangRepository.SubtractPreSugang(stuId, id);
                 response.sendRedirect(request.getContextPath()  + "/sugang/preApply");
                 return;
        	}

        }
	}

	/**
	 * 신청시 현재정원 증가
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void HandleStudentPlus(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id")); // sub_id
		StudentDTO dto = (StudentDTO)session.getAttribute("principal"); 
        int stuId = dto.getId(); // stuId
        
        List<PreSugangListDTO> checkList=sugangRepository.CheckById(stuId);
        for(int i=1; i<checkList.size(); i++) {
        	System.out.println("for문 들어옴");
        	PreSugangListDTO check= checkList.get(i);
        	
        	if(check.getSubjectId()==id) {
        		System.out.println("수강 신청 튕김");
        		System.out.println("중복 수강신청 불가!!");
                response.sendRedirect(request.getContextPath()  + "/sugang/preApply");
        		return;
        	} else {
        		System.out.println("수강 신청 완료");
        		sugangRepository.StudentPlus(id);
                sugangRepository.AddPreSugang(stuId, id);
                response.sendRedirect(request.getContextPath()  + "/sugang/preApply");
                return;
        	}
        }
		
	}


	/**
	 * 수강신청
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void SugangApply(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
	
	
}