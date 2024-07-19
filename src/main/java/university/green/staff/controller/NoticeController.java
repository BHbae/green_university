package university.green.staff.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.staff.repository.NoticeRepository;
import university.green.staff.repository.NoticeRepositoryImpl;

import java.io.IOException;

// URL 매핑 수정
@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeRepository noticeRepository;
       
    @Override
    public void init() throws ServletException {
    	noticeRepository = new NoticeRepositoryImpl();
    }
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo();
		HttpSession session = request.getSession(false);
		
		switch (action) {
		case "":
			
			break;

		default:
			break;
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
