package university.green;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.professor.repository.ProfessorRepository;
import university.green.staff.repository.StaffRepository;
import university.green.student.repository.StudentRepository;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserRepository userRepository;

	@Override
	public void init() throws ServletException {
		userRepository = new UserRepositoryImpl();
		System.out.println("22222");
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getPathInfo();
		    switch (action) {
		        case "/login":
		            String userId = request.getParameter("id");
		            String password = request.getParameter("password");
		            
		            LoginDto dto = userRepository.userId(Integer.parseInt(userId), password);
		            dto.getUser_role();
		            
		            System.out.println(dto);
		            
		            // 유효성 검사
		            if (userId.equals("id") && password.equals("password")) {
		                HttpSession session = request.getSession();
		                session.setAttribute("userId", userId);
		                
		                response.sendRedirect(request.getContextPath() + "/mainPage.jsp");
		            } else {
		                request.setAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
		                request.getRequestDispatcher("Login.jsp").forward(request, response);
		            }
		            break;

		        default:
		            response.sendError(HttpServletResponse.SC_NOT_FOUND);
		            break;
		    }
	}
}
