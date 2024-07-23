package university.green.student.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import university.green.student.SugangRepositoryImpl;
import university.green.student.model.SugangDTO;
import university.green.student.repository.SugangRepository;
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
		
		
		switch (action) {
		case "/search":
			SearchSugangBoard(request, response);
			break;
		case "/preApply":
			PreSugangApply(request, response);
			break;
		case "/SugangApply":
			SugangApply(request, response);
			break;
		case "/ApplyInfo":
			ApplyInfo(request, response);
		case "/listBoards":
			handleListBoards(request, response);

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
		
	}
	
	
	/**
	 * 페이징 처리
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void handleListBoards(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		int pageSize = 20;
		
		try {
			String pageStr = request.getParameter("page");
			if(pageStr != null ) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = -1;
		}
		int offset = (page -1) * pageSize;
		
		List<SugangDTO> boardList = sugangRepository.listBoard(pageSize, offset);
		request.setAttribute("boardList", boardList);
		
		int totalBoards = sugangRepository.getTotalBoardCount();
		
		int totalPages = (int) Math.ceil((double)totalBoards / pageSize);
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		
		request.getRequestDispatcher("/WEB-INF/application.jsp").forward(request, response);
	}

	/**
	 * 수강신청 이력 조회
	 * @param request
	 * @param response
	 */
	private void ApplyInfo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 수강신청
	 * @param request
	 * @param response
	 */
	private void SugangApply(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 예비 수강신청
	 * @param request
	 * @param response
	 */
	private void PreSugangApply(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 수강신청 조회 기능
	 * @param request
	 * @param response
	 */
	private void SearchSugangBoard(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
