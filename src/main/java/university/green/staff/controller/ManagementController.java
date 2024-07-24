package university.green.staff.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		// 학생 조회 페이지 이동
		case "/selectStudent": {
			SelectAllStudent(request,response,session);
			break;
		}
		// 교수 조회 페이지 이동
		case "/selectProfessor": {
			selectAllProfessor(request,response,session);
			break;
		}
		// 학생 등록 페이지 이동
		case "/registerStudent": {
			registerStudent(request,response,session);
			break;
		}
		// 교수 등록 페이지 이동
		case "/registerProfessor": {
			registerProfessor(request,response,session);
			break;
		}
		// 직원 등록 페이지 이동
		case "/registerStaff": {
			registerStaff(request,response,session);
			break;
		}
		// 고지서 전송 페이지 이동
		case "/sendBill": {
			sendBill(request,response,session);
			break;
		}
		// 휴학 처리 페이지 이동
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

	/**
	 * 등록금 고지서 발송
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void sendBill(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/sendBill.jsp").forward(request, response);
	}

	/**
	 * 교직원 등록
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void registerStaff(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/registerStaff.jsp").forward(request, response);
		
	}

	/**
	 * 교수 등록
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void registerProfessor(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/registerProfessor.jsp").forward(request, response);
	}

	/**
	 * 학생 등록
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void registerStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/registerStudent.jsp").forward(request, response);
	}

	/**
	 * 전체 교수 조회
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
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
	 * 전체 학생 조회
	 * 
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
		// 특정 학생 조회
		case "/selecSpecifictStudent": {
			selectSpecificStudent(request,response,session);
			break;
		}
		// 특정 교수 조회
		case "/selectSpecificProfessor": {
			sendRegisterProfessor(request,response,session);
			break;
		}
		// 학생 등록하기 (정보 전송)
		case "/registerSt": {
			try {
				sendRegisterStudent(request,response,session);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		}
		// 교수 등록하기 (정보 전송)
		case "/registerPr": {
			sendRegisterProfessor(request,response,session);
			break;
		}
		// 교직원 등록하기 (정보 전송)
		case "/registerSf": {
			// TODO - 교직원 등록 기능 만들기
			break;
		}
		default:
			break;
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void sendRegisterProfessor(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 특정 학생 조회 (학과 번호, 학번 조회)
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void selectSpecificStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 학생 등록(학생 정보 전송)
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ParseException 
	 */
	private void sendRegisterStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ParseException {
		String name=request.getParameter("name");
		String strBirthDate=request.getParameter("birthDate");
		Date birthDate=Date.valueOf(strBirthDate);
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		int deptId=Integer.parseInt(request.getParameter("deptId"));
		String strEntranceDate=request.getParameter("hireDate");
		Date entranceDate=Date.valueOf(strEntranceDate);
		
		StudentDTO student=StudentDTO.builder().name(name).birthDate(birthDate).gender(gender)
				.address(address).tel(tel).email(email).deptId(deptId).entranceDate(entranceDate).build();
				
	}

}
