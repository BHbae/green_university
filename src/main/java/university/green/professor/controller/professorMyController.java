package university.green.professor.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.professor.model.ProfessorDTO;

import java.io.IOException;

@WebServlet("/professor/*")
public class professorMyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public professorMyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		
		switch (action) {
		case "/my":
			mydetail(request, response, session);
			break;

		default:
			break;
		}
		
	}

	private void mydetail(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		ProfessorDTO dto = (ProfessorDTO)session.getAttribute("principal");
		
		request.setAttribute("principal", dto);
		request.getRequestDispatcher("/WEB-INF/views/professor/professorMy.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
