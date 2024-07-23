package university.green;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.professor.model.ProfessorDTO;
import university.green.staff.model.StaffDTO;
import university.green.student.model.StudentDTO;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserRepository userRepository;

	@Override
	public void init() throws ServletException {
		userRepository = new UserRepositoryImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/login":
			String userIdStr = request.getParameter("id");
			int userId = Integer.parseInt(userIdStr);
			
			String password = request.getParameter("password");
			
			LoginDto dto = userRepository.userId(userId, password);
			System.out.println(dto);
			try {
				if (userId == dto.getId() && password.equals(dto.getPassword())) {
					
					if (dto.getUser_role().equals("student")) {
						StudentDTO studentDitail = userRepository.studentDtail(dto.getId());
						System.out.println(studentDitail);
						HttpSession session = request.getSession();
						session.setAttribute("principal", studentDitail);

						// TODO - 수정 학생전용 메인 페이지로 이동처리
						response.sendRedirect(request.getContextPath() + "/mainStudent.jsp");
						
					} else if (dto.getUser_role().equals("professor")) {
						ProfessorDTO professorDitail = userRepository.professorDtail(dto.getId());
						System.out.println(professorDitail);
						HttpSession session = request.getSession();
						session.setAttribute("principal", professorDitail);

						// TODO - 수정 교수전용 메인 페이지로 이동처리
						response.sendRedirect(request.getContextPath() + "/mainProfessor.jsp");

					} else if (dto.getUser_role().equals("staff")) {
						StaffDTO staffDitail = userRepository.staffDtail(dto.getId());
						System.out.println(staffDitail);
						HttpSession session = request.getSession();
						session.setAttribute("principal", staffDitail);

						// TODO - 수정 교직원 전용 메인 페이지로 이동처리
						System.out.println("Principal 데이터: " + session.getAttribute("principal")); // 디버그용 출력
						response.sendRedirect(request.getContextPath() + "/mainStaff.jsp");

					} else {
						 response.setContentType("text/html; charset=UTF-8");
						 PrintWriter out = response.getWriter();
						 out.println("<script> alert('유효하지 않은 방식입니다.'); history.back();  </script>");
					}

				} else {
					 response.setContentType("text/html; charset=UTF-8");
					 PrintWriter out = response.getWriter();
					 out.println("<script> alert('아이디 또는 비밀번호가 틀렷습니다'); history.back();  </script>");
				}
			} catch (Exception e) {
				 response.setContentType("text/html; charset=UTF-8");
				 PrintWriter out = response.getWriter();
				 out.println("<script> alert('아이디 또는 비밀번호가 틀렷습니다.'); history.back();  </script>");
			}

			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}
}
