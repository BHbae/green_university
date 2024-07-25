package university.green.staff.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import university.green.staff.model.StaffDTO;
import university.green.staff.repository.BreakAppRepositoryImpl;
import university.green.staff.repository.StaffRepositoryImpl;
import university.green.staff.repository.StuSubRepositoryImpl;
import university.green.staff.repository.StudentRepositoryimpl;
import university.green.staff.repository.TuitionRepositoryImpl;
import university.green.staff.repository.interfaces.BreakAppRepository;
import university.green.staff.repository.interfaces.StaffRepository;
import university.green.staff.repository.interfaces.StuSubRepository;
import university.green.staff.repository.interfaces.StudentRepository;
import university.green.staff.repository.interfaces.TuitionRepository;
import university.green.student.model.BreakAppDTO;
import university.green.student.model.StudentDTO;
import university.green.student.model.TuitionDTO;

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
        studentRepository=new StudentRepositoryimpl();
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
		//if(session==null || session.getAttribute("principal")==null) {
		//	request.getRequestDispatcher("/Login.jsp").forward(request, response);
		//	return;
		//}
		
		switch (action) {
		// 학생 조회 페이지 이동
		case "/selectStudent": {
			SelectAllStudent(request,response,session);
			break;
		}
		case "/newSemester":{
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
		case "/sendBillLetter": {
			sendBillLetter(request,response,session);
			break;
		}
		// 휴학 처리 페이지 이동
		case "/absence": {
			handleBreakApp(request,response,session);
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
	 * 고지서 보내기
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void sendBillLetter(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		List<TuitionDTO> tuitionList=tuitionRepository.getAllTuition();
		request.setAttribute("tuitionList", tuitionList);
		request.getRequestDispatcher("/WEB-INF/views/staff/sendBill.jsp").forward(request, response);
	}

	private void handleBreakApp(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		
		List<BreakAppDTO> breakAppList=breakAppRepository.getAllBreakApp();
		request.setAttribute("breakList", breakAppList);
		request.getRequestDispatcher("/WEB-INF/views/staff/breakApp.jsp").forward(request, response);
	}

	private void updateStudentList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
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
		List<StudentDTO> sendBillList=studentRepository.getAllStudent();
		
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
		
//		if(session==null || session.getAttribute("principal")==null) {
//			response.sendRedirect(request.getContextPath()+"/user/login");
//			return;
//		}
		
		switch (action) {
		// 특정 학생 조회
		case "/selecSpecifictStudent": {
			selectSpecificStudent(request,response,session);
			break;
		}
		// 특정 교수 조회
		case "/selectSpecificProfessor": {
			selectSpecificProfessor(request,response,session);
			break;
		}
		// 학생 등록하기 (정보 전송)
		case "/registerSt": {
			sendRegisterStudent(request,response,session);
			break;
		}
		// 교수 등록하기 (정보 전송)
		case "/registerPr": {
			sendRegisterProfessor(request,response,session);
			break;
		}
		// 교직원 등록하기 (정보 전송)
		case "/registerSf": {
			sendRegisterStaff(request,response,session);
			break;
		}
		default:
			break;
		}
	}


	/**
	 * 특정 교수 조회
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void selectSpecificProfessor(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws ServletException, IOException {
		int deptId=Integer.parseInt(request.getParameter("deptId"));
		int id=Integer.parseInt(request.getParameter("proId"));
		int page=1;
		int pageSize=20;
		
		List<ProfessorDTO> professorList=new ArrayList<>();
		
		if(deptId==0 || id==0) {
			professorList=professorRepository.getAllProfessor();
		} else if (deptId==0 || id!=0) {
			professorList.add(professorRepository.getProfessorById(id));
		} else if (deptId!=0 || id==0 ) {
			professorList=professorRepository.getProfessorByDeptNo(deptId);
		}
		// 전체 학생 수 조회
		int totalProfessorNumber=professorList.size();
		//총 페이지 수 계산
		int totalPages=(int)Math.ceil((double)totalProfessorNumber/pageSize);
		
		request.setAttribute("professorList", professorList);
		request.setAttribute("totalStudentNumber", professorList);
		request.setAttribute("currentPage", page);
		
		System.out.println(professorList);
		request.getRequestDispatcher("/WEB-INF/views/staff/selectProfessor.jsp").forward(request, response);
		
	}

	/**
	 * 교직원 등록(교직원 정보 전송)
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException 
	 */
	private void sendRegisterStaff(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		DateTimeFormatter dtfm=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String name=request.getParameter("name");
		
		String strBirthDate=request.getParameter("birthDate");
		LocalDate ldBirthDate=LocalDate.parse(strBirthDate,dtfm);
		Date birthDate=Date.valueOf(ldBirthDate);

		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		
		StaffDTO staff=StaffDTO.builder().name(name).birth_date(birthDate).gender(gender)
				.address(address).tel(tel).email(email).build();
		staffRepository.addStaff(staff);
		System.out.println(staff);
		
		
		response.sendRedirect(request.getContextPath()+"/management/registerStaff");
	}

	/**
	 * 교수 등록(교수 정보 전송)
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException 
	 */
	private void sendRegisterProfessor(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		DateTimeFormatter dtfm=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String name=request.getParameter("name");
		
		String strBirthDate=request.getParameter("birthDate");
		LocalDate ldBirthDate=LocalDate.parse(strBirthDate,dtfm);
		Date birthDate=Date.valueOf(ldBirthDate);

		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		int deptId=Integer.parseInt(request.getParameter("deptId"));
		
		ProfessorDTO professor=ProfessorDTO.builder().name(name).birthDate(birthDate).gender(gender).address(address)
				.tel(tel).email(email).deptId(deptId).build();
		professorRepository.addProfessor(professor);
		System.out.println(professor);
		
		response.sendRedirect(request.getContextPath()+"/management/registerProfessor");
	}

	/**
	 * 특정 학생 조회 (학과 번호, 학번 조회)
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void selectSpecificStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		int deptId=Integer.parseInt(request.getParameter("deptId"));
		int id=Integer.parseInt(request.getParameter("stuId"));
		int page=1;
		int pageSize=20;
		
		List<StudentDTO> studentList=new ArrayList<>();
		
		if(deptId==0 || id==0) {
			studentList=studentRepository.getAllStudent();
		} else if (deptId==0 || id!=0) {
			studentList.add(studentRepository.getStudentById(id));
		} else if (deptId!=0 || id==0 ) {
			studentList=studentRepository.getStudentByDeptId(deptId);
		}
		// 전체 학생 수 조회
		int totalStudentNumber=studentList.size();
		//총 페이지 수 계산
		int totalPages=(int)Math.ceil((double)totalStudentNumber/pageSize);
		
		request.setAttribute("studentList", studentList);
		request.setAttribute("totalStudentNumber", totalStudentNumber);
		request.setAttribute("currentPage", page);
		
		System.out.println(studentList);
		request.getRequestDispatcher("/WEB-INF/views/staff/selectStudent.jsp").forward(request, response);
		
	}

	/**
	 * 학생 등록(학생 정보 전송)
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ParseException 
	 * @throws IOException 
	 */
	private void sendRegisterStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		DateTimeFormatter dtfm=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String name=request.getParameter("name");
		
		String strBirthDate=request.getParameter("birthDate");
		LocalDate ldBirthDate=LocalDate.parse(strBirthDate,dtfm);
		Date birthDate=Date.valueOf(ldBirthDate);

		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		int deptId=Integer.parseInt(request.getParameter("deptId"));
		String strEntranceDate=request.getParameter("entranceDate");
		LocalDate ldEntranceDate=LocalDate.parse(strEntranceDate,dtfm);
		Date entranceDate=Date.valueOf(ldBirthDate);
		
		StudentDTO student=StudentDTO.builder().name(name).birthDate(birthDate).gender(gender)
				.address(address).tel(tel).email(email).deptId(deptId).entranceDate(entranceDate).build();
		
		response.sendRedirect(request.getContextPath()+"/management/registerStudent");
		
	}

}
