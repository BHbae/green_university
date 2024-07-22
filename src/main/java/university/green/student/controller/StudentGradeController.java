package university.green.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/student-grade/*")
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
		
		switch(action) {
		case "/grade-of-this-semester": {
			selectThisSemester(request,response,session);
			break;
		}
		case "/grade-select": {
			selectEachSemester(request,response,session);
			break;
		}
		case "/grade-total": {
			selectTotalGrade(request,response,session);
			break;
		}
		default: {
			break;
		}
		}
	}


	private void selectTotalGrade(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/student/TotalAverageGrade.jsp").forward(request, response);
	}

	private void selectEachSemester(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/student/EachSemesterGrade.jsp").forward(request, response);
	}

	private void selectThisSemester(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/student/ThisSemesterGrade.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getPathInfo();
		HttpSession session=request.getSession();
		// TODO - 유저정보 받아오기
		// TODO - 유효성 체크 (직원이 맞는지, null값은 아닌지)
		
		switch(action) {
		case "/grade-of-this-semester": {
			// TODO - 금학기 성적 조회
			break;
		}
		case "/grade-select": {
			// TODO - 학기별 성적 조회 
			break;
		}
		default: {
			break;
		}
		}
	}

}
