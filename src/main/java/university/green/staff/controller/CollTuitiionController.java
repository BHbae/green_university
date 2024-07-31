package university.green.staff.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import university.green.staff.model.CollTuitionDTO;
import university.green.staff.model.CollTuitionListDTO;
import university.green.staff.model.CollegeDTO;
import university.green.staff.repository.CollTuitionRepositoryImpl;
import university.green.staff.repository.interfaces.CollTuitionRepository;

import java.io.IOException;
import java.util.List;

// 등록 - 단대별 등록금
@WebServlet("/colltuition/*")
public class CollTuitiionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CollTuitionRepository collTuitionRepository;
       
  
	// 등록, 수정, 삭제
    public CollTuitiionController() {
        super();
    collTuitionRepository = new CollTuitionRepositoryImpl();
    }

    // 리스트, 등록 페이지, 수정 페이지, 삭제 페이지
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		switch (action) {
		case "/colllist":
			colllist(request, response);
			break;
		case "/colladd":
			collladd(request, response);
			break;
		case "/colldelete":
			colldelete(request, response);
			break;
		case "/collupdate":
			collupdate(request, response);
			break;

		default:
			break;
		}
		
		
		
	}


	// 리스트
	private void colllist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CollTuitionListDTO> coll = collTuitionRepository.colltuitionList();
		
		String action = request.getParameter("action");
		
		List<CollegeDTO> college = collTuitionRepository.selectCollege();
		
		request.setAttribute("college", college);
		request.setAttribute("action", action);
		request.setAttribute("colltuitionList", coll);
		request.getRequestDispatcher("/WEB-INF/views/staff/collTuition.jsp").forward(request, response);
		
	}

	// 등록 페이지
	private void collladd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/collTuition.jsp").forward(request, response);
		
	}

	// 삭제 페이지
	private void colldelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/collTuition.jsp").forward(request, response);
		
	}

	// 수정 페이지
	private void collupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/collTuition.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		switch (action) {
	
		case "/addcoll":
			addcoll(request, response);
			break;
		case "/detelecoll":
			detelecoll(request, response);
			break;
		case "/updatecoll":
			updatecoll(request, response);
			break;

		default:
			break;
		}
		
	}

	// 등록 기능
	private void addcoll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int collegeId = Integer.parseInt(request.getParameter("college_id"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		System.out.println(collegeId);
		System.out.println(amount);
		
		CollTuitionDTO dto = CollTuitionDTO.builder()
										   .collegeId(collegeId)
										   .amount(amount)
										   .build();
		collTuitionRepository.addColltuition(dto);
		
		
		response.sendRedirect(request.getContextPath() + "/colltuition/colllist");
	}

	// 삭제 기능
	private void detelecoll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int collegeId = Integer.parseInt(request.getParameter("college_id"));
		collTuitionRepository.deleteColltuition(collegeId);
		
		
		response.sendRedirect(request.getContextPath() + "/colltuition/colllist");
		
		
	}

	// 수정 기능
	private void updatecoll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// college_id, amount
		int collegeId = Integer.parseInt(request.getParameter("college_id"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		CollTuitionDTO dto = CollTuitionDTO.builder()
				   .collegeId(collegeId)
				   .amount(amount)
				   .build();
		
		collTuitionRepository.updateColltuition(dto);
		
	
		response.sendRedirect(request.getContextPath() + "/colltuition/colllist");
	}

}
