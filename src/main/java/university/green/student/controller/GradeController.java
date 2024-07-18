package university.green.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * URL 매핑 추가 예정
 */
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// TODO - 사용할 DAO 생성하기
	
    public GradeController() {
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
			// TODO - 금학기 성적 조회
			break;
		}
		case "/grade-select": {
			// TODO - 학기별 성적 조회 
			break;
		}
		case "/grade-total": {
			// TODO - 누계 성적
			break;
		}
		default: {
			break;
		}
		}
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
		case "/grade-total": {
			// TODO - 누계 성적
			break;
		}
		default: {
			break;
		}
		}
	}

}
