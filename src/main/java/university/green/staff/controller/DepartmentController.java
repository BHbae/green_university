package university.green.staff.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import university.green.staff.model.DepartmentDTO;
import university.green.staff.repository.DepartmentRepositoryImpl;
import university.green.staff.repository.interfaces.DepartmentRepository;

import java.io.IOException;
import java.util.List;

// 등록 - 학과
@WebServlet("/department/*")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentRepository departmentRepository;
       
  
	// 등록, 수정, 삭제
    public DepartmentController() {
        super();
        departmentRepository = new DepartmentRepositoryImpl();
    }

	// 리스트, 등록 페이지, 수정 페이지. 삭제 페이지
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		switch (action) {
		case "/departmentlist":
			departmentlist(request, response);
			break;
			
		case "/departmentadd":
			departmentadd(request, response);
			break;

		case "/departmentdelete":
			departmentdelete(request, response);
			break;
			
		case "/departmentupdate":
			departmentupdate(request, response);
			break;
		default:
			break;
		}
		
	}


	// 목록 페이지
	private void departmentlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DepartmentDTO> departmentList = departmentRepository.departmentList();
		
		String action = request.getParameter("action");
		
		request.setAttribute("action", action);
		request.setAttribute("departmentList", departmentList);
		request.getRequestDispatcher("/WEB-INF/views/staff/department.jsp").forward(request, response);

		
	}

	// 등록 페이지
	private void departmentadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/views/staff/department.jsp").forward(request, response);
		
		
	}

	// 삭제 페이지
	private void departmentdelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/department.jsp").forward(request, response);

	}

	// 수정 페이지
	private void departmentupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/department.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getPathInfo();
		
		switch (action) {
		case "/adddepartment":
			adddepartment(request, response);
			break;
			
		case "/deletedepartment":
			deletedepartment(request, response);
			break;
			
		case "/updatedepartment":
			updatedepartment(request, response);
			break;

		default:
			break;
		}
	}

	//등록
	private void adddepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		int collegeId = Integer.parseInt(college);
		
		DepartmentDTO dto = DepartmentDTO.builder()
										 .name(name)
										 .collegeId(collegeId)
										 .build();
		departmentRepository.addDepartment(dto);
		
		response.sendRedirect(request.getContextPath() + "/department/departmentlist");
		
	}

	// 삭제
	private void deletedepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		departmentRepository.deleteDepartment(id);
		
		response.sendRedirect(request.getContextPath() + "/department/departmentlist");
		
		
	}

	// 수정
	private void updatedepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		
		DepartmentDTO dto = DepartmentDTO.builder()
										 .name(name)
										 .collegeId(collegeId)
										 .build();
		departmentRepository.updateDepartment(dto);
		
		
		
		
		response.sendRedirect(request.getContextPath() + "/department/departmentlist");
	}

}
