package university.green.staff.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import university.green.staff.model.RoomDTO;
import university.green.staff.repository.RoomRepositoryImpl;
import university.green.staff.repository.interfaces.RoomRepositroy;

import java.io.IOException;
import java.util.List;

// 등록 - 강의실
@WebServlet("/room/*")
public class RoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomRepositroy roomRepositroy;
       

    public RoomController() {
        super();
        roomRepositroy = new RoomRepositoryImpl();
    }

    // 등록 , 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		switch (action) {
		case "/roomlist":
			roomlist(request, response);
			break;
		case "/roomadd":
			roomadd(request, response);
			break;
		case "/roomdelete":
			roomdelete(request, response);
			break;

		default:
			break;
		}
		
	}


	// 리스트
	private void roomlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RoomDTO> room = roomRepositroy.roomList();
		
		String action = request.getParameter("action");
		
		request.setAttribute("action", action);
		request.setAttribute("roomList", room);
		request.getRequestDispatcher("/WEB-INF/views/staff/room.jsp").forward(request, response);

		
		
	}

	// 등록 페이지
	private void roomadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/room.jsp").forward(request, response);

		
	}

	// 삭제 페이지
	private void roomdelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/staff/room.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();
		
		switch (action) {
		case "/addroom":
			addroom(request, response);
			break;
		case "/deleteroom":
			deleteroom(request, response);
			break;

		default:
			break;
		}
		
	}

	// 등록 
	private void addroom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String college = request.getParameter("college");
		int collegeId = Integer.parseInt(college);
		
		RoomDTO dto = RoomDTO.builder()
							 .id(id)
							 .collegeId(collegeId)
							 .build();
		roomRepositroy.addRoom(dto);
		
		List<RoomDTO> room = roomRepositroy.roomList();
		request.setAttribute("roomList", room);
		request.getRequestDispatcher("/WEB-INF/views/staff/room.jsp").forward(request, response);
		
	}

	// 삭제 
	private void deleteroom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		roomRepositroy.deleteRoom(id);
		
		List<RoomDTO> room = roomRepositroy.roomList();
		request.setAttribute("roomList", room);
		request.getRequestDispatcher("/WEB-INF/views/staff/room.jsp").forward(request, response);
		
	}

}
