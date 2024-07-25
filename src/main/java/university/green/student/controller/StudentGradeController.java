package university.green.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.student.model.StudentDTO;

import java.io.IOException;
//check
@WebServlet("/studentGrade/*")
public class StudentGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// TODO - 사용할 DAO 생성하기
	
    public StudentGradeController() {
        super();
        // TODO - 사용할 DAO 초기화 처리 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getPathInfo();
		HttpSession session=request.getSession();
		// TODO - 유저정보 받아오기
		// TODO - 유효성 체크 (직원이 맞는지, null값은 아닌지)
		
		if(session==null||session.getAttribute("principal")==null) {
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
			return;
		}
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
			request.getRequestDispatcher("/WEB-INF/views/student/TotalAverageGrade.jsp").forward(request, response);
			break;
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
	 * 총 누계 성적 조회
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void selectTotalGrade(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		StudentDTO student=(StudentDTO)request.getAttribute("principal");
		if(student!=null) {
			request.setAttribute("studentId",student.getId());
		} 
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
		StudentDTO student=(StudentDTO)request.getAttribute("principal");
		if(student!=null) {
			request.setAttribute("studentId",student.getId());
		}
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
		StudentDTO student=(StudentDTO)request.getAttribute("principal");
		if(student!=null) {
			request.setAttribute("studentId",student.getId());
		}
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
		// TODO Auto-generated method stub
		
	}

}
