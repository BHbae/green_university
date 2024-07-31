package university.green.staff.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import university.green.LoginDto;
import university.green.staff.model.StaffDTO;
import university.green.staff.repository.staffpassRepositoryImpl;
import university.green.staff.repository.interfaces.staffpassRepository;

@WebServlet("/staffmy/*")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private staffpassRepository repository;

	public StaffController() {
		super();
		repository = new staffpassRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();

		switch (action) {
		case "/my":
			mydetail(request, response, session);
			break;
		case "/uppass":
			uppass(request, response, session);
			break;
		default:
			break;
		}

	}

	private void uppass(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/staff/staffUpdatePassword.jsp").forward(request, response);
	}

	private void mydetail(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		StaffDTO principal = (StaffDTO) session.getAttribute("principal");

		request.setAttribute("principal", principal);

		request.getRequestDispatcher("/WEB-INF/views/staff/staffMy.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();

		switch (action) {
		case "/password":
			passupdate(request, response, session);
			break;

		default:
			break;
		}

	}

	private void passupdate(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		StaffDTO principal = (StaffDTO) session.getAttribute("principal");
		String beforePasswordStr = request.getParameter("beforePassword");
		int beforePassword = Integer.parseInt(beforePasswordStr);

		String afterPassword = request.getParameter("afterPassword");

		String passwordCheck = request.getParameter("passwordCheck");

		LoginDto loginDto = repository.stafflogin(principal.getId(), beforePassword);

		if (loginDto == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('현재 비밀 번호가 틀렵습니다.'); history.back();  </script>");
		} else if(!afterPassword.equals(passwordCheck)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('변경하실 비밀번호를 똑같이 해주세요.'); history.back();  </script>");
		} else {
			int password = Integer.parseInt(passwordCheck);
			repository.setPassword(principal.getId(), password);
			response.sendRedirect(request.getContextPath()  + "/staffmy/my");
		}

	}

}
