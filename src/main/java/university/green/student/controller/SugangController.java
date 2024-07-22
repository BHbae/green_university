package university.green.student.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.student.SugangRepositoryImpl;
import university.green.student.repository.SugangRepository;
@WebServlet ("/sugang/*")
public class SugangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	private SugangRepository sugangRepository;
	
    @Override
    public void init() throws ServletException {
    	sugangRepository = new SugangRepositoryImpl();
    	
=======
	// cyj
	
    public SugangController() {
        super();
>>>>>>> main
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		switch (action) {
		case "/search":
			SearchSugangBoard(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
		
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
