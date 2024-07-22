package university.green.staff.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import university.green.professor.model.ProfessorDTO;
import university.green.professor.repository.ProfessorRepositoryimpl;
import university.green.professor.repositoryinterfaces.ProfessorRepository;
import university.green.staff.repository.BreakAppRepositoryImpl;
import university.green.staff.repository.StaffRepositoryImpl;
import university.green.staff.repository.StuSubRepositoryImpl;
import university.green.staff.repository.StudentRepositoryImpl;
import university.green.staff.repository.TuitionRepositoryImpl;
import university.green.staff.repository.interfaces.BreakAppRepository;
import university.green.staff.repository.interfaces.StaffRepository;
import university.green.staff.repository.interfaces.StuSubRepository;
import university.green.staff.repository.interfaces.StudentRepository;
import university.green.staff.repository.interfaces.TuitionRepository;
import university.green.student.model.StudentDTO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 직원 - 학사 관리 콘트롤러
 */
@WebServlet("/management/*")
public class ManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// TODO - 사용할 DAO 생성하기
	private BreakAppRepository breakAppRepository; // 휴학처리 인터페이스
	private StaffRepository staffRepository; // 교직원 인터페이스
	private ProfessorRepository professorRepository; // 교수 인터페이스
	private StudentRepository studentRepository; // 학생 인터페이스
	private StuSubRepository stuSubRepository; // 수강신청기간 인터페이스
	private TuitionRepository tuitionRepository; // 등록금 고지서 인터페이스
	
	
    public ManagementController() {
        super();
        // TODO - 사용할 DAO 초기화 처리 
        breakAppRepository=new BreakAppRepositoryImpl();
        staffRepository=new StaffRepositoryImpl();
        professorRepository=new ProfessorRepositoryimpl();
        studentRepository=new StudentRepositoryImpl();
        stuSubRepository=new StuSubRepositoryImpl();
        tuitionRepository=new TuitionRepositoryImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getPathInfo(); // 페이지 처리
		HttpSession session=request.getSession(); // 세션 받아오기
		/* TODO - 나중에 로그인 검증 처리 맞춰서 하기
		 * if(session==null || session.getAttribute("principal")==null) {
		 * response.sendRedirect(request.getContextPath()+"/user/sigin"); 
		 * return; }
		 */
		// TODO - 유저정보 받아오기
		// TODO - 유효성 체크 (직원이 맞는지, null값은 아닌지)
		System.out.println("get");
		switch (action) {
		case "/selectStudent": {
			SelectAllStudent(request,response,session);
			break;
		}
		case "/selectProfessor": {
			selectAllProfessor(request,response,session);
			break;
		}
		case "/registerStudent": {
			request.getRequestDispatcher("/WEB-INF/views/staff/registerStudent.jsp").forward(request, response);
			break;
		}
		case "/registerProfessor": {
			request.getRequestDispatcher("/WEB-INF/views/staff/registerProfessor.jsp").forward(request, response);
			break;
		}
		case "/registerStaff": {
			request.getRequestDispatcher("/WEB-INF/views/staff/registerStaff.jsp").forward(request, response);
			break;
		}
		case "/sendBill": {
			request.getRequestDispatcher("/WEB-INF/views/staff/sendBill.jsp").forward(request, response);
			break;
		}
		case "/absence": {
			request.getRequestDispatcher("/WEB-INF/views/staff/breakApp.jsp").forward(request, response);
			break;
		}
		case "/setPeriod": {
			request.getRequestDispatcher("/WEB-INF/views/staff/setStuSubPeriod.jsp").forward(request, response);
			break;
		}
		default: {
			break;
		}}
	}

	private void selectAllProfessor(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int page=1;
		int pageSize=20;
		
		try {
			String pageStr=request.getParameter("page");
			if(pageStr!=null) {
				page=Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page=1;
			e.printStackTrace();
		}
		
		int offset=(page-1)*pageSize;
		List<ProfessorDTO> professorList=professorRepository.getAllProfessor();
		System.out.println(professorList);
		
		// 전체 학생 수 조회
		int totalStudentNumber=professorList.size();
		//총 페이지 수 계산
		int totalPages=(int)Math.ceil((double)totalStudentNumber/pageSize);
		
		request.setAttribute("professorList", professorList);
		request.setAttribute("totalProfessorNumber", totalStudentNumber);
		request.setAttribute("currentPage", page);
		
		request.getRequestDispatcher("/WEB-INF/views/staff/selectProfessor.jsp").forward(request, response);
	}

	/**
	 * 모든 학생 조회 기능
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void SelectAllStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int page=1;
		int pageSize=20;
		
		try {
			String pageStr=request.getParameter("page");
			if(pageStr!=null) {
				page=Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page=1;
			e.printStackTrace();
		}
		
		int offset=(page-1)*pageSize;
		List<StudentDTO> studentList=studentRepository.getAllStudent();
		
		// 전체 학생 수 조회
		int totalStudentNumber=studentList.size();
		//총 페이지 수 계산
		int totalPages=(int)Math.ceil((double)totalStudentNumber/pageSize);
		
		request.setAttribute("studentList", studentList);
		request.setAttribute("totalStudentNumber", totalStudentNumber);
		request.setAttribute("currentPage", page);
		
		request.getRequestDispatcher("/WEB-INF/views/staff/selectStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getPathInfo(); // 페이지 처리
		HttpSession session=request.getSession(); // 세션 받아오기
		
		switch (action) {
		case "/selectStudent": {
			// TODO - 학생 명단 조회 기능 만들기
			break;
		}
		case "/selectProfessor": {
			// TODO - 교수 명단 조회 기능 만들기
			break;
		}
		case "/registerSt": {
			regiterStudent(request,response,session);
			break;
		}
		case "/registerPr": {
			// TODO - 교수 등록 기능 만들기
			break;
		}
		case "/registerSf": {
			// TODO - 교직원 등록 기능 만들기
			break;
		}
		case "/sendBill": {
			// TODO - 등록금 고지서 발송
			break;
		}
		case "/absence": {
			// TODO - 휴학 처리 
			break;
		}
		case "/setPeriod": {
			// TODO - 수강 신청 기간 설정
			break;
		}
		default:
			break;
		}
	}

	private void regiterStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}

}
