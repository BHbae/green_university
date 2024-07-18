package university.green.staff.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * URL 매핑 추가 예정
 */
public class ManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// TODO - 사용할 DAO 생성하기
	
    public ManagementController() {
        super();
        // TODO - 사용할 DAO 초기화 처리 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getPathInfo();
		HttpSession session=request.getSession();
		// TODO - 유저정보 받아오기
		// TODO - 유효성 체크 (직원이 맞는지, null값은 아닌지)
		
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
			// TODO - 학생 등록 기능 만들기
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
		default: {
			break;
		}}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action=request.getPathInfo();
		
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
			// TODO - 학생 등록 기능 만들기
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

}
