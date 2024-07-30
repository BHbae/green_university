package university.green;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
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
        // GET 요청 처리 로직을 추가할 수 있습니다.
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        switch (action) {
            case "/login":
                handleLogin(request, response);
                break;

            case "/findId":
                handleFindId(request, response);
                break;

            case "/findPassword":
                handleFindPassword(request, response);
                break;

            case "/findIdComplete":
                handleFindIdComplete(request, response);
                break;

            case "/findPasswordComplete":
                handleFindPasswordComplete(request, response);
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userIdStr = request.getParameter("id");
        int userId = Integer.parseInt(userIdStr);
        String password = request.getParameter("password");

        try {
            LoginDto dto = userRepository.userId(userId, password);
            if (userId == dto.getId() && password.equals(dto.getPassword())) {
                HttpSession session = request.getSession();
                if ("student".equals(dto.getUser_role())) {
                    StudentDTO studentDetail = userRepository.studentDtail(dto.getId());
                    session.setAttribute("principal", studentDetail);
                    response.sendRedirect(request.getContextPath() + "/mainStudent.jsp");
                } else if ("professor".equals(dto.getUser_role())) {
                    ProfessorDTO professorDetail = userRepository.professorDtail(dto.getId());
                    session.setAttribute("principal", professorDetail);
                    response.sendRedirect(request.getContextPath() + "/mainProfessor.jsp");
                } else if ("staff".equals(dto.getUser_role())) {
                    StaffDTO staffDetail = userRepository.staffDtail(dto.getId());
                    session.setAttribute("principal", staffDetail);
                    response.sendRedirect(request.getContextPath() + "/mainStaff.jsp");
                } else {
                    showError(response, "유효하지 않은 방식입니다.");
                }
            } else {
                showError(response, "아이디 또는 비밀번호가 틀렸습니다.");
            }
        } catch (Exception e) {
            showError(response, "아이디 또는 비밀번호가 틀렸습니다.");
        }
    }

    private void handleFindId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String userRole = request.getParameter("userRole");

        String findId = userRepository.findIdDtail(name, email, userRole);
        request.setAttribute("findId", findId);
        request.setAttribute("name", name);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/findIdComplete.jsp");
        dispatcher.forward(request, response);
        System.out.println("아이디 찾기 들어오나!");
    }

    private void handleFindPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String userRole = request.getParameter("userRole");

        String findPassword = userRepository.findPasswordDtail(name, id, email, userRole);
        request.setAttribute("findPassword", findPassword);
        request.setAttribute("name", name);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/findPasswordComplete.jsp");
        dispatcher.forward(request, response);
    }

    private void handleFindIdComplete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // findIdComplete.jsp에서 findIdDto 속성을 사용하여 결과를 표시할 것입니다.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/findIdComplete.jsp");
        dispatcher.forward(request, response);
    }

    private void handleFindPasswordComplete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/findPasswordComplete.jsp");
        dispatcher.forward(request, response);
    }



    private void showError(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + message + "'); history.back();</script>");
    }
}