package university.green.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.student.model.EachGradeDTO;
import university.green.student.model.StudentDTO;
import university.green.student.model.TotalGradeDTO;
import university.green.student.repository.GradeRepositoryImpl;
import university.green.student.repository.interfaces.GradeRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/studentGrade/*")
public class StudentGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GradeRepository gradeRepository; // 과목별 성적
	
    public StudentGradeController() {
        super();
        gradeRepository=new GradeRepositoryImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getPathInfo();
		HttpSession session=request.getSession();
		// TODO - 유저정보 받아오기
		// TODO - 유효성 체크 (직원이 맞는지, null값은 아닌지)
		
		/*
		 * if(session==null||session.getAttribute("principal")==null) {
		 * request.getRequestDispatcher("/Login.jsp").forward(request, response);
		 * return; }
		 */
		System.out.println("유효성 검사 통과");
		System.out.println("get");
		
		
		switch(action) {
		// 이번 학기 성적 조회
		case "/gradeOfThisSemester": {
			selectThisSemester(request,response,session);
			break;
		}
		// 학기별 성적 조회
		case "/selectSemester": {
			selectEachSemester(request,response,session);
			break;
		}
		// 학기별 성적 조회 -> 검색 기능
		case "/searchSelectsemester": {
			searchEachGrade(request,response,session);
		}
		// 총 누계 성적 조회
		case "/totalGrade": {
			selectTotalGrade(request,response,session);
			break;
		}
		default: {
			break;
		}
		}
	}

	/**
	 * 학기별 성적 조회 - 검색 기능
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void searchEachGrade(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		StudentDTO student=(StudentDTO)request.getAttribute("principal");
		int year=Integer.parseInt(request.getParameter("year"));
		int semester=Integer.parseInt(request.getParameter("semester"));
		String type=request.getParameter("type");
		
		List<EachGradeDTO> EachGradeList=gradeRepository.getEachGradeBySemester(2023000201,2023,1);
		request.setAttribute("EachGradeList", EachGradeList);
	}

	/**
	 * 총 누계 성적 조회
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void selectTotalGrade(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		//StudentDTO student=(StudentDTO)request.getAttribute("principal");
		 /* if(student!=null) { request.setAttribute("studentId",student.getId()); }
		 */
		
		// 누계 성적(학기별 total,avg)
		List<TotalGradeDTO> totalGradeList=gradeRepository.getAllTotalGrade(2023000201, 2023, 1);
		request.setAttribute("totalGradeList", totalGradeList);
		request.getRequestDispatcher("/WEB-INF/views/student/TotalAverageGrade.jsp").forward(request, response);
	}

	/**
	 * 학기별 성적 조회
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void selectEachSemester(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		//StudentDTO student=(StudentDTO)request.getAttribute("principal");
		 /* if(student!=null) { request.setAttribute("studentId",student.getId()); }
		 */
		List<EachGradeDTO> EachGradeList=gradeRepository.getEachGradeBySemester(2023000201,2023,1);
		request.setAttribute("EachGradeList", EachGradeList);
		
		request.getRequestDispatcher("/WEB-INF/views/student/EachSemesterGrade.jsp").forward(request, response);
	}

	/**
	 * 이번 학기 성적 조회
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void selectThisSemester(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		//StudentDTO student=(StudentDTO)request.getAttribute("principal");
		 /* if(student!=null) { request.setAttribute("studentId",student.getId()); }
		 */
		// 과목별 성적 조회
		List<EachGradeDTO> gradeList=gradeRepository.getEachGradeBySemester(2023000201,1,1);
		request.setAttribute("gradeList", gradeList);
		
		// 누계 성적(학기별 total,avg)
		List<TotalGradeDTO> totalGradeList=gradeRepository.getAllTotalGrade(2023000201, 2023, 1);
		request.setAttribute("totalGradeList", totalGradeList);
		
		request.getRequestDispatcher("/WEB-INF/views/student/ThisSemesterGrade.jsp").forward(request, response);
	}

	
	// doPost 포스트 방식 통신
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getPathInfo();
		HttpSession session=request.getSession();
		// TODO - 유저정보 받아오기
		// TODO - 유효성 체크 (직원이 맞는지, null값은 아닌지)
		if(session==null||session.getAttribute("principal")==null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return;
		}
		
		switch(action) {
		// 특정 과목 검색
		case "/selectSepcificSubject": {
			selectSpecificSubject(request,response,session);
			break;
		}
		case "/send-subject-evaluation":{
			
		}
		default: {
			break;
		}
		}
	}

	private void selectSpecificSubject(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
	}

}
