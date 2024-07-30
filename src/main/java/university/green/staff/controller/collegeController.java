package university.green.staff.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import university.green.staff.model.CollegeDTO;
import university.green.staff.repository.collegeRepositoryImpl;
import university.green.staff.repository.interfaces.collegeRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/college/*")
public class collegeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private collegeRepository collegeRepository;

	public collegeController() {
		super();
		collegeRepository = new collegeRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		case "/collegelist":
			collegelist(request, response);
			break;
		case "/collegeadd":
			collegeadd(request, response);
			break;
		case "/collegedelete":
			collegedelete(request, response);
			break;
		case "/deletecollege":
			deletecollege(request, response);
			break;

		default:
			break;
		}

	}

	
	private void collegedelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/college.jsp").forward(request, response);
		
	}

	
	private void collegeadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/college.jsp").forward(request, response);
	}

	private void collegelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CollegeDTO> college = collegeRepository.listCollege();
		
		
		request.setAttribute("collegeList", college);
		request.getRequestDispatcher("/WEB-INF/views/staff/college.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		
		case "/collegeadd":
			addcollege(request, response);
			break;
		

		default:
			break;
		}


	}

	// 추가
	private void addcollege(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		collegeRepository.addCollege(name);
		List<CollegeDTO> college = collegeRepository.listCollege();// 조회
		
		
		response.sendRedirect(request.getContextPath() + "/college/collegelist");

	}

	// 삭제 (get 방식으로 던져 줌)
	private void deletecollege(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		collegeRepository.deleteCollege(id);
		
		List<CollegeDTO> college = collegeRepository.listCollege();
		request.setAttribute("collegeList", college);
		request.getRequestDispatcher("/WEB-INF/views/staff/college.jsp").forward(request, response);
		
	}

}
