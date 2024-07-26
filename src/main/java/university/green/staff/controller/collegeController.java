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

		default:
			break;
		}

	}

	// 삭제
	private void collegedelete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	// 등록
	private void collegeadd(HttpServletRequest request, HttpServletResponse response) {

		 request.getRequestDispatcher("")
	}

	private void collegelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CollegeDTO> collegeList = collegeRepository.listCollege();
		
		
		request.setAttribute("college", collegeList);
		request.getRequestDispatcher("/WEB-INF/views/staff/registrationCollege.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
