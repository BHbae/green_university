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
	private StudentRepository studentRepository; 
	private ProfessorRepository professorRepository;
	private StaffRepository staffRepository;
	
	@Override
	public void init() throws ServletException {
		userRepository = new UserRepositoryImpl();
		System.out.println("22222");
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/login":
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
			System.out.println("성공?");
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 String action = request.getPathInfo();
//		    switch (action) {
//		        case "/login":
//		            String userId = request.getParameter("id");
//		            String password = request.getParameter("password");
//		            
//		            // 여기에 아이디와 비밀번호 검증 로직을 추가
//		            
//		            // 예시: 간단한 아이디와 비밀번호 확인 예시
//		            if (userId.equals("admin") && password.equals("password")) {
//		                // 로그인 성공 시 세션에 사용자 정보 등을 저장할 수 있음
//		                HttpSession session = request.getSession();
//		                session.setAttribute("userId", userId);
//		                
//		                // 로그인 성공 후 다른 페이지로 리다이렉트 예시
//		                response.sendRedirect(request.getContextPath() + "/dashboard");
//		            } else {
//		                // 로그인 실패 시 처리
//		                request.setAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
//		                request.getRequestDispatcher("Login.jsp").forward(request, response);
//		            }
//		            break;
//
//		        default:
//		            response.sendError(HttpServletResponse.SC_NOT_FOUND);
//		            break;
//		    }
	}
}
