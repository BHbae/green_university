package university.green.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//check
@WebServlet("/mystudent/*")
public class StudentMyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentMyController() {
        super();
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
			MyDitail(request, response, session);
			break;
		case "/mybreakapplist":
			MyDitail(request, response, session);
			break;
		case "/mytuilist":
			MyDitail(request, response, session);
			break;
			

		default:
			break;
		}
		
	}

	private void MyDitail(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/student/studentMy.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
