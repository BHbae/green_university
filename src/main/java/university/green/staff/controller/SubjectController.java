package university.green.staff.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import university.green.professor.model.subjectDTO;
import university.green.staff.model.SubjectDTO;
import university.green.staff.repository.SubjectRepositoryImpl;
import university.green.staff.repository.interfaces.SubjectRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/subject/*")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SubjectRepository subjectRepository;
   
    public SubjectController() {
        super();
        subjectRepository = new SubjectRepositoryImpl();
    }

    // 등록, 수정, 삭제

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		switch (action) {
		case "/subjectlist":
			subjectlist(request, response);
			break;

		case "/subjectadd":
			subjectadd(request, response);
			break;
		
		case "/subjectdelete":
			subjectdelete(request, response);
			break;
			
		case "/subjectupdate":
			subjectupdate(request, response);
			break;
		default:
			break;
		}
		
		
	}


	// 목록 페이지
	private void subjectlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SubjectDTO> subject = subjectRepository.subjectList();
		
		String action = request.getParameter("action");
		
		request.setAttribute("action", action);
		request.setAttribute("subjectList", subject);
		request.getRequestDispatcher("/WEB-INF/views/staff/subject.jsp").forward(request, response);
		
	}

	// 등록 페이지
	private void subjectadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/subject.jsp").forward(request, response);
		
	}

	// 삭제 페이지
	private void subjectdelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/subject.jsp").forward(request, response);
		
	}

	// 수정 페이지
	private void subjectupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/subject.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		switch (action) {
		case "/addsubject":
			addsubject(request, response);
			break;
		
		case "/deletesubject":
			deletesubject(request, response);
			break;
			
		case "/updatesubject":
			updatesubject(request, response);
			break;
		default:
			break;
		}
	}

	// 등록 기능
	private void addsubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int professorId = Integer.parseInt(request.getParameter("professorId"));
		String roomId = request.getParameter("roomId");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String type = request.getParameter("type");
		int subYear = Integer.parseInt(request.getParameter("subYear"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		String subDay = request.getParameter("subDay");
		int startTime = Integer.parseInt(request.getParameter("startTime"));
		int endTime = Integer.parseInt(request.getParameter("endTime"));
		int grades = Integer.parseInt(request.getParameter("grades"));
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		
		SubjectDTO dto = SubjectDTO.builder()
								   .name(name)
								   .professorId(professorId)
								   .roomId(roomId)
								   .deptId(deptId)
								   .type(type)
								   .subYear(subYear)
								   .semester(semester)
								   .subDay(subDay)
								   .startTime(startTime)
								   .endTime(endTime)
								   .grades(grades)
								   .capacity(capacity)
								   .build();
		subjectRepository.addSubject(dto);
		
		List<SubjectDTO> subject = subjectRepository.subjectList();
		request.setAttribute("subjectList", subject);
		request.getRequestDispatcher("/WEB-INF/views/staff/subject.jsp").forward(request, response);
		
		
		
	}

	// 삭제 기능
	private void deletesubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		subjectRepository.deleteSubject(id);
		
		List<SubjectDTO> subject = subjectRepository.subjectList();
		request.setAttribute("subjectList", subject);
		request.getRequestDispatcher("/WEB-INF/views/staff/subject.jsp").forward(request, response);
		
	}

	// 수정 기능
	private void updatesubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		List<SubjectDTO> subject = subjectRepository.subjectList();
		request.setAttribute("subjectList", subject);
		request.getRequestDispatcher("/WEB-INF/views/staff/subject.jsp").forward(request, response);
		
		
	}

}
