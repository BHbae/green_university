package university.green.student.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.student.model.BreakAppDTO;
import university.green.student.model.CoDeDTO;
import university.green.student.model.StudentDTO;
import university.green.student.repository.leaveRepositoryImpl;
import university.green.student.repository.interfaces.leaveRepository;
//check
@WebServlet("/mystudent/*")
public class StudentMyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private leaveRepository leaveRepository;
	
    public StudentMyController() {
        super();
        leaveRepository = new leaveRepositoryImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		
		switch (action) {
		case "/my":
			MyDitail(request, response, session);
			break;
		case "/mypassword":
			MyDitail(request, response, session);
			break;
		case "/mybreakapp":
			mybreakapp(request, response, session);
			break;
		case "/mybreakapplist":
			breakapplist(request, response, session);
			break;
		case "/mybreakappdetail":
			mybreakappdetail(request, response, session);
			break;
			

		default:
			break;
		}
		
	}

	private void mybreakappdetail(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int leaveID = Integer.parseInt(idStr);
		StudentDTO studentDTO = (StudentDTO)session.getAttribute("principal");
		
		CoDeDTO dto = leaveRepository.searchCoDe(studentDTO.getId());
		BreakAppDTO leave = leaveRepository.detailBreakApp(leaveID);
		
		
		request.setAttribute("dto", dto);
		request.setAttribute("leave", leave);
		request.getRequestDispatcher("/WEB-INF/views/student/breakappdetail.jsp").forward(request, response);
	}

	private void breakapplist(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		StudentDTO studentDTO = (StudentDTO)session.getAttribute("principal");
		List<BreakAppDTO> AppList = leaveRepository.breakAppList(studentDTO.getId());
		
		request.setAttribute("AppList", AppList);
		System.out.println(AppList);
		request.getRequestDispatcher("/WEB-INF/views/student/breakAppListStudent.jsp").forward(request, response);
	}

	private void mybreakapp(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		StudentDTO studentDTO = (StudentDTO)session.getAttribute("principal");
		CoDeDTO college = leaveRepository.searchCoDe(studentDTO.getId());
		request.setAttribute("college", college);
		
		request.getRequestDispatcher("/WEB-INF/views/student/breakApplication.jsp").forward(request, response);
	}

	private void MyDitail(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		
		
		request.getRequestDispatcher("/WEB-INF/views/student/studentMy.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		
		switch (action) {
		case "/appbreak":
			appbreak(request, response, session);
			break;
		case "/deleteapp":
			deleteapp(request, response, session);
			break;
		default:
			break;
		}
		
		
	}

	private void deleteapp(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		StudentDTO dto = (StudentDTO)session.getAttribute("principal");
		
		
		leaveRepository.deleteBreakApp(id, dto.getId());
		
		response.sendRedirect(request.getContextPath()  + "/mystudent/mybreakapplist");
	}

	private void appbreak(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		StudentDTO studentDTO = (StudentDTO)session.getAttribute("principal");
		int stusentId = studentDTO.getId();
		int stusentGd = studentDTO.getGrade();
		
		String fromYearStr = request.getParameter("fromYear");
		int fromYear = Integer.parseInt(fromYearStr);
		
		String fromSemesterStr = request.getParameter("fromSemester");
		int fromSemester = Integer.parseInt(fromSemesterStr);
		
		String toYearStr = request.getParameter("toYear");
		int toYear = Integer.parseInt(toYearStr);
		String toSemesterStr = request.getParameter("toSemester");
		int toSemester = Integer.parseInt(toSemesterStr);
		
		String type = request.getParameter("type");
		
		BreakAppDTO breakAppDTO = BreakAppDTO.builder()
				.studentId(stusentId)
				.studentGrade(stusentGd)
				.fromYear(fromYear)
				.fromSemester(fromSemester)
				.toYear(toYear)
				.toSemester(toSemester)
				.type(type)
				.build();
		
		leaveRepository.breakApp(breakAppDTO);
		response.sendRedirect(request.getContextPath()  + "/mystudent/mybreakapplist");
		
	}

}
