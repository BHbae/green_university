package university.green;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
