package university.green.professor.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.professor.lectureListImpl;
import university.green.professor.model.ProfessorDTO;
import university.green.professor.model.lectureDTO;
import university.green.professor.model.subjectDTO;
import university.green.professor.repositoryinterfaces.lectureList;
@WebServlet("/lecture/*")
public class LectureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private lectureList lectureList;
	
    public LectureController() {
    	super();
    	lectureList = new lectureListImpl();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		
		switch (action) {
		case "/lectureAll":
			LectureviewsAll(request, response, session);
			break;
		case "/mylecture":
			LectureviewsMy(request, response, session);
			break;
		default:
			break;
		}
		
	}

	private void LectureviewsMy(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		// TODO - 예외처리 추가
		try {
			ProfessorDTO professorDTO =  (ProfessorDTO)session.getAttribute("principal");
			List<subjectDTO> list = lectureList.myLecture(professorDTO.getId());
			
			request.setAttribute("lectureList", list);
			
			// TODO - 경로 수정
			request.getRequestDispatcher("/WEB-INF/views/professor/test.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void LectureviewsAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO - 예외처리 추가
		try {
			String offsetStr = request.getParameter("offset");
			int offset = Integer.parseInt(offsetStr); 
			
			String pageStr = request.getParameter("page");
			int page = Integer.parseInt(pageStr);
			
			List<lectureDTO> list = lectureList.lectureAllList(page, offset);
			
			request.setAttribute("lectureList", list);
			
			// TODO - 경로 수정
			request.getRequestDispatcher("/WEB-INF/views/professor/test.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
